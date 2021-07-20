/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.Fruit;

import com.opamg.erp.beans.Fruit.FruitLevelForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.DAO.repo.Fruit.FruitLevelFormRepository;
import com.opamg.erp.beans.Fruit.FruitLevel;
import java.util.List;

/**
 *
 * @author acer
 */
@Service
public class FruitLevelFormService {

   @Autowired
   FruitLevelFormRepository repository;

   public FruitLevelFormRepository getRepository() {
      return repository;
   }

   public List findByLevel(FruitLevel level) {
      return repository.findByLevel(level);
   }

   public void insert(FruitLevelForm form) {
      repository.save(form);
   }

   public FruitLevelForm findById(Long id) {
      return repository.findById(id).get();
   }

}
