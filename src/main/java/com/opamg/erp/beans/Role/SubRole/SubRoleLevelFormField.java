/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.beans.Role.SubRole;

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
public class SubRoleLevelFormField {

   @GeneratedValue(strategy = GenerationType.AUTO)
   @Id
   private long id;

   @ManyToOne(cascade = CascadeType.DETACH)
   private SubRoleLevelForm levelForm;
   private String type;
   private String placeholder;
   private String field_position;
   private String name;
   private String default_value_type; //values in (user/fixed_data/select_parent)
   private String default_value;

   public SubRoleLevelFormField() {
   }

   public SubRoleLevelFormField(SubRoleLevelForm levelForm, String type) {
      this.levelForm = levelForm;
      this.type = type;
   }

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public SubRoleLevelForm getLevelForm() {
      return levelForm;
   }

   public void setLevelForm(SubRoleLevelForm levelForm) {
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

   public String getDefault_value_type() {
      return default_value_type;
   }

   public void setDefault_value_type(String default_value_type) {
      this.default_value_type = default_value_type;
   }

   public String getDefault_value() {
      return default_value;
   }

   public void setDefault_value(String default_value) {
      this.default_value = default_value;
   }

}
