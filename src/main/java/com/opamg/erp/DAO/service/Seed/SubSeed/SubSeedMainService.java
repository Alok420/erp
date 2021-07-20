/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.Seed.SubSeed;

import com.opamg.erp.DAO.repo.Seed.SubSeed.SubSeedMainRepository;
import com.opamg.erp.beans.Seed.SeedLevelForm;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.beans.Seed.SubSeed.SubSeedMain;

/**
 *
 * @author acer
 */
@Service
public class SubSeedMainService {

   @Autowired
   SubSeedMainRepository mainRepository;

   public SubSeedMainRepository getMainRepository() {
      return mainRepository;
   }

   public SubSeedMain insertMain(SubSeedMain chart) {
      return mainRepository.save(chart);
   }

   public SubSeedMain findById(Long id) {
      return mainRepository.findById(id).get();
   }

   public List findAllBySeedLevelForm(SeedLevelForm seedLevelForm) {
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
