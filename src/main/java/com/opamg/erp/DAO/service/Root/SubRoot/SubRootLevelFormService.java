/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.Root.SubRoot;

import com.opamg.erp.DAO.repo.Root.SubRoot.SubRootLevelFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.opamg.erp.beans.Root.SubRoot.SubRootLevel;
import com.opamg.erp.beans.Root.SubRoot.SubRootLevelForm;

/**
 *
 * @author acer
 */
@Service
public class SubRootLevelFormService {

  @Autowired
   SubRootLevelFormRepository repository;

   public SubRootLevelFormRepository getRepository() {
    return repository;
  }
   public List findByLevel(SubRootLevel level) {
    return repository.findByLevel(level);
  }
   public void insert(SubRootLevelForm form) {
    repository.save(form);
  }

}
