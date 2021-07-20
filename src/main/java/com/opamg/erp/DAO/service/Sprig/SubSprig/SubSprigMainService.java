/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.Sprig.SubSprig;

import com.opamg.erp.DAO.repo.Sprig.SubSprig.SubSprigMainRepository;
import com.opamg.erp.beans.Sprig.SprigLevelForm;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.beans.Sprig.SubSprig.SubSprigMain;

/**
 *
 * @author acer
 */
@Service
public class SubSprigMainService {

   @Autowired
   SubSprigMainRepository mainRepository;

   public SubSprigMainRepository getMainRepository() {
      return mainRepository;
   }

   public SubSprigMain insertMain(SubSprigMain chart) {
      return mainRepository.save(chart);
   }

   public SubSprigMain findById(Long id) {
      return mainRepository.findById(id).get();
   }

   public List findAllBySprigLevelForm(SprigLevelForm sprigLevelForm) {
      return mainRepository.findByPLevelForm(sprigLevelForm);
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
