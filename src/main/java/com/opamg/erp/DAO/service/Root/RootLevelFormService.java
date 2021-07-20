/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.Root;

import com.opamg.erp.DAO.service.Root.*;
import com.opamg.erp.beans.Root.RootLevelForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.DAO.repo.Root.RootLevelFormRepository;
import com.opamg.erp.beans.Root.RootLevel;
import java.util.List;

/**
 *
 * @author acer
 */
@Service
public class RootLevelFormService {

   @Autowired
   RootLevelFormRepository repository;

   public RootLevelFormRepository getRepository() {
      return repository;
   }

   public List findByLevel(RootLevel level) {
      return repository.findByLevel(level);
   }

   public void insert(RootLevelForm form) {
      repository.save(form);
   }

   public RootLevelForm findById(Long id) {
      return repository.findById(id).get();
   }

}
