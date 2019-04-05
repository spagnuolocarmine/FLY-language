//package org.xtext.typing
//
//import org.xtext.fLY.ArithmeticExpression
//import org.xtext.fLY.StringLiteral
//import org.xtext.fLY.NumberLiteral
//import org.xtext.fLY.BooleanLiteral
//import org.xtext.fLY.FloatLiteral
//import org.xtext.fLY.NameObject
//import org.xtext.fLY.NameObjectDef
//import org.xtext.fLY.DatSingleObject
//import org.xtext.fLY.DatTableObject
//import org.xtext.fLY.VariableLiteral
//import org.xtext.fLY.VariableDeclaration
//import org.xtext.fLY.CastExpression
//import org.xtext.fLY.BinaryOperation
//import org.xtext.fLY.ParenthesizedExpression
//import org.xtext.fLY.UnaryOperation
//import org.xtext.fLY.PostfixOperation
//import org.xtext.fLY.IndexObject
//
//class FlyTypeProvider {
//	public static val stringType = new StringType
//	public static val intType = new NumericalType
//	public static val boolType = new BooleanType
//	public static val floatType = new FloatType
//	public static val datType = new DatType
//	public static val objectType = new ObjectType
//
//	def dispatch typeFor(ArithmeticExpression e) {
//		switch (e) {
//			StringLiteral: stringType
//			NumberLiteral: intType
//			BooleanLiteral: boolType
//			FloatLiteral: floatType
//			NameObject: objectType
//			NameObjectDef: objectType
//			IndexObject: objectType
//			DatSingleObject: objectType
//			DatTableObject: datType
//			default: null
//		}
//	}
//
//	def dispatch typeFor(VariableLiteral e) {
//		if (e.variable == null)
//			return intType
//		else
//			e.variable.typeFor
//	}
//
//	def dispatch typeFor(VariableDeclaration e) {
//		if (e.right != null)
//			return e.right.typeFor
//		else
//			return objectType
//	}
//
//	def dispatch typeFor(CastExpression e) {
//		if (e.type == 'String' || e.type == 'Date')
//			return stringType
//		else if (e.type == 'Integer')
//			return intType
//		else if (e.type == 'Float')
//			return floatType
//		else if (e.type == 'Dat')
//			return datType
//	}
//
//	def dispatch typeFor(BinaryOperation e) {
//		var leftType = e.left.typeFor
//		var rightType = e.right.typeFor
//		var op = e.feature
//		if (op == '+') {
//			if (leftType == stringType || rightType == stringType) {
//				return stringType
//			} else if (leftType == stringType || rightType == stringType) {
//				return floatType
//			} else {
//				return intType
//			}
//		} else if (op == '-' || op == '*' || op == '/') {
//			if (leftType == stringType || rightType == stringType) {
//				return floatType
//			} else {
//				return intType
//			}
//		}
//		return boolType
//	}
//
////	def dispatch typeFor(Assignment e){
////		return e.value.typeFor
////	}
//	def dispatch typeFor(ParenthesizedExpression e) {
//		return e.expression.typeFor
//	}
//
//	def dispatch typeFor(UnaryOperation e) {
//		val op = e.feature
//		if (op == '!')
//			return boolType
//		else {
//			return e.operand.typeFor
//		}
//	}
//
//	def dispatch typeFor(PostfixOperation e) {
//		return e.variable.typeFor
//	}
//}