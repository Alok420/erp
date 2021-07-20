/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.beans.Flower;

import com.opamg.erp.beans.Root.*;
import com.opamg.erp.beans.Root.RootLevelForm;
import java.util.LinkedHashMap;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;

/**
 *
 * @author acer
 */
@Entity
public class FlowerFormData {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  private long id;

  @ManyToOne
  private FlowerLevelForm levelForm;

  @Column(columnDefinition = "TEXT")
  private String jsonvalue;

  public FlowerFormData() {
  }

  public FlowerFormData(FlowerLevelForm levelForm, String jsonvalue) {
    this.levelForm = levelForm;
    this.jsonvalue = jsonvalue;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public FlowerLevelForm getLevelForm() {
    return levelForm;
  }

  public void setLevelForm(FlowerLevelForm levelForm) {
    this.levelForm = levelForm;
  }

  public String getJsonvalue() {
    return jsonvalue;
  }

  public void setJsonvalue(String jsonvalue) {
    this.jsonvalue = jsonvalue;
  }


  public LinkedHashMap stringTOJson(String str) {

//    str = str.replace("\"", "\\\"");
    Object object;
    try {
      LinkedHashMap hashMap = (LinkedHashMap) new JSONParser(str).parse();
      return hashMap;
    } catch (ParseException ex) {
      ex.printStackTrace();
    }
    return null;
  }

}
