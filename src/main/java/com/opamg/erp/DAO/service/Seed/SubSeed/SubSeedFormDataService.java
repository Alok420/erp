/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.Seed.SubSeed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.beans.Seed.SubSeed.SubSeedFormData;
import com.opamg.erp.DAO.repo.Seed.SubSeed.SubSeedFormDataRepository;

/**
 *
 * @author acer
 */
@Service
public class SubSeedFormDataService {

  @Autowired
   SubSeedFormDataRepository repository;

   public SubSeedFormDataRepository getRepository() {
    return repository;
  }

  public void insert(SubSeedFormData form) {
    repository.save(form);
  }

}
