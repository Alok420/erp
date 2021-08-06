/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.Role;

import com.opamg.erp.beans.Role.RoleFormData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.DAO.repo.Role.RoleFormDataRepository;
import com.opamg.erp.beans.Role.RoleLevelForm;
import java.util.List;

/**
 *
 * @author acer
 */
@Service
public class RoleFormDataService {

   @Autowired
   RoleFormDataRepository repository;

   public RoleFormDataRepository getRepository() {
      return repository;
   }

   public void insert(RoleFormData form) {
      repository.save(form);
   }
  public List allByParentLevelAndSearchParam(String data, long id) {
      return repository.allByParentLevelAndSearchParam(data, id);
   }
   public List<RoleFormData> findByLevelForm(RoleLevelForm levelForm) {
      return repository.findByLevelForm(levelForm);
   }
   public List findByFormDataId(long id) {
      return repository.findByFormDataId(id);
   }


   public List allGroupByLevel(RoleLevelForm RoleLevelForm) {
      List<Object[]> allObjects = repository.allGroupByLevel(RoleLevelForm.getId());
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
