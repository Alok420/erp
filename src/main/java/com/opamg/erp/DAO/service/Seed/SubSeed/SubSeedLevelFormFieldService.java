/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.Seed.SubSeed;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.beans.Seed.SubSeed.SubSeedLevelFormField;
import com.opamg.erp.DAO.repo.Seed.SubSeed.SubSeedLevelFormFieldRepository;
import com.opamg.erp.beans.Seed.SubSeed.SubSeedLevelForm;

/**
 *
 * @author acer
 */
@Service
public class SubSeedLevelFormFieldService {

  @Autowired
   SubSeedLevelFormFieldRepository repository;

   public SubSeedLevelFormFieldRepository getRepository() {
    return repository;
  }

  public void insert(SubSeedLevelFormField levelFormField) {
    repository.save(levelFormField);
  }
  public List findAll(){
    return repository.findAll();
  }
   public List findByLevelForm(SubSeedLevelForm subspringLevelForm) {
      return repository.findByLevelForm(subspringLevelForm);
   }
}
