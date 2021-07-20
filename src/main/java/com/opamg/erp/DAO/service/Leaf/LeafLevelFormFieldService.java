/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.Leaf;

import com.opamg.erp.beans.Leaf.LeafLevelFormField;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.DAO.repo.Leaf.LeafLevelFormFieldRepository;
import com.opamg.erp.beans.Leaf.LeafLevelForm;

/**
 *
 * @author acer
 */
@Service
public class LeafLevelFormFieldService {

  @Autowired
  LeafLevelFormFieldRepository repository;

  public LeafLevelFormFieldRepository getRepository() {
    return repository;
  }

  public void insert(LeafLevelFormField levelFormField) {
    repository.save(levelFormField);
  }
  public List findAll(){
    return repository.findAll();
  }
   public List findByLevelForm(LeafLevelForm LevelForm) {
      return repository.findByLevelForm(LevelForm);
   }

}
