/**
 * generated by Xtext 2.16.0
 */
package org.xtext.fLY;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Local Function Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.fLY.LocalFunctionCall#getTarget <em>Target</em>}</li>
 *   <li>{@link org.xtext.fLY.LocalFunctionCall#getInput <em>Input</em>}</li>
 * </ul>
 *
 * @see org.xtext.fLY.FLYPackage#getLocalFunctionCall()
 * @model
 * @generated
 */
public interface LocalFunctionCall extends Expression, ArithmeticExpression
{
  /**
   * Returns the value of the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Target</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target</em>' reference.
   * @see #setTarget(FunctionDefinition)
   * @see org.xtext.fLY.FLYPackage#getLocalFunctionCall_Target()
   * @model
   * @generated
   */
  FunctionDefinition getTarget();

  /**
   * Sets the value of the '{@link org.xtext.fLY.LocalFunctionCall#getTarget <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' reference.
   * @see #getTarget()
   * @generated
   */
  void setTarget(FunctionDefinition value);

  /**
   * Returns the value of the '<em><b>Input</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Input</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Input</em>' containment reference.
   * @see #setInput(LocalFunctionInput)
   * @see org.xtext.fLY.FLYPackage#getLocalFunctionCall_Input()
   * @model containment="true"
   * @generated
   */
  LocalFunctionInput getInput();

  /**
   * Sets the value of the '{@link org.xtext.fLY.LocalFunctionCall#getInput <em>Input</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Input</em>' containment reference.
   * @see #getInput()
   * @generated
   */
  void setInput(LocalFunctionInput value);

} // LocalFunctionCall