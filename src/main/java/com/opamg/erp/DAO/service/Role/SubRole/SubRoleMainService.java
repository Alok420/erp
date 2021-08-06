/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.Role.SubRole;

import com.opamg.erp.DAO.repo.Role.SubRole.SubRoleMainRepository;
import com.opamg.erp.beans.Role.RoleLevelForm;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.beans.Role.SubRole.SubRoleMain;

/**
 *
 * @author acer
 */
@Service
public class SubRoleMainService {

   @Autowired
   SubRoleMainRepository mainRepository;

   public SubRoleMainRepository getMainRepository() {
      return mainRepository;
   }

   public SubRoleMain insertMain(SubRoleMain chart) {
      return mainRepository.save(chart);
   }

   public SubRoleMain findById(Long id) {
      return mainRepository.findById(id).get();
   }

   public List findAllByRoleLevelForm(RoleLevelForm seedLevelForm) {
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
