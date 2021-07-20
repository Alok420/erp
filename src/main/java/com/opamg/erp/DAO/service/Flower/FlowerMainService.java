/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.Flower;

import com.opamg.erp.beans.Flower.FlowerMain;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.DAO.repo.Flower.FlowerMainRepository;

/**
 *
 * @author acer
 */
@Service
public class FlowerMainService {

  @Autowired
  FlowerMainRepository mainRepository;

  
  public FlowerMainRepository getMainRepository() {
    return mainRepository;
  }
  public FlowerMain insertMain(FlowerMain chart) {
    return mainRepository.save(chart);
  }

  public FlowerMain findById(Long id) {
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
