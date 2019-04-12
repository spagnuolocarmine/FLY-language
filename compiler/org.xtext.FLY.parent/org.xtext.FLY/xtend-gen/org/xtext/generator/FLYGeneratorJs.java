package org.xtext.generator;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.HashMap;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.xtext.fLY.ArithmeticExpression;
import org.xtext.fLY.ArrayDefinition;
import org.xtext.fLY.ArrayInit;
import org.xtext.fLY.ArrayValue;
import org.xtext.fLY.Assignment;
import org.xtext.fLY.BinaryOperation;
import org.xtext.fLY.BlockExpression;
import org.xtext.fLY.BooleanLiteral;
import org.xtext.fLY.CastExpression;
import org.xtext.fLY.ChannelDeclaration;
import org.xtext.fLY.ChannelReceive;
import org.xtext.fLY.ChannelSend;
import org.xtext.fLY.ConstantDeclaration;
import org.xtext.fLY.DatDeclaration;
import org.xtext.fLY.DatTableObject;
import org.xtext.fLY.DeclarationObject;
import org.xtext.fLY.EnvironmentDeclaration;
import org.xtext.fLY.Expression;
import org.xtext.fLY.FeautureName;
import org.xtext.fLY.FloatLiteral;
import org.xtext.fLY.FlyFunctionCall;
import org.xtext.fLY.ForExpression;
import org.xtext.fLY.FunctionDefinition;
import org.xtext.fLY.IfExpression;
import org.xtext.fLY.IndexObject;
import org.xtext.fLY.LocalFunctionCall;
import org.xtext.fLY.LocalFunctionInput;
import org.xtext.fLY.MathFunction;
import org.xtext.fLY.NameObject;
import org.xtext.fLY.NameObjectDef;
import org.xtext.fLY.NativeExpression;
import org.xtext.fLY.NumberLiteral;
import org.xtext.fLY.ObjectLiteral;
import org.xtext.fLY.ParenthesizedExpression;
import org.xtext.fLY.PostfixOperation;
import org.xtext.fLY.PrintExpression;
import org.xtext.fLY.RangeLiteral;
import org.xtext.fLY.RequireExpression;
import org.xtext.fLY.StringLiteral;
import org.xtext.fLY.TimeFunction;
import org.xtext.fLY.UnaryOperation;
import org.xtext.fLY.VariableDeclaration;
import org.xtext.fLY.VariableFor;
import org.xtext.fLY.VariableFunction;
import org.xtext.fLY.VariableLiteral;
import org.xtext.fLY.WhileExpression;

@SuppressWarnings("all")
public class FLYGeneratorJs extends AbstractGenerator {
  private String name = "";
  
  private String env = "";
  
  private String language = "";
  
  private int memory = 0;
  
  private int nthread = 0;
  
  private int time = 0;
  
  private FunctionDefinition root = null;
  
  private Object id_execution = null;
  
  private HashMap<String, HashMap<String, String>> typeSystem = null;
  
  private boolean isLocal;
  
  public void generateJS(final Resource input, final IFileSystemAccess2 fsa, final IGeneratorContext context, final String name_file, final FunctionDefinition func, final EnvironmentDeclaration environment, final HashMap<String, HashMap<String, String>> scoping, final long id, final boolean local) {
    this.name = name_file;
    this.root = func;
    this.typeSystem = scoping;
    this.id_execution = Long.valueOf(id);
    if ((!local)) {
      EObject _right = environment.getRight();
      this.env = ((DeclarationObject) _right).getFeatures().get(0).getValue_s();
      EObject _right_1 = environment.getRight();
      this.language = ((DeclarationObject) _right_1).getFeatures().get(4).getValue_s();
      EObject _right_2 = environment.getRight();
      this.nthread = ((DeclarationObject) _right_2).getFeatures().get(5).getValue_t();
      EObject _right_3 = environment.getRight();
      this.memory = ((DeclarationObject) _right_3).getFeatures().get(6).getValue_t();
      EObject _right_4 = environment.getRight();
      this.time = ((DeclarationObject) _right_4).getFeatures().get(7).getValue_t();
    } else {
      this.env = "smp";
      EObject _right_5 = environment.getRight();
      this.nthread = ((DeclarationObject) _right_5).getFeatures().get(1).getValue_t();
      EObject _right_6 = environment.getRight();
      this.language = ((DeclarationObject) _right_6).getFeatures().get(2).getValue_s();
    }
    this.isLocal = local;
    this.doGenerate(input, fsa, context);
  }
  
  @Override
  public void doGenerate(final Resource input, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    String _name = this.root.getName();
    String _plus = (_name + "_deploy.sh");
    fsa.generateFile(_plus, this.compileDeploy(input, this.root.getName()));
    String _name_1 = this.root.getName();
    String _plus_1 = (_name_1 + "_undeploy.sh");
    fsa.generateFile(_plus_1, this.compileUndeploy(input, this.root.getName()));
    if (this.isLocal) {
      String _name_2 = this.root.getName();
      String _plus_2 = (_name_2 + ".js");
      fsa.generateFile(_plus_2, this.compileJavaScript(input, this.root.getName(), true));
    }
  }
  
