/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.Seed.SubSeed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.beans.Seed.SubSeed.SubSeedLevel;
import com.opamg.erp.beans.Seed.SubSeed.SubSeedLevelForm;
import java.util.List;
import com.opamg.erp.DAO.repo.Seed.SubSeed.SubSeedLevelFormRepository;

/**
 *
 * @author acer
 */
@Service
public class SubSeedLevelFormService {

  @Autowired
   SubSeedLevelFormRepository repository;

   public SubSeedLevelFormRepository getRepository() {
    return repository;
  }
  public List findByLevel(SubSeedLevel level) {
    return repository.findByLevel(level);
  }
  public void insert(SubSeedLevelForm form) {
    repository.save(form);
  }
   public SubSeedLevelForm findById(Long id) {
      return repository.findById(id).get();
   }
}
