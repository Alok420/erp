/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.Trunk.SubTrunk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.beans.Trunk.SubTrunk.SubTrunkFormData;
import com.opamg.erp.DAO.repo.Trunk.SubTrunk.SubTrunkFormDataRepository;

/**
 *
 * @author acer
 */
@Service
public class SubTrunkFormDataService {

  @Autowired
   SubTrunkFormDataRepository repository;

   public SubTrunkFormDataRepository getRepository() {
    return repository;
  }

  public void insert(SubTrunkFormData form) {
    repository.save(form);
  }

}
