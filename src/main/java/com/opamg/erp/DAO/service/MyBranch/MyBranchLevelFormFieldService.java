/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.MyBranch;

import com.opamg.erp.beans.MyBranch.MyBranchLevelFormField;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.DAO.repo.MyBranch.MyBranchLevelFormFieldRepository;
import com.opamg.erp.beans.MyBranch.MyBranchLevelForm;

/**
 *
 * @author acer
 */
@Service
public class MyBranchLevelFormFieldService {

   @Autowired
   MyBranchLevelFormFieldRepository repository;

   public MyBranchLevelFormFieldRepository getRepository() {
      return repository;
   }

   public void insert(MyBranchLevelFormField levelFormField) {
      repository.save(levelFormField);
   }

   public List findAll() {
      return repository.findAll();
   }

   public List findByLevelForm(MyBranchLevelForm springLevelForm) {
      return repository.findByLevelForm(springLevelForm);
   }


}
