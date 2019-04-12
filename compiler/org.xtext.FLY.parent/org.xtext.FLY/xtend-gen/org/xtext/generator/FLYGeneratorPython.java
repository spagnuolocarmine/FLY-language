package org.xtext.generator;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.xtext.fLY.ArithmeticExpression;
import org.xtext.fLY.ArrayDefinition;
import org.xtext.fLY.Assignment;
import org.xtext.fLY.BinaryOperation;
import org.xtext.fLY.BlockExpression;
import org.xtext.fLY.BooleanLiteral;
import org.xtext.fLY.CastExpression;
import org.xtext.fLY.ChannelDeclaration;
import org.xtext.fLY.ChannelReceive;
import org.xtext.fLY.ChannelSend;
import org.xtext.fLY.DatDeclaration;
import org.xtext.fLY.DatTableObject;
import org.xtext.fLY.DeclarationObject;
import org.xtext.fLY.EnvironmentDeclaration;
import org.xtext.fLY.Expression;
import org.xtext.fLY.FeautureName;
import org.xtext.fLY.FloatLiteral;
import org.xtext.fLY.ForExpression;
import org.xtext.fLY.FunctionDefinition;
import org.xtext.fLY.FunctionReturn;
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
import org.xtext.fLY.SortExpression;
import org.xtext.fLY.StringLiteral;
import org.xtext.fLY.TimeFunction;
import org.xtext.fLY.UnaryOperation;
import org.xtext.fLY.VariableDeclaration;
import org.xtext.fLY.VariableFor;
import org.xtext.fLY.VariableFunction;
import org.xtext.fLY.VariableLiteral;
import org.xtext.fLY.WhileExpression;

@SuppressWarnings("all")
public class FLYGeneratorPython extends AbstractGenerator {
  private String name = null;
  
  private String env = null;
  
  private FunctionDefinition root = null;
  
  private Object id_execution = null;
  
  private HashMap<String, HashMap<String, String>> typeSystem = null;
  
  private HashMap<String, FunctionDefinition> functionCalled = null;
  
  private String language;
  
  private int nthread;
  
  private int memory;
  
  private int time;
  
  private Resource resourceInput;
  
  private boolean isLocal;
  
