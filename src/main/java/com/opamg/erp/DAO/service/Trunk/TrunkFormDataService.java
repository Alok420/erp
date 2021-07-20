/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.Trunk;

import com.opamg.erp.beans.Trunk.TrunkFormData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.DAO.repo.Trunk.TrunkFormDataRepository;
import com.opamg.erp.beans.Trunk.TrunkLevelForm;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author acer
 */
@Service
public class TrunkFormDataService {

   @Autowired
   TrunkFormDataRepository repository;

   public TrunkFormDataRepository getRepository() {
      return repository;
   }

   public void insert(TrunkFormData form) {
      repository.save(form);
   }
  public List allByParentLevelAndSearchParam(String data, long id) {
      return repository.allByParentLevelAndSearchParam(data, id);
   }
   public List<TrunkFormData> findByLevelForm(TrunkLevelForm levelForm) {
      return repository.findByLevelForm(levelForm);
   }
   public List findByFormDataId(long id) {
      return repository.findByFormDataId(id);
   }


   public List allGroupByLevel(TrunkLevelForm TrunkLevelForm) {
      List<Object[]> allObjects = repository.allGroupByLevel(TrunkLevelForm.getId());
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
