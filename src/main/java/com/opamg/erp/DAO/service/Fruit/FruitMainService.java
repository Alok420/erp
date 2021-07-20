/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.Fruit;

import com.opamg.erp.beans.Fruit.FruitMain;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.DAO.repo.Fruit.FruitMainRepository;

/**
 *
 * @author acer
 */
@Service
public class FruitMainService {

  @Autowired
   FruitMainRepository mainRepository;


   public FruitMainRepository getMainRepository() {
    return mainRepository;
  }
   public FruitMain insertMain(FruitMain chart) {
    return mainRepository.save(chart);
  }
   public FruitMain findById(Long id) {
    return mainRepository.findById(id).get();
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
