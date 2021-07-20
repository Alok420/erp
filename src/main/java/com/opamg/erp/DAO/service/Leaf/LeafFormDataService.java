/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.Leaf;

import com.opamg.erp.beans.Leaf.LeafFormData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.DAO.repo.Leaf.LeafFormDataRepository;

/**
 *
 * @author acer
 */
@Service
public class LeafFormDataService {

  @Autowired
  LeafFormDataRepository repository;

  public LeafFormDataRepository getRepository() {
    return repository;
  }
   public void insert(LeafFormData form) {
    repository.save(form);
  }

}
