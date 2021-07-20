/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.Fruit.SubFruit;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.beans.Fruit.SubFruit.SubFruitLevelFormField;
import com.opamg.erp.DAO.repo.Fruit.SubFruit.SubFruitLevelFormFieldRepository;
import com.opamg.erp.beans.Fruit.SubFruit.SubFruitLevelForm;

/**
 *
 * @author acer
 */
@Service
public class SubFruitLevelFormFieldService {

  @Autowired
   SubFruitLevelFormFieldRepository repository;

   public SubFruitLevelFormFieldRepository getRepository() {
    return repository;
  }

   public void insert(SubFruitLevelFormField levelFormField) {
    repository.save(levelFormField);
  }
  public List findAll(){
    return repository.findAll();
  }
   public List findByLevelForm(SubFruitLevelForm subspringLevelForm) {
      return repository.findByLevelForm(subspringLevelForm);
   }
}
