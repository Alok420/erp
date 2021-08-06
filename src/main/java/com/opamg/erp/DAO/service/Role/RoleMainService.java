/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.Role;

import com.opamg.erp.beans.Role.RoleMain;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.DAO.repo.Role.RoleMainRepository;

/**
 *
 * @author acer
 */
@Service
public class RoleMainService {

  @Autowired
  RoleMainRepository mainRepository;

  
  public RoleMainRepository getMainRepository() {
    return mainRepository;
  }
  public RoleMain insertMain(RoleMain chart) {
    return mainRepository.save(chart);
  }
  public RoleMain findById(Long id) {
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
