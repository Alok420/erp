/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.Root;

import com.opamg.erp.DAO.repo.Root.RootFormDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.beans.Root.RootFormData;
import com.opamg.erp.beans.Root.RootLevelForm;
import java.util.List;

/**
 *
 * @author acer
 */
@Service
public class RootFormDataService {

   @Autowired
   RootFormDataRepository repository;

   public RootFormDataRepository getRepository() {
      return repository;
   }

   public void insert(RootFormData form) {
      repository.save(form);
   }

   public List findByLevelForm(RootLevelForm form) {
      return repository.findByLevelForm(form);
   }

   public List findByFormDataId(long id) {
      return repository.findByFormDataId(id);
   }

   public List allByParentLevelAndSearchParam(String data, long id) {
      return repository.allByParentLevelAndSearchParam(data, id);
   }

   public List allGroupByLevel(RootLevelForm rootLevelForm) {
      List<Object[]> allObjects = repository.allGroupByLevel(rootLevelForm.getId());
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
