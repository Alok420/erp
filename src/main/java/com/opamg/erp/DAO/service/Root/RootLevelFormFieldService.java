/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.Root;

import com.opamg.erp.beans.Root.RootLevelFormField;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.DAO.repo.Root.RootLevelFormFieldRepository;
import com.opamg.erp.beans.Root.RootLevelForm;

/**
 *
 * @author acer
 */
@Service
public class RootLevelFormFieldService {

  @Autowired
   RootLevelFormFieldRepository repository;

   public RootLevelFormFieldRepository getRepository() {
    return repository;
  }

   public void insert(RootLevelFormField levelFormField) {
    repository.save(levelFormField);
  }
  public List findAll(){
    return repository.findAll();
  }
   public List findByLevelForm(RootLevelForm LevelForm) {
      return repository.findByLevelForm(LevelForm);
   }

}
