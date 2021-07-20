/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.Flower;

import com.opamg.erp.beans.Flower.FlowerFormData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.DAO.repo.Flower.FlowerFormDataRepository;

/**
 *
 * @author acer
 */
@Service
public class FlowerFormDataService {

  @Autowired
  FlowerFormDataRepository repository;

  public FlowerFormDataRepository getRepository() {
    return repository;
  }

  public void insert(FlowerFormData form) {
    repository.save(form);
    
  }

}
