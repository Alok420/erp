/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.Trunk.SubTrunk;

import com.opamg.erp.DAO.repo.Trunk.SubTrunk.SubTrunkMainRepository;
import com.opamg.erp.beans.Trunk.TrunkLevelForm;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.beans.Trunk.SubTrunk.SubTrunkMain;

/**
 *
 * @author acer
 */
@Service
public class SubTrunkMainService {

   @Autowired
   SubTrunkMainRepository mainRepository;

   public SubTrunkMainRepository getMainRepository() {
      return mainRepository;
   }

   public SubTrunkMain insertMain(SubTrunkMain chart) {
      return mainRepository.save(chart);
   }

   public SubTrunkMain findById(Long id) {
      return mainRepository.findById(id).get();
   }

   public List findAllByTrunkLevelForm(TrunkLevelForm seedLevelForm) {
      return mainRepository.findByPLevelForm(seedLevelForm);
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
