/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.Seed;

import com.opamg.erp.beans.Seed.SeedMain;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.DAO.repo.Seed.SeedMainRepository;

/**
 *
 * @author acer
 */
@Service
public class SeedMainService {

  @Autowired
  SeedMainRepository mainRepository;

  
  public SeedMainRepository getMainRepository() {
    return mainRepository;
  }
  public SeedMain insertMain(SeedMain chart) {
    return mainRepository.save(chart);
  }
  public SeedMain findById(Long id) {
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
