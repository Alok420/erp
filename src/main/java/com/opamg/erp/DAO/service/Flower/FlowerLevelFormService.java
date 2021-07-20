/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.Flower;

import com.opamg.erp.beans.Flower.FlowerLevelForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.DAO.repo.Flower.FlowerLevelFormRepository;
import com.opamg.erp.beans.Flower.FlowerLevel;
import java.util.List;

/**
 *
 * @author acer
 */
@Service
public class FlowerLevelFormService {

  @Autowired
  FlowerLevelFormRepository repository;

  public FlowerLevelFormRepository getRepository() {
    return repository;
  }
  public List findByLevel(FlowerLevel level) {
    return repository.findByLevel(level);
  }
  public void insert(FlowerLevelForm form) {
    repository.save(form);
  }

}
