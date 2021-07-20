/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.Fruit.SubFruit;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.beans.Fruit.SubFruit.SubFruitLevel;
import com.opamg.erp.beans.Fruit.SubFruit.SubFruitMain;
import com.opamg.erp.DAO.repo.Fruit.SubFruit.SubFruitLevelRepository;

/**
 *
 * @author acer
 */
@Service
public class SubFruitLevelService {

  @Autowired
   SubFruitLevelRepository levelRepository;
//----------------------------------------------------------level-------------------

   public SubFruitLevelRepository getLeveleRepository() {
    return levelRepository;
  }

  public List findAllLevel() {
    return levelRepository.findAll();
  }

   public SubFruitLevel findOneById(long id) {
    if (id < 1) {
      return null;
    } else {
      return levelRepository.findById(id).get();
    }
  }

   public List FindLevelByMain(SubFruitMain main) {
    return levelRepository.findByMain(main);
  }

  public void deleteLevel(long id) {
    levelRepository.deleteById(id);
  }
}
