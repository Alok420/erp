/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.MyBranch.SubMyBranch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.beans.MyBranch.SubMyBranch.SubMyBranchLevel;
import com.opamg.erp.beans.MyBranch.SubMyBranch.SubMyBranchLevelForm;
import java.util.List;
import com.opamg.erp.DAO.repo.MyBranch.SubMyBranch.SubMyBranchLevelFormRepository;

/**
 *
 * @author acer
 */
@Service
public class SubMyBranchLevelFormService {

  @Autowired
   SubMyBranchLevelFormRepository repository;

   public SubMyBranchLevelFormRepository getRepository() {
    return repository;
  }
   public List findByLevel(SubMyBranchLevel level) {
    return repository.findByLevel(level);
  }
   public void insert(SubMyBranchLevelForm form) {
    repository.save(form);
  }
   public SubMyBranchLevelForm findById(Long id) {
      return repository.findById(id).get();
   }
}