  public void generatePython(final Resource input, final IFileSystemAccess2 fsa, final IGeneratorContext context, final String name_file, final FunctionDefinition func, final EnvironmentDeclaration environment, final HashMap<String, HashMap<String, String>> scoping, final long id, final boolean local) {
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
      this.language = ((DeclarationObject) _right_5).getFeatures().get(2).getValue_s();
      EObject _right_6 = environment.getRight();
      this.nthread = ((DeclarationObject) _right_6).getFeatures().get(1).getValue_t();
    }
    this.resourceInput = input;
    HashMap<String, FunctionDefinition> _hashMap = new HashMap<String, FunctionDefinition>();
    this.functionCalled = _hashMap;
    final Function1<FunctionDefinition, Boolean> _function = (FunctionDefinition it) -> {
      String _name = it.getName();
      String _name_1 = this.root.getName();
      return Boolean.valueOf((!Objects.equal(_name, _name_1)));
    };
    final Function1<FunctionDefinition, Boolean> _function_1 = (FunctionDefinition it) -> {
      int _length = ((Object[])Conversions.unwrapArray(Iterables.<NativeExpression>filter(IterableExtensions.<Expression>toList(it.getBody().getExpressions()), NativeExpression.class), Object.class)).length;
      return Boolean.valueOf((_length > 0));
    };
    Iterable<FunctionDefinition> _filter = IterableExtensions.<FunctionDefinition>filter(IterableExtensions.<FunctionDefinition>filter(Iterables.<FunctionDefinition>filter(IteratorExtensions.<EObject>toIterable(input.getAllContents()), FunctionDefinition.class), _function), _function_1);
    for (final FunctionDefinition element : _filter) {
      this.functionCalled.put(element.getName(), element);
    }
    this.isLocal = local;
    this.doGenerate(input, fsa, context);
  }
  
  @Override
  public void doGenerate(final Resource input, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    final Function1<RequireExpression, Boolean> _function = (RequireExpression it) -> {
      EObject _right = it.getEnvironment().getRight();
      String _value_s = ((DeclarationObject) _right).getFeatures().get(0).getValue_s();
      return Boolean.valueOf((!Objects.equal(_value_s, "local")));
    };
    final Function1<RequireExpression, String> _function_1 = (RequireExpression it) -> {
      return it.getLib();
    };
    List<String> allReqs = IteratorExtensions.<String>toList(IteratorExtensions.<RequireExpression, String>map(IteratorExtensions.<RequireExpression>filter(Iterators.<RequireExpression>filter(input.getAllContents(), RequireExpression.class), _function), _function_1));
    final List<String> _converted_allReqs = (List<String>)allReqs;
    this.saveToRequirements(((String[])Conversions.unwrapArray(_converted_allReqs, String.class)), fsa);
    InputOutput.<String>println(this.root.getName());
    if (this.isLocal) {
      String _name = this.root.getName();
      String _plus = (_name + ".py");
      fsa.generateFile(_plus, this.compilePython(input, this.root.getName(), true));
    } else {
      String _name_1 = this.root.getName();
      String _plus_1 = (_name_1 + "_deploy.sh");
      fsa.generateFile(_plus_1, this.compileScript(input, this.root.getName(), false));
    }
  }
  
  public Object[] channelsNames(final BlockExpression exps) {
    HashSet<String> names = new HashSet<String>();
    final Function1<EObject, Boolean> _function = (EObject it) -> {
      return Boolean.valueOf((it instanceof ChannelReceive));
    };
    final Function1<EObject, Boolean> _function_1 = (EObject it) -> {
      Object _functionContainer = this.functionContainer(it);
      String _name = this.root.getName();
      return Boolean.valueOf((_functionContainer == _name));
    };
    final Function1<EObject, ChannelReceive> _function_2 = (EObject it) -> {
      return ((ChannelReceive) it);
    };
    final Function1<ChannelReceive, ChannelDeclaration> _function_3 = (ChannelReceive it) -> {
      ChannelDeclaration _target = it.getTarget();
      return ((ChannelDeclaration) _target);
    };
    final Function1<ChannelDeclaration, String> _function_4 = (ChannelDeclaration it) -> {
      return it.getName();
    };
    final Iterator<String> chRecvs = IteratorExtensions.<ChannelDeclaration, String>map(IteratorExtensions.<ChannelReceive, ChannelDeclaration>map(IteratorExtensions.<EObject, ChannelReceive>map(IteratorExtensions.<EObject>filter(IteratorExtensions.<EObject>filter(this.resourceInput.getAllContents(), _function), _function_1), _function_2), _function_3), _function_4);
    final Function1<EObject, Boolean> _function_5 = (EObject it) -> {
      return Boolean.valueOf((it instanceof ChannelSend));
    };
    final Function1<EObject, Boolean> _function_6 = (EObject it) -> {
      Object _functionContainer = this.functionContainer(it);
      String _name = this.root.getName();
      return Boolean.valueOf((_functionContainer == _name));
    };
    final Function1<EObject, ChannelSend> _function_7 = (EObject it) -> {
      return ((ChannelSend) it);
    };
    final Function1<ChannelSend, ChannelDeclaration> _function_8 = (ChannelSend it) -> {
      ChannelDeclaration _target = it.getTarget();
      return ((ChannelDeclaration) _target);
    };
    final Function1<ChannelDeclaration, String> _function_9 = (ChannelDeclaration it) -> {
      return it.getName();
    };
    final Iterator<String> chSends = IteratorExtensions.<ChannelDeclaration, String>map(IteratorExtensions.<ChannelSend, ChannelDeclaration>map(IteratorExtensions.<EObject, ChannelSend>map(IteratorExtensions.<EObject>filter(IteratorExtensions.<EObject>filter(this.resourceInput.getAllContents(), _function_5), _function_6), _function_7), _function_8), _function_9);
    while (chRecvs.hasNext()) {
      names.add(chRecvs.next());
    }
    while (chSends.hasNext()) {
      names.add(chSends.next());
    }
    return names.toArray();
  }
  
  public Object functionContainer(final EObject e) {
    EObject parent = e.eContainer();
    if ((parent == null)) {
      return "";
    } else {
      if ((parent instanceof FunctionDefinition)) {
        return ((FunctionDefinition) parent).getName();
      } else {
        return this.functionContainer(parent);
      }
    }
  }
  
  public void saveToRequirements(final String[] requirements, final IFileSystemAccess fsa) {
    String res = "";
    for (final String s : requirements) {
      String _res = res;
      res = (_res + (s + "\n"));
    }
    fsa.generateFile("requirements.txt", res);
  }
  
  public String generateBodyPyLocal(final BlockExpression exps, final List<Expression> parameters, final String name, final String env, final boolean local) {
    final Object[] channelNames = this.channelsNames(exps);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import random");
    _builder.newLine();
    _builder.append("import time");
    _builder.newLine();
    _builder.append("import math ");
    _builder.newLine();
    _builder.append("import pandas as pd");
    _builder.newLine();
    _builder.append("import json");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import socket");
    _builder.newLine();
    _builder.append("import sys");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    _builder.append("__sock_loc = socket.socket() # TODO");
    _builder.newLine();
    _builder.append("__sock_loc.connect((\'\', 9090))\t\t\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    {
      for(final Object chName : channelNames) {
        _builder.append(chName);
        _builder.append(" = __sock_loc.makefile(\'rwb\')");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    {
      Collection<FunctionDefinition> _values = this.functionCalled.values();
      for(final FunctionDefinition fd : _values) {
        String _generatePyExpression = this.generatePyExpression(fd, name, local);
        _builder.append(_generatePyExpression);
        _builder.newLineIfNotEmpty();
        _builder.newLine();
      }
    }
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("def main(event):");
    _builder.newLine();
    {
      for(final Expression exp : parameters) {
        {
          boolean _equals = this.typeSystem.get(name).get(((VariableDeclaration) exp).getName()).equals("Table");
          if (_equals) {
            _builder.append("\t");
            _builder.append("__columns=json.loads(event)[0].keys()");
            _builder.newLine();
            _builder.append("\t");
            String _name = ((VariableDeclaration) exp).getName();
            _builder.append(_name, "\t");
            _builder.append(" = pd.read_json(event)");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            String _name_1 = ((VariableDeclaration) exp).getName();
            _builder.append(_name_1, "\t");
            _builder.append(" = ");
            String _name_2 = ((VariableDeclaration) exp).getName();
            _builder.append(_name_2, "\t");
            _builder.append("[__columns]");
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("\t");
            String _name_3 = ((VariableDeclaration) exp).getName();
            _builder.append(_name_3, "\t");
            _builder.append(" = json.loads(event)");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    {
      EList<Expression> _expressions = exps.getExpressions();
      for(final Expression exp_1 : _expressions) {
        _builder.append("\t");
        String _generatePyExpression_1 = this.generatePyExpression(exp_1, name, local);
        _builder.append(_generatePyExpression_1, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("__sock_loc.close()");
    _builder.newLine();
    _builder.newLine();
    _builder.append("if __name__ == \"__main__\":");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("__sock_data = socket.socket()");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("__sock_data.connect((\'\', 9091))");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("__sock_data_fh = __sock_data.makefile(\'rb\')");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("main(__sock_data_fh.readline())");
    _builder.newLine();
    return _builder.toString();
  }
  
  public CharSequence generateBodyPy(final BlockExpression exps, final List<Expression> parameters, final String name, final String env, final boolean local) {
    CharSequence _xblockexpression = null;
    {
      final Object[] channelNames = this.channelsNames(exps);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("# python");
      _builder.newLine();
      _builder.append("import random");
      _builder.newLine();
      _builder.append("import time");
      _builder.newLine();
      _builder.append("import math ");
      _builder.newLine();
      _builder.append("import pandas as pd");
      _builder.newLine();
      _builder.append("import json");
      _builder.newLine();
      _builder.newLine();
      {
        boolean _equals = Objects.equal(env, "aws");
        if (_equals) {
          _builder.append("import boto3");
          _builder.newLine();
          _builder.append("sqs = boto3.resource(\'sqs\')");
          _builder.newLine();
          _builder.newLine();
          {
            for(final Object chName : channelNames) {
              _builder.append(chName);
              _builder.append(" = sqs.get_queue_by_name(QueueName=\'");
              _builder.append(chName);
              _builder.append("_\"${id}\"\')");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.append("\t\t\t");
      _builder.newLine();
      _builder.append("def handler(event,context):");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      {
        for(final Expression exp : parameters) {
          {
            boolean _equals_1 = this.typeSystem.get(name).get(((VariableDeclaration) exp).getName()).equals("Table");
            if (_equals_1) {
              _builder.append("\t");
              _builder.append("__columns = event[0].keys()");
              _builder.newLine();
              _builder.append("\t");
              String _name = ((VariableDeclaration) exp).getName();
              _builder.append(_name, "\t");
              _builder.append(" = pd.read_json(json.dumps(event))");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              String _name_1 = ((VariableDeclaration) exp).getName();
              _builder.append(_name_1, "\t");
              _builder.append(" = ");
              String _name_2 = ((VariableDeclaration) exp).getName();
              _builder.append(_name_2, "\t");
              _builder.append("[__columns]");
              _builder.newLineIfNotEmpty();
            } else {
              _builder.append("\t");
              String _name_3 = ((VariableDeclaration) exp).getName();
              _builder.append(_name_3, "\t");
              _builder.append(" = event # TODO check");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      {
        EList<Expression> _expressions = exps.getExpressions();
        for(final Expression exp_1 : _expressions) {
          _builder.append("\t");
          String _generatePyExpression = this.generatePyExpression(exp_1, name, local);
          _builder.append(_generatePyExpression, "\t");
          _builder.newLineIfNotEmpty();
        }
      }
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public String generatePyExpression(final Expression exp, final String scope, final boolean local) {
    StringConcatenation _builder = new StringConcatenation();
    String s = _builder.toString();
    if ((exp instanceof ChannelSend)) {
      String _s = s;
      StringConcatenation _builder_1 = new StringConcatenation();
      {
        if (local) {
          String _name = ((ChannelSend)exp).getTarget().getName();
          _builder_1.append(_name);
          _builder_1.append(".write(json.dumps(");
          Object _generatePyArithmeticExpression = this.generatePyArithmeticExpression(((ChannelSend)exp).getExpression(), scope, local);
          _builder_1.append(_generatePyArithmeticExpression);
          _builder_1.append(").encode(\'utf8\'))");
          _builder_1.newLineIfNotEmpty();
        } else {
          String _name_1 = ((ChannelSend)exp).getTarget().getName();
          _builder_1.append(_name_1);
          _builder_1.append(".send_message(");
          _builder_1.newLineIfNotEmpty();
          _builder_1.append("\t");
          _builder_1.append("MessageBody=json.dumps(");
          Object _generatePyArithmeticExpression_1 = this.generatePyArithmeticExpression(((ChannelSend)exp).getExpression(), scope, local);
          _builder_1.append(_generatePyArithmeticExpression_1, "\t");
          _builder_1.append(")");
          _builder_1.newLineIfNotEmpty();
          _builder_1.append(")");
          _builder_1.newLine();
        }
      }
      _builder_1.newLine();
      s = (_s + _builder_1);
    } else {
      if ((exp instanceof VariableDeclaration)) {
        if ((((VariableDeclaration)exp).getTypeobject().equals("var") || ((VariableDeclaration)exp).getTypeobject().equals("const"))) {
          EObject _right = ((VariableDeclaration)exp).getRight();
          if ((_right instanceof NameObjectDef)) {
            this.typeSystem.get(scope).put(((VariableDeclaration)exp).getName(), "HashMap");
            String _s_1 = s;
            StringConcatenation _builder_2 = new StringConcatenation();
            String _name_2 = ((VariableDeclaration)exp).getName();
            _builder_2.append(_name_2);
            _builder_2.append(" = {");
            s = (_s_1 + _builder_2);
            int i = 0;
            EObject _right_1 = ((VariableDeclaration)exp).getRight();
            EList<FeautureName> _features = ((NameObjectDef) _right_1).getFeatures();
            for (final FeautureName f : _features) {
              {
                String _feature = f.getFeature();
                boolean _tripleNotEquals = (_feature != null);
                if (_tripleNotEquals) {
                  HashMap<String, String> _get = this.typeSystem.get(scope);
                  String _name_3 = ((VariableDeclaration)exp).getName();
                  String _plus = (_name_3 + ".");
                  String _feature_1 = f.getFeature();
                  String _plus_1 = (_plus + _feature_1);
                  _get.put(_plus_1, 
                    this.valuateArithmeticExpression(f.getValue(), scope, local));
                  StringConcatenation _builder_3 = new StringConcatenation();
                  _builder_3.append(" ");
                  _builder_3.append("\'");
                  String _feature_2 = f.getFeature();
                  _builder_3.append(_feature_2, " ");
                  _builder_3.append("\' : ");
                  Object _generatePyArithmeticExpression_2 = this.generatePyArithmeticExpression(f.getValue(), scope, local);
                  _builder_3.append(_generatePyArithmeticExpression_2, " ");
                  String _plus_2 = (s + _builder_3);
                  s = _plus_2;
                } else {
                  HashMap<String, String> _get_1 = this.typeSystem.get(scope);
                  String _name_4 = ((VariableDeclaration)exp).getName();
                  String _plus_3 = (_name_4 + "[");
                  String _plus_4 = (_plus_3 + Integer.valueOf(i));
                  String _plus_5 = (_plus_4 + "]");
                  _get_1.put(_plus_5, 
                    this.valuateArithmeticExpression(f.getValue(), scope, local));
                  StringConcatenation _builder_4 = new StringConcatenation();
                  _builder_4.append(" ");
                  _builder_4.append("\'");
                  _builder_4.append(i, " ");
                  _builder_4.append("\' :");
                  Object _generatePyArithmeticExpression_3 = this.generatePyArithmeticExpression(f.getValue(), scope, local);
                  _builder_4.append(_generatePyArithmeticExpression_3, " ");
                  String _plus_6 = (s + _builder_4);
                  s = _plus_6;
                  i++;
                }
                EObject _right_2 = ((VariableDeclaration)exp).getRight();
                FeautureName _last = IterableExtensions.<FeautureName>last(((NameObjectDef) _right_2).getFeatures());
                boolean _notEquals = (!Objects.equal(f, _last));
                if (_notEquals) {
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
              final ArithmeticExpression len = ((ArrayDefinition) _right_3).getIndexes().get(0).getValue();
              EObject _right_4 = ((VariableDeclaration)exp).getRight();
              final String type = ((ArrayDefinition) _right_4).getType();
              String _s_3 = s;
              StringConcatenation _builder_4 = new StringConcatenation();
              String _name_3 = ((VariableDeclaration)exp).getName();
              _builder_4.append(_name_3);
              _builder_4.append(" = [None] * ");
              Object _generatePyArithmeticExpression_2 = this.generatePyArithmeticExpression(len, scope, local);
              _builder_4.append(_generatePyArithmeticExpression_2);
              _builder_4.newLineIfNotEmpty();
              s = (_s_3 + _builder_4);
            } else {
              String _s_4 = s;
              StringConcatenation _builder_5 = new StringConcatenation();
              String _name_4 = ((VariableDeclaration)exp).getName();
              _builder_5.append(_name_4);
              _builder_5.append(" = ");
              EObject _right_5 = ((VariableDeclaration)exp).getRight();
              Object _generatePyArithmeticExpression_3 = this.generatePyArithmeticExpression(((ArithmeticExpression) _right_5), scope, local);
              _builder_5.append(_generatePyArithmeticExpression_3);
              _builder_5.newLineIfNotEmpty();
              s = (_s_4 + _builder_5);
            }
          }
        } else {
          boolean _equals = ((VariableDeclaration)exp).getTypeobject().equals("dat");
          if (_equals) {
            this.typeSystem.get(scope).put(((VariableDeclaration)exp).getName(), "Table");
            EObject _right_6 = ((VariableDeclaration)exp).getRight();
            String path = ((DeclarationObject) _right_6).getFeatures().get(1).getValue_s();
            EObject _right_7 = ((VariableDeclaration)exp).getRight();
            String type_1 = ((DeclarationObject) _right_7).getFeatures().get(2).getValue_s();
            EObject _right_8 = ((VariableDeclaration)exp).getRight();
            String sep = ((DeclarationObject) _right_8).getFeatures().get(3).getValue_s();
            path = path.replaceAll("\"", "");
            StringConcatenation _builder_6 = new StringConcatenation();
            {
              if ((((DatDeclaration) exp).isOnCloud() && (!path.contains("https://")))) {
                _builder_6.append("https://s3.us-east-2.amazonaws.com/bucket-\"${id}\"/");
                _builder_6.append(path);
              } else {
                _builder_6.append(path);
              }
            }
            String uri = _builder_6.toString();
            if (type_1 != null) {
              switch (type_1) {
                case "csv":
                  String _s_5 = s;
                  StringConcatenation _builder_7 = new StringConcatenation();
                  String _name_5 = ((VariableDeclaration)exp).getName();
                  _builder_7.append(_name_5);
                  _builder_7.append(" = pd.read_csv(\'");
                  _builder_7.append(uri);
                  _builder_7.append("\', sep=\'");
                  _builder_7.append(sep);
                  _builder_7.append("\')");
                  _builder_7.newLineIfNotEmpty();
                  s = (_s_5 + _builder_7);
                  break;
                default:
                  String _s_6 = s;
                  StringConcatenation _builder_8 = new StringConcatenation();
                  String _name_6 = ((VariableDeclaration)exp).getName();
                  _builder_8.append(_name_6);
                  _builder_8.append(" = pd.read_csv(\'");
                  _builder_8.append(uri);
                  _builder_8.append("\', sep=\'");
                  _builder_8.append(sep);
                  _builder_8.append("\')");
                  _builder_8.newLineIfNotEmpty();
                  s = (_s_6 + _builder_8);
                  break;
              }
            } else {
              String _s_6 = s;
              StringConcatenation _builder_8 = new StringConcatenation();
              String _name_6 = ((VariableDeclaration)exp).getName();
              _builder_8.append(_name_6);
              _builder_8.append(" = pd.read_csv(\'");
              _builder_8.append(uri);
              _builder_8.append("\', sep=\'");
              _builder_8.append(sep);
              _builder_8.append("\')");
              _builder_8.newLineIfNotEmpty();
              s = (_s_6 + _builder_8);
            }
          }
        }
      } else {
        if ((exp instanceof LocalFunctionCall)) {
          final LocalFunctionCall fc = ((LocalFunctionCall) exp);
          FunctionDefinition _target = fc.getTarget();
          final FunctionDefinition fd = ((FunctionDefinition) _target);
          LocalFunctionInput _input = fc.getInput();
          final EList<ArithmeticExpression> inputs = ((LocalFunctionInput) _input).getInputs();
          String _s_7 = s;
          StringConcatenation _builder_9 = new StringConcatenation();
          String _name_7 = ((LocalFunctionCall) exp).getTarget().getName();
          _builder_9.append(_name_7);
          _builder_9.append("(");
          {
            for(final ArithmeticExpression par : inputs) {
              Object _generatePyArithmeticExpression_4 = this.generatePyArithmeticExpression(par, scope, local);
              _builder_9.append(_generatePyArithmeticExpression_4);
              {
                boolean _equals_1 = par.equals(IterableExtensions.<ArithmeticExpression>last(inputs));
                boolean _not = (!_equals_1);
                if (_not) {
                  _builder_9.append(", ");
                }
              }
            }
          }
          _builder_9.append(")");
          s = (_s_7 + _builder_9);
        } else {
          if ((exp instanceof FunctionDefinition)) {
            final FunctionDefinition fd_1 = ((FunctionDefinition) exp);
            final String name = fd_1.getName();
            final Function1<Expression, VariableDeclaration> _function = (Expression it) -> {
              return ((VariableDeclaration) it);
            };
            final Function1<VariableDeclaration, String> _function_1 = (VariableDeclaration it) -> {
              return it.getName();
            };
            final List<String> params = ListExtensions.<VariableDeclaration, String>map(ListExtensions.<Expression, VariableDeclaration>map(fd_1.getParameters(), _function), _function_1);
            BlockExpression _body = fd_1.getBody();
            final BlockExpression body = ((BlockExpression) _body);
            String _s_8 = s;
            StringConcatenation _builder_10 = new StringConcatenation();
            _builder_10.append("def ");
            _builder_10.append(name);
            _builder_10.append("(");
            String _join = String.join(", ", params);
            _builder_10.append(_join);
            _builder_10.append("):");
            _builder_10.newLineIfNotEmpty();
            _builder_10.append("\t");
            CharSequence _generatePyBlockExpression = this.generatePyBlockExpression(body, scope, local);
            _builder_10.append(_generatePyBlockExpression, "\t");
            _builder_10.newLineIfNotEmpty();
            s = (_s_8 + _builder_10);
          } else {
            if ((exp instanceof IfExpression)) {
              String _s_9 = s;
              StringConcatenation _builder_11 = new StringConcatenation();
              _builder_11.append("if ");
              Object _generatePyArithmeticExpression_5 = this.generatePyArithmeticExpression(((IfExpression)exp).getCond(), scope, local);
              _builder_11.append(_generatePyArithmeticExpression_5);
              _builder_11.append(":");
              _builder_11.newLineIfNotEmpty();
              _builder_11.append("\t");
              Object _generatePyExpression = this.generatePyExpression(((IfExpression)exp).getThen(), scope, local);
              _builder_11.append(_generatePyExpression, "\t");
              _builder_11.newLineIfNotEmpty();
              {
                Expression _else = ((IfExpression)exp).getElse();
                boolean _tripleNotEquals = (_else != null);
                if (_tripleNotEquals) {
                  _builder_11.append("else:");
                  _builder_11.newLine();
                  _builder_11.append("\t");
                  Object _generatePyExpression_1 = this.generatePyExpression(((IfExpression)exp).getElse(), scope, local);
                  _builder_11.append(_generatePyExpression_1, "\t");
                  _builder_11.newLineIfNotEmpty();
                }
              }
              s = (_s_9 + _builder_11);
            } else {
              if ((exp instanceof ForExpression)) {
                String _s_10 = s;
                StringConcatenation _builder_12 = new StringConcatenation();
                String _generatePyForExpression = this.generatePyForExpression(((ForExpression)exp), scope, local);
                _builder_12.append(_generatePyForExpression);
                _builder_12.newLineIfNotEmpty();
                s = (_s_10 + _builder_12);
              } else {
                if ((exp instanceof WhileExpression)) {
                  String _s_11 = s;
                  StringConcatenation _builder_13 = new StringConcatenation();
                  CharSequence _generatePyWhileExpression = this.generatePyWhileExpression(((WhileExpression)exp), scope, local);
                  _builder_13.append(_generatePyWhileExpression);
                  _builder_13.newLineIfNotEmpty();
                  s = (_s_11 + _builder_13);
                } else {
                  if ((exp instanceof BlockExpression)) {
                    String _s_12 = s;
                    StringConcatenation _builder_14 = new StringConcatenation();
                    CharSequence _generatePyBlockExpression_1 = this.generatePyBlockExpression(((BlockExpression)exp), scope, local);
                    _builder_14.append(_generatePyBlockExpression_1);
                    _builder_14.newLineIfNotEmpty();
                    s = (_s_12 + _builder_14);
                  } else {
                    if ((exp instanceof Assignment)) {
                      String _s_13 = s;
                      StringConcatenation _builder_15 = new StringConcatenation();
                      String _generatePyAssignmentExpression = this.generatePyAssignmentExpression(((Assignment)exp), scope, local);
                      _builder_15.append(_generatePyAssignmentExpression);
                      _builder_15.newLineIfNotEmpty();
                      s = (_s_13 + _builder_15);
                    } else {
                      if ((exp instanceof PrintExpression)) {
                        String _s_14 = s;
                        StringConcatenation _builder_16 = new StringConcatenation();
                        _builder_16.append("print(");
                        Object _generatePyArithmeticExpression_6 = this.generatePyArithmeticExpression(((PrintExpression)exp).getPrint(), scope, local);
                        _builder_16.append(_generatePyArithmeticExpression_6);
                        _builder_16.append(")");
                        _builder_16.newLineIfNotEmpty();
                        s = (_s_14 + _builder_16);
                      } else {
                        if ((exp instanceof SortExpression)) {
                          String isAscending = "False";
                          String _type = ((SortExpression)exp).getType();
                          boolean _tripleEquals = (_type == "asc");
                          if (_tripleEquals) {
                            isAscending = "True";
                          }
                          String _s_15 = s;
                          StringConcatenation _builder_17 = new StringConcatenation();
                          VariableDeclaration _target_1 = ((SortExpression)exp).getTarget();
                          _builder_17.append(_target_1);
                          _builder_17.append(".sort_values(by=[\'");
                          String _taget = ((SortExpression)exp).getTaget();
                          _builder_17.append(_taget);
                          _builder_17.append("\'], ascending=");
                          _builder_17.append(isAscending);
                          _builder_17.append(")");
                          _builder_17.newLineIfNotEmpty();
                          s = (_s_15 + _builder_17);
                        } else {
                          if ((exp instanceof FunctionReturn)) {
                            final FunctionReturn fr = ((FunctionReturn) exp);
                            String _s_16 = s;
                            StringConcatenation _builder_18 = new StringConcatenation();
                            _builder_18.append("return ");
                            Object _generatePyArithmeticExpression_7 = this.generatePyArithmeticExpression(fr.getExpression(), scope, local);
                            _builder_18.append(_generatePyArithmeticExpression_7);
                            s = (_s_16 + _builder_18);
                          } else {
                            if ((exp instanceof PostfixOperation)) {
                              String postfixOp = "";
                              String _feature = ((PostfixOperation)exp).getFeature();
                              if (_feature != null) {
                                switch (_feature) {
                                  case "++":
                                    postfixOp = "+=1";
                                    break;
                                  case "--":
                                    postfixOp = "-=1";
                                    break;
                                }
                              }
                              StringConcatenation _builder_19 = new StringConcatenation();
                              Object _generatePyArithmeticExpression_8 = this.generatePyArithmeticExpression(((PostfixOperation)exp).getVariable(), scope, local);
                              _builder_19.append(_generatePyArithmeticExpression_8);
                              _builder_19.append(postfixOp);
                              return _builder_19.toString();
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
      }
    }
    return s;
  }
  
  public String generatePyAssignmentExpression(final Assignment assignment, final String scope, final boolean local) {
    InputOutput.<Assignment>println(assignment);
    ArithmeticExpression _feature = assignment.getFeature();
    boolean _tripleNotEquals = (_feature != null);
    if (_tripleNotEquals) {
      if (((assignment.getValue() instanceof CastExpression) && (((CastExpression) assignment.getValue()).getTarget() instanceof ChannelReceive))) {
        ArithmeticExpression _value = assignment.getValue();
        ArithmeticExpression _target = ((CastExpression) _value).getTarget();
        EObject _right = ((ChannelReceive) _target).getTarget().getEnvironment().getRight();
        boolean _equals = ((DeclarationObject) _right).getFeatures().get(0).getValue_s().equals("aws");
        if (_equals) {
          ArithmeticExpression _value_1 = assignment.getValue();
          ArithmeticExpression _target_1 = ((CastExpression) _value_1).getTarget();
          ChannelDeclaration _target_2 = ((ChannelReceive) _target_1).getTarget();
          final ChannelDeclaration channel = ((ChannelDeclaration) _target_2);
          ArithmeticExpression _value_2 = assignment.getValue();
          boolean _equals_1 = ((CastExpression) _value_2).getType().equals("Integer");
          if (_equals_1) {
            StringConcatenation _builder = new StringConcatenation();
            {
              if (local) {
                _builder.append("int(");
                String _name = channel.getName();
                _builder.append(_name);
                _builder.append(".readline())");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("int(");
                String _name_1 = channel.getName();
                _builder.append(_name_1);
                _builder.append(".receive_messages()[0])");
                _builder.newLineIfNotEmpty();
              }
            }
            return _builder.toString();
          } else {
            ArithmeticExpression _value_3 = assignment.getValue();
            boolean _equals_2 = ((CastExpression) _value_3).getType().equals("Double");
            if (_equals_2) {
              StringConcatenation _builder_1 = new StringConcatenation();
              {
                if (local) {
                  _builder_1.append("float(");
                  String _name_2 = channel.getName();
                  _builder_1.append(_name_2);
                  _builder_1.append(".readline())");
                  _builder_1.newLineIfNotEmpty();
                } else {
                  _builder_1.append("float(");
                  String _name_3 = channel.getName();
                  _builder_1.append(_name_3);
                  _builder_1.append(".receive_messages()[0])\t\t\t\t\t\t\t");
                  _builder_1.newLineIfNotEmpty();
                }
              }
              return _builder_1.toString();
            }
          }
        } else {
          ArithmeticExpression _value_4 = assignment.getValue();
          boolean _equals_3 = ((CastExpression) _value_4).getType().equals("Integer");
          if (_equals_3) {
            StringConcatenation _builder_2 = new StringConcatenation();
            _builder_2.append("raise Exception(\'not now\')");
            _builder_2.newLine();
            return _builder_2.toString();
          } else {
            ArithmeticExpression _value_5 = assignment.getValue();
            boolean _equals_4 = ((CastExpression) _value_5).getType().equals("Double");
            if (_equals_4) {
              StringConcatenation _builder_3 = new StringConcatenation();
              _builder_3.append("raise Exception(\'not now\')\t\t\t\t\t\t\t");
              _builder_3.newLine();
              return _builder_3.toString();
            }
          }
        }
      } else {
        ArithmeticExpression _value_6 = assignment.getValue();
        if ((_value_6 instanceof ChannelReceive)) {
          ArithmeticExpression _value_7 = assignment.getValue();
          EObject _right_1 = ((ChannelReceive) _value_7).getTarget().getEnvironment().getRight();
          boolean _equals_5 = ((DeclarationObject) _right_1).getFeatures().get(0).getValue_s().equals("aws");
          if (_equals_5) {
            ArithmeticExpression _value_8 = assignment.getValue();
            ArithmeticExpression _target_3 = ((CastExpression) _value_8).getTarget();
            ChannelDeclaration _target_4 = ((ChannelReceive) _target_3).getTarget();
            final ChannelDeclaration channel_1 = ((ChannelDeclaration) _target_4);
            StringConcatenation _builder_4 = new StringConcatenation();
            {
              if (local) {
                String _name_4 = channel_1.getName();
                _builder_4.append(_name_4);
                _builder_4.append(".readline()");
                _builder_4.newLineIfNotEmpty();
              } else {
                String _name_5 = channel_1.getName();
                _builder_4.append(_name_5);
                _builder_4.append(".receive_messages()[0]");
                _builder_4.newLineIfNotEmpty();
              }
            }
            return _builder_4.toString();
          } else {
            ArithmeticExpression _value_9 = assignment.getValue();
            EObject _right_2 = ((ChannelReceive) _value_9).getTarget().getEnvironment().getRight();
            boolean _equals_6 = ((DeclarationObject) _right_2).getFeatures().get(0).getValue_s().equals("smp");
            if (_equals_6) {
              ArithmeticExpression _value_10 = assignment.getValue();
              ArithmeticExpression _target_5 = ((CastExpression) _value_10).getTarget();
              ChannelDeclaration _target_6 = ((ChannelReceive) _target_5).getTarget();
              final ChannelDeclaration channel_2 = ((ChannelDeclaration) _target_6);
              StringConcatenation _builder_5 = new StringConcatenation();
              {
                if (local) {
                  String _name_6 = channel_2.getName();
                  _builder_5.append(_name_6);
                  _builder_5.append(".readline()");
                  _builder_5.newLineIfNotEmpty();
                } else {
                  String _name_7 = channel_2.getName();
                  _builder_5.append(_name_7);
                  _builder_5.append(".receive_messages()[0]");
                  _builder_5.newLineIfNotEmpty();
                }
              }
              return _builder_5.toString();
            } else {
              StringConcatenation _builder_6 = new StringConcatenation();
              _builder_6.append("raise Exception(\'not now\')");
              _builder_6.newLine();
              return _builder_6.toString();
            }
          }
        } else {
          StringConcatenation _builder_7 = new StringConcatenation();
          Object _generatePyArithmeticExpression = this.generatePyArithmeticExpression(assignment.getFeature(), scope, local);
          _builder_7.append(_generatePyArithmeticExpression);
          _builder_7.append(" ");
          String _op = assignment.getOp();
          _builder_7.append(_op);
          _builder_7.append(" ");
          Object _generatePyArithmeticExpression_1 = this.generatePyArithmeticExpression(assignment.getValue(), scope, local);
          _builder_7.append(_generatePyArithmeticExpression_1);
          _builder_7.append(" ");
          _builder_7.newLineIfNotEmpty();
          return _builder_7.toString();
        }
      }
    }
    ObjectLiteral _feature_obj = assignment.getFeature_obj();
    boolean _tripleNotEquals_1 = (_feature_obj != null);
    if (_tripleNotEquals_1) {
      ObjectLiteral _feature_obj_1 = assignment.getFeature_obj();
      if ((_feature_obj_1 instanceof NameObject)) {
        HashMap<String, String> _get = this.typeSystem.get(scope);
        ObjectLiteral _feature_obj_2 = assignment.getFeature_obj();
        VariableDeclaration _name_8 = ((NameObject) _feature_obj_2).getName();
        String _name_9 = ((VariableDeclaration) _name_8).getName();
        String _plus = (_name_9 + ".");
        ObjectLiteral _feature_obj_3 = assignment.getFeature_obj();
        String _value_11 = ((NameObject) _feature_obj_3).getValue();
        String _plus_1 = (_plus + _value_11);
        _get.put(_plus_1, 
          this.valuateArithmeticExpression(assignment.getValue(), scope, local));
        StringConcatenation _builder_8 = new StringConcatenation();
        ObjectLiteral _feature_obj_4 = assignment.getFeature_obj();
        VariableDeclaration _name_10 = ((NameObject) _feature_obj_4).getName();
        String _name_11 = ((VariableDeclaration) _name_10).getName();
        _builder_8.append(_name_11);
        _builder_8.append("[\'");
        ObjectLiteral _feature_obj_5 = assignment.getFeature_obj();
        String _value_12 = ((NameObject) _feature_obj_5).getValue();
        _builder_8.append(_value_12);
        _builder_8.append("\'] = ");
        Object _generatePyArithmeticExpression_2 = this.generatePyArithmeticExpression(assignment.getValue(), scope, local);
        _builder_8.append(_generatePyArithmeticExpression_2);
        _builder_8.append(" ");
        _builder_8.newLineIfNotEmpty();
        return _builder_8.toString();
      }
      ObjectLiteral _feature_obj_6 = assignment.getFeature_obj();
      if ((_feature_obj_6 instanceof IndexObject)) {
        ObjectLiteral _feature_obj_7 = assignment.getFeature_obj();
        boolean _contains = this.typeSystem.get(scope).get(((IndexObject) _feature_obj_7).getName().getName()).contains("Array");
        if (_contains) {
          StringConcatenation _builder_9 = new StringConcatenation();
          ObjectLiteral _feature_obj_8 = assignment.getFeature_obj();
          String _name_12 = ((IndexObject) _feature_obj_8).getName().getName();
          _builder_9.append(_name_12);
          _builder_9.append("[");
          ObjectLiteral _feature_obj_9 = assignment.getFeature_obj();
          Object _generatePyArithmeticExpression_3 = this.generatePyArithmeticExpression(((IndexObject) _feature_obj_9).getIndexes().get(0).getValue(), scope, local);
          _builder_9.append(_generatePyArithmeticExpression_3);
          _builder_9.append("] = ");
          Object _generatePyArithmeticExpression_4 = this.generatePyArithmeticExpression(assignment.getValue(), scope, local);
          _builder_9.append(_generatePyArithmeticExpression_4);
          _builder_9.newLineIfNotEmpty();
          return _builder_9.toString();
        } else {
          ObjectLiteral _feature_obj_10 = assignment.getFeature_obj();
          boolean _contains_1 = this.typeSystem.get(scope).get(((IndexObject) _feature_obj_10).getName().getName()).contains("Matrix");
          if (_contains_1) {
            ObjectLiteral _feature_obj_11 = assignment.getFeature_obj();
            int _length = ((Object[])Conversions.unwrapArray(((IndexObject) _feature_obj_11).getIndexes(), Object.class)).length;
            boolean _equals_7 = (_length == 2);
            if (_equals_7) {
              ObjectLiteral _feature_obj_12 = assignment.getFeature_obj();
              Object i = this.generatePyArithmeticExpression(((IndexObject) _feature_obj_12).getIndexes().get(0).getValue(), scope, local);
              ObjectLiteral _feature_obj_13 = assignment.getFeature_obj();
              Object j = this.generatePyArithmeticExpression(((IndexObject) _feature_obj_13).getIndexes().get(1).getValue(), scope, local);
              ObjectLiteral _feature_obj_14 = assignment.getFeature_obj();
              String col = this.typeSystem.get(scope).get(((IndexObject) _feature_obj_14).getName().getName()).split("_")[2];
              StringConcatenation _builder_10 = new StringConcatenation();
              ObjectLiteral _feature_obj_15 = assignment.getFeature_obj();
              String _name_13 = ((IndexObject) _feature_obj_15).getName().getName();
              _builder_10.append(_name_13);
              _builder_10.append("[");
              _builder_10.append(i);
              _builder_10.append("*");
              _builder_10.append(col);
              _builder_10.append("+");
              _builder_10.append(j);
              _builder_10.append("] = ");
              Object _generatePyArithmeticExpression_5 = this.generatePyArithmeticExpression(assignment.getValue(), scope, local);
              _builder_10.append(_generatePyArithmeticExpression_5);
              _builder_10.newLineIfNotEmpty();
              return _builder_10.toString();
            }
          } else {
            StringConcatenation _builder_11 = new StringConcatenation();
            ObjectLiteral _feature_obj_16 = assignment.getFeature_obj();
            String _name_14 = ((IndexObject) _feature_obj_16).getName().getName();
            _builder_11.append(_name_14);
            _builder_11.append("[");
            ObjectLiteral _feature_obj_17 = assignment.getFeature_obj();
            Object _generatePyArithmeticExpression_6 = this.generatePyArithmeticExpression(((IndexObject) _feature_obj_17).getIndexes().get(0).getValue(), scope, local);
            _builder_11.append(_generatePyArithmeticExpression_6);
            _builder_11.append("] = ");
            Object _generatePyArithmeticExpression_7 = this.generatePyArithmeticExpression(assignment.getValue(), scope, local);
            _builder_11.append(_generatePyArithmeticExpression_7);
            _builder_11.newLineIfNotEmpty();
            return _builder_11.toString();
          }
        }
      }
    }
    return null;
  }
  
  public CharSequence generatePyWhileExpression(final WhileExpression exp, final String scope, final boolean local) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("while ");
    Object _generatePyArithmeticExpression = this.generatePyArithmeticExpression(exp.getCond(), scope, local);
    _builder.append(_generatePyArithmeticExpression);
    _builder.append(":");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    Object _generatePyExpression = this.generatePyExpression(exp.getBody(), scope, local);
    _builder.append(_generatePyExpression, "\t");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public String generatePyForExpression(final ForExpression exp, final String scope, final boolean local) {
    int _length = ((Object[])Conversions.unwrapArray(exp.getIndex().getIndices(), Object.class)).length;
    boolean _equals = (_length == 1);
    if (_equals) {
      ArithmeticExpression _object = exp.getObject();
      if ((_object instanceof CastExpression)) {
        ArithmeticExpression _object_1 = exp.getObject();
        boolean _equals_1 = ((CastExpression) _object_1).getType().equals("Dat");
        if (_equals_1) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("for ");
          VariableFor _get = exp.getIndex().getIndices().get(0);
          String _name = ((VariableDeclaration) _get).getName();
          _builder.append(_name);
          _builder.append(" in ");
          ArithmeticExpression _object_2 = exp.getObject();
          String _name_1 = ((VariableLiteral) _object_2).getVariable().getName();
          _builder.append(_name_1);
          _builder.append(".itertuples(index=False):");
          _builder.newLineIfNotEmpty();
          {
            Expression _body = exp.getBody();
            if ((_body instanceof BlockExpression)) {
              {
                Expression _body_1 = exp.getBody();
                EList<Expression> _expressions = ((BlockExpression) _body_1).getExpressions();
                for(final Expression e : _expressions) {
                  _builder.append("\t");
                  Object _generatePyExpression = this.generatePyExpression(e, scope, local);
                  _builder.append(_generatePyExpression, "\t");
                  _builder.newLineIfNotEmpty();
                }
              }
            } else {
              _builder.append("\t");
              Object _generatePyExpression_1 = this.generatePyExpression(exp.getBody(), scope, local);
              _builder.append(_generatePyExpression_1, "\t");
              _builder.newLineIfNotEmpty();
            }
          }
          return _builder.toString();
        } else {
          ArithmeticExpression _object_3 = exp.getObject();
          boolean _equals_2 = ((CastExpression) _object_3).getType().equals("Object");
          if (_equals_2) {
            VariableFor _get_1 = exp.getIndex().getIndices().get(0);
            final String variableName = ((VariableDeclaration) _get_1).getName();
            StringConcatenation _builder_1 = new StringConcatenation();
            _builder_1.append("for ");
            _builder_1.append(variableName);
            _builder_1.append("k, ");
            _builder_1.append(variableName);
            _builder_1.append("v in ");
            ArithmeticExpression _object_4 = exp.getObject();
            ArithmeticExpression _target = ((CastExpression) _object_4).getTarget();
            String _name_2 = ((VariableLiteral) _target).getVariable().getName();
            _builder_1.append(_name_2);
            _builder_1.append(".items():");
            _builder_1.newLineIfNotEmpty();
            _builder_1.append("\t");
            VariableFor _get_2 = exp.getIndex().getIndices().get(0);
            String _name_3 = ((VariableDeclaration) _get_2).getName();
            _builder_1.append(_name_3, "\t");
            _builder_1.append(" = {\'k\': ");
            _builder_1.append(variableName, "\t");
            _builder_1.append("k, \'v\': ");
            _builder_1.append(variableName, "\t");
            _builder_1.append("v} ");
            _builder_1.newLineIfNotEmpty();
            {
              Expression _body_2 = exp.getBody();
              if ((_body_2 instanceof BlockExpression)) {
                {
                  Expression _body_3 = exp.getBody();
                  EList<Expression> _expressions_1 = ((BlockExpression) _body_3).getExpressions();
                  for(final Expression e_1 : _expressions_1) {
                    _builder_1.append("\t");
                    Object _generatePyExpression_2 = this.generatePyExpression(e_1, scope, local);
                    _builder_1.append(_generatePyExpression_2, "\t");
                    _builder_1.newLineIfNotEmpty();
                  }
                }
              } else {
                _builder_1.append("\t");
                Object _generatePyExpression_3 = this.generatePyExpression(exp.getBody(), scope, local);
                _builder_1.append(_generatePyExpression_3, "\t");
                _builder_1.append("\t");
                _builder_1.newLineIfNotEmpty();
              }
            }
            return _builder_1.toString();
          }
        }
      } else {
        ArithmeticExpression _object_5 = exp.getObject();
        if ((_object_5 instanceof RangeLiteral)) {
          ArithmeticExpression _object_6 = exp.getObject();
          final int lRange = ((RangeLiteral) _object_6).getValue1();
          ArithmeticExpression _object_7 = exp.getObject();
          final int rRange = ((RangeLiteral) _object_7).getValue2();
          StringConcatenation _builder_2 = new StringConcatenation();
          _builder_2.append("for ");
          VariableFor _get_3 = exp.getIndex().getIndices().get(0);
          String _name_4 = ((VariableDeclaration) _get_3).getName();
          _builder_2.append(_name_4);
          _builder_2.append(" in range(");
          _builder_2.append(lRange);
          _builder_2.append(", ");
          _builder_2.append(rRange);
          _builder_2.append("):");
          _builder_2.newLineIfNotEmpty();
          {
            Expression _body_4 = exp.getBody();
            if ((_body_4 instanceof BlockExpression)) {
              _builder_2.append("\t");
              Expression _body_5 = exp.getBody();
              CharSequence _generatePyBlockExpression = this.generatePyBlockExpression(((BlockExpression) _body_5), scope, local);
              _builder_2.append(_generatePyBlockExpression, "\t");
              _builder_2.newLineIfNotEmpty();
            } else {
              _builder_2.append("\t");
              Object _generatePyExpression_4 = this.generatePyExpression(exp.getBody(), scope, local);
              _builder_2.append(_generatePyExpression_4, "\t");
              _builder_2.newLineIfNotEmpty();
            }
          }
          return _builder_2.toString();
        } else {
          ArithmeticExpression _object_8 = exp.getObject();
          if ((_object_8 instanceof VariableLiteral)) {
            if (((((VariableLiteral) exp.getObject()).getVariable().getTypeobject().equals("var") && (((VariableLiteral) exp.getObject()).getVariable().getRight() instanceof NameObjectDef)) || 
              this.typeSystem.get(scope).get(((VariableLiteral) exp.getObject()).getVariable().getName()).equals("HashMap"))) {
              VariableFor _get_4 = exp.getIndex().getIndices().get(0);
              final String variableName_1 = ((VariableDeclaration) _get_4).getName();
              StringConcatenation _builder_3 = new StringConcatenation();
              _builder_3.append("for ");
              _builder_3.append(variableName_1);
              _builder_3.append("k, ");
              _builder_3.append(variableName_1);
              _builder_3.append("v in ");
              ArithmeticExpression _object_9 = exp.getObject();
              String _name_5 = ((VariableLiteral) _object_9).getVariable().getName();
              _builder_3.append(_name_5);
              _builder_3.append(".items():");
              _builder_3.newLineIfNotEmpty();
              _builder_3.append("\t");
              VariableFor _get_5 = exp.getIndex().getIndices().get(0);
              String _name_6 = ((VariableDeclaration) _get_5).getName();
              _builder_3.append(_name_6, "\t");
              _builder_3.append(" = {\'k\': ");
              _builder_3.append(variableName_1, "\t");
              _builder_3.append("k, \'v\': ");
              _builder_3.append(variableName_1, "\t");
              _builder_3.append("v}");
              _builder_3.newLineIfNotEmpty();
              {
                Expression _body_6 = exp.getBody();
                if ((_body_6 instanceof BlockExpression)) {
                  {
                    Expression _body_7 = exp.getBody();
                    EList<Expression> _expressions_2 = ((BlockExpression) _body_7).getExpressions();
                    for(final Expression e_2 : _expressions_2) {
                      _builder_3.append("\t");
                      Object _generatePyExpression_5 = this.generatePyExpression(e_2, scope, local);
                      _builder_3.append(_generatePyExpression_5, "\t");
                      _builder_3.newLineIfNotEmpty();
                    }
                  }
                } else {
                  _builder_3.append("\t");
                  Object _generatePyExpression_6 = this.generatePyExpression(exp.getBody(), scope, local);
                  _builder_3.append(_generatePyExpression_6, "\t");
                  _builder_3.append("\t");
                  _builder_3.newLineIfNotEmpty();
                }
              }
              _builder_3.newLine();
              return _builder_3.toString();
            } else {
              if ((((VariableLiteral) exp.getObject()).getVariable().getTypeobject().equals("dat") || 
                this.typeSystem.get(scope).get(((VariableLiteral) exp.getObject()).getVariable().getName()).equals("Table"))) {
                StringConcatenation _builder_4 = new StringConcatenation();
                _builder_4.append("for ");
                VariableFor _get_6 = exp.getIndex().getIndices().get(0);
                String _name_7 = ((VariableDeclaration) _get_6).getName();
                _builder_4.append(_name_7);
                _builder_4.append(" in ");
                ArithmeticExpression _object_10 = exp.getObject();
                String _name_8 = ((VariableLiteral) _object_10).getVariable().getName();
                _builder_4.append(_name_8);
                _builder_4.append(".itertuples(index=False):");
                _builder_4.newLineIfNotEmpty();
                {
                  Expression _body_8 = exp.getBody();
                  if ((_body_8 instanceof BlockExpression)) {
                    {
                      Expression _body_9 = exp.getBody();
                      EList<Expression> _expressions_3 = ((BlockExpression) _body_9).getExpressions();
                      for(final Expression e_3 : _expressions_3) {
                        _builder_4.append("\t");
                        Object _generatePyExpression_7 = this.generatePyExpression(e_3, scope, local);
                        _builder_4.append(_generatePyExpression_7, "\t");
                        _builder_4.newLineIfNotEmpty();
                      }
                    }
                  } else {
                    _builder_4.append("\t");
                    Object _generatePyExpression_8 = this.generatePyExpression(exp.getBody(), scope, local);
                    _builder_4.append(_generatePyExpression_8, "\t");
                    _builder_4.newLineIfNotEmpty();
                  }
                }
                return _builder_4.toString();
              }
            }
          }
        }
      }
    }
    return null;
  }
  
  public CharSequence generatePyBlockExpression(final BlockExpression block, final String scope, final boolean local) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<Expression> _expressions = block.getExpressions();
      for(final Expression exp : _expressions) {
        Object _generatePyExpression = this.generatePyExpression(exp, scope, local);
        _builder.append(_generatePyExpression);
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public Object generatePyArithmeticExpression(final ArithmeticExpression exp, final String scope, final boolean local) {
    Object _xblockexpression = null;
    {
      if ((exp instanceof BinaryOperation)) {
        boolean _equals = ((BinaryOperation)exp).getFeature().equals("and");
        if (_equals) {
          StringConcatenation _builder = new StringConcatenation();
          Object _generatePyArithmeticExpression = this.generatePyArithmeticExpression(((BinaryOperation)exp).getLeft(), scope, local);
          _builder.append(_generatePyArithmeticExpression);
          _builder.append(" and ");
          Object _generatePyArithmeticExpression_1 = this.generatePyArithmeticExpression(((BinaryOperation)exp).getRight(), scope, local);
          _builder.append(_generatePyArithmeticExpression_1);
          return _builder.toString();
        } else {
          boolean _equals_1 = ((BinaryOperation)exp).getFeature().equals("or");
          if (_equals_1) {
            StringConcatenation _builder_1 = new StringConcatenation();
            Object _generatePyArithmeticExpression_2 = this.generatePyArithmeticExpression(((BinaryOperation)exp).getLeft(), scope, local);
            _builder_1.append(_generatePyArithmeticExpression_2);
            _builder_1.append(" or ");
            Object _generatePyArithmeticExpression_3 = this.generatePyArithmeticExpression(((BinaryOperation)exp).getRight(), scope, local);
            _builder_1.append(_generatePyArithmeticExpression_3);
            return _builder_1.toString();
          } else {
            boolean _equals_2 = ((BinaryOperation)exp).getFeature().equals("+");
            if (_equals_2) {
              final boolean leftTypeString = this.valuateArithmeticExpression(((BinaryOperation)exp).getLeft(), scope, local).equals("String");
              final boolean rightTypeString = this.valuateArithmeticExpression(((BinaryOperation)exp).getRight(), scope, local).equals("String");
              if (((leftTypeString && rightTypeString) || ((!leftTypeString) && (!rightTypeString)))) {
                StringConcatenation _builder_2 = new StringConcatenation();
                Object _generatePyArithmeticExpression_4 = this.generatePyArithmeticExpression(((BinaryOperation)exp).getLeft(), scope, local);
                _builder_2.append(_generatePyArithmeticExpression_4);
                _builder_2.append(" ");
                String _feature = ((BinaryOperation)exp).getFeature();
                _builder_2.append(_feature);
                _builder_2.append(" ");
                Object _generatePyArithmeticExpression_5 = this.generatePyArithmeticExpression(((BinaryOperation)exp).getRight(), scope, local);
                _builder_2.append(_generatePyArithmeticExpression_5);
                return _builder_2.toString();
              } else {
                if (leftTypeString) {
                  StringConcatenation _builder_3 = new StringConcatenation();
                  Object _generatePyArithmeticExpression_6 = this.generatePyArithmeticExpression(((BinaryOperation)exp).getLeft(), scope, local);
                  _builder_3.append(_generatePyArithmeticExpression_6);
                  _builder_3.append(" ");
                  String _feature_1 = ((BinaryOperation)exp).getFeature();
                  _builder_3.append(_feature_1);
                  _builder_3.append(" str(");
                  Object _generatePyArithmeticExpression_7 = this.generatePyArithmeticExpression(((BinaryOperation)exp).getRight(), scope, local);
                  _builder_3.append(_generatePyArithmeticExpression_7);
                  _builder_3.append(")");
                  return _builder_3.toString();
                } else {
                  StringConcatenation _builder_4 = new StringConcatenation();
                  _builder_4.append("str(");
                  Object _generatePyArithmeticExpression_8 = this.generatePyArithmeticExpression(((BinaryOperation)exp).getLeft(), scope, local);
                  _builder_4.append(_generatePyArithmeticExpression_8);
                  _builder_4.append(") ");
                  String _feature_2 = ((BinaryOperation)exp).getFeature();
                  _builder_4.append(_feature_2);
                  _builder_4.append(" ");
                  Object _generatePyArithmeticExpression_9 = this.generatePyArithmeticExpression(((BinaryOperation)exp).getRight(), scope, local);
                  _builder_4.append(_generatePyArithmeticExpression_9);
                  return _builder_4.toString();
                }
              }
            } else {
              StringConcatenation _builder_5 = new StringConcatenation();
              Object _generatePyArithmeticExpression_10 = this.generatePyArithmeticExpression(((BinaryOperation)exp).getLeft(), scope, local);
              _builder_5.append(_generatePyArithmeticExpression_10);
              _builder_5.append(" ");
              String _feature_3 = ((BinaryOperation)exp).getFeature();
              _builder_5.append(_feature_3);
              _builder_5.append(" ");
              Object _generatePyArithmeticExpression_11 = this.generatePyArithmeticExpression(((BinaryOperation)exp).getRight(), scope, local);
              _builder_5.append(_generatePyArithmeticExpression_11);
              return _builder_5.toString();
            }
          }
        }
      } else {
        if ((exp instanceof UnaryOperation)) {
          StringConcatenation _builder_6 = new StringConcatenation();
          String _feature_4 = ((UnaryOperation)exp).getFeature();
          _builder_6.append(_feature_4);
          _builder_6.append(" ");
          Object _generatePyArithmeticExpression_12 = this.generatePyArithmeticExpression(((UnaryOperation)exp).getOperand(), scope, local);
          _builder_6.append(_generatePyArithmeticExpression_12);
          _builder_6.append(" ");
          return _builder_6.toString();
        } else {
          if ((exp instanceof PostfixOperation)) {
            String postfixOp = "";
            String _feature_5 = ((PostfixOperation)exp).getFeature();
            if (_feature_5 != null) {
              switch (_feature_5) {
                case "++":
                  postfixOp = "+=1";
                  break;
                case "--":
                  postfixOp = "-=1";
                  break;
              }
            }
            StringConcatenation _builder_7 = new StringConcatenation();
            Object _generatePyArithmeticExpression_13 = this.generatePyArithmeticExpression(((PostfixOperation)exp).getVariable(), scope, local);
            _builder_7.append(_generatePyArithmeticExpression_13);
            _builder_7.append(postfixOp);
            return _builder_7.toString();
          } else {
            if ((exp instanceof ParenthesizedExpression)) {
              StringConcatenation _builder_8 = new StringConcatenation();
              _builder_8.append("(");
              Object _generatePyArithmeticExpression_14 = this.generatePyArithmeticExpression(((ParenthesizedExpression)exp).getExpression(), scope, local);
              _builder_8.append(_generatePyArithmeticExpression_14);
              _builder_8.append(")");
              return _builder_8.toString();
            } else {
              if ((exp instanceof NumberLiteral)) {
                StringConcatenation _builder_9 = new StringConcatenation();
                int _value = ((NumberLiteral)exp).getValue();
                _builder_9.append(_value);
                return _builder_9.toString();
              } else {
                if ((exp instanceof BooleanLiteral)) {
                  StringConcatenation _builder_10 = new StringConcatenation();
                  String _firstUpper = StringExtensions.toFirstUpper(((BooleanLiteral)exp).getValue());
                  _builder_10.append(_firstUpper);
                  return _builder_10.toString();
                } else {
                  if ((exp instanceof FloatLiteral)) {
                    StringConcatenation _builder_11 = new StringConcatenation();
                    float _value_1 = ((FloatLiteral)exp).getValue();
                    _builder_11.append(_value_1);
                    return _builder_11.toString();
                  }
                }
              }
            }
          }
        }
      }
      Object _xifexpression = null;
      if ((exp instanceof StringLiteral)) {
        StringConcatenation _builder_12 = new StringConcatenation();
        _builder_12.append(" ");
        _builder_12.append("\'");
        String _value_2 = ((StringLiteral)exp).getValue();
        _builder_12.append(_value_2, " ");
        _builder_12.append("\' ");
        return _builder_12.toString();
      } else {
        Object _xifexpression_1 = null;
        if ((exp instanceof VariableLiteral)) {
          StringConcatenation _builder_13 = new StringConcatenation();
          String _name = ((VariableLiteral)exp).getVariable().getName();
          _builder_13.append(_name);
          return _builder_13.toString();
        } else {
          Object _xifexpression_2 = null;
          if ((exp instanceof VariableFunction)) {
            boolean _equals_3 = ((VariableFunction)exp).getTarget().getTypeobject().equals("random");
            if (_equals_3) {
              StringConcatenation _builder_14 = new StringConcatenation();
              _builder_14.append("random.random()");
              return _builder_14.toString();
            } else {
              boolean _equals_4 = ((VariableFunction)exp).getFeature().equals("length");
              if (_equals_4) {
                StringConcatenation _builder_15 = new StringConcatenation();
                _builder_15.append("len(");
                String _name_1 = ((VariableFunction)exp).getTarget().getName();
                _builder_15.append(_name_1);
                _builder_15.append(")");
                return _builder_15.toString();
              }
            }
          } else {
            Object _xifexpression_3 = null;
            if ((exp instanceof TimeFunction)) {
              VariableDeclaration _value_3 = ((TimeFunction)exp).getValue();
              boolean _tripleNotEquals = (_value_3 != null);
              if (_tripleNotEquals) {
                StringConcatenation _builder_16 = new StringConcatenation();
                _builder_16.append("int(time.time() * 1000) - ");
                String _name_2 = ((TimeFunction)exp).getValue().getName();
                _builder_16.append(_name_2);
                return _builder_16.toString();
              } else {
                StringConcatenation _builder_17 = new StringConcatenation();
                _builder_17.append("int(time.time() * 1000)");
                return _builder_17.toString();
              }
            } else {
              Object _xifexpression_4 = null;
              if ((exp instanceof NameObject)) {
                StringConcatenation _builder_18 = new StringConcatenation();
                VariableDeclaration _name_3 = ((NameObject)exp).getName();
                String _name_4 = ((VariableDeclaration) _name_3).getName();
                _builder_18.append(_name_4);
                _builder_18.append("[\'");
                String _value_4 = ((NameObject)exp).getValue();
                _builder_18.append(_value_4);
                _builder_18.append("\']");
                return _builder_18.toString();
              } else {
                Object _xifexpression_5 = null;
                if ((exp instanceof IndexObject)) {
                  Object _xifexpression_6 = null;
                  int _length = ((Object[])Conversions.unwrapArray(((IndexObject)exp).getIndexes(), Object.class)).length;
                  boolean _equals_5 = (_length == 1);
                  if (_equals_5) {
                    StringConcatenation _builder_19 = new StringConcatenation();
                    VariableDeclaration _name_5 = ((IndexObject)exp).getName();
                    String _name_6 = ((VariableDeclaration) _name_5).getName();
                    _builder_19.append(_name_6);
                    _builder_19.append("[");
                    Object _generatePyArithmeticExpression_15 = this.generatePyArithmeticExpression(((IndexObject)exp).getIndexes().get(0).getValue(), scope, local);
                    _builder_19.append(_generatePyArithmeticExpression_15);
                    _builder_19.append("]");
                    return _builder_19.toString();
                  } else {
                    Object _xifexpression_7 = null;
                    int _length_1 = ((Object[])Conversions.unwrapArray(((IndexObject)exp).getIndexes(), Object.class)).length;
                    boolean _equals_6 = (_length_1 == 2);
                    if (_equals_6) {
                      Object i = this.generatePyArithmeticExpression(((IndexObject)exp).getIndexes().get(0).getValue(), scope, local);
                      Object j = this.generatePyArithmeticExpression(((IndexObject)exp).getIndexes().get(1).getValue(), scope, local);
                      VariableDeclaration _name_7 = ((IndexObject)exp).getName();
                      String col = this.typeSystem.get(scope).get(((VariableDeclaration) _name_7).getName()).split("_")[2];
                      StringConcatenation _builder_20 = new StringConcatenation();
                      VariableDeclaration _name_8 = ((IndexObject)exp).getName();
                      String _name_9 = ((VariableDeclaration) _name_8).getName();
                      _builder_20.append(_name_9);
                      _builder_20.append("[(");
                      _builder_20.append(i);
                      _builder_20.append("*");
                      _builder_20.append(col);
                      _builder_20.append(")+");
                      _builder_20.append(j);
                      _builder_20.append("]");
                      _builder_20.newLineIfNotEmpty();
                      return _builder_20.toString();
                    } else {
                      _xifexpression_7 = null;
                    }
                    _xifexpression_6 = _xifexpression_7;
                  }
                  _xifexpression_5 = _xifexpression_6;
                } else {
                  if ((exp instanceof CastExpression)) {
                    StringConcatenation _builder_21 = new StringConcatenation();
                    String _generatePyCast = this.generatePyCast(((CastExpression)exp), scope, local);
                    _builder_21.append(_generatePyCast);
                    return _builder_21.toString();
                  } else {
                    if ((exp instanceof MathFunction)) {
                      boolean _equals_7 = ((MathFunction)exp).getFeature().equals("abs");
                      if (_equals_7) {
                        StringConcatenation _builder_22 = new StringConcatenation();
                        _builder_22.append("abs(");
                        {
                          EList<ArithmeticExpression> _expressions = ((MathFunction)exp).getExpressions();
                          for(final ArithmeticExpression par : _expressions) {
                            Object _generatePyArithmeticExpression_16 = this.generatePyArithmeticExpression(par, scope, local);
                            _builder_22.append(_generatePyArithmeticExpression_16);
                            {
                              boolean _equals_8 = par.equals(IterableExtensions.<ArithmeticExpression>last(((MathFunction)exp).getExpressions()));
                              boolean _not = (!_equals_8);
                              if (_not) {
                                _builder_22.append(", ");
                              }
                            }
                          }
                        }
                        _builder_22.append(")");
                        return _builder_22.toString();
                      }
                      StringConcatenation _builder_23 = new StringConcatenation();
                      _builder_23.append("math.");
                      String _feature_6 = ((MathFunction)exp).getFeature();
                      _builder_23.append(_feature_6);
                      _builder_23.append("(");
                      {
                        EList<ArithmeticExpression> _expressions_1 = ((MathFunction)exp).getExpressions();
                        for(final ArithmeticExpression par_1 : _expressions_1) {
                          Object _generatePyArithmeticExpression_17 = this.generatePyArithmeticExpression(par_1, scope, local);
                          _builder_23.append(_generatePyArithmeticExpression_17);
                          {
                            boolean _equals_9 = par_1.equals(IterableExtensions.<ArithmeticExpression>last(((MathFunction)exp).getExpressions()));
                            boolean _not_1 = (!_equals_9);
                            if (_not_1) {
                              _builder_23.append(", ");
                            }
                          }
                        }
                      }
                      _builder_23.append(")");
                      return _builder_23.toString();
                    } else {
                      if ((exp instanceof ChannelReceive)) {
                        ChannelDeclaration _target = ((ChannelReceive) exp).getTarget();
                        final String channelName = ((VariableDeclaration) ((ChannelDeclaration) _target)).getName();
                        if (local) {
                          StringConcatenation _builder_24 = new StringConcatenation();
                          _builder_24.append(channelName);
                          _builder_24.append(".readline()");
                          return _builder_24.toString();
                        }
                        StringConcatenation _builder_25 = new StringConcatenation();
                        _builder_25.append(channelName);
                        _builder_25.append(".receive_messages()[0]");
                        return _builder_25.toString();
                      } else {
                        if ((exp instanceof LocalFunctionCall)) {
                          return this.generatePyExpression(((LocalFunctionCall) exp), scope, local);
                        } else {
                          StringConcatenation _builder_26 = new StringConcatenation();
                          _builder_26.append("# ???");
                          return _builder_26.toString();
                        }
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
    return _xblockexpression;
  }
  
  public String generatePyCast(final CastExpression cast, final String scope, final boolean local) {
    String _type = cast.getType();
    if (_type != null) {
      switch (_type) {
        case "String":
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("str(");
          Object _generatePyArithmeticExpression = this.generatePyArithmeticExpression(cast.getTarget(), scope, local);
          _builder.append(_generatePyArithmeticExpression);
          _builder.append(")");
          return _builder.toString();
        case "Integer":
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("int(");
          Object _generatePyArithmeticExpression_1 = this.generatePyArithmeticExpression(cast.getTarget(), scope, local);
          _builder_1.append(_generatePyArithmeticExpression_1);
          _builder_1.append(")");
          return _builder_1.toString();
        case "Dat":
          StringConcatenation _builder_2 = new StringConcatenation();
          _builder_2.append("pd.read_json(");
          Object _generatePyArithmeticExpression_2 = this.generatePyArithmeticExpression(cast.getTarget(), scope, local);
          _builder_2.append(_generatePyArithmeticExpression_2);
          _builder_2.append(")");
          return _builder_2.toString();
        case "Object":
          StringConcatenation _builder_3 = new StringConcatenation();
          Object _generatePyArithmeticExpression_3 = this.generatePyArithmeticExpression(cast.getTarget(), scope, local);
          _builder_3.append(_generatePyArithmeticExpression_3);
          return _builder_3.toString();
        case "Double":
          StringConcatenation _builder_4 = new StringConcatenation();
          _builder_4.append("float(");
          Object _generatePyArithmeticExpression_4 = this.generatePyArithmeticExpression(cast.getTarget(), scope, local);
          _builder_4.append(_generatePyArithmeticExpression_4);
          _builder_4.append(")");
          return _builder_4.toString();
      }
    }
    return null;
  }
  
  public String valuateArithmeticExpression(final ArithmeticExpression exp, final String scope, final boolean local) {
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
                        return this.valuateArithmeticExpression(((ArithmeticExpression) _right_2), scope, local);
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
                    Object _generatePyArithmeticExpression = this.generatePyArithmeticExpression(((IndexObject)exp).getIndexes().get(0).getValue(), scope, local);
                    String _plus_3 = (_plus_2 + _generatePyArithmeticExpression);
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
      return this.valuateArithmeticExpression(((UnaryOperation)exp).getOperand(), scope, local);
    }
    if ((exp instanceof BinaryOperation)) {
      String left = this.valuateArithmeticExpression(((BinaryOperation)exp).getLeft(), scope, local);
      String right = this.valuateArithmeticExpression(((BinaryOperation)exp).getRight(), scope, local);
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
      if ((exp instanceof PostfixOperation)) {
        return this.valuateArithmeticExpression(((PostfixOperation) exp).getVariable(), scope, local);
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
            return this.valuateArithmeticExpression(((ParenthesizedExpression)exp).getExpression(), scope, local);
          }
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
          boolean _equals_11 = this.valuateArithmeticExpression(el, scope, local).equals("Double");
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
  
  public CharSequence compilePython(final Resource resource, final String name, final boolean local) {
    StringConcatenation _builder = new StringConcatenation();
    String _generateBodyPyLocal = this.generateBodyPyLocal(this.root.getBody(), this.root.getParameters(), name, this.env, local);
    _builder.append(_generateBodyPyLocal);
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence compileScript(final Resource resource, final String name, final boolean local) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#!/bin/bash");
    _builder.newLine();
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
    _builder.append("echo \"Checking that aws-cli is installed\"");
    _builder.newLine();
    _builder.append("which aws");
    _builder.newLine();
    _builder.append("if [ $? -eq 0 ]; then");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("echo \"aws-cli is installed, continuing...\"");
    _builder.newLine();
    _builder.append("else");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("echo \"You need aws-cli to deploy this lambda. Google \'aws-cli install\'\"");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("exit 1");
    _builder.newLine();
    _builder.append("fi");
    _builder.newLine();
    _builder.newLine();
    _builder.append("echo \"Checking wheter virtualenv is installed\"");
    _builder.newLine();
    _builder.append("which virtualenv");
    _builder.newLine();
    _builder.append("if [ $? -eq 0 ]; then");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("echo \"virtualenv is installed, continuing...\"");
    _builder.newLine();
    _builder.append("else");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("echo \"You need to install virtualenv. Google \'virtualenv install\'\"");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("exit 1");
    _builder.newLine();
    _builder.append("fi");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    _builder.append("function=$1");
    _builder.newLine();
    _builder.append("id=$2");
    _builder.newLine();
    _builder.newLine();
    _builder.append("echo \'{");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("\"Version\": \"2012-10-17\",");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("\"Statement\": [");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("\"Effect\": \"Allow\",");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("\"Action\": [");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("\"sqs:DeleteMessage\",");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("\"sqs:GetQueueAttributes\",");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("\"sqs:ReceiveMessage\",");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("\"sqs:SendMessage\",");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("\"sqs:*\"");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("],");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("\"Resource\": \"*\" ");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("},");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("\"Effect\": \"Allow\",");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("\"Action\": [");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("\"s3:*\"");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("],");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("\"Resource\": \"*\" ");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t");
    _builder.append("},");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("\"Effect\":\"Allow\",");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("\"Action\": [");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("\"logs:CreateLogGroup\",");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("\"logs:CreateLogStream\",");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("\"logs:PutLogEvents\"");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("],");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("\"Resource\": \"*\"");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}\' > policyDocument.json");
    _builder.newLine();
    _builder.newLine();
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
    _builder.append("\"Principal\": {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("\"Service\": \"lambda.amazonaws.com\"");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("},");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("\"Action\": \"sts:AssumeRole\" ");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("]");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}\' > rolePolicyDocument.json");
    _builder.newLine();
    _builder.newLine();
    _builder.append("#create role policy");
    _builder.newLine();
    _builder.newLine();
    _builder.append("echo \"creation of role lambda-sqs-execution ...\"");
    _builder.newLine();
    _builder.newLine();
    _builder.append("role_arn=$(aws iam get-role --role-name lambda-sqs-execution --query \'Role.Arn\')");
    _builder.newLine();
    _builder.newLine();
    _builder.append("if [ $? -eq 255 ]; then ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("role_arn=$(aws iam create-role --role-name lambda-sqs-execution --assume-role-policy-document file://rolePolicyDocument.json --output json --query \'Role.Arn\')");
    _builder.newLine();
    _builder.append("fi");
    _builder.newLine();
    _builder.newLine();
    _builder.append("echo \"role lambda-sqs-execution created at ARN \"$role_arn");
    _builder.newLine();
    _builder.newLine();
    _builder.append("aws iam put-role-policy --role-name lambda-sqs-execution --policy-name lambda-sqs-policy --policy-document file://policyDocument.json");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    _builder.append("echo \"Installing requirements\"");
    _builder.newLine();
    _builder.newLine();
    _builder.append("virtualenv venv -p ");
    _builder.append(this.language);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("source venv/bin/activate");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    _builder.append("echo \"Checking wheter pip3 is installed\"");
    _builder.newLine();
    _builder.append("which pip3");
    _builder.newLine();
    _builder.append("if [ $? -eq 0 ]; then");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("echo \"pip3 is installed, continuing...\"");
    _builder.newLine();
    _builder.append("else");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("echo \"You need to install pip3. Google \'pip3 install\'\"");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("exit 1");
    _builder.newLine();
    _builder.append("fi");
    _builder.newLine();
    _builder.newLine();
    _builder.append("PIPVER=\"$(pip3 -V | grep -Eo \"(\\d+\\.)+\\d+\" | grep -Eo \"\\d+\" | head -1)\"");
    _builder.newLine();
    _builder.append("if [ ${PIPVER} -lt 19 ]; then");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("echo \"pip version is too old. installing new one\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("curl https://bootstrap.pypa.io/get-pip.py -o get-pip.py");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("python get-pip.py");
    _builder.newLine();
    _builder.append("fi");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    _builder.append("pip3 install boto3");
    _builder.newLine();
    _builder.append("if [ $? -eq 0 ]; then");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("echo \"...\"");
    _builder.newLine();
    _builder.append("else");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("echo \"pip install boto3 failed\"");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("exit 1");
    _builder.newLine();
    _builder.append("fi");
    _builder.newLine();
    _builder.newLine();
    _builder.append("pip3 install pytz");
    _builder.newLine();
    _builder.append("if [ $? -eq 0 ]; then");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("echo \"...\"");
    _builder.newLine();
    _builder.append("else");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("echo \"pip install pytz failed\"");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("exit 1");
    _builder.newLine();
    _builder.append("fi");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    _builder.append("pip3 install ortools");
    _builder.newLine();
    _builder.append("if [ $? -eq 0 ]; then");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("echo \"...\"");
    _builder.newLine();
    _builder.append("else");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("echo \"pip install ortools failed\"");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("exit 1");
    _builder.newLine();
    _builder.append("fi");
    _builder.newLine();
    _builder.newLine();
    _builder.append("if [[ -s requirements.txt ]]; then echo \"dependencies installed\"; else pip3 install -r requirements.txt; fi");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("echo \"\"");
    _builder.newLine();
    _builder.append("echo \"add precompliled libraries\"");
    _builder.newLine();
    _builder.newLine();
    _builder.append("cd venv/lib/python3.6/site-packages/");
    _builder.newLine();
    _builder.append("echo \"installing ortools\"");
    _builder.newLine();
    _builder.append("rm -rf ortools*");
    _builder.newLine();
    _builder.append("wget https://files.pythonhosted.org/packages/64/13/8c8d0fe23da0767ec0f8d00ad14619a20bc6d55ca49a3bd13700e629a1be/ortools-6.10.6025-cp36-cp36m-manylinux1\\_x86\\_64.whl");
    _builder.newLine();
    _builder.append("unzip ortools-6.10.6025-cp36-cp36m-manylinux1\\_x86\\_64.whl");
    _builder.newLine();
    _builder.append("rm ortools-6.10.6025-cp36-cp36m-manylinux1\\_x86\\_64.whl");
    _builder.newLine();
    _builder.append("echo \"ortools installed\"");
    _builder.newLine();
    _builder.newLine();
    _builder.append("echo \"installing pandas\"");
    _builder.newLine();
    _builder.append("wget https://files.pythonhosted.org/packages/f9/e1/4a63ed31e1b1362d40ce845a5735c717a959bda992669468dae3420af2cd/pandas-0.24.0-cp36-cp36m-manylinux1\\_x86\\_64.whl");
    _builder.newLine();
    _builder.append("unzip pandas-0.24.0-cp36-cp36m-manylinux1\\_x86\\_64.whl");
    _builder.newLine();
    _builder.append("rm pandas-0.24.0-cp36-cp36m-manylinux1\\_x86\\_64.whl ");
    _builder.newLine();
    _builder.append("echo \"pandas installed\"");
    _builder.newLine();
    _builder.newLine();
    _builder.append("echo \"installing numpy\"");
    _builder.newLine();
    _builder.append("wget https://files.pythonhosted.org/packages/7b/74/54c5f9bb9bd4dae27a61ec1b39076a39d359b3fb7ba15da79ef23858a9d8/numpy-1.16.0-cp36-cp36m-manylinux1\\_x86\\_64.whl");
    _builder.newLine();
    _builder.append("unzip numpy-1.16.0-cp36-cp36m-manylinux1\\_x86\\_64.whl");
    _builder.newLine();
    _builder.append("rm numpy-1.16.0-cp36-cp36m-manylinux1\\_x86\\_64.whl");
    _builder.newLine();
    _builder.append("echo \"numpy installed\"");
    _builder.newLine();
    _builder.newLine();
    _builder.append("echo \"creating zip package\"");
    _builder.newLine();
    _builder.append("zip -q -r9 ../../../../${id}\\_lambda.zip .");
    _builder.newLine();
    _builder.append("echo \"zip created\"");
    _builder.newLine();
    _builder.newLine();
    _builder.append("cd ../../../../");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    _builder.append("echo \"");
    CharSequence _generateBodyPy = this.generateBodyPy(this.root.getBody(), this.root.getParameters(), name, this.env, local);
    _builder.append(_generateBodyPy);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      Collection<FunctionDefinition> _values = this.functionCalled.values();
      for(final FunctionDefinition fd : _values) {
        _builder.newLine();
        String _generatePyExpression = this.generatePyExpression(fd, name, local);
        _builder.append(_generatePyExpression);
        _builder.newLineIfNotEmpty();
        _builder.newLine();
      }
    }
    _builder.append("\" > ${function}.py");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    _builder.append("zip -g ${id}_lambda.zip ${function}.py");
    _builder.newLine();
    _builder.newLine();
    _builder.append("deactivate");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("#create the lambda function");
    _builder.newLine();
    _builder.append("echo \"creation of the lambda function\"");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    _builder.append("echo \"zip file too big, uploading it using s3\"");
    _builder.newLine();
    _builder.append("echo \"creating bucket for s3\"");
    _builder.newLine();
    _builder.append("aws s3 mb s3://${function}${id}bucket");
    _builder.newLine();
    _builder.append("echo \"s3 bucket created. uploading file\"");
    _builder.newLine();
    _builder.append("aws s3 cp ${id}_lambda.zip s3://${function}${id}bucket --grants read=uri=http://acs.amazonaws.com/groups/global/AllUsers");
    _builder.newLine();
    _builder.append("echo \"file uploaded, creating function\"");
    _builder.newLine();
    _builder.append("aws lambda create-function --function-name ${function}_${id} --code S3Bucket=\"\"${function}\"\"${id}\"bucket\",S3Key=\"\"${id}\"_lambda.zip\" --handler ${function}.handler --runtime ");
    _builder.append(this.language);
    _builder.append(" --role ${role_arn//\\\"} --memory-size 128 --timeout 300");
    _builder.newLineIfNotEmpty();
    _builder.append("echo \"lambda function created\"");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    _builder.append("# clear ");
    _builder.newLine();
    _builder.append("rm -r venv/");
    _builder.newLine();
    _builder.append("rm ${function}.py");
    _builder.newLine();
    _builder.append("rm ${id}_lambda.zip");
    _builder.newLine();
    _builder.append("rm rolePolicyDocument.json");
    _builder.newLine();
    _builder.append("rm policyDocument.json");
    _builder.newLine();
    return _builder;
  }
}
