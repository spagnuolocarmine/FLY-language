package org.xtext.typing;

import com.google.common.base.Objects;
import java.util.Arrays;
import org.eclipse.emf.ecore.EObject;
import org.xtext.fLY.ArithmeticExpression;
import org.xtext.fLY.BinaryOperation;
import org.xtext.fLY.BooleanLiteral;
import org.xtext.fLY.CastExpression;
import org.xtext.fLY.DatSingleObject;
import org.xtext.fLY.DatTableObject;
import org.xtext.fLY.FloatLiteral;
import org.xtext.fLY.IndexObject;
import org.xtext.fLY.NameObject;
import org.xtext.fLY.NameObjectDef;
import org.xtext.fLY.NumberLiteral;
import org.xtext.fLY.ParenthesizedExpression;
import org.xtext.fLY.PostfixOperation;
import org.xtext.fLY.StringLiteral;
import org.xtext.fLY.UnaryOperation;
import org.xtext.fLY.VariableDeclaration;
import org.xtext.fLY.VariableLiteral;
import org.xtext.typing.BooleanType;
import org.xtext.typing.DatType;
import org.xtext.typing.FloatType;
import org.xtext.typing.FlyType;
import org.xtext.typing.NumericalType;
import org.xtext.typing.ObjectType;
import org.xtext.typing.StringType;

@SuppressWarnings("all")
public class FlyTypeProvider {
  public final static StringType stringType = new StringType();
  
  public final static NumericalType intType = new NumericalType();
  
  public final static BooleanType boolType = new BooleanType();
  
  public final static FloatType floatType = new FloatType();
  
  public final static DatType datType = new DatType();
  
  public final static ObjectType objectType = new ObjectType();
  
  protected Object _typeFor(final ArithmeticExpression e) {
    FlyType _switchResult = null;
    boolean _matched = false;
    if (e instanceof StringLiteral) {
      _matched=true;
      _switchResult = FlyTypeProvider.stringType;
    }
    if (!_matched) {
      if (e instanceof NumberLiteral) {
        _matched=true;
        _switchResult = FlyTypeProvider.intType;
      }
    }
    if (!_matched) {
      if (e instanceof BooleanLiteral) {
        _matched=true;
        _switchResult = FlyTypeProvider.boolType;
      }
    }
    if (!_matched) {
      if (e instanceof FloatLiteral) {
        _matched=true;
        _switchResult = FlyTypeProvider.floatType;
      }
    }
    if (!_matched) {
      if (e instanceof NameObject) {
        _matched=true;
        _switchResult = FlyTypeProvider.objectType;
      }
    }
    if (!_matched) {
      if (e instanceof NameObjectDef) {
        _matched=true;
        _switchResult = FlyTypeProvider.objectType;
      }
    }
    if (!_matched) {
      if (e instanceof IndexObject) {
        _matched=true;
        _switchResult = FlyTypeProvider.objectType;
      }
    }
    if (!_matched) {
      if (e instanceof DatSingleObject) {
        _matched=true;
        _switchResult = FlyTypeProvider.objectType;
      }
    }
    if (!_matched) {
      if (e instanceof DatTableObject) {
        _matched=true;
        _switchResult = FlyTypeProvider.datType;
      }
    }
    if (!_matched) {
      _switchResult = null;
    }
    return _switchResult;
  }
  
  protected Object _typeFor(final VariableLiteral e) {
    Object _xifexpression = null;
    VariableDeclaration _variable = e.getVariable();
    boolean _equals = Objects.equal(_variable, null);
    if (_equals) {
      return FlyTypeProvider.intType;
    } else {
      _xifexpression = this.typeFor(e.getVariable());
    }
    return _xifexpression;
  }
  
  protected Object _typeFor(final VariableDeclaration e) {
    EObject _right = e.getRight();
    boolean _notEquals = (!Objects.equal(_right, null));
    if (_notEquals) {
      return this.typeFor(e.getRight());
    } else {
      return FlyTypeProvider.objectType;
    }
  }
  
  protected Object _typeFor(final CastExpression e) {
    if ((Objects.equal(e.getType(), "String") || Objects.equal(e.getType(), "Date"))) {
      return FlyTypeProvider.stringType;
    } else {
      String _type = e.getType();
      boolean _equals = Objects.equal(_type, "Integer");
      if (_equals) {
        return FlyTypeProvider.intType;
      } else {
        String _type_1 = e.getType();
        boolean _equals_1 = Objects.equal(_type_1, "Float");
        if (_equals_1) {
          return FlyTypeProvider.floatType;
        } else {
          String _type_2 = e.getType();
          boolean _equals_2 = Objects.equal(_type_2, "Dat");
          if (_equals_2) {
            return FlyTypeProvider.datType;
          }
        }
      }
    }
    return null;
  }
  
  protected Object _typeFor(final BinaryOperation e) {
    Object leftType = this.typeFor(e.getLeft());
    Object rightType = this.typeFor(e.getRight());
    String op = e.getFeature();
    boolean _equals = Objects.equal(op, "+");
    if (_equals) {
      if ((Objects.equal(leftType, FlyTypeProvider.stringType) || Objects.equal(rightType, FlyTypeProvider.stringType))) {
        return FlyTypeProvider.stringType;
      } else {
        if ((Objects.equal(leftType, FlyTypeProvider.stringType) || Objects.equal(rightType, FlyTypeProvider.stringType))) {
          return FlyTypeProvider.floatType;
        } else {
          return FlyTypeProvider.intType;
        }
      }
    } else {
      if (((Objects.equal(op, "-") || Objects.equal(op, "*")) || Objects.equal(op, "/"))) {
        if ((Objects.equal(leftType, FlyTypeProvider.stringType) || Objects.equal(rightType, FlyTypeProvider.stringType))) {
          return FlyTypeProvider.floatType;
        } else {
          return FlyTypeProvider.intType;
        }
      }
    }
    return FlyTypeProvider.boolType;
  }
  
  protected Object _typeFor(final ParenthesizedExpression e) {
    return this.typeFor(e.getExpression());
  }
  
  protected Object _typeFor(final UnaryOperation e) {
    final String op = e.getFeature();
    boolean _equals = Objects.equal(op, "!");
    if (_equals) {
      return FlyTypeProvider.boolType;
    } else {
      return this.typeFor(e.getOperand());
    }
  }
  
  protected Object _typeFor(final PostfixOperation e) {
    return this.typeFor(e.getOperand());
  }
  
  public Object typeFor(final EObject e) {
    if (e instanceof BinaryOperation) {
      return _typeFor((BinaryOperation)e);
    } else if (e instanceof CastExpression) {
      return _typeFor((CastExpression)e);
    } else if (e instanceof ParenthesizedExpression) {
      return _typeFor((ParenthesizedExpression)e);
    } else if (e instanceof PostfixOperation) {
      return _typeFor((PostfixOperation)e);
    } else if (e instanceof UnaryOperation) {
      return _typeFor((UnaryOperation)e);
    } else if (e instanceof VariableDeclaration) {
      return _typeFor((VariableDeclaration)e);
    } else if (e instanceof VariableLiteral) {
      return _typeFor((VariableLiteral)e);
    } else if (e instanceof ArithmeticExpression) {
      return _typeFor((ArithmeticExpression)e);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(e).toString());
    }
  }
}
