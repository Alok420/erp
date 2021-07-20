/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.Fruit;

import com.opamg.erp.beans.Fruit.FruitFormData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.DAO.repo.Fruit.FruitFormDataRepository;
import com.opamg.erp.beans.Fruit.FruitLevelForm;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author acer
 */
@Service
public class FruitFormDataService {

   @Autowired
   FruitFormDataRepository repository;

   public FruitFormDataRepository getRepository() {
      return repository;
   }

   public void insert(FruitFormData form) {
      repository.save(form);
   }

   public List<FruitFormData> findByLevelForm(FruitLevelForm levelForm) {
      return repository.findByLevelForm(levelForm);
   }
   public List findByFormDataId(long id) {
      return repository.findByFormDataId(id);
   }


   public List allGroupByLevel(FruitLevelForm fruitLevelForm) {
      List<Object[]> allObjects = repository.allGroupByLevel(fruitLevelForm.getId());
      return allObjects;
   }

   public List allGroupByLevel(long id, int year) {
      List<Object[]> allObjects = repository.allGroupByLevel(id, year);
      return allObjects;
   }

   public List allGroupByMonth(int month) {
      List<Object[]> allObjects = repository.allGroupByMonth(month);
      return allObjects;
   }

   public List allGroupByMonth(long id, int year) {
      List<Object[]> allObjects = repository.allGroupByMonth(id, year);
      return allObjects;
   }
}
