/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.Root.SubRoot;

import com.opamg.erp.DAO.repo.Root.SubRoot.SubRootMainRepository;
import com.opamg.erp.beans.Root.RootLevelForm;
import com.opamg.erp.beans.Root.SubRoot.SubRootMain;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author acer
 */
@Service
public class SubRootMainService {

   @Autowired
   SubRootMainRepository mainRepository;

   public SubRootMainRepository getMainRepository() {
      return mainRepository;
   }

   public SubRootMain insertMain(SubRootMain chart) {
      return mainRepository.save(chart);
   }

   public SubRootMain findById(Long id) {
      return mainRepository.findById(id).get();
   }

   public List findAllByRootLevelForm(RootLevelForm rootLevelForm) {
      return mainRepository.findByRootLevelForm(rootLevelForm);
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
