/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.beans.MyBranch;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MyBranchMain {

  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  private long id;

  @Column(unique = true)
  private String name;

   public MyBranchMain() {
  }

   public MyBranchMain(String name) {
    this.name = name;

  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "RootChart{" + "id=" + id + ", name=" + name + '}';
  }

}
