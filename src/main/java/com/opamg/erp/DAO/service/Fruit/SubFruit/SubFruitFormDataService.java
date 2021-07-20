/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.Fruit.SubFruit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.beans.Fruit.SubFruit.SubFruitFormData;
import com.opamg.erp.DAO.repo.Fruit.SubFruit.SubFruitFormDataRepository;

/**
 *
 * @author acer
 */
@Service
public class SubFruitFormDataService {

  @Autowired
   SubFruitFormDataRepository repository;

   public SubFruitFormDataRepository getRepository() {
    return repository;
  }

   public void insert(SubFruitFormData form) {
    repository.save(form);
  }

}
