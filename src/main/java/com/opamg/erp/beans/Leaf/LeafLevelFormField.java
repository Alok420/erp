/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.beans.Leaf;

import com.opamg.erp.beans.Flower.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author acer
 */
@Entity
public class LeafLevelFormField {

  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  private long id;

  @ManyToOne(cascade = CascadeType.DETACH)
  private LeafLevelForm levelForm;
  private String type;
  private String placeholder;
  private String field_position;
  private String name;

  public LeafLevelFormField() {
  }

  public LeafLevelFormField(LeafLevelForm levelForm, String type) {
    this.levelForm = levelForm;
    this.type = type;
  }



  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public LeafLevelForm getLevelForm() {
    return levelForm;
  }

  public void setLevelForm(LeafLevelForm levelForm) {
    this.levelForm = levelForm;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getPlaceholder() {
    return placeholder;
  }

  public void setPlaceholder(String placeholder) {
    this.placeholder = placeholder;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getField_position() {
    return field_position;
  }

  public void setField_position(String field_position) {
    this.field_position = field_position;
  }

}
