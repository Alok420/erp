/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.Flower;

import com.opamg.erp.beans.Flower.FlowerLevelFormField;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.DAO.repo.Flower.FlowerLevelFormFieldRepository;
import com.opamg.erp.beans.Flower.FlowerLevelForm;

/**
 *
 * @author acer
 */
@Service
public class FlowerLevelFormFieldService {

  @Autowired
  FlowerLevelFormFieldRepository repository;

  public FlowerLevelFormFieldRepository getRepository() {
    return repository;
  }

  public void insert(FlowerLevelFormField levelFormField) {
    repository.save(levelFormField);
  }
  public List findAll(){
    return repository.findAll();
   }

   public List findByLevelForm(FlowerLevelForm LevelForm) {
      return repository.findByLevelForm(LevelForm);
   }

}
