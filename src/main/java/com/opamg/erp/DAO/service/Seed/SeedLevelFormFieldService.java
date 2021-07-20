/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.Seed;

import com.opamg.erp.beans.Seed.SeedLevelFormField;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.DAO.repo.Seed.SeedLevelFormFieldRepository;
import com.opamg.erp.beans.Seed.SeedLevelForm;

/**
 *
 * @author acer
 */
@Service
public class SeedLevelFormFieldService {

   @Autowired
   SeedLevelFormFieldRepository repository;

   public SeedLevelFormFieldRepository getRepository() {
      return repository;
   }

   public void insert(SeedLevelFormField levelFormField) {
      repository.save(levelFormField);
   }

   public List findAll() {
      return repository.findAll();
   }

   public List findByLevelForm(SeedLevelForm springLevelForm) {
      return repository.findByLevelForm(springLevelForm);
   }


}
