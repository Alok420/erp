/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.Sprig;

import com.opamg.erp.beans.Sprig.SprigMain;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.DAO.repo.Sprig.SprigMainRepository;

/**
 *
 * @author acer
 */
@Service
public class SprigMainService {

  @Autowired
  SprigMainRepository mainRepository;

  
  public SprigMainRepository getMainRepository() {
    return mainRepository;
  }
  public SprigMain insertMain(SprigMain chart) {
    return mainRepository.save(chart);
  }
  public SprigMain findById(Long id) {
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
