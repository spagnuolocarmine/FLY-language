/**
 * generated by Xtext 2.16.0
 */
package org.xtext.fLY;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Declaration Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.fLY.DeclarationFeature#getFeature <em>Feature</em>}</li>
 *   <li>{@link org.xtext.fLY.DeclarationFeature#getValue_f <em>Value f</em>}</li>
 *   <li>{@link org.xtext.fLY.DeclarationFeature#getValue_s <em>Value s</em>}</li>
 *   <li>{@link org.xtext.fLY.DeclarationFeature#getValue_t <em>Value t</em>}</li>
 *   <li>{@link org.xtext.fLY.DeclarationFeature#getValue_b <em>Value b</em>}</li>
 * </ul>
 *
 * @see org.xtext.fLY.FLYPackage#getDeclarationFeature()
 * @model
 * @generated
 */
public interface DeclarationFeature extends EObject
{
  /**
   * Returns the value of the '<em><b>Feature</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Feature</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Feature</em>' attribute.
   * @see #setFeature(String)
   * @see org.xtext.fLY.FLYPackage#getDeclarationFeature_Feature()
   * @model
   * @generated
   */
  String getFeature();

  /**
   * Sets the value of the '{@link org.xtext.fLY.DeclarationFeature#getFeature <em>Feature</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Feature</em>' attribute.
   * @see #getFeature()
   * @generated
   */
  void setFeature(String value);

  /**
   * Returns the value of the '<em><b>Value f</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value f</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value f</em>' attribute.
   * @see #setValue_f(String)
   * @see org.xtext.fLY.FLYPackage#getDeclarationFeature_Value_f()
   * @model
   * @generated
   */
  String getValue_f();

  /**
   * Sets the value of the '{@link org.xtext.fLY.DeclarationFeature#getValue_f <em>Value f</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value f</em>' attribute.
   * @see #getValue_f()
   * @generated
   */
  void setValue_f(String value);

  /**
   * Returns the value of the '<em><b>Value s</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value s</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value s</em>' attribute.
   * @see #setValue_s(String)
   * @see org.xtext.fLY.FLYPackage#getDeclarationFeature_Value_s()
   * @model
   * @generated
   */
  String getValue_s();

  /**
   * Sets the value of the '{@link org.xtext.fLY.DeclarationFeature#getValue_s <em>Value s</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value s</em>' attribute.
   * @see #getValue_s()
   * @generated
   */
  void setValue_s(String value);

  /**
   * Returns the value of the '<em><b>Value t</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value t</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value t</em>' attribute.
   * @see #setValue_t(int)
   * @see org.xtext.fLY.FLYPackage#getDeclarationFeature_Value_t()
   * @model
   * @generated
   */
  int getValue_t();

  /**
   * Sets the value of the '{@link org.xtext.fLY.DeclarationFeature#getValue_t <em>Value t</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value t</em>' attribute.
   * @see #getValue_t()
   * @generated
   */
  void setValue_t(int value);

  /**
   * Returns the value of the '<em><b>Value b</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value b</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value b</em>' containment reference.
   * @see #setValue_b(ArithmeticExpression)
   * @see org.xtext.fLY.FLYPackage#getDeclarationFeature_Value_b()
   * @model containment="true"
   * @generated
   */
  ArithmeticExpression getValue_b();

  /**
   * Sets the value of the '{@link org.xtext.fLY.DeclarationFeature#getValue_b <em>Value b</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value b</em>' containment reference.
   * @see #getValue_b()
   * @generated
   */
  void setValue_b(ArithmeticExpression value);

} // DeclarationFeature
