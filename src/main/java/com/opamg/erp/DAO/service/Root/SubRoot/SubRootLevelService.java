/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.Root.SubRoot;
import com.opamg.erp.DAO.repo.Root.SubRoot.SubRootLevelRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.beans.Root.SubRoot.SubRootLevel;
import com.opamg.erp.beans.Root.SubRoot.SubRootMain;

/**
 *
 * @author acer
 */
@Service
public class SubRootLevelService {

  @Autowired
   SubRootLevelRepository levelRepository;
//----------------------------------------------------------level-------------------

   public SubRootLevelRepository getLeveleRepository() {
    return levelRepository;
  }

  public List findAllLevel() {
    return levelRepository.findAll();
  }

   public SubRootLevel findOneById(long id) {
    if (id < 1) {
      return null;
    } else {
      return levelRepository.findById(id).get();
    }
  }

   public List FindLevelByMain(SubRootMain main) {
    return levelRepository.findByMain(main);
  }

  public void deleteLevel(long id) {
    levelRepository.deleteById(id);
  }
}
