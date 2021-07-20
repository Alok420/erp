/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.Root.SubRoot;

import com.opamg.erp.DAO.repo.Root.SubRoot.SubRootLevelFormFieldRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.beans.Root.SubRoot.SubRootLevelFormField;

/**
 *
 * @author acer
 */
@Service
public class SubRootLevelFormFieldService {

  @Autowired
   SubRootLevelFormFieldRepository repository;

   public SubRootLevelFormFieldRepository getRepository() {
    return repository;
  }

   public void insert(SubRootLevelFormField levelFormField) {
    repository.save(levelFormField);
  }
  public List findAll(){
    return repository.findAll();
  }

}
