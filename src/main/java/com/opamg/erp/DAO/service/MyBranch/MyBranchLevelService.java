/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.MyBranch;

import com.opamg.erp.beans.MyBranch.MyBranchLevel;
import com.opamg.erp.beans.MyBranch.MyBranchMain;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.DAO.repo.MyBranch.MyBranchLevelRepository;

/**
 *
 * @author acer
 */
@Service
public class MyBranchLevelService {

   @Autowired
   MyBranchLevelRepository levelRepository;
//----------------------------------------------------------level-------------------

   public MyBranchLevelRepository getLeveleRepository() {
      return levelRepository;
   }

   public List findAllLevel() {
      return levelRepository.findAll();
   }

   public MyBranchLevel findOneById(long id) {
      if (id < 1) {
	return null;
      } else {
	return levelRepository.findById(id).get();
      }
   }

   public List FindLevelByMain(MyBranchMain main) {
      return levelRepository.findByMain(main);
   }

   public void deleteLevel(long id) {
      levelRepository.deleteById(id);
   }

}
