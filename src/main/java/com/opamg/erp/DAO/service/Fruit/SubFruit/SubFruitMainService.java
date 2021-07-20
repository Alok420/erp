/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.Fruit.SubFruit;

import com.opamg.erp.DAO.repo.Fruit.SubFruit.SubFruitMainRepository;
import com.opamg.erp.beans.Fruit.FruitLevelForm;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.beans.Fruit.SubFruit.SubFruitMain;

/**
 *
 * @author acer
 */
@Service
public class SubFruitMainService {

   @Autowired
   SubFruitMainRepository mainRepository;

   public SubFruitMainRepository getMainRepository() {
      return mainRepository;
   }

   public SubFruitMain insertMain(SubFruitMain chart) {
      return mainRepository.save(chart);
   }

   public SubFruitMain findById(Long id) {
      return mainRepository.findById(id).get();
   }

   public List findAllByFruitLevelForm(FruitLevelForm p_level_form) {
      return mainRepository.findByPLevelForm(p_level_form);
   }

   public void deleteMain(long id) {
      mainRepository.deleteById(id);
   }

   public boolean isMainExist(long id) {
      return mainRepository.existsById(id);
   }

   public List findAllMain() {
      return mainRepository.findAll();
   }
//----------------------------------------------------------level-------------------

}
