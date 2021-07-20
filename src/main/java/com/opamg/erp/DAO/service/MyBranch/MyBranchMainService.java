/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.MyBranch;

import com.opamg.erp.beans.MyBranch.MyBranchMain;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.DAO.repo.MyBranch.MyBranchMainRepository;

/**
 *
 * @author acer
 */
@Service
public class MyBranchMainService {

  @Autowired
   MyBranchMainRepository mainRepository;


   public MyBranchMainRepository getMainRepository() {
    return mainRepository;
  }
   public MyBranchMain insertMain(MyBranchMain chart) {
    return mainRepository.save(chart);
  }
   public MyBranchMain findById(Long id) {
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
