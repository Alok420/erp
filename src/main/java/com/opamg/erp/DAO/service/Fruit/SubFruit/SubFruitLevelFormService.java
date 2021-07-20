/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.Fruit.SubFruit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.beans.Fruit.SubFruit.SubFruitLevel;
import com.opamg.erp.beans.Fruit.SubFruit.SubFruitLevelForm;
import java.util.List;
import com.opamg.erp.DAO.repo.Fruit.SubFruit.SubFruitLevelFormRepository;

/**
 *
 * @author acer
 */
@Service
public class SubFruitLevelFormService {

  @Autowired
   SubFruitLevelFormRepository repository;

   public SubFruitLevelFormRepository getRepository() {
    return repository;
  }
   public List findByLevel(SubFruitLevel level) {
    return repository.findByLevel(level);
  }
   public void insert(SubFruitLevelForm form) {
    repository.save(form);
  }
   public SubFruitLevelForm findById(Long id) {
      return repository.findById(id).get();
   }
}
