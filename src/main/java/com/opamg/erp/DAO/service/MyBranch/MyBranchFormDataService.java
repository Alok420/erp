/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.MyBranch;

import com.opamg.erp.beans.MyBranch.MyBranchFormData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.DAO.repo.MyBranch.MyBranchFormDataRepository;
import com.opamg.erp.beans.MyBranch.MyBranchLevelForm;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author acer
 */
@Service
public class MyBranchFormDataService {

   @Autowired
   MyBranchFormDataRepository repository;

   public MyBranchFormDataRepository getRepository() {
      return repository;
   }

   public void insert(MyBranchFormData form) {
      repository.save(form);
   }

   public List<MyBranchFormData> findByLevelForm(MyBranchLevelForm levelForm) {
      return repository.findByLevelForm(levelForm);
   }
   public List findByFormDataId(long id) {
      return repository.findByFormDataId(id);
   }


   public List allGroupByLevel(MyBranchLevelForm sprigLevelForm) {
      List<Object[]> allObjects = repository.allGroupByLevel(sprigLevelForm.getId());
      return allObjects;
   }

   public List allGroupByLevel(long id, int year) {
      List<Object[]> allObjects = repository.allGroupByLevel(id, year);
      return allObjects;
   }

   public List allGroupByMonth(int month) {
      List<Object[]> allObjects = repository.allGroupByMonth(month);
      return allObjects;
   }

   public List allGroupByMonth(long id, int year) {
      List<Object[]> allObjects = repository.allGroupByMonth(id, year);
      return allObjects;
   }
}