  public CharSequence compileJavaScript(final Resource resource, final String string, final boolean local) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generateLocalBodyJs = this.generateLocalBodyJs(this.root.getBody(), this.root.getParameters(), this.name, this.env, local);
    _builder.append(_generateLocalBodyJs);
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence generateLocalBodyJs(final BlockExpression expression, final EList<Expression> list, final String string, final String string2, final boolean b) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var __dataframe = require(\"dataframe-js\").DataFrame;");
    _builder.newLine();
    _builder.append("export.main = async => {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compileJS(final Resource resource, final FunctionDefinition func, final String env) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generateBodyJs = this.generateBodyJs(resource, func.getBody(), func.getParameters(), func.getName(), env);
    _builder.append(_generateBodyJs);
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence generateBodyJs(final Resource resource, final BlockExpression exps, final List<Expression> parameters, final String name, final String env) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _equals = Objects.equal(env, "aws");
      if (_equals) {
        _builder.append("var AWS = require(\"aws-sdk\");");
        _builder.newLine();
        _builder.append("var sqs = new AWS.SQS();");
        _builder.newLine();
      }
    }
    _builder.append("var __dataframe = require(\"dataframe-js\").DataFrame;");
    _builder.newLine();
    {
      Iterable<RequireExpression> _filter = Iterables.<RequireExpression>filter(exps.getExpressions(), RequireExpression.class);
      for(final RequireExpression req : _filter) {
        _builder.newLine();
      }
    }
    _builder.append("let __params;");
    _builder.newLine();
    _builder.append("let __data;");
    _builder.newLine();
    _builder.newLine();
    {
      Iterable<ConstantDeclaration> _filter_1 = Iterables.<ConstantDeclaration>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), ConstantDeclaration.class);
      for(final ConstantDeclaration exp : _filter_1) {
        String _generateConstantDefinition = this.generateConstantDefinition(exp, name);
        _builder.append(_generateConstantDefinition);
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("exports.handler = async (event,context) => {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    {
      for(final Expression exp_1 : parameters) {
        {
          boolean _equals_1 = this.typeSystem.get(name).get(((VariableDeclaration) exp_1).getName()).equals("Table");
          if (_equals_1) {
            _builder.append("\t");
            _builder.append("var __");
            String _name = ((VariableDeclaration) exp_1).getName();
            _builder.append(_name, "\t");
            _builder.append(" = await new __dataframe(JSON.parse(event.Records[0].body));");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("var ");
            String _name_1 = ((VariableDeclaration) exp_1).getName();
            _builder.append(_name_1, "\t");
            _builder.append(" = __");
            String _name_2 = ((VariableDeclaration) exp_1).getName();
            _builder.append(_name_2, "\t");
            _builder.append(".toArray()");
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("\t");
            _builder.append("var ");
            String _name_3 = ((VariableDeclaration) exp_1).getName();
            _builder.append(_name_3, "\t");
            _builder.append(" = event.Records[0].body;");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    {
      EList<Expression> _expressions = exps.getExpressions();
      for(final Expression exp_2 : _expressions) {
        _builder.append("\t");
        String _generateJsExpression = this.generateJsExpression(exp_2, name);
        _builder.append(_generateJsExpression, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public String generateConstantDefinition(final ConstantDeclaration exp, final String scope) {
    StringConcatenation _builder = new StringConcatenation();
    String s = _builder.toString();
    EObject _right = exp.getRight();
    if ((_right instanceof NameObjectDef)) {
      this.typeSystem.get(scope).put(exp.getName(), "HashMap");
      String _s = s;
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("const ");
      String _name = exp.getName();
      _builder_1.append(_name);
      _builder_1.append(" = {");
      s = (_s + _builder_1);
      int i = 0;
      EObject _right_1 = exp.getRight();
      EList<FeautureName> _features = ((NameObjectDef) _right_1).getFeatures();
      for (final FeautureName f : _features) {
        {
          String _feature = f.getFeature();
          boolean _notEquals = (!Objects.equal(_feature, null));
          if (_notEquals) {
            HashMap<String, String> _get = this.typeSystem.get(scope);
            String _name_1 = exp.getName();
            String _plus = (_name_1 + ".");
            String _feature_1 = f.getFeature();
            String _plus_1 = (_plus + _feature_1);
            _get.put(_plus_1, 
              this.valuateArithmeticExpression(f.getValue(), scope));
            StringConcatenation _builder_2 = new StringConcatenation();
            String _feature_2 = f.getFeature();
            _builder_2.append(_feature_2);
            _builder_2.append(":");
            String _generateJsArithmeticExpression = this.generateJsArithmeticExpression(f.getValue(), scope);
            _builder_2.append(_generateJsArithmeticExpression);
            String _plus_2 = (s + _builder_2);
            s = _plus_2;
          } else {
            HashMap<String, String> _get_1 = this.typeSystem.get(scope);
            String _name_2 = exp.getName();
            String _plus_3 = (_name_2 + "[");
            String _plus_4 = (_plus_3 + Integer.valueOf(i));
            String _plus_5 = (_plus_4 + "]");
            _get_1.put(_plus_5, 
              this.valuateArithmeticExpression(f.getValue(), scope));
            StringConcatenation _builder_3 = new StringConcatenation();
            _builder_3.append(i);
            _builder_3.append(":");
            String _generateJsArithmeticExpression_1 = this.generateJsArithmeticExpression(f.getValue(), scope);
            _builder_3.append(_generateJsArithmeticExpression_1);
            String _plus_6 = (s + _builder_3);
            s = _plus_6;
            i++;
          }
          EObject _right_2 = exp.getRight();
          FeautureName _last = IterableExtensions.<FeautureName>last(((NameObjectDef) _right_2).getFeatures());
          boolean _notEquals_1 = (!Objects.equal(f, _last));
          if (_notEquals_1) {
            String _s_1 = s;
            StringConcatenation _builder_4 = new StringConcatenation();
            _builder_4.append(",");
            s = (_s_1 + _builder_4);
          }
        }
      }
      String _s_1 = s;
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("}");
      s = (_s_1 + _builder_2);
    } else {
      EObject _right_2 = exp.getRight();
      if ((_right_2 instanceof ArrayDefinition)) {
        EObject _right_3 = exp.getRight();
        String type_decl = ((ArrayDefinition) _right_3).getType();
        EObject _right_4 = exp.getRight();
        int _length = ((Object[])Conversions.unwrapArray(((ArrayDefinition) _right_4).getIndexes(), Object.class)).length;
        boolean _equals = (_length == 1);
        if (_equals) {
          this.typeSystem.get(scope).put(exp.getName(), ("Array_" + type_decl));
        } else {
          EObject _right_5 = exp.getRight();
          int _length_1 = ((Object[])Conversions.unwrapArray(((ArrayDefinition) _right_5).getIndexes(), Object.class)).length;
          boolean _equals_1 = (_length_1 == 2);
          if (_equals_1) {
            EObject _right_6 = exp.getRight();
            String col = this.generateJsArithmeticExpression(((ArrayDefinition) _right_6).getIndexes().get(1).getValue(), scope);
            this.typeSystem.get(scope).put(exp.getName(), ((("Matrix_" + type_decl) + "_") + col));
          } else {
            EObject _right_7 = exp.getRight();
            int _length_2 = ((Object[])Conversions.unwrapArray(((ArrayDefinition) _right_7).getIndexes(), Object.class)).length;
            boolean _equals_2 = (_length_2 == 3);
            if (_equals_2) {
              EObject _right_8 = exp.getRight();
              String col_1 = this.generateJsArithmeticExpression(((ArrayDefinition) _right_8).getIndexes().get(1).getValue(), scope);
              EObject _right_9 = exp.getRight();
              String dep = this.generateJsArithmeticExpression(((ArrayDefinition) _right_9).getIndexes().get(2).getValue(), scope);
              this.typeSystem.get(scope).put(exp.getName(), ((((("Matrix_" + type_decl) + "_") + col_1) + "_") + dep));
            }
          }
        }
        String _s_2 = s;
        StringConcatenation _builder_3 = new StringConcatenation();
        _builder_3.append("const ");
        String _name_1 = exp.getName();
        _builder_3.append(_name_1);
        _builder_3.append(" = [];");
        _builder_3.newLineIfNotEmpty();
        s = (_s_2 + _builder_3);
      } else {
        EObject _right_10 = exp.getRight();
        if ((_right_10 instanceof ArrayInit)) {
          if ((((((ArrayInit) exp.getRight()).getValues().get(0) instanceof NumberLiteral) || (((ArrayInit) exp.getRight()).getValues().get(0) instanceof StringLiteral)) || (((ArrayInit) exp.getRight()).getValues().get(0) instanceof FloatLiteral))) {
            EObject _right_11 = exp.getRight();
            ArrayValue _get = ((ArrayInit) _right_11).getValues().get(0);
            String real_type = this.valuateArithmeticExpression(((ArithmeticExpression) _get), scope);
            this.typeSystem.get(scope).put(exp.getName(), ("Array_" + real_type));
            StringConcatenation _builder_4 = new StringConcatenation();
            _builder_4.append("const ");
            String _name_2 = exp.getName();
            _builder_4.append(_name_2);
            _builder_4.append(" = [");
            {
              EObject _right_12 = exp.getRight();
              EList<ArrayValue> _values = ((ArrayInit) _right_12).getValues();
              for(final ArrayValue e : _values) {
                String _generateJsArithmeticExpression = this.generateJsArithmeticExpression(((ArithmeticExpression) e), scope);
                _builder_4.append(_generateJsArithmeticExpression);
                {
                  EObject _right_13 = exp.getRight();
                  ArrayValue _last = IterableExtensions.<ArrayValue>last(((ArrayInit) _right_13).getValues());
                  boolean _notEquals = (!Objects.equal(e, _last));
                  if (_notEquals) {
                    _builder_4.append(",");
                  }
                }
              }
            }
            _builder_4.append("]");
            _builder_4.newLineIfNotEmpty();
            return _builder_4.toString();
          } else {
            EObject _right_14 = exp.getRight();
            ArrayValue _get_1 = ((ArrayInit) _right_14).getValues().get(0);
            if ((_get_1 instanceof ArrayValue)) {
              if ((((((ArrayValue) ((ArrayInit) exp.getRight()).getValues().get(0)).getValues().get(0) instanceof NumberLiteral) || 
                (((ArrayValue) ((ArrayInit) exp.getRight()).getValues().get(0)).getValues().get(0) instanceof StringLiteral)) || 
                (((ArrayValue) ((ArrayInit) exp.getRight()).getValues().get(0)).getValues().get(0) instanceof FloatLiteral))) {
                EObject _right_15 = exp.getRight();
                ArrayValue _get_2 = ((ArrayInit) _right_15).getValues().get(0);
                ArrayValue _get_3 = ((ArrayValue) _get_2).getValues().get(0);
                String real_type_1 = this.valuateArithmeticExpression(((ArithmeticExpression) _get_3), scope);
                EObject _right_16 = exp.getRight();
                ArrayValue _get_4 = ((ArrayInit) _right_16).getValues().get(0);
                ArrayValue _get_5 = ((ArrayValue) _get_4).getValues().get(0);
                int col_2 = ((Object[])Conversions.unwrapArray(((ArrayValue) _get_5).getValues(), Object.class)).length;
                this.typeSystem.get(scope).put(exp.getName(), ((("Matrix_" + real_type_1) + "_") + Integer.valueOf(col_2)));
                StringConcatenation _builder_5 = new StringConcatenation();
                _builder_5.append("const ");
                String _name_3 = exp.getName();
                _builder_5.append(_name_3);
                _builder_5.append(" = [");
                String ret = _builder_5.toString();
                EObject _right_17 = exp.getRight();
                EList<ArrayValue> _values_1 = ((ArrayInit) _right_17).getValues();
                for (final ArrayValue e_1 : _values_1) {
                  {
                    String _ret = ret;
                    StringConcatenation _builder_6 = new StringConcatenation();
                    _builder_6.append("[");
                    ret = (_ret + _builder_6);
                    EList<ArrayValue> _values_2 = ((ArrayValue) e_1).getValues();
                    for (final ArrayValue e1 : _values_2) {
                      {
                        String _ret_1 = ret;
                        String _generateJsArithmeticExpression_1 = this.generateJsArithmeticExpression(((ArithmeticExpression) e1), scope);
                        ret = (_ret_1 + _generateJsArithmeticExpression_1);
                        ArrayValue _last_1 = IterableExtensions.<ArrayValue>last(((ArrayValue) e_1).getValues());
                        boolean _notEquals_1 = (!Objects.equal(e1, _last_1));
                        if (_notEquals_1) {
                          String _ret_2 = ret;
                          StringConcatenation _builder_7 = new StringConcatenation();
                          _builder_7.append(",");
                          ret = (_ret_2 + _builder_7);
                        }
                      }
                    }
                    String _ret_1 = ret;
                    StringConcatenation _builder_7 = new StringConcatenation();
                    _builder_7.append("]");
                    ret = (_ret_1 + _builder_7);
                    EObject _right_18 = exp.getRight();
                    ArrayValue _last_1 = IterableExtensions.<ArrayValue>last(((ArrayInit) _right_18).getValues());
                    boolean _notEquals_1 = (!Objects.equal(e_1, _last_1));
                    if (_notEquals_1) {
                      String _ret_2 = ret;
                      StringConcatenation _builder_8 = new StringConcatenation();
                      _builder_8.append(",");
                      ret = (_ret_2 + _builder_8);
                    }
                  }
                }
                String _ret = ret;
                StringConcatenation _builder_6 = new StringConcatenation();
                _builder_6.append("]");
                ret = (_ret + _builder_6);
                return ret;
              } else {
                EObject _right_18 = exp.getRight();
                ArrayValue _get_6 = ((ArrayInit) _right_18).getValues().get(0);
                ArrayValue _get_7 = ((ArrayValue) _get_6).getValues().get(0);
                if ((_get_7 instanceof ArrayValue)) {
                  if ((((((ArrayValue) ((ArrayValue) ((ArrayInit) exp.getRight()).getValues().get(0)).getValues().get(0)).getValues().get(0) instanceof NumberLiteral) || 
                    (((ArrayValue) ((ArrayValue) ((ArrayInit) exp.getRight()).getValues().get(0)).getValues().get(0)).getValues().get(0) instanceof StringLiteral)) || 
                    (((ArrayValue) ((ArrayValue) ((ArrayInit) exp.getRight()).getValues().get(0)).getValues().get(0)).getValues().get(0) instanceof FloatLiteral))) {
                    EObject _right_19 = exp.getRight();
                    ArrayValue _get_8 = ((ArrayInit) _right_19).getValues().get(0);
                    ArrayValue _get_9 = ((ArrayValue) _get_8).getValues().get(0);
                    ArrayValue _get_10 = ((ArrayValue) _get_9).getValues().get(0);
                    String real_type_2 = this.valuateArithmeticExpression(((ArithmeticExpression) _get_10), scope);
                    EObject _right_20 = exp.getRight();
                    ArrayValue _get_11 = ((ArrayInit) _right_20).getValues().get(0);
                    ArrayValue _get_12 = ((ArrayValue) _get_11).getValues().get(0);
                    int col_3 = ((Object[])Conversions.unwrapArray(((ArrayValue) _get_12).getValues(), Object.class)).length;
                    EObject _right_21 = exp.getRight();
                    ArrayValue _get_13 = ((ArrayInit) _right_21).getValues().get(0);
                    ArrayValue _get_14 = ((ArrayValue) _get_13).getValues().get(0);
                    ArrayValue _get_15 = ((ArrayValue) _get_14).getValues().get(0);
                    int dep_1 = ((Object[])Conversions.unwrapArray(((ArrayValue) _get_15).getValues(), Object.class)).length;
                    this.typeSystem.get(scope).put(exp.getName(), ((((("Matrix_" + real_type_2) + "_") + Integer.valueOf(col_3)) + "_") + Integer.valueOf(dep_1)));
                    StringConcatenation _builder_7 = new StringConcatenation();
                    _builder_7.append("const ");
                    String _name_4 = exp.getName();
                    _builder_7.append(_name_4);
                    _builder_7.append(" = [");
                    String ret_1 = _builder_7.toString();
                    EObject _right_22 = exp.getRight();
                    EList<ArrayValue> _values_2 = ((ArrayInit) _right_22).getValues();
                    for (final ArrayValue e_2 : _values_2) {
                      {
                        String _ret_1 = ret_1;
                        StringConcatenation _builder_8 = new StringConcatenation();
                        _builder_8.append("[");
                        ret_1 = (_ret_1 + _builder_8);
                        EList<ArrayValue> _values_3 = ((ArrayValue) e_2).getValues();
                        for (final ArrayValue e1 : _values_3) {
                          {
                            String _ret_2 = ret_1;
                            StringConcatenation _builder_9 = new StringConcatenation();
                            _builder_9.append("[");
                            ret_1 = (_ret_2 + _builder_9);
                            EList<ArrayValue> _values_4 = ((ArrayValue) e1).getValues();
                            for (final ArrayValue e2 : _values_4) {
                              {
                                String _ret_3 = ret_1;
                                String _generateJsArithmeticExpression_1 = this.generateJsArithmeticExpression(((ArithmeticExpression) e2), scope);
                                ret_1 = (_ret_3 + _generateJsArithmeticExpression_1);
                                ArrayValue _last_1 = IterableExtensions.<ArrayValue>last(((ArrayValue) e1).getValues());
                                boolean _notEquals_1 = (!Objects.equal(e2, _last_1));
                                if (_notEquals_1) {
                                  String _ret_4 = ret_1;
                                  StringConcatenation _builder_10 = new StringConcatenation();
                                  _builder_10.append(",");
                                  ret_1 = (_ret_4 + _builder_10);
                                }
                              }
                            }
                            String _ret_3 = ret_1;
                            StringConcatenation _builder_10 = new StringConcatenation();
                            _builder_10.append("]");
                            ret_1 = (_ret_3 + _builder_10);
                            ArrayValue _last_1 = IterableExtensions.<ArrayValue>last(((ArrayValue) e_2).getValues());
                            boolean _notEquals_1 = (!Objects.equal(e1, _last_1));
                            if (_notEquals_1) {
                              String _ret_4 = ret_1;
                              StringConcatenation _builder_11 = new StringConcatenation();
                              _builder_11.append(",");
                              ret_1 = (_ret_4 + _builder_11);
                            }
                          }
                        }
                        String _ret_2 = ret_1;
                        StringConcatenation _builder_9 = new StringConcatenation();
                        _builder_9.append("]");
                        ret_1 = (_ret_2 + _builder_9);
                        EObject _right_23 = exp.getRight();
                        ArrayValue _last_1 = IterableExtensions.<ArrayValue>last(((ArrayInit) _right_23).getValues());
                        boolean _notEquals_1 = (!Objects.equal(e_2, _last_1));
                        if (_notEquals_1) {
                          String _ret_3 = ret_1;
                          StringConcatenation _builder_10 = new StringConcatenation();
                          _builder_10.append(",");
                          ret_1 = (_ret_3 + _builder_10);
                        }
                      }
                    }
                    String _ret_1 = ret_1;
                    StringConcatenation _builder_8 = new StringConcatenation();
                    _builder_8.append("]");
                    ret_1 = (_ret_1 + _builder_8);
                    return ret_1;
                  }
                }
              }
            }
          }
        } else {
          String _s_3 = s;
          StringConcatenation _builder_9 = new StringConcatenation();
          _builder_9.append("const ");
          String _name_5 = exp.getName();
          _builder_9.append(_name_5);
          _builder_9.append(" = ");
          EObject _right_23 = exp.getRight();
          String _generateJsArithmeticExpression_1 = this.generateJsArithmeticExpression(((ArithmeticExpression) _right_23), scope);
          _builder_9.append(_generateJsArithmeticExpression_1);
          _builder_9.append(";");
          _builder_9.newLineIfNotEmpty();
          s = (_s_3 + _builder_9);
        }
      }
    }
    return s;
  }
  
  public String generateJsExpression(final Expression exp, final String scope) {
    StringConcatenation _builder = new StringConcatenation();
    String s = _builder.toString();
    if ((exp instanceof ChannelSend)) {
      String _s = s;
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("__data = await sqs.getQueueUrl({ QueueName: \"");
      String _name = ((ChannelSend)exp).getTarget().getName();
      _builder_1.append(_name);
      _builder_1.append("_\'${id}\'\"}).promise();");
      _builder_1.newLineIfNotEmpty();
      _builder_1.newLine();
      _builder_1.append("__params = {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("MessageBody : JSON.stringify(");
      String _generateJsArithmeticExpression = this.generateJsArithmeticExpression(((ChannelSend)exp).getExpression(), scope);
      _builder_1.append(_generateJsArithmeticExpression, "\t");
      _builder_1.append("),");
      _builder_1.newLineIfNotEmpty();
      _builder_1.append("\t");
      _builder_1.append("QueueUrl : __data.QueueUrl");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("__data = await sqs.sendMessage(__params).promise();");
      _builder_1.newLine();
      s = (_s + _builder_1);
    } else {
      if ((exp instanceof VariableDeclaration)) {
        boolean _equals = ((VariableDeclaration)exp).getTypeobject().equals("var");
        if (_equals) {
          EObject _right = ((VariableDeclaration)exp).getRight();
          if ((_right instanceof NameObjectDef)) {
            this.typeSystem.get(scope).put(((VariableDeclaration)exp).getName(), "HashMap");
            String _s_1 = s;
            StringConcatenation _builder_2 = new StringConcatenation();
            _builder_2.append("var ");
            String _name_1 = ((VariableDeclaration)exp).getName();
            _builder_2.append(_name_1);
            _builder_2.append(" = {");
            s = (_s_1 + _builder_2);
            int i = 0;
            EObject _right_1 = ((VariableDeclaration)exp).getRight();
            EList<FeautureName> _features = ((NameObjectDef) _right_1).getFeatures();
            for (final FeautureName f : _features) {
              {
                String _feature = f.getFeature();
                boolean _notEquals = (!Objects.equal(_feature, null));
                if (_notEquals) {
                  HashMap<String, String> _get = this.typeSystem.get(scope);
                  String _name_2 = ((VariableDeclaration)exp).getName();
                  String _plus = (_name_2 + ".");
                  String _feature_1 = f.getFeature();
                  String _plus_1 = (_plus + _feature_1);
                  _get.put(_plus_1, 
                    this.valuateArithmeticExpression(f.getValue(), scope));
                  StringConcatenation _builder_3 = new StringConcatenation();
                  String _feature_2 = f.getFeature();
                  _builder_3.append(_feature_2);
                  _builder_3.append(":");
                  String _generateJsArithmeticExpression_1 = this.generateJsArithmeticExpression(f.getValue(), scope);
                  _builder_3.append(_generateJsArithmeticExpression_1);
                  String _plus_2 = (s + _builder_3);
                  s = _plus_2;
                } else {
                  HashMap<String, String> _get_1 = this.typeSystem.get(scope);
                  String _name_3 = ((VariableDeclaration)exp).getName();
                  String _plus_3 = (_name_3 + "[");
                  String _plus_4 = (_plus_3 + Integer.valueOf(i));
                  String _plus_5 = (_plus_4 + "]");
                  _get_1.put(_plus_5, 
                    this.valuateArithmeticExpression(f.getValue(), scope));
                  StringConcatenation _builder_4 = new StringConcatenation();
                  _builder_4.append(i);
                  _builder_4.append(":");
                  String _generateJsArithmeticExpression_2 = this.generateJsArithmeticExpression(f.getValue(), scope);
                  _builder_4.append(_generateJsArithmeticExpression_2);
                  String _plus_6 = (s + _builder_4);
                  s = _plus_6;
                  i++;
                }
                EObject _right_2 = ((VariableDeclaration)exp).getRight();
                FeautureName _last = IterableExtensions.<FeautureName>last(((NameObjectDef) _right_2).getFeatures());
                boolean _notEquals_1 = (!Objects.equal(f, _last));
                if (_notEquals_1) {
                  String _s_2 = s;
                  StringConcatenation _builder_5 = new StringConcatenation();
                  _builder_5.append(",");
                  s = (_s_2 + _builder_5);
                }
              }
            }
            String _s_2 = s;
            StringConcatenation _builder_3 = new StringConcatenation();
            _builder_3.append("}");
            s = (_s_2 + _builder_3);
          } else {
            EObject _right_2 = ((VariableDeclaration)exp).getRight();
            if ((_right_2 instanceof ArrayDefinition)) {
              EObject _right_3 = ((VariableDeclaration)exp).getRight();
              String type_decl = ((ArrayDefinition) _right_3).getType();
              EObject _right_4 = ((VariableDeclaration)exp).getRight();
              int _length = ((Object[])Conversions.unwrapArray(((ArrayDefinition) _right_4).getIndexes(), Object.class)).length;
              boolean _equals_1 = (_length == 1);
              if (_equals_1) {
                this.typeSystem.get(scope).put(((VariableDeclaration)exp).getName(), ("Array_" + type_decl));
              } else {
                EObject _right_5 = ((VariableDeclaration)exp).getRight();
                int _length_1 = ((Object[])Conversions.unwrapArray(((ArrayDefinition) _right_5).getIndexes(), Object.class)).length;
                boolean _equals_2 = (_length_1 == 2);
                if (_equals_2) {
                  EObject _right_6 = ((VariableDeclaration)exp).getRight();
                  String col = this.generateJsArithmeticExpression(((ArrayDefinition) _right_6).getIndexes().get(1).getValue(), scope);
                  this.typeSystem.get(scope).put(((VariableDeclaration)exp).getName(), ((("Matrix_" + type_decl) + "_") + col));
                } else {
                  EObject _right_7 = ((VariableDeclaration)exp).getRight();
                  int _length_2 = ((Object[])Conversions.unwrapArray(((ArrayDefinition) _right_7).getIndexes(), Object.class)).length;
                  boolean _equals_3 = (_length_2 == 3);
                  if (_equals_3) {
                    EObject _right_8 = ((VariableDeclaration)exp).getRight();
                    String col_1 = this.generateJsArithmeticExpression(((ArrayDefinition) _right_8).getIndexes().get(1).getValue(), scope);
                    EObject _right_9 = ((VariableDeclaration)exp).getRight();
                    String dep = this.generateJsArithmeticExpression(((ArrayDefinition) _right_9).getIndexes().get(2).getValue(), scope);
                    this.typeSystem.get(scope).put(((VariableDeclaration)exp).getName(), ((((("Matrix_" + type_decl) + "_") + col_1) + "_") + dep));
                  }
                }
              }
              String _s_3 = s;
              StringConcatenation _builder_4 = new StringConcatenation();
              _builder_4.append("var ");
              String _name_2 = ((VariableDeclaration)exp).getName();
              _builder_4.append(_name_2);
              _builder_4.append(" = [];");
              _builder_4.newLineIfNotEmpty();
              s = (_s_3 + _builder_4);
            } else {
              EObject _right_10 = ((VariableDeclaration)exp).getRight();
              if ((_right_10 instanceof ArrayInit)) {
                if ((((((ArrayInit) ((VariableDeclaration)exp).getRight()).getValues().get(0) instanceof NumberLiteral) || (((ArrayInit) ((VariableDeclaration)exp).getRight()).getValues().get(0) instanceof StringLiteral)) || (((ArrayInit) ((VariableDeclaration)exp).getRight()).getValues().get(0) instanceof FloatLiteral))) {
                  EObject _right_11 = ((VariableDeclaration)exp).getRight();
                  ArrayValue _get = ((ArrayInit) _right_11).getValues().get(0);
                  String real_type = this.valuateArithmeticExpression(((ArithmeticExpression) _get), scope);
                  this.typeSystem.get(scope).put(((VariableDeclaration)exp).getName(), ("Array_" + real_type));
                  StringConcatenation _builder_5 = new StringConcatenation();
                  _builder_5.append("var ");
                  String _name_3 = ((VariableDeclaration)exp).getName();
                  _builder_5.append(_name_3);
                  _builder_5.append(" = [");
                  {
                    EObject _right_12 = ((VariableDeclaration)exp).getRight();
                    EList<ArrayValue> _values = ((ArrayInit) _right_12).getValues();
                    for(final ArrayValue e : _values) {
                      String _generateJsArithmeticExpression_1 = this.generateJsArithmeticExpression(((ArithmeticExpression) e), scope);
                      _builder_5.append(_generateJsArithmeticExpression_1);
                      {
                        EObject _right_13 = ((VariableDeclaration)exp).getRight();
                        ArrayValue _last = IterableExtensions.<ArrayValue>last(((ArrayInit) _right_13).getValues());
                        boolean _notEquals = (!Objects.equal(e, _last));
                        if (_notEquals) {
                          _builder_5.append(",");
                        }
                      }
                    }
                  }
                  _builder_5.append("]");
                  _builder_5.newLineIfNotEmpty();
                  return _builder_5.toString();
                } else {
                  EObject _right_14 = ((VariableDeclaration)exp).getRight();
                  ArrayValue _get_1 = ((ArrayInit) _right_14).getValues().get(0);
                  if ((_get_1 instanceof ArrayValue)) {
                    if ((((((ArrayValue) ((ArrayInit) ((VariableDeclaration)exp).getRight()).getValues().get(0)).getValues().get(0) instanceof NumberLiteral) || 
                      (((ArrayValue) ((ArrayInit) ((VariableDeclaration)exp).getRight()).getValues().get(0)).getValues().get(0) instanceof StringLiteral)) || 
                      (((ArrayValue) ((ArrayInit) ((VariableDeclaration)exp).getRight()).getValues().get(0)).getValues().get(0) instanceof FloatLiteral))) {
                      EObject _right_15 = ((VariableDeclaration)exp).getRight();
                      ArrayValue _get_2 = ((ArrayInit) _right_15).getValues().get(0);
                      ArrayValue _get_3 = ((ArrayValue) _get_2).getValues().get(0);
                      String real_type_1 = this.valuateArithmeticExpression(((ArithmeticExpression) _get_3), scope);
                      EObject _right_16 = ((VariableDeclaration)exp).getRight();
                      ArrayValue _get_4 = ((ArrayInit) _right_16).getValues().get(0);
                      ArrayValue _get_5 = ((ArrayValue) _get_4).getValues().get(0);
                      int col_2 = ((Object[])Conversions.unwrapArray(((ArrayValue) _get_5).getValues(), Object.class)).length;
                      this.typeSystem.get(scope).put(((VariableDeclaration)exp).getName(), ((("Matrix_" + real_type_1) + "_") + Integer.valueOf(col_2)));
                      StringConcatenation _builder_6 = new StringConcatenation();
                      _builder_6.append("var ");
                      String _name_4 = ((VariableDeclaration)exp).getName();
                      _builder_6.append(_name_4);
                      _builder_6.append(" = [");
                      String ret = _builder_6.toString();
                      EObject _right_17 = ((VariableDeclaration)exp).getRight();
                      EList<ArrayValue> _values_1 = ((ArrayInit) _right_17).getValues();
                      for (final ArrayValue e_1 : _values_1) {
                        {
                          String _ret = ret;
                          StringConcatenation _builder_7 = new StringConcatenation();
                          _builder_7.append("[");
                          ret = (_ret + _builder_7);
                          EList<ArrayValue> _values_2 = ((ArrayValue) e_1).getValues();
                          for (final ArrayValue e1 : _values_2) {
                            {
                              String _ret_1 = ret;
                              String _generateJsArithmeticExpression_2 = this.generateJsArithmeticExpression(((ArithmeticExpression) e1), scope);
                              ret = (_ret_1 + _generateJsArithmeticExpression_2);
                              ArrayValue _last_1 = IterableExtensions.<ArrayValue>last(((ArrayValue) e_1).getValues());
                              boolean _notEquals_1 = (!Objects.equal(e1, _last_1));
                              if (_notEquals_1) {
                                String _ret_2 = ret;
                                StringConcatenation _builder_8 = new StringConcatenation();
                                _builder_8.append(",");
                                ret = (_ret_2 + _builder_8);
                              }
                            }
                          }
                          String _ret_1 = ret;
                          StringConcatenation _builder_8 = new StringConcatenation();
                          _builder_8.append("]");
                          ret = (_ret_1 + _builder_8);
                          EObject _right_18 = ((VariableDeclaration)exp).getRight();
                          ArrayValue _last_1 = IterableExtensions.<ArrayValue>last(((ArrayInit) _right_18).getValues());
                          boolean _notEquals_1 = (!Objects.equal(e_1, _last_1));
                          if (_notEquals_1) {
                            String _ret_2 = ret;
                            StringConcatenation _builder_9 = new StringConcatenation();
                            _builder_9.append(",");
                            ret = (_ret_2 + _builder_9);
                          }
                        }
                      }
                      String _ret = ret;
                      StringConcatenation _builder_7 = new StringConcatenation();
                      _builder_7.append("]");
                      ret = (_ret + _builder_7);
                      return ret;
                    } else {
                      EObject _right_18 = ((VariableDeclaration)exp).getRight();
                      ArrayValue _get_6 = ((ArrayInit) _right_18).getValues().get(0);
                      ArrayValue _get_7 = ((ArrayValue) _get_6).getValues().get(0);
                      if ((_get_7 instanceof ArrayValue)) {
                        if ((((((ArrayValue) ((ArrayValue) ((ArrayInit) ((VariableDeclaration)exp).getRight()).getValues().get(0)).getValues().get(0)).getValues().get(0) instanceof NumberLiteral) || 
                          (((ArrayValue) ((ArrayValue) ((ArrayInit) ((VariableDeclaration)exp).getRight()).getValues().get(0)).getValues().get(0)).getValues().get(0) instanceof StringLiteral)) || 
                          (((ArrayValue) ((ArrayValue) ((ArrayInit) ((VariableDeclaration)exp).getRight()).getValues().get(0)).getValues().get(0)).getValues().get(0) instanceof FloatLiteral))) {
                          EObject _right_19 = ((VariableDeclaration)exp).getRight();
                          ArrayValue _get_8 = ((ArrayInit) _right_19).getValues().get(0);
                          ArrayValue _get_9 = ((ArrayValue) _get_8).getValues().get(0);
                          ArrayValue _get_10 = ((ArrayValue) _get_9).getValues().get(0);
                          String real_type_2 = this.valuateArithmeticExpression(((ArithmeticExpression) _get_10), scope);
                          EObject _right_20 = ((VariableDeclaration)exp).getRight();
                          ArrayValue _get_11 = ((ArrayInit) _right_20).getValues().get(0);
                          ArrayValue _get_12 = ((ArrayValue) _get_11).getValues().get(0);
                          int col_3 = ((Object[])Conversions.unwrapArray(((ArrayValue) _get_12).getValues(), Object.class)).length;
                          EObject _right_21 = ((VariableDeclaration)exp).getRight();
                          ArrayValue _get_13 = ((ArrayInit) _right_21).getValues().get(0);
                          ArrayValue _get_14 = ((ArrayValue) _get_13).getValues().get(0);
                          ArrayValue _get_15 = ((ArrayValue) _get_14).getValues().get(0);
                          int dep_1 = ((Object[])Conversions.unwrapArray(((ArrayValue) _get_15).getValues(), Object.class)).length;
                          this.typeSystem.get(scope).put(((VariableDeclaration)exp).getName(), ((((("Matrix_" + real_type_2) + "_") + Integer.valueOf(col_3)) + "_") + Integer.valueOf(dep_1)));
                          StringConcatenation _builder_8 = new StringConcatenation();
                          _builder_8.append("var ");
                          String _name_5 = ((VariableDeclaration)exp).getName();
                          _builder_8.append(_name_5);
                          _builder_8.append(" = [");
                          String ret_1 = _builder_8.toString();
                          EObject _right_22 = ((VariableDeclaration)exp).getRight();
                          EList<ArrayValue> _values_2 = ((ArrayInit) _right_22).getValues();
                          for (final ArrayValue e_2 : _values_2) {
                            {
                              String _ret_1 = ret_1;
                              StringConcatenation _builder_9 = new StringConcatenation();
                              _builder_9.append("[");
                              ret_1 = (_ret_1 + _builder_9);
                              EList<ArrayValue> _values_3 = ((ArrayValue) e_2).getValues();
                              for (final ArrayValue e1 : _values_3) {
                                {
                                  String _ret_2 = ret_1;
                                  StringConcatenation _builder_10 = new StringConcatenation();
                                  _builder_10.append("[");
                                  ret_1 = (_ret_2 + _builder_10);
                                  EList<ArrayValue> _values_4 = ((ArrayValue) e1).getValues();
                                  for (final ArrayValue e2 : _values_4) {
                                    {
                                      String _ret_3 = ret_1;
                                      String _generateJsArithmeticExpression_2 = this.generateJsArithmeticExpression(((ArithmeticExpression) e2), scope);
                                      ret_1 = (_ret_3 + _generateJsArithmeticExpression_2);
                                      ArrayValue _last_1 = IterableExtensions.<ArrayValue>last(((ArrayValue) e1).getValues());
                                      boolean _notEquals_1 = (!Objects.equal(e2, _last_1));
                                      if (_notEquals_1) {
                                        String _ret_4 = ret_1;
                                        StringConcatenation _builder_11 = new StringConcatenation();
                                        _builder_11.append(",");
                                        ret_1 = (_ret_4 + _builder_11);
                                      }
                                    }
                                  }
                                  String _ret_3 = ret_1;
                                  StringConcatenation _builder_11 = new StringConcatenation();
                                  _builder_11.append("]");
                                  ret_1 = (_ret_3 + _builder_11);
                                  ArrayValue _last_1 = IterableExtensions.<ArrayValue>last(((ArrayValue) e_2).getValues());
                                  boolean _notEquals_1 = (!Objects.equal(e1, _last_1));
                                  if (_notEquals_1) {
                                    String _ret_4 = ret_1;
                                    StringConcatenation _builder_12 = new StringConcatenation();
                                    _builder_12.append(",");
                                    ret_1 = (_ret_4 + _builder_12);
                                  }
                                }
                              }
                              String _ret_2 = ret_1;
                              StringConcatenation _builder_10 = new StringConcatenation();
                              _builder_10.append("]");
                              ret_1 = (_ret_2 + _builder_10);
                              EObject _right_23 = ((VariableDeclaration)exp).getRight();
                              ArrayValue _last_1 = IterableExtensions.<ArrayValue>last(((ArrayInit) _right_23).getValues());
                              boolean _notEquals_1 = (!Objects.equal(e_2, _last_1));
                              if (_notEquals_1) {
                                String _ret_3 = ret_1;
                                StringConcatenation _builder_11 = new StringConcatenation();
                                _builder_11.append(",");
                                ret_1 = (_ret_3 + _builder_11);
                              }
                            }
                          }
                          String _ret_1 = ret_1;
                          StringConcatenation _builder_9 = new StringConcatenation();
                          _builder_9.append("]");
                          ret_1 = (_ret_1 + _builder_9);
                          return ret_1;
                        }
                      }
                    }
                  }
                }
              } else {
                String _s_4 = s;
                StringConcatenation _builder_10 = new StringConcatenation();
                _builder_10.append("var ");
                String _name_6 = ((VariableDeclaration)exp).getName();
                _builder_10.append(_name_6);
                _builder_10.append(" = ");
                EObject _right_23 = ((VariableDeclaration)exp).getRight();
                String _generateJsArithmeticExpression_2 = this.generateJsArithmeticExpression(((ArithmeticExpression) _right_23), scope);
                _builder_10.append(_generateJsArithmeticExpression_2);
                _builder_10.append(";");
                _builder_10.newLineIfNotEmpty();
                s = (_s_4 + _builder_10);
              }
            }
          }
        } else {
          boolean _equals_4 = ((VariableDeclaration)exp).getTypeobject().equals("dat");
          if (_equals_4) {
            this.typeSystem.get(scope).put(((VariableDeclaration)exp).getName(), "Table");
            EObject _right_24 = ((VariableDeclaration)exp).getRight();
            String path = ((DeclarationObject) _right_24).getFeatures().get(1).getValue_s();
            String _s_5 = s;
            StringConcatenation _builder_11 = new StringConcatenation();
            _builder_11.append("var __");
            String _name_7 = ((VariableDeclaration)exp).getName();
            _builder_11.append(_name_7);
            _builder_11.append(" = await __dataframe.fromCSV(");
            {
              if ((((DatDeclaration) exp).isOnCloud() && (!path.contains("https://")))) {
                _builder_11.append(" \"https://s3.us-east-2.amazonaws.com/bucket-\'${id}\'/");
                _builder_11.append(path);
                _builder_11.append("\" ");
              } else {
                _builder_11.append(path);
              }
            }
            _builder_11.append(")");
            _builder_11.newLineIfNotEmpty();
            _builder_11.append("var ");
            String _name_8 = ((VariableDeclaration)exp).getName();
            _builder_11.append(_name_8);
            _builder_11.append(" = __");
            String _name_9 = ((VariableDeclaration)exp).getName();
            _builder_11.append(_name_9);
            _builder_11.append(".toArray()");
            _builder_11.newLineIfNotEmpty();
            s = (_s_5 + _builder_11);
          }
        }
      } else {
        if ((exp instanceof IfExpression)) {
          String _s_6 = s;
          StringConcatenation _builder_12 = new StringConcatenation();
          _builder_12.append("if(");
          String _generateJsArithmeticExpression_3 = this.generateJsArithmeticExpression(((IfExpression)exp).getCond(), scope);
          _builder_12.append(_generateJsArithmeticExpression_3);
          _builder_12.append(")");
          _builder_12.newLineIfNotEmpty();
          _builder_12.append("\t");
          Object _generateJsExpression = this.generateJsExpression(((IfExpression)exp).getThen(), scope);
          _builder_12.append(_generateJsExpression, "\t");
          _builder_12.append(" ");
          _builder_12.newLineIfNotEmpty();
          {
            Expression _else = ((IfExpression)exp).getElse();
            boolean _notEquals_1 = (!Objects.equal(_else, null));
            if (_notEquals_1) {
              _builder_12.append("else");
              _builder_12.newLine();
              _builder_12.append("\t");
              Object _generateJsExpression_1 = this.generateJsExpression(((IfExpression)exp).getElse(), scope);
              _builder_12.append(_generateJsExpression_1, "\t");
              _builder_12.newLineIfNotEmpty();
            }
          }
          s = (_s_6 + _builder_12);
        } else {
          if ((exp instanceof ForExpression)) {
            String _s_7 = s;
            StringConcatenation _builder_13 = new StringConcatenation();
            String _generateJsForExpression = this.generateJsForExpression(((ForExpression)exp), scope);
            _builder_13.append(_generateJsForExpression);
            _builder_13.newLineIfNotEmpty();
            s = (_s_7 + _builder_13);
          } else {
            if ((exp instanceof WhileExpression)) {
              String _s_8 = s;
              StringConcatenation _builder_14 = new StringConcatenation();
              CharSequence _generateJsWhileExpression = this.generateJsWhileExpression(((WhileExpression)exp), scope);
              _builder_14.append(_generateJsWhileExpression);
              _builder_14.newLineIfNotEmpty();
              s = (_s_8 + _builder_14);
            } else {
              if ((exp instanceof BlockExpression)) {
                String _s_9 = s;
                StringConcatenation _builder_15 = new StringConcatenation();
                String _generateJsBlockExpression = this.generateJsBlockExpression(((BlockExpression)exp), scope);
                _builder_15.append(_generateJsBlockExpression);
                _builder_15.newLineIfNotEmpty();
                s = (_s_9 + _builder_15);
              } else {
                if ((exp instanceof Assignment)) {
                  String _s_10 = s;
                  StringConcatenation _builder_16 = new StringConcatenation();
                  String _generateJsAssignmentExpression = this.generateJsAssignmentExpression(((Assignment)exp), scope);
                  _builder_16.append(_generateJsAssignmentExpression);
                  _builder_16.newLineIfNotEmpty();
                  s = (_s_10 + _builder_16);
                } else {
                  if ((exp instanceof PrintExpression)) {
                    String _s_11 = s;
                    StringConcatenation _builder_17 = new StringConcatenation();
                    _builder_17.append("console.log(");
                    String _generateJsArithmeticExpression_4 = this.generateJsArithmeticExpression(((PrintExpression)exp).getPrint(), scope);
                    _builder_17.append(_generateJsArithmeticExpression_4);
                    _builder_17.append(") ");
                    _builder_17.newLineIfNotEmpty();
                    s = (_s_11 + _builder_17);
                  } else {
                    if ((exp instanceof NativeExpression)) {
                      String _s_12 = s;
                      StringConcatenation _builder_18 = new StringConcatenation();
                      String _generateJsNativeExpression = this.generateJsNativeExpression(((NativeExpression)exp));
                      _builder_18.append(_generateJsNativeExpression);
                      _builder_18.newLineIfNotEmpty();
                      s = (_s_12 + _builder_18);
                    } else {
                      if ((exp instanceof PostfixOperation)) {
                        String _s_13 = s;
                        StringConcatenation _builder_19 = new StringConcatenation();
                        String _generateJsArithmeticExpression_5 = this.generateJsArithmeticExpression(((PostfixOperation)exp).getVariable(), scope);
                        _builder_19.append(_generateJsArithmeticExpression_5);
                        String _feature = ((PostfixOperation)exp).getFeature();
                        _builder_19.append(_feature);
                        _builder_19.newLineIfNotEmpty();
                        s = (_s_13 + _builder_19);
                      } else {
                        if ((exp instanceof LocalFunctionCall)) {
                          String _s_14 = s;
                          String _name_10 = ((LocalFunctionCall)exp).getTarget().getName();
                          String _plus = (_name_10 + "(");
                          s = (_s_14 + _plus);
                          LocalFunctionInput _input = ((LocalFunctionCall)exp).getInput();
                          boolean _notEquals_2 = (!Objects.equal(_input, null));
                          if (_notEquals_2) {
                            EList<ArithmeticExpression> _inputs = ((LocalFunctionCall)exp).getInput().getInputs();
                            for (final ArithmeticExpression input : _inputs) {
                              {
                                String _s_15 = s;
                                String _generateJsArithmeticExpression_6 = this.generateJsArithmeticExpression(input, scope);
                                s = (_s_15 + _generateJsArithmeticExpression_6);
                                ArithmeticExpression _last_1 = IterableExtensions.<ArithmeticExpression>last(((LocalFunctionCall)exp).getInput().getInputs());
                                boolean _notEquals_3 = (!Objects.equal(input, _last_1));
                                if (_notEquals_3) {
                                  String _s_16 = s;
                                  s = (_s_16 + ",");
                                }
                              }
                            }
                          }
                          String _s_15 = s;
                          s = (_s_15 + ")");
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return s;
  }
  
  public String generateJsNativeExpression(final NativeExpression expression) {
    int i = 0;
    String[] lines = expression.getCode().split("\n");
    int num_tabs = 0;
    while (Character.valueOf(lines[1].charAt(i)).equals(Character.valueOf(lines[1].charAt(0)))) {
      {
        num_tabs++;
        i++;
      }
    }
    i = 0;
    StringBuilder ret = new StringBuilder();
    for (i = 1; (i < (lines.length - 1)); i++) {
      {
        StringConcatenation _builder = new StringConcatenation();
        String _substring = lines[i].substring(num_tabs);
        _builder.append(_substring);
        ret.append(_builder);
        ret.append("\n");
      }
    }
    return ret.toString();
  }
  
  public String generateJsAssignmentExpression(final Assignment assignment, final String scope) {
    ArithmeticExpression _feature = assignment.getFeature();
    boolean _notEquals = (!Objects.equal(_feature, null));
    if (_notEquals) {
      if (((assignment.getValue() instanceof CastExpression) && (((CastExpression) assignment.getValue()).getTarget() instanceof ChannelReceive))) {
        ArithmeticExpression _value = assignment.getValue();
        ArithmeticExpression _target = ((CastExpression) _value).getTarget();
        EObject _right = ((ChannelReceive) _target).getTarget().getEnvironment().getRight();
        boolean _equals = ((DeclarationObject) _right).getFeatures().get(0).getValue_s().equals("aws");
        if (_equals) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("__data = await sqs.getQueueUrl({ QueueName: \"");
          ArithmeticExpression _value_1 = assignment.getValue();
          ArithmeticExpression _target_1 = ((CastExpression) _value_1).getTarget();
          String _name = ((ChannelReceive) _target_1).getTarget().getName();
          _builder.append(_name);
          _builder.append("_\'${id}\'}\").promise();");
          _builder.newLineIfNotEmpty();
          _builder.append("__data = await sqs.sendMessage({QueueUrl : __data.QueueUrl }).promise();");
          _builder.newLine();
          String _generateJsArithmeticExpression = this.generateJsArithmeticExpression(assignment.getFeature(), scope);
          _builder.append(_generateJsArithmeticExpression);
          _builder.append(" ");
          String _op = assignment.getOp();
          _builder.append(_op);
          _builder.append(" __data.Messages[0].Body");
          _builder.newLineIfNotEmpty();
          return _builder.toString();
        } else {
        }
      } else {
        ArithmeticExpression _value_2 = assignment.getValue();
        if ((_value_2 instanceof ChannelReceive)) {
          ArithmeticExpression _value_3 = assignment.getValue();
          EObject _right_1 = ((ChannelReceive) _value_3).getTarget().getEnvironment().getRight();
          boolean _equals_1 = ((DeclarationObject) _right_1).getFeatures().get(0).getValue_s().equals("aws");
          if (_equals_1) {
            StringConcatenation _builder_1 = new StringConcatenation();
            _builder_1.append("__data = await sqs.getQueueUrl({ QueueName: \"");
            ArithmeticExpression _value_4 = assignment.getValue();
            ArithmeticExpression _target_2 = ((CastExpression) _value_4).getTarget();
            String _name_1 = ((ChannelReceive) _target_2).getTarget().getName();
            _builder_1.append(_name_1);
            _builder_1.append("_\'${id}\'\"}).promise();");
            _builder_1.newLineIfNotEmpty();
            _builder_1.append("__data = await sqs.sendMessage({QueueUrl : __data.QueueUrl }).promise();");
            _builder_1.newLine();
            String _generateJsArithmeticExpression_1 = this.generateJsArithmeticExpression(assignment.getFeature(), scope);
            _builder_1.append(_generateJsArithmeticExpression_1);
            _builder_1.append(" ");
            String _op_1 = assignment.getOp();
            _builder_1.append(_op_1);
            _builder_1.append(" __data.Messages[0].Body");
            _builder_1.newLineIfNotEmpty();
            return _builder_1.toString();
          } else {
            StringConcatenation _builder_2 = new StringConcatenation();
            _builder_2.append("\t\t\t\t\t\t");
            _builder_2.newLine();
            return _builder_2.toString();
          }
        } else {
          StringConcatenation _builder_3 = new StringConcatenation();
          String _generateJsArithmeticExpression_2 = this.generateJsArithmeticExpression(assignment.getFeature(), scope);
          _builder_3.append(_generateJsArithmeticExpression_2);
          _builder_3.append(" ");
          String _op_2 = assignment.getOp();
          _builder_3.append(_op_2);
          _builder_3.append(" ");
          String _generateJsArithmeticExpression_3 = this.generateJsArithmeticExpression(assignment.getValue(), scope);
          _builder_3.append(_generateJsArithmeticExpression_3);
          _builder_3.append(" ");
          _builder_3.newLineIfNotEmpty();
          return _builder_3.toString();
        }
      }
    }
    ObjectLiteral _feature_obj = assignment.getFeature_obj();
    boolean _tripleNotEquals = (_feature_obj != null);
    if (_tripleNotEquals) {
      ObjectLiteral _feature_obj_1 = assignment.getFeature_obj();
      if ((_feature_obj_1 instanceof NameObject)) {
        HashMap<String, String> _get = this.typeSystem.get(scope);
        ObjectLiteral _feature_obj_2 = assignment.getFeature_obj();
        VariableDeclaration _name_2 = ((NameObject) _feature_obj_2).getName();
        String _name_3 = ((VariableDeclaration) _name_2).getName();
        String _plus = (_name_3 + ".");
        ObjectLiteral _feature_obj_3 = assignment.getFeature_obj();
        String _value_5 = ((NameObject) _feature_obj_3).getValue();
        String _plus_1 = (_plus + _value_5);
        _get.put(_plus_1, 
          this.valuateArithmeticExpression(assignment.getValue(), scope));
        StringConcatenation _builder_4 = new StringConcatenation();
        ObjectLiteral _feature_obj_4 = assignment.getFeature_obj();
        VariableDeclaration _name_4 = ((NameObject) _feature_obj_4).getName();
        String _name_5 = ((VariableDeclaration) _name_4).getName();
        _builder_4.append(_name_5);
        _builder_4.append("[\"");
        ObjectLiteral _feature_obj_5 = assignment.getFeature_obj();
        String _value_6 = ((NameObject) _feature_obj_5).getValue();
        _builder_4.append(_value_6);
        _builder_4.append("\"] = ");
        String _generateJsArithmeticExpression_4 = this.generateJsArithmeticExpression(assignment.getValue(), scope);
        _builder_4.append(_generateJsArithmeticExpression_4);
        _builder_4.append(" ");
        _builder_4.newLineIfNotEmpty();
        return _builder_4.toString();
      }
      ObjectLiteral _feature_obj_6 = assignment.getFeature_obj();
      if ((_feature_obj_6 instanceof IndexObject)) {
        ObjectLiteral _feature_obj_7 = assignment.getFeature_obj();
        boolean _contains = this.typeSystem.get(scope).get(((IndexObject) _feature_obj_7).getName().getName()).contains("Array");
        if (_contains) {
          StringConcatenation _builder_5 = new StringConcatenation();
          ObjectLiteral _feature_obj_8 = assignment.getFeature_obj();
          String _name_6 = ((IndexObject) _feature_obj_8).getName().getName();
          _builder_5.append(_name_6);
          _builder_5.append("[");
          ObjectLiteral _feature_obj_9 = assignment.getFeature_obj();
          String _generateJsArithmeticExpression_5 = this.generateJsArithmeticExpression(((IndexObject) _feature_obj_9).getIndexes().get(0).getValue(), scope);
          _builder_5.append(_generateJsArithmeticExpression_5);
          _builder_5.append("] = ");
          String _generateJsArithmeticExpression_6 = this.generateJsArithmeticExpression(assignment.getValue(), scope);
          _builder_5.append(_generateJsArithmeticExpression_6);
          _builder_5.newLineIfNotEmpty();
          return _builder_5.toString();
        } else {
          ObjectLiteral _feature_obj_10 = assignment.getFeature_obj();
          boolean _contains_1 = this.typeSystem.get(scope).get(((IndexObject) _feature_obj_10).getName().getName()).contains("Matrix");
          if (_contains_1) {
            ObjectLiteral _feature_obj_11 = assignment.getFeature_obj();
            int _length = ((Object[])Conversions.unwrapArray(((IndexObject) _feature_obj_11).getIndexes(), Object.class)).length;
            boolean _equals_2 = (_length == 2);
            if (_equals_2) {
              ObjectLiteral _feature_obj_12 = assignment.getFeature_obj();
              String i = this.generateJsArithmeticExpression(((IndexObject) _feature_obj_12).getIndexes().get(0).getValue(), scope);
              ObjectLiteral _feature_obj_13 = assignment.getFeature_obj();
              String j = this.generateJsArithmeticExpression(((IndexObject) _feature_obj_13).getIndexes().get(1).getValue(), scope);
              ObjectLiteral _feature_obj_14 = assignment.getFeature_obj();
              String col = this.typeSystem.get(scope).get(((IndexObject) _feature_obj_14).getName().getName()).split("_")[2];
              StringConcatenation _builder_6 = new StringConcatenation();
              ObjectLiteral _feature_obj_15 = assignment.getFeature_obj();
              String _name_7 = ((IndexObject) _feature_obj_15).getName().getName();
              _builder_6.append(_name_7);
              _builder_6.append("[(");
              _builder_6.append(i);
              _builder_6.append("*");
              _builder_6.append(col);
              _builder_6.append(")+");
              _builder_6.append(j);
              _builder_6.append("] = ");
              String _generateJsArithmeticExpression_7 = this.generateJsArithmeticExpression(assignment.getValue(), scope);
              _builder_6.append(_generateJsArithmeticExpression_7);
              _builder_6.newLineIfNotEmpty();
              return _builder_6.toString();
            } else {
              StringConcatenation _builder_7 = new StringConcatenation();
              ObjectLiteral _feature_obj_16 = assignment.getFeature_obj();
              String _name_8 = ((IndexObject) _feature_obj_16).getName().getName();
              _builder_7.append(_name_8);
              _builder_7.append("[");
              ObjectLiteral _feature_obj_17 = assignment.getFeature_obj();
              String _generateJsArithmeticExpression_8 = this.generateJsArithmeticExpression(((IndexObject) _feature_obj_17).getIndexes().get(0).getValue(), scope);
              _builder_7.append(_generateJsArithmeticExpression_8);
              _builder_7.append(",");
              ObjectLiteral _feature_obj_18 = assignment.getFeature_obj();
              String _generateJsArithmeticExpression_9 = this.generateJsArithmeticExpression(((IndexObject) _feature_obj_18).getIndexes().get(1).getValue(), scope);
              _builder_7.append(_generateJsArithmeticExpression_9);
              _builder_7.append(",");
              ObjectLiteral _feature_obj_19 = assignment.getFeature_obj();
              String _generateJsArithmeticExpression_10 = this.generateJsArithmeticExpression(((IndexObject) _feature_obj_19).getIndexes().get(2).getValue(), scope);
              _builder_7.append(_generateJsArithmeticExpression_10);
              _builder_7.append("] = ");
              String _generateJsArithmeticExpression_11 = this.generateJsArithmeticExpression(assignment.getValue(), scope);
              _builder_7.append(_generateJsArithmeticExpression_11);
              _builder_7.newLineIfNotEmpty();
              return _builder_7.toString();
            }
          } else {
            HashMap<String, String> _get_1 = this.typeSystem.get(scope);
            ObjectLiteral _feature_obj_20 = assignment.getFeature_obj();
            VariableDeclaration _name_9 = ((IndexObject) _feature_obj_20).getName();
            String _name_10 = ((VariableDeclaration) _name_9).getName();
            String _plus_2 = (_name_10 + "[");
            ObjectLiteral _feature_obj_21 = assignment.getFeature_obj();
            String _generateJsArithmeticExpression_12 = this.generateJsArithmeticExpression(((IndexObject) _feature_obj_21).getIndexes().get(0).getValue(), scope);
            String _plus_3 = (_plus_2 + _generateJsArithmeticExpression_12);
            String _plus_4 = (_plus_3 + "]");
            _get_1.put(_plus_4, 
              this.valuateArithmeticExpression(assignment.getValue(), scope));
            StringConcatenation _builder_8 = new StringConcatenation();
            ObjectLiteral _feature_obj_22 = assignment.getFeature_obj();
            VariableDeclaration _name_11 = ((IndexObject) _feature_obj_22).getName();
            String _name_12 = ((VariableDeclaration) _name_11).getName();
            _builder_8.append(_name_12);
            _builder_8.append("[");
            ObjectLiteral _feature_obj_23 = assignment.getFeature_obj();
            String _generateJsArithmeticExpression_13 = this.generateJsArithmeticExpression(((IndexObject) _feature_obj_23).getIndexes().get(0).getValue(), scope);
            _builder_8.append(_generateJsArithmeticExpression_13);
            _builder_8.append("] = ");
            String _generateJsArithmeticExpression_14 = this.generateJsArithmeticExpression(assignment.getValue(), scope);
            _builder_8.append(_generateJsArithmeticExpression_14);
            _builder_8.append(" ");
            _builder_8.newLineIfNotEmpty();
            return _builder_8.toString();
          }
        }
      }
    }
    return null;
  }
  
  public CharSequence generateJsWhileExpression(final WhileExpression exp, final String scope) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("while(");
    String _generateJsArithmeticExpression = this.generateJsArithmeticExpression(exp.getCond(), scope);
    _builder.append(_generateJsArithmeticExpression);
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    Object _generateJsExpression = this.generateJsExpression(exp.getBody(), scope);
    _builder.append(_generateJsExpression, "\t");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public String generateJsForExpression(final ForExpression exp, final String scope) {
    ArithmeticExpression _object = exp.getObject();
    if ((_object instanceof CastExpression)) {
      ArithmeticExpression _object_1 = exp.getObject();
      boolean _equals = ((CastExpression) _object_1).getType().equals("Dat");
      if (_equals) {
        int _length = ((Object[])Conversions.unwrapArray(exp.getIndex().getIndices(), Object.class)).length;
        boolean _equals_1 = (_length == 1);
        if (_equals_1) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("for(var __");
          VariableFor _get = exp.getIndex().getIndices().get(0);
          String _name = ((VariableDeclaration) _get).getName();
          _builder.append(_name);
          _builder.append(" in ");
          ArithmeticExpression _object_2 = exp.getObject();
          ArithmeticExpression _target = ((CastExpression) _object_2).getTarget();
          String _name_1 = ((VariableLiteral) _target).getVariable().getName();
          _builder.append(_name_1);
          _builder.append("»){");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("var ");
          VariableFor _get_1 = exp.getIndex().getIndices().get(0);
          String _name_2 = ((VariableDeclaration) _get_1).getName();
          _builder.append(_name_2, "\t");
          _builder.append(" = ");
          VariableFor _get_2 = exp.getIndex().getIndices().get(0);
          String _name_3 = ((VariableDeclaration) _get_2).getName();
          _builder.append(_name_3, "\t");
          _builder.append("[__");
          VariableFor _get_3 = exp.getIndex().getIndices().get(0);
          String _name_4 = ((VariableDeclaration) _get_3).getName();
          _builder.append(_name_4, "\t");
          _builder.append("];");
          _builder.newLineIfNotEmpty();
          {
            Expression _body = exp.getBody();
            if ((_body instanceof BlockExpression)) {
              {
                Expression _body_1 = exp.getBody();
                EList<Expression> _expressions = ((BlockExpression) _body_1).getExpressions();
                for(final Expression e : _expressions) {
                  _builder.append("\t");
                  Object _generateJsExpression = this.generateJsExpression(e, scope);
                  _builder.append(_generateJsExpression, "\t");
                  _builder.newLineIfNotEmpty();
                }
              }
            } else {
              _builder.append("\t");
              Object _generateJsExpression_1 = this.generateJsExpression(exp.getBody(), scope);
              _builder.append(_generateJsExpression_1, "\t");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("}");
          _builder.newLine();
          return _builder.toString();
        } else {
          StringConcatenation _builder_1 = new StringConcatenation();
          return _builder_1.toString();
        }
      } else {
        ArithmeticExpression _object_3 = exp.getObject();
        boolean _equals_2 = ((CastExpression) _object_3).getType().equals("Object");
        if (_equals_2) {
          int _length_1 = ((Object[])Conversions.unwrapArray(exp.getIndex().getIndices(), Object.class)).length;
          boolean _equals_3 = (_length_1 == 1);
          if (_equals_3) {
            StringConcatenation _builder_2 = new StringConcatenation();
            _builder_2.append("for(__key in ");
            ArithmeticExpression _object_4 = exp.getObject();
            ArithmeticExpression _target_1 = ((CastExpression) _object_4).getTarget();
            String _name_5 = ((VariableLiteral) _target_1).getVariable().getName();
            _builder_2.append(_name_5);
            _builder_2.append(" ){");
            _builder_2.newLineIfNotEmpty();
            _builder_2.append("\t");
            _builder_2.append("var ");
            VariableFor _get_4 = exp.getIndex().getIndices().get(0);
            String _name_6 = ((VariableDeclaration) _get_4).getName();
            _builder_2.append(_name_6, "\t");
            _builder_2.append(" = {k:__key, v:");
            ArithmeticExpression _object_5 = exp.getObject();
            ArithmeticExpression _target_2 = ((CastExpression) _object_5).getTarget();
            String _name_7 = ((VariableLiteral) _target_2).getVariable().getName();
            _builder_2.append(_name_7, "\t");
            _builder_2.append("[__key]} ");
            _builder_2.newLineIfNotEmpty();
            {
              Expression _body_2 = exp.getBody();
              if ((_body_2 instanceof BlockExpression)) {
                {
                  Expression _body_3 = exp.getBody();
                  EList<Expression> _expressions_1 = ((BlockExpression) _body_3).getExpressions();
                  for(final Expression e_1 : _expressions_1) {
                    _builder_2.append("\t");
                    Object _generateJsExpression_2 = this.generateJsExpression(e_1, scope);
                    _builder_2.append(_generateJsExpression_2, "\t");
                    _builder_2.newLineIfNotEmpty();
                  }
                }
              } else {
                _builder_2.append("\t");
                Object _generateJsExpression_3 = this.generateJsExpression(exp.getBody(), scope);
                _builder_2.append(_generateJsExpression_3, "\t");
                _builder_2.append("\t");
                _builder_2.newLineIfNotEmpty();
              }
            }
            _builder_2.append("}");
            _builder_2.newLine();
            return _builder_2.toString();
          } else {
            StringConcatenation _builder_3 = new StringConcatenation();
            return _builder_3.toString();
          }
        }
      }
    } else {
      ArithmeticExpression _object_6 = exp.getObject();
      if ((_object_6 instanceof RangeLiteral)) {
        int _length_2 = ((Object[])Conversions.unwrapArray(exp.getIndex().getIndices(), Object.class)).length;
        boolean _equals_4 = (_length_2 == 1);
        if (_equals_4) {
          StringConcatenation _builder_4 = new StringConcatenation();
          _builder_4.append("var ");
          VariableFor _get_5 = exp.getIndex().getIndices().get(0);
          String _name_8 = ((VariableDeclaration) _get_5).getName();
          _builder_4.append(_name_8);
          _builder_4.append(";");
          _builder_4.newLineIfNotEmpty();
          _builder_4.append("for(");
          VariableFor _get_6 = exp.getIndex().getIndices().get(0);
          String _name_9 = ((VariableDeclaration) _get_6).getName();
          _builder_4.append(_name_9);
          _builder_4.append(" = ");
          {
            ArithmeticExpression _object_7 = exp.getObject();
            VariableDeclaration _value_l1 = ((RangeLiteral) _object_7).getValue_l1();
            boolean _equals_5 = Objects.equal(_value_l1, null);
            if (_equals_5) {
              _builder_4.append(" ");
              ArithmeticExpression _object_8 = exp.getObject();
              int _value1 = ((RangeLiteral) _object_8).getValue1();
              _builder_4.append(_value1);
            } else {
              ArithmeticExpression _object_9 = exp.getObject();
              String _name_10 = ((RangeLiteral) _object_9).getValue_l1().getName();
              _builder_4.append(_name_10);
            }
          }
          _builder_4.append(" ;");
          VariableFor _get_7 = exp.getIndex().getIndices().get(0);
          String _name_11 = ((VariableDeclaration) _get_7).getName();
          _builder_4.append(_name_11);
          _builder_4.append(" < ");
          {
            ArithmeticExpression _object_10 = exp.getObject();
            VariableDeclaration _value_l2 = ((RangeLiteral) _object_10).getValue_l2();
            boolean _equals_6 = Objects.equal(_value_l2, null);
            if (_equals_6) {
              _builder_4.append(" ");
              ArithmeticExpression _object_11 = exp.getObject();
              int _value2 = ((RangeLiteral) _object_11).getValue2();
              _builder_4.append(_value2);
            } else {
              ArithmeticExpression _object_12 = exp.getObject();
              String _name_12 = ((RangeLiteral) _object_12).getValue_l2().getName();
              _builder_4.append(_name_12);
            }
          }
          _builder_4.append("; ");
          VariableFor _get_8 = exp.getIndex().getIndices().get(0);
          String _name_13 = ((VariableDeclaration) _get_8).getName();
          _builder_4.append(_name_13);
          _builder_4.append("++)");
          _builder_4.newLineIfNotEmpty();
          {
            Expression _body_4 = exp.getBody();
            if ((_body_4 instanceof BlockExpression)) {
              Expression _body_5 = exp.getBody();
              String _generateJsBlockExpression = this.generateJsBlockExpression(((BlockExpression) _body_5), scope);
              _builder_4.append(_generateJsBlockExpression);
              _builder_4.newLineIfNotEmpty();
            } else {
              Object _generateJsExpression_4 = this.generateJsExpression(exp.getBody(), scope);
              _builder_4.append(_generateJsExpression_4);
              _builder_4.newLineIfNotEmpty();
            }
          }
          return _builder_4.toString();
        } else {
          StringConcatenation _builder_5 = new StringConcatenation();
          return _builder_5.toString();
        }
      } else {
        ArithmeticExpression _object_13 = exp.getObject();
        if ((_object_13 instanceof VariableLiteral)) {
          if (((((VariableLiteral) exp.getObject()).getVariable().getTypeobject().equals("var") && (((VariableLiteral) exp.getObject()).getVariable().getRight() instanceof NameObjectDef)) || 
            this.typeSystem.get(scope).get(((VariableLiteral) exp.getObject()).getVariable().getName()).equals("HashMap"))) {
            int _length_3 = ((Object[])Conversions.unwrapArray(exp.getIndex().getIndices(), Object.class)).length;
            boolean _equals_7 = (_length_3 == 1);
            if (_equals_7) {
              StringConcatenation _builder_6 = new StringConcatenation();
              _builder_6.append("for(__key in ");
              ArithmeticExpression _object_14 = exp.getObject();
              String _name_14 = ((VariableLiteral) _object_14).getVariable().getName();
              _builder_6.append(_name_14);
              _builder_6.append(" ){");
              _builder_6.newLineIfNotEmpty();
              _builder_6.append("\t");
              _builder_6.append("var ");
              VariableFor _get_9 = exp.getIndex().getIndices().get(0);
              String _name_15 = ((VariableDeclaration) _get_9).getName();
              _builder_6.append(_name_15, "\t");
              _builder_6.append(" = {k:__key, v:");
              ArithmeticExpression _object_15 = exp.getObject();
              String _name_16 = ((VariableLiteral) _object_15).getVariable().getName();
              _builder_6.append(_name_16, "\t");
              _builder_6.append("[__key]}");
              _builder_6.newLineIfNotEmpty();
              {
                Expression _body_6 = exp.getBody();
                if ((_body_6 instanceof BlockExpression)) {
                  {
                    Expression _body_7 = exp.getBody();
                    EList<Expression> _expressions_2 = ((BlockExpression) _body_7).getExpressions();
                    for(final Expression e_2 : _expressions_2) {
                      _builder_6.append("\t");
                      Object _generateJsExpression_5 = this.generateJsExpression(e_2, scope);
                      _builder_6.append(_generateJsExpression_5, "\t");
                      _builder_6.newLineIfNotEmpty();
                    }
                  }
                } else {
                  _builder_6.append("\t");
                  Object _generateJsExpression_6 = this.generateJsExpression(exp.getBody(), scope);
                  _builder_6.append(_generateJsExpression_6, "\t");
                  _builder_6.append("\t");
                  _builder_6.newLineIfNotEmpty();
                }
              }
              _builder_6.append("}");
              _builder_6.newLine();
              return _builder_6.toString();
            } else {
              StringConcatenation _builder_7 = new StringConcatenation();
              return _builder_7.toString();
            }
          } else {
            if ((((VariableLiteral) exp.getObject()).getVariable().getTypeobject().equals("dat") || 
              this.typeSystem.get(scope).get(((VariableLiteral) exp.getObject()).getVariable().getName()).equals("Table"))) {
              int _length_4 = ((Object[])Conversions.unwrapArray(exp.getIndex().getIndices(), Object.class)).length;
              boolean _equals_8 = (_length_4 == 1);
              if (_equals_8) {
                StringConcatenation _builder_8 = new StringConcatenation();
                _builder_8.append("for(var __");
                VariableFor _get_10 = exp.getIndex().getIndices().get(0);
                String _name_17 = ((VariableDeclaration) _get_10).getName();
                _builder_8.append(_name_17);
                _builder_8.append(" in ");
                ArithmeticExpression _object_16 = exp.getObject();
                String _name_18 = ((VariableLiteral) _object_16).getVariable().getName();
                _builder_8.append(_name_18);
                _builder_8.append(" ){");
                _builder_8.newLineIfNotEmpty();
                _builder_8.append("\t");
                _builder_8.append("var ");
                VariableFor _get_11 = exp.getIndex().getIndices().get(0);
                String _name_19 = ((VariableDeclaration) _get_11).getName();
                _builder_8.append(_name_19, "\t");
                _builder_8.append(" = ");
                ArithmeticExpression _object_17 = exp.getObject();
                String _name_20 = ((VariableLiteral) _object_17).getVariable().getName();
                _builder_8.append(_name_20, "\t");
                _builder_8.append("[__");
                VariableFor _get_12 = exp.getIndex().getIndices().get(0);
                String _name_21 = ((VariableDeclaration) _get_12).getName();
                _builder_8.append(_name_21, "\t");
                _builder_8.append("]");
                _builder_8.newLineIfNotEmpty();
                {
                  Expression _body_8 = exp.getBody();
                  if ((_body_8 instanceof BlockExpression)) {
                    {
                      Expression _body_9 = exp.getBody();
                      EList<Expression> _expressions_3 = ((BlockExpression) _body_9).getExpressions();
                      for(final Expression e_3 : _expressions_3) {
                        _builder_8.append("\t");
                        Object _generateJsExpression_7 = this.generateJsExpression(e_3, scope);
                        _builder_8.append(_generateJsExpression_7, "\t");
                        _builder_8.newLineIfNotEmpty();
                      }
                    }
                  } else {
                    _builder_8.append("\t");
                    Object _generateJsExpression_8 = this.generateJsExpression(exp.getBody(), scope);
                    _builder_8.append(_generateJsExpression_8, "\t");
                    _builder_8.newLineIfNotEmpty();
                  }
                }
                _builder_8.append("}");
                _builder_8.newLine();
                return _builder_8.toString();
              } else {
                StringConcatenation _builder_9 = new StringConcatenation();
                return _builder_9.toString();
              }
            }
          }
        }
      }
    }
    return null;
  }
  
  public String generateJsBlockExpression(final BlockExpression block, final String scope) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{");
    _builder.newLine();
    {
      EList<Expression> _expressions = block.getExpressions();
      for(final Expression exp : _expressions) {
        _builder.append("\t");
        Object _generateJsExpression = this.generateJsExpression(exp, scope);
        _builder.append(_generateJsExpression, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
  
  public String generateJsArithmeticExpression(final ArithmeticExpression exp, final String scope) {
    Object _xblockexpression = null;
    {
      if ((exp instanceof BinaryOperation)) {
        boolean _equals = ((BinaryOperation)exp).getFeature().equals("and");
        if (_equals) {
          StringConcatenation _builder = new StringConcatenation();
          Object _generateJsArithmeticExpression = this.generateJsArithmeticExpression(((BinaryOperation)exp).getLeft(), scope);
          _builder.append(_generateJsArithmeticExpression);
          _builder.append(" && ");
          Object _generateJsArithmeticExpression_1 = this.generateJsArithmeticExpression(((BinaryOperation)exp).getRight(), scope);
          _builder.append(_generateJsArithmeticExpression_1);
          return _builder.toString();
        } else {
          boolean _equals_1 = ((BinaryOperation)exp).getFeature().equals("or");
          if (_equals_1) {
            StringConcatenation _builder_1 = new StringConcatenation();
            Object _generateJsArithmeticExpression_2 = this.generateJsArithmeticExpression(((BinaryOperation)exp).getLeft(), scope);
            _builder_1.append(_generateJsArithmeticExpression_2);
            _builder_1.append(" || ");
            Object _generateJsArithmeticExpression_3 = this.generateJsArithmeticExpression(((BinaryOperation)exp).getRight(), scope);
            _builder_1.append(_generateJsArithmeticExpression_3);
            return _builder_1.toString();
          } else {
            StringConcatenation _builder_2 = new StringConcatenation();
            Object _generateJsArithmeticExpression_4 = this.generateJsArithmeticExpression(((BinaryOperation)exp).getLeft(), scope);
            _builder_2.append(_generateJsArithmeticExpression_4);
            _builder_2.append(" ");
            String _feature = ((BinaryOperation)exp).getFeature();
            _builder_2.append(_feature);
            _builder_2.append(" ");
            Object _generateJsArithmeticExpression_5 = this.generateJsArithmeticExpression(((BinaryOperation)exp).getRight(), scope);
            _builder_2.append(_generateJsArithmeticExpression_5);
            return _builder_2.toString();
          }
        }
      } else {
        if ((exp instanceof UnaryOperation)) {
          StringConcatenation _builder_3 = new StringConcatenation();
          String _feature_1 = ((UnaryOperation)exp).getFeature();
          _builder_3.append(_feature_1);
          Object _generateJsArithmeticExpression_6 = this.generateJsArithmeticExpression(((UnaryOperation)exp).getOperand(), scope);
          _builder_3.append(_generateJsArithmeticExpression_6);
          return _builder_3.toString();
        } else {
          if ((exp instanceof ParenthesizedExpression)) {
            StringConcatenation _builder_4 = new StringConcatenation();
            _builder_4.append("(");
            Object _generateJsArithmeticExpression_7 = this.generateJsArithmeticExpression(((ParenthesizedExpression)exp).getExpression(), scope);
            _builder_4.append(_generateJsArithmeticExpression_7);
            _builder_4.append(")");
            return _builder_4.toString();
          } else {
            if ((exp instanceof NumberLiteral)) {
              StringConcatenation _builder_5 = new StringConcatenation();
              int _value = ((NumberLiteral)exp).getValue();
              _builder_5.append(_value);
              return _builder_5.toString();
            } else {
              if ((exp instanceof BooleanLiteral)) {
                StringConcatenation _builder_6 = new StringConcatenation();
                String _value_1 = ((BooleanLiteral)exp).getValue();
                _builder_6.append(_value_1);
                return _builder_6.toString();
              } else {
                if ((exp instanceof FloatLiteral)) {
                  StringConcatenation _builder_7 = new StringConcatenation();
                  float _value_2 = ((FloatLiteral)exp).getValue();
                  _builder_7.append(_value_2);
                  return _builder_7.toString();
                }
              }
            }
          }
        }
      }
      Object _xifexpression = null;
      if ((exp instanceof StringLiteral)) {
        StringConcatenation _builder_8 = new StringConcatenation();
        _builder_8.append("\"");
        String _value_3 = ((StringLiteral)exp).getValue();
        _builder_8.append(_value_3);
        _builder_8.append("\"");
        return _builder_8.toString();
      } else {
        Object _xifexpression_1 = null;
        if ((exp instanceof VariableLiteral)) {
          StringConcatenation _builder_9 = new StringConcatenation();
          String _name = ((VariableLiteral)exp).getVariable().getName();
          _builder_9.append(_name);
          return _builder_9.toString();
        } else {
          Object _xifexpression_2 = null;
          if ((exp instanceof VariableFunction)) {
            boolean _equals_2 = ((VariableFunction)exp).getTarget().getTypeobject().equals("random");
            if (_equals_2) {
              StringConcatenation _builder_10 = new StringConcatenation();
              _builder_10.append("Math.random()");
              return _builder_10.toString();
            } else {
              String _name_1 = ((VariableFunction)exp).getTarget().getName();
              String _plus = (_name_1 + ".");
              String _feature_2 = ((VariableFunction)exp).getFeature();
              String _plus_1 = (_plus + _feature_2);
              String s = (_plus_1 + "(");
              EList<ArithmeticExpression> _expressions = ((VariableFunction)exp).getExpressions();
              for (final ArithmeticExpression e : _expressions) {
                {
                  String _s = s;
                  Object _generateJsArithmeticExpression_8 = this.generateJsArithmeticExpression(e, scope);
                  s = (_s + _generateJsArithmeticExpression_8);
                  ArithmeticExpression _last = IterableExtensions.<ArithmeticExpression>last(((VariableFunction)exp).getExpressions());
                  boolean _notEquals = (!Objects.equal(e, _last));
                  if (_notEquals) {
                    String _s_1 = s;
                    s = (_s_1 + ",");
                  }
                }
              }
              String _s = s;
              s = (_s + ")");
              return s;
            }
          } else {
            Object _xifexpression_3 = null;
            if ((exp instanceof TimeFunction)) {
              VariableDeclaration _value_4 = ((TimeFunction)exp).getValue();
              boolean _notEquals = (!Objects.equal(_value_4, null));
              if (_notEquals) {
                StringConcatenation _builder_11 = new StringConcatenation();
                _builder_11.append("(process.hrtime(");
                String _name_2 = ((TimeFunction)exp).getValue().getName();
                _builder_11.append(_name_2);
                _builder_11.append("))");
                return _builder_11.toString();
              } else {
                StringConcatenation _builder_12 = new StringConcatenation();
                _builder_12.append("(process.hrtime())");
                return _builder_12.toString();
              }
            } else {
              Object _xifexpression_4 = null;
              if ((exp instanceof NameObject)) {
                StringConcatenation _builder_13 = new StringConcatenation();
                VariableDeclaration _name_3 = ((NameObject)exp).getName();
                String _name_4 = ((VariableDeclaration) _name_3).getName();
                _builder_13.append(_name_4);
                _builder_13.append(".");
                String _value_5 = ((NameObject)exp).getValue();
                _builder_13.append(_value_5);
                return _builder_13.toString();
              } else {
                Object _xifexpression_5 = null;
                if ((exp instanceof IndexObject)) {
                  Object _xifexpression_6 = null;
                  int _length = ((Object[])Conversions.unwrapArray(((IndexObject)exp).getIndexes(), Object.class)).length;
                  boolean _equals_3 = (_length == 1);
                  if (_equals_3) {
                    StringConcatenation _builder_14 = new StringConcatenation();
                    VariableDeclaration _name_5 = ((IndexObject)exp).getName();
                    String _name_6 = ((VariableDeclaration) _name_5).getName();
                    _builder_14.append(_name_6);
                    _builder_14.append("[");
                    Object _generateJsArithmeticExpression_8 = this.generateJsArithmeticExpression(((IndexObject)exp).getIndexes().get(0).getValue(), scope);
                    _builder_14.append(_generateJsArithmeticExpression_8);
                    _builder_14.append("]");
                    return _builder_14.toString();
                  } else {
                    Object _xifexpression_7 = null;
                    int _length_1 = ((Object[])Conversions.unwrapArray(((IndexObject)exp).getIndexes(), Object.class)).length;
                    boolean _equals_4 = (_length_1 == 2);
                    if (_equals_4) {
                      Object i = this.generateJsArithmeticExpression(((IndexObject)exp).getIndexes().get(0).getValue(), scope);
                      Object j = this.generateJsArithmeticExpression(((IndexObject)exp).getIndexes().get(1).getValue(), scope);
                      VariableDeclaration _name_7 = ((IndexObject)exp).getName();
                      String col = this.typeSystem.get(scope).get(((VariableDeclaration) _name_7).getName()).split("_")[2];
                      StringConcatenation _builder_15 = new StringConcatenation();
                      VariableDeclaration _name_8 = ((IndexObject)exp).getName();
                      String _name_9 = ((VariableDeclaration) _name_8).getName();
                      _builder_15.append(_name_9);
                      _builder_15.append("[(");
                      _builder_15.append(i);
                      _builder_15.append("*");
                      _builder_15.append(col);
                      _builder_15.append(")+");
                      _builder_15.append(j);
                      _builder_15.append("]");
                      return _builder_15.toString();
                    } else {
                      _xifexpression_7 = null;
                    }
                    _xifexpression_6 = _xifexpression_7;
                  }
                  _xifexpression_5 = _xifexpression_6;
                } else {
                  if ((exp instanceof CastExpression)) {
                    StringConcatenation _builder_16 = new StringConcatenation();
                    Object _generateJsArithmeticExpression_9 = this.generateJsArithmeticExpression(((CastExpression)exp).getTarget(), scope);
                    _builder_16.append(_generateJsArithmeticExpression_9);
                    return _builder_16.toString();
                  } else {
                    if ((exp instanceof MathFunction)) {
                      StringConcatenation _builder_17 = new StringConcatenation();
                      _builder_17.append("Math.");
                      String _feature_3 = ((MathFunction)exp).getFeature();
                      _builder_17.append(_feature_3);
                      _builder_17.append("(");
                      {
                        EList<ArithmeticExpression> _expressions_1 = ((MathFunction)exp).getExpressions();
                        for(final ArithmeticExpression par : _expressions_1) {
                          _builder_17.append(" ");
                          Object _generateJsArithmeticExpression_10 = this.generateJsArithmeticExpression(par, scope);
                          _builder_17.append(_generateJsArithmeticExpression_10);
                          _builder_17.append(" ");
                          {
                            boolean _equals_5 = par.equals(IterableExtensions.<ArithmeticExpression>last(((MathFunction)exp).getExpressions()));
                            boolean _not = (!_equals_5);
                            if (_not) {
                              _builder_17.append(",");
                            }
                          }
                        }
                      }
                      _builder_17.append(")");
                      return _builder_17.toString();
                    } else {
                      if ((exp instanceof LocalFunctionCall)) {
                        StringConcatenation _builder_18 = new StringConcatenation();
                        String s_1 = _builder_18.toString();
                        String _s_1 = s_1;
                        String _name_10 = ((LocalFunctionCall)exp).getTarget().getName();
                        String _plus_2 = (_name_10 + "(");
                        s_1 = (_s_1 + _plus_2);
                        LocalFunctionInput _input = ((LocalFunctionCall)exp).getInput();
                        boolean _notEquals_1 = (!Objects.equal(_input, null));
                        if (_notEquals_1) {
                          EList<ArithmeticExpression> _inputs = ((LocalFunctionCall)exp).getInput().getInputs();
                          for (final ArithmeticExpression input : _inputs) {
                            {
                              String _s_2 = s_1;
                              Object _generateJsArithmeticExpression_11 = this.generateJsArithmeticExpression(input, scope);
                              s_1 = (_s_2 + _generateJsArithmeticExpression_11);
                              ArithmeticExpression _last = IterableExtensions.<ArithmeticExpression>last(((LocalFunctionCall)exp).getInput().getInputs());
                              boolean _notEquals_2 = (!Objects.equal(input, _last));
                              if (_notEquals_2) {
                                String _s_3 = s_1;
                                s_1 = (_s_3 + ",");
                              }
                            }
                          }
                        }
                        String _s_2 = s_1;
                        s_1 = (_s_2 + ")");
                        return s_1;
                      } else {
                        StringConcatenation _builder_19 = new StringConcatenation();
                        return _builder_19.toString();
                      }
                    }
                  }
                }
                _xifexpression_4 = _xifexpression_5;
              }
              _xifexpression_3 = _xifexpression_4;
            }
            _xifexpression_2 = _xifexpression_3;
          }
          _xifexpression_1 = _xifexpression_2;
        }
        _xifexpression = _xifexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return ((String)_xblockexpression);
  }
  
  public String valuateArithmeticExpression(final ArithmeticExpression exp, final String scope) {
    if ((exp instanceof NumberLiteral)) {
      return "Integer";
    } else {
      if ((exp instanceof BooleanLiteral)) {
        return "Boolean";
      } else {
        if ((exp instanceof StringLiteral)) {
          return "String";
        } else {
          if ((exp instanceof FloatLiteral)) {
            return "Double";
          } else {
            if ((exp instanceof VariableLiteral)) {
              final VariableDeclaration variable = ((VariableLiteral)exp).getVariable();
              boolean _equals = variable.getTypeobject().equals("dat");
              if (_equals) {
                return "Table";
              } else {
                boolean _equals_1 = variable.getTypeobject().equals("channel");
                if (_equals_1) {
                  return "Channel";
                } else {
                  boolean _equals_2 = variable.getTypeobject().equals("var");
                  if (_equals_2) {
                    EObject _right = variable.getRight();
                    if ((_right instanceof NameObjectDef)) {
                      return "HashMap";
                    } else {
                      EObject _right_1 = variable.getRight();
                      if ((_right_1 instanceof ArithmeticExpression)) {
                        EObject _right_2 = variable.getRight();
                        return this.valuateArithmeticExpression(((ArithmeticExpression) _right_2), scope);
                      } else {
                        return this.typeSystem.get(scope).get(variable.getName());
                      }
                    }
                  }
                }
              }
              return "variable";
            } else {
              if ((exp instanceof NameObject)) {
                HashMap<String, String> _get = this.typeSystem.get(scope);
                String _name = ((NameObject)exp).getName().getName();
                String _plus = (_name + ".");
                String _value = ((NameObject)exp).getValue();
                String _plus_1 = (_plus + _value);
                return _get.get(_plus_1);
              } else {
                if ((exp instanceof IndexObject)) {
                  if ((this.typeSystem.get(scope).get(((IndexObject)exp).getName().getName()).contains("Array") || this.typeSystem.get(scope).get(((IndexObject)exp).getName().getName()).contains("Matrix"))) {
                    return this.typeSystem.get(scope).get(((IndexObject)exp).getName().getName()).split("_")[1];
                  } else {
                    HashMap<String, String> _get_1 = this.typeSystem.get(scope);
                    String _name_1 = ((IndexObject)exp).getName().getName();
                    String _plus_2 = (_name_1 + "[");
                    String _generateJsArithmeticExpression = this.generateJsArithmeticExpression(((IndexObject)exp).getIndexes().get(0).getValue(), scope);
                    String _plus_3 = (_plus_2 + _generateJsArithmeticExpression);
                    String _plus_4 = (_plus_3 + "]");
                    return _get_1.get(_plus_4);
                  }
                } else {
                  if ((exp instanceof DatTableObject)) {
                    return "Table";
                  }
                }
              }
            }
          }
        }
      }
    }
    if ((exp instanceof UnaryOperation)) {
      boolean _equals_3 = ((UnaryOperation)exp).getFeature().equals("!");
      if (_equals_3) {
        return "Boolean";
      }
      return this.valuateArithmeticExpression(((UnaryOperation)exp).getOperand(), scope);
    }
    if ((exp instanceof BinaryOperation)) {
      String left = this.valuateArithmeticExpression(((BinaryOperation)exp).getLeft(), scope);
      String right = this.valuateArithmeticExpression(((BinaryOperation)exp).getRight(), scope);
      if ((((((BinaryOperation)exp).getFeature().equals("+") || ((BinaryOperation)exp).getFeature().equals("-")) || ((BinaryOperation)exp).getFeature().equals("*")) || 
        ((BinaryOperation)exp).getFeature().equals("/"))) {
        if ((left.equals("String") || right.equals("String"))) {
          return "String";
        } else {
          if ((left.equals("Double") || right.equals("Double"))) {
            return "Double";
          } else {
            return "Integer";
          }
        }
      } else {
        return "Boolean";
      }
    } else {
      if ((exp instanceof CastExpression)) {
        boolean _equals_4 = ((CastExpression)exp).getType().equals("Object");
        if (_equals_4) {
          return "HashMap";
        }
        boolean _equals_5 = ((CastExpression)exp).getType().equals("String");
        if (_equals_5) {
          return "String";
        }
        boolean _equals_6 = ((CastExpression)exp).getType().equals("Integer");
        if (_equals_6) {
          return "Integer";
        }
        boolean _equals_7 = ((CastExpression)exp).getType().equals("Float");
        if (_equals_7) {
          return "Double";
        }
        boolean _equals_8 = ((CastExpression)exp).getType().equals("Dat");
        if (_equals_8) {
          return "Table";
        }
        boolean _equals_9 = ((CastExpression)exp).getType().equals("Date");
        if (_equals_9) {
          return "LocalDate";
        }
      } else {
        if ((exp instanceof ParenthesizedExpression)) {
          return this.valuateArithmeticExpression(((ParenthesizedExpression)exp).getExpression(), scope);
        }
      }
    }
    if ((exp instanceof MathFunction)) {
      boolean _equals_10 = ((MathFunction)exp).getFeature().equals("round");
      if (_equals_10) {
        return "Integer";
      } else {
        EList<ArithmeticExpression> _expressions = ((MathFunction)exp).getExpressions();
        for (final ArithmeticExpression el : _expressions) {
          boolean _equals_11 = this.valuateArithmeticExpression(el, scope).equals("Double");
          if (_equals_11) {
            return "Double";
          }
        }
        return "Integer";
      }
    } else {
      if ((exp instanceof TimeFunction)) {
        return "Long";
      } else {
        if ((exp instanceof VariableFunction)) {
          boolean _equals_12 = ((VariableFunction)exp).getTarget().getTypeobject().equals("var");
          if (_equals_12) {
            boolean _equals_13 = ((VariableFunction)exp).getFeature().equals("split");
            if (_equals_13) {
              return "HashMap";
            } else {
              if ((((VariableFunction)exp).getFeature().contains("indexOf") || ((VariableFunction)exp).getFeature().equals("length"))) {
                return "Integer";
              } else {
                if ((((((VariableFunction)exp).getFeature().equals("concat") || ((VariableFunction)exp).getFeature().equals("substring")) || 
                  ((VariableFunction)exp).getFeature().equals("toLowerCase")) || ((VariableFunction)exp).getFeature().equals("toUpperCase"))) {
                  return "String";
                } else {
                  return "Boolean";
                }
              }
            }
          } else {
            boolean _equals_14 = ((VariableFunction)exp).getTarget().getTypeobject().equals("random");
            if (_equals_14) {
              boolean _equals_15 = ((VariableFunction)exp).getFeature().equals("nextBoolean");
              if (_equals_15) {
                return "Boolean";
              } else {
                boolean _equals_16 = ((VariableFunction)exp).getFeature().equals("nextDouble");
                if (_equals_16) {
                  return "Double";
                } else {
                  boolean _equals_17 = ((VariableFunction)exp).getFeature().equals("nextInt");
                  if (_equals_17) {
                    return "Integer";
                  }
                }
              }
            }
          }
        } else {
          return "Object";
        }
      }
    }
    return null;
  }
  
  public CharSequence compileDeploy(final Resource resource, final String name) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#!/bin/bash");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if [ $# -eq 0 ]");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("then");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("echo \"No arguments supplied. ./aws_deploy.sh <function_name> <id_function_execution>\"");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("exit 1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("fi");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("function=$1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("id=$2");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("echo \"Checking that aws-cli is installed\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("which aws");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if [ $? -eq 0 ]; then");
    _builder.newLine();
    _builder.append("\t      ");
    _builder.append("echo \"aws-cli is installed, continuing...\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("else");
    _builder.newLine();
    _builder.append("\t      ");
    _builder.append("echo \"You need aws-cli to deploy this lambda. Google \'aws-cli install\'\"");
    _builder.newLine();
    _builder.append("\t      ");
    _builder.append("exit 1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("fi");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("echo \'{");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("\"Version\": \"2012-10-17\",");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("\"Statement\": [");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("\"Effect\": \"Allow\",");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("\"Action\": [");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("\"sqs:DeleteMessage\",");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("\"sqs:GetQueueAttributes\",");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("\"sqs:ReceiveMessage\",");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("\"sqs:SendMessage\",");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("\"sqs:*\"");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("],");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("\"Resource\": \"*\" ");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("},");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("\"Effect\": \"Allow\",");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("\"Action\": [");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("\"s3:*\"");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("],");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("\"Resource\": \"*\" ");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t");
    _builder.append("},");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("\"Effect\":\"Allow\",");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("\"Action\": [");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("\"logs:CreateLogGroup\",");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("\"logs:CreateLogStream\",");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("\"logs:PutLogEvents\"");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("],");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("\"Resource\": \"*\"");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("]");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}\' > policyDocument.json");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("echo \'{");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("\"Version\": \"2012-10-17\",");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("\"Statement\": [");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("\"Effect\": \"Allow\",");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("\"Principal\": {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("\"Service\": \"lambda.amazonaws.com\"");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("},");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("\"Action\": \"sts:AssumeRole\" ");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("]");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}\' > rolePolicyDocument.json");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("#create role policy");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("echo \"creation of role lambda-sqs-execution ...\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("role_arn=$(aws iam get-role --role-name lambda-sqs-execution --query \'Role.Arn\')");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if [ $? -eq 255 ]; then ");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("role_arn=$(aws iam create-role --role-name lambda-sqs-execution --assume-role-policy-document file://rolePolicyDocument.json --output json --query \'Role.Arn\')");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("fi");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("echo \"role lambda-sqs-execution created at ARN \"$role_arn");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("aws iam put-role-policy --role-name lambda-sqs-execution --policy-name lambda-sqs-policy --policy-document file://policyDocument.json");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("mkdir ${function}_lambda");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("cd ${function}_lambda");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("echo \'");
    CharSequence _generateBodyJs = this.generateBodyJs(resource, this.root.getBody(), this.root.getParameters(), name, this.env);
    _builder.append(_generateBodyJs, "\t");
    _builder.append("\' > ${function}.js");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("echo \"npm init...\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("npm init -y");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if [ $? -eq 0 ]; then");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("echo \"...\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("else");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("echo \"npm init failed\"");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("exit 1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("fi");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("echo \" npm instal aws-sdk \"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("npm install aws-sdk");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if [ $? -eq 0 ]; then");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("echo \"...\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("else");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("echo \"npm install aws-sdk failed\"");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("exit 1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("fi");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("echo \"npm install async\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("npm install async");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if [ $? -eq 0 ]; then");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("echo \"...\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("else");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("echo \"npm install async failed\"");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("exit 1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("fi");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("echo \"npm install dataframe-js\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("npm install dataframe-js");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if [ $? -eq 0 ]; then");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("echo \"...\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("else");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("echo \"npm install dataframe-js failed\"");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("exit 1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("fi");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    {
      final Function1<RequireExpression, Boolean> _function = (RequireExpression it) -> {
        EObject _right = it.getEnvironment().getRight();
        return Boolean.valueOf(((DeclarationObject) _right).getFeatures().get(4).getValue_s().equals(this.language));
      };
      Iterable<RequireExpression> _filter = IterableExtensions.<RequireExpression>filter(Iterables.<RequireExpression>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), RequireExpression.class), _function);
      for(final RequireExpression req : _filter) {
        _builder.append("echo \"npm install ");
        String _lib = req.getLib();
        _builder.append(_lib);
        _builder.append("\"");
        _builder.newLineIfNotEmpty();
        _builder.append("npm install ");
        String _lib_1 = req.getLib();
        _builder.append(_lib_1);
        _builder.append("\"");
        _builder.newLineIfNotEmpty();
        _builder.append("if [ $? -eq 0 ]; then");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("echo \"...\"");
        _builder.newLine();
        _builder.append("else");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("echo \"npm install ");
        String _lib_2 = req.getLib();
        _builder.append(_lib_2, "    ");
        _builder.append(" failed\"");
        _builder.newLineIfNotEmpty();
        _builder.append("    ");
        _builder.append("exit 1");
        _builder.newLine();
        _builder.append("fi");
        _builder.newLine();
      }
    }
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("echo \"\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("echo \"creating .zip file\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("zip -r -q -9 ../${function}_lambda.zip . ");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("cd .. ");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("#create the lambda function");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("echo \"creation of the lambda function\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("aws lambda create-function --function-name ${function}_${id} --zip-file fileb://${function}_lambda.zip --handler ${function}.handler --runtime ");
    _builder.append(this.language, "\t");
    _builder.append(" --role ${role_arn//\\\"} --memory-size ");
    _builder.append(this.memory, "\t");
    _builder.append(" --timeout ");
    _builder.append(this.time, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("while [ $? -ne 0 ]; do");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("aws lambda create-function --function-name ${function}_${id} --zip-file fileb://${function}_lambda.zip --handler ${function}.handler --runtime ");
    _builder.append(this.language, "\t\t");
    _builder.append(" --role ${role_arn//\\\"} --memory-size ");
    _builder.append(this.memory, "\t\t");
    _builder.append(" --timeout ");
    _builder.append(this.time, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("done");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("echo \"lambda function created\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("# clear ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("rm -r ${function}_lambda/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("rm ${function}_lambda.zip");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("rm rolePolicyDocument.json");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("rm policyDocument.json");
    _builder.newLine();
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compileUndeploy(final Resource resource, final String name) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#!/bin/bash");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("if [ $# -eq 0 ]");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("then");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("echo \"No arguments supplied. ./aws_deploy.sh <function_name> <id_function_execution>\"");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("exit 1");
    _builder.newLine();
    _builder.append("fi");
    _builder.newLine();
    _builder.newLine();
    _builder.append("function=$1");
    _builder.newLine();
    _builder.append("id=$2");
    _builder.newLine();
    _builder.newLine();
    _builder.append("# delete user queue");
    _builder.newLine();
    {
      final Function1<ChannelDeclaration, Boolean> _function = (ChannelDeclaration it) -> {
        EObject _right = it.getEnvironment().getRight();
        return Boolean.valueOf(((DeclarationObject) _right).getFeatures().get(0).getValue_s().equals("aws"));
      };
      Iterable<ChannelDeclaration> _filter = IterableExtensions.<ChannelDeclaration>filter(Iterables.<ChannelDeclaration>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), ChannelDeclaration.class), _function);
      for(final ChannelDeclaration res : _filter) {
        _builder.append("#get ");
        String _name = res.getName();
        _builder.append(_name);
        _builder.append("_${id} queue-url");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("echo \"get ");
        String _name_1 = res.getName();
        _builder.append(_name_1);
        _builder.append("_${id} queue-url\"");
        _builder.newLineIfNotEmpty();
        _builder.append("queue_url=$(aws sqs get-queue-url --queue-name ");
        String _name_2 = res.getName();
        _builder.append(_name_2);
        _builder.append("_${id} --query \'QueueUrl\')");
        _builder.newLineIfNotEmpty();
        _builder.append("echo ${queue_url//\\\"}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("echo \"delete queue at url ${queue_url//\\\"} \"");
        _builder.newLine();
        _builder.append("aws sqs delete-queue --queue-url ${queue_url//\\\"}");
        _builder.newLine();
        _builder.newLine();
      }
    }
    _builder.newLine();
    {
      final Function1<FlyFunctionCall, Boolean> _function_1 = (FlyFunctionCall it) -> {
        EObject _right = it.getEnvironment().getRight();
        return Boolean.valueOf(((DeclarationObject) _right).getFeatures().get(0).getValue_s().equals("aws"));
      };
      Iterable<FlyFunctionCall> _filter_1 = IterableExtensions.<FlyFunctionCall>filter(Iterables.<FlyFunctionCall>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), FlyFunctionCall.class), _function_1);
      for(final FlyFunctionCall res_1 : _filter_1) {
        _builder.append("#delete ");
        String _name_3 = res_1.getTarget().getName();
        _builder.append(_name_3);
        _builder.append(" input queue");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("echo \"get __input_");
        String _name_4 = res_1.getTarget().getName();
        _builder.append(_name_4);
        _builder.append("_${id}_queue queue-url\"");
        _builder.newLineIfNotEmpty();
        _builder.append("queue_url=$(aws sqs get-queue-url --queue-name __input_");
        String _name_5 = res_1.getTarget().getName();
        _builder.append(_name_5);
        _builder.append("_${id}_queue --query \'QueueUrl\')");
        _builder.newLineIfNotEmpty();
        _builder.append("echo ${queue_url//\\\"}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("echo \"delete queue at url ${queue_url//\\\"} \"");
        _builder.newLine();
        _builder.append("aws sqs delete-queue --queue-url ${queue_url//\\\"}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("#delete ");
        String _name_6 = res_1.getTarget().getName();
        _builder.append(_name_6);
        _builder.append("_${id} lambda function");
        _builder.newLineIfNotEmpty();
        _builder.append("echo \"delete ");
        String _name_7 = res_1.getTarget().getName();
        _builder.append(_name_7);
        _builder.append("_${id} lambda function\"");
        _builder.newLineIfNotEmpty();
        _builder.append("aws lambda delete-function function-name ");
        String _name_8 = res_1.getTarget().getName();
        _builder.append(_name_8);
        _builder.append("_${id}");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
      }
    }
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    return _builder;
  }
}
