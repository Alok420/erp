/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.beans.MyBranch.SubMyBranch;

import com.opamg.erp.beans.MyBranch.MyBranchFormData;
import com.opamg.erp.beans.MyBranch.MyBranchLevelForm;
import javax.persistence.CascadeType;
import javax.persistence.Column;
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
public class SubMyBranchMain {

   @GeneratedValue(strategy = GenerationType.AUTO)
   @Id
   private long id;

   @Column(unique = true)
   private String name;

   @ManyToOne(cascade = CascadeType.DETACH)
   private MyBranchLevelForm PLevelForm;

   public SubMyBranchMain() {
   }

   public SubMyBranchMain(String name) {
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

   public MyBranchLevelForm getPLevelForm() {
      return PLevelForm;
   }

   public void setPLevelForm(MyBranchLevelForm PLevelForm) {
      this.PLevelForm = PLevelForm;
   }

  







}
