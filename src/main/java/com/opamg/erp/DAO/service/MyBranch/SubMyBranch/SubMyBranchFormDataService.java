/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.MyBranch.SubMyBranch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.beans.MyBranch.SubMyBranch.SubMyBranchFormData;
import com.opamg.erp.DAO.repo.MyBranch.SubMyBranch.SubMyBranchFormDataRepository;

/**
 *
 * @author acer
 */
@Service
public class SubMyBranchFormDataService {

  @Autowired
   SubMyBranchFormDataRepository repository;

   public SubMyBranchFormDataRepository getRepository() {
    return repository;
  }

   public void insert(SubMyBranchFormData form) {
    repository.save(form);
  }

}
