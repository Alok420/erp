/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.Seed;

import com.opamg.erp.beans.Seed.SeedLevelForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.DAO.repo.Seed.SeedLevelFormRepository;
import com.opamg.erp.beans.Seed.SeedLevel;
import java.util.List;

/**
 *
 * @author acer
 */
@Service
public class SeedLevelFormService {

   @Autowired
   SeedLevelFormRepository repository;

   public SeedLevelFormRepository getRepository() {
      return repository;
   }

   public List findByLevel(SeedLevel level) {
      return repository.findByLevel(level);
   }

   public void insert(SeedLevelForm form) {
      repository.save(form);
   }

   public SeedLevelForm findById(Long id) {
      return repository.findById(id).get();
   }

}
