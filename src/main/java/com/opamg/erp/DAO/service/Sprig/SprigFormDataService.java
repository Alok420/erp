/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.Sprig;

import com.opamg.erp.beans.Sprig.SprigFormData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.DAO.repo.Sprig.SprigFormDataRepository;
import com.opamg.erp.beans.Sprig.SprigLevelForm;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author acer
 */
@Service
public class SprigFormDataService {

   @Autowired
   SprigFormDataRepository repository;

   public SprigFormDataRepository getRepository() {
      return repository;
   }

   public void insert(SprigFormData form) {
      repository.save(form);
   }

   public List<SprigFormData> findByLevelForm(SprigLevelForm levelForm) {
      return repository.findByLevelForm(levelForm);
   }
   public List findByFormDataId(long id) {
      return repository.findByFormDataId(id);
   }


   public List allGroupByLevel(SprigLevelForm sprigLevelForm) {
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
