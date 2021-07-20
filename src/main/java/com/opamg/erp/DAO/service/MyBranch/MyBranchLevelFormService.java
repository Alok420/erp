/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.MyBranch;

import com.opamg.erp.beans.MyBranch.MyBranchLevelForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.DAO.repo.MyBranch.MyBranchLevelFormRepository;
import com.opamg.erp.beans.MyBranch.MyBranchLevel;
import java.util.List;

/**
 *
 * @author acer
 */
@Service
public class MyBranchLevelFormService {

   @Autowired
   MyBranchLevelFormRepository repository;

   public MyBranchLevelFormRepository getRepository() {
      return repository;
   }

   public List findByLevel(MyBranchLevel level) {
      return repository.findByLevel(level);
   }

   public void insert(MyBranchLevelForm form) {
      repository.save(form);
   }

   public MyBranchLevelForm findById(Long id) {
      return repository.findById(id).get();
   }

}
