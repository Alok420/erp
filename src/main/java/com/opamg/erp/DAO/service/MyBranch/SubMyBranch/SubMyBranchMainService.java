/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.MyBranch.SubMyBranch;

import com.opamg.erp.DAO.repo.MyBranch.SubMyBranch.SubMyBranchMainRepository;
import com.opamg.erp.beans.MyBranch.MyBranchLevelForm;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.beans.MyBranch.SubMyBranch.SubMyBranchMain;

/**
 *
 * @author acer
 */
@Service
public class SubMyBranchMainService {

   @Autowired
   SubMyBranchMainRepository mainRepository;

   public SubMyBranchMainRepository getMainRepository() {
      return mainRepository;
   }

   public SubMyBranchMain insertMain(SubMyBranchMain chart) {
      return mainRepository.save(chart);
   }

   public SubMyBranchMain findById(Long id) {
      return mainRepository.findById(id).get();
   }

   public List findAllByMyBranchLevelForm(MyBranchLevelForm p_level_form) {
      return mainRepository.findByPLevelForm(p_level_form);
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
