/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.Seed;

import com.opamg.erp.beans.Seed.SeedFormData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.DAO.repo.Seed.SeedFormDataRepository;
import com.opamg.erp.beans.Seed.SeedLevelForm;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author acer
 */
@Service
public class SeedFormDataService {

   @Autowired
   SeedFormDataRepository repository;

   public SeedFormDataRepository getRepository() {
      return repository;
   }

   public void insert(SeedFormData form) {
      repository.save(form);
   }
  public List allByParentLevelAndSearchParam(String data, long id) {
      return repository.allByParentLevelAndSearchParam(data, id);
   }
   public List<SeedFormData> findByLevelForm(SeedLevelForm levelForm) {
      return repository.findByLevelForm(levelForm);
   }
   public List findByFormDataId(long id) {
      return repository.findByFormDataId(id);
   }


   public List allGroupByLevel(SeedLevelForm SeedLevelForm) {
      List<Object[]> allObjects = repository.allGroupByLevel(SeedLevelForm.getId());
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
