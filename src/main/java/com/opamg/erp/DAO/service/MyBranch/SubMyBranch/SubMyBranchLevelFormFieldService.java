/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.MyBranch.SubMyBranch;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.beans.MyBranch.SubMyBranch.SubMyBranchLevelFormField;
import com.opamg.erp.DAO.repo.MyBranch.SubMyBranch.SubMyBranchLevelFormFieldRepository;
import com.opamg.erp.beans.MyBranch.SubMyBranch.SubMyBranchLevelForm;

/**
 *
 * @author acer
 */
@Service
public class SubMyBranchLevelFormFieldService {

  @Autowired
   SubMyBranchLevelFormFieldRepository repository;

   public SubMyBranchLevelFormFieldRepository getRepository() {
    return repository;
  }

   public void insert(SubMyBranchLevelFormField levelFormField) {
    repository.save(levelFormField);
  }
  public List findAll(){
    return repository.findAll();
  }
   public List findByLevelForm(SubMyBranchLevelForm subspringLevelForm) {
      return repository.findByLevelForm(subspringLevelForm);
   }
}
