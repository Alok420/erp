/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.Root;

import com.opamg.erp.DAO.service.Root.*;
import com.opamg.erp.beans.Root.RootMain;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.DAO.repo.Root.RootMainRepository;

/**
 *
 * @author acer
 */
@Service
public class RootMainService {

   @Autowired
   RootMainRepository mainRepository;

   public RootMainRepository getMainRepository() {
      return mainRepository;
   }

   public RootMain insertMain(RootMain chart) {
      return mainRepository.save(chart);
   }

   public RootMain findById(Long id) {
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
