/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.Leaf;

import com.opamg.erp.beans.Leaf.LeafMain;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.DAO.repo.Leaf.LeafMainRepository;

/**
 *
 * @author acer
 */
@Service
public class LeafMainService {

  @Autowired
  LeafMainRepository mainRepository;

  
  public LeafMainRepository getMainRepository() {
    return mainRepository;
  }
  public LeafMain insertMain(LeafMain chart) {
    return mainRepository.save(chart);
  }


  public boolean isMainExist(long id) {
    return mainRepository.existsById(id);
  }
  public LeafMain findById(Long id) {
    return mainRepository.findById(id).get();
  }
 public void deleteMain(long id) {
    mainRepository.deleteById(id);
  }
  public List findAllMain() {
    return mainRepository.findAll();
  }
//----------------------------------------------------------level-------------------

}
