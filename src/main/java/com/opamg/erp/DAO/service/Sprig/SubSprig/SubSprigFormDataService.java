/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.Sprig.SubSprig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.beans.Sprig.SubSprig.SubSprigFormData;
import com.opamg.erp.DAO.repo.Sprig.SubSprig.SubSprigFormDataRepository;

/**
 *
 * @author acer
 */
@Service
public class SubSprigFormDataService {

  @Autowired
   SubSprigFormDataRepository repository;

   public SubSprigFormDataRepository getRepository() {
    return repository;
  }

  public void insert(SubSprigFormData form) {
    repository.save(form);
  }

}
