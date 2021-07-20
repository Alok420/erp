/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.beans.Flower;

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
public class FlowerLevelForm {

  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  private long id;
  private String action;
  @ManyToOne(cascade = CascadeType.DETACH)
  private FlowerLevel level;
  private String method;

  public FlowerLevelForm() {
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getAction() {
    return action;
  }

  public void setAction(String action) {
    this.action = action;
  }

  public FlowerLevel getLevel() {
    return level;
  }

  public void setLevel(FlowerLevel level) {
    this.level = level;
  }

  public String getMethod() {
    return method;
  }

  public void setMethod(String method) {
    this.method = method;
  }


}
