/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.Root.SubRoot;

import com.opamg.erp.DAO.repo.Root.SubRoot.SubRootFormDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.beans.Root.SubRoot.SubRootFormData;

/**
 *
 * @author acer
 */
@Service
public class SubRootFormDataService {

  @Autowired
   SubRootFormDataRepository repository;

   public SubRootFormDataRepository getRepository() {
    return repository;
  }

   public void insert(SubRootFormData form) {
      repository.save(form);
  }

}
