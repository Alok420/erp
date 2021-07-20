/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.Fruit;

import com.opamg.erp.beans.Fruit.FruitLevel;
import com.opamg.erp.beans.Fruit.FruitMain;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.DAO.repo.Fruit.FruitLevelRepository;

/**
 *
 * @author acer
 */
@Service
public class FruitLevelService {

   @Autowired
   FruitLevelRepository levelRepository;
//----------------------------------------------------------level-------------------

   public FruitLevelRepository getLeveleRepository() {
      return levelRepository;
   }

   public List findAllLevel() {
      return levelRepository.findAll();
   }

   public FruitLevel findOneById(long id) {
      if (id < 1) {
	return null;
      } else {
	return levelRepository.findById(id).get();
      }
   }

   public List FindLevelByMain(FruitMain main) {
      return levelRepository.findByMain(main);
   }

   public void deleteLevel(long id) {
      levelRepository.deleteById(id);
   }

}
