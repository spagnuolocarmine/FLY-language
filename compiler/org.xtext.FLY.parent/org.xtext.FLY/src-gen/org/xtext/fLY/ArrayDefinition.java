/**
 * generated by Xtext 2.16.0
 */
package org.xtext.fLY;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Array Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.fLY.ArrayDefinition#getType <em>Type</em>}</li>
 *   <li>{@link org.xtext.fLY.ArrayDefinition#getIndexes <em>Indexes</em>}</li>
 * </ul>
 *
 * @see org.xtext.fLY.FLYPackage#getArrayDefinition()
 * @model
 * @generated
 */
public interface ArrayDefinition extends org.xtext.fLY.Object
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' attribute.
   * @see #setType(String)
   * @see org.xtext.fLY.FLYPackage#getArrayDefinition_Type()
   * @model
   * @generated
   */
  String getType();

  /**
   * Sets the value of the '{@link org.xtext.fLY.ArrayDefinition#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see #getType()
   * @generated
   */
  void setType(String value);

  /**
   * Returns the value of the '<em><b>Indexes</b></em>' containment reference list.
   * The list contents are of type {@link org.xtext.fLY.Index}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Indexes</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Indexes</em>' containment reference list.
   * @see org.xtext.fLY.FLYPackage#getArrayDefinition_Indexes()
   * @model containment="true"
   * @generated
   */
  EList<Index> getIndexes();

} // ArrayDefinition
