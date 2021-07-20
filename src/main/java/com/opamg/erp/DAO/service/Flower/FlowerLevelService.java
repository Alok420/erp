/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.Flower;
import com.opamg.erp.beans.Flower.FlowerLevel;
import com.opamg.erp.beans.Flower.FlowerMain;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.DAO.repo.Flower.FlowerLevelRepository;

/**
 *
 * @author acer
 */
@Service
public class FlowerLevelService {

  @Autowired
  FlowerLevelRepository levelRepository;
//----------------------------------------------------------level-------------------

  public FlowerLevelRepository getLeveleRepository() {
    return levelRepository;
  }

  public List findAllLevel() {
    return levelRepository.findAll();
  }

  public FlowerLevel findOneById(long id) {
    if (id < 1) {
      return null;
    } else {
      return levelRepository.findById(id).get();
    }
  }

  public List FindLevelByMain(FlowerMain main) {
    return levelRepository.findByMain(main);
  }

  public void deleteLevel(long id) {
    levelRepository.deleteById(id);
   }
}
