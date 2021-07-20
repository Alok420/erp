/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.Trunk.SubTrunk;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.beans.Trunk.SubTrunk.SubTrunkLevel;
import com.opamg.erp.beans.Trunk.SubTrunk.SubTrunkMain;
import com.opamg.erp.DAO.repo.Trunk.SubTrunk.SubTrunkLevelRepository;

/**
 *
 * @author acer
 */
@Service
public class SubTrunkLevelService {

  @Autowired
   SubTrunkLevelRepository levelRepository;
//----------------------------------------------------------level-------------------

   public SubTrunkLevelRepository getLeveleRepository() {
    return levelRepository;
  }

  public List findAllLevel() {
    return levelRepository.findAll();
  }

  public SubTrunkLevel findOneById(long id) {
    if (id < 1) {
      return null;
    } else {
      return levelRepository.findById(id).get();
    }
  }

  public List FindLevelByMain(SubTrunkMain main) {
    return levelRepository.findByMain(main);
  }

  public void deleteLevel(long id) {
    levelRepository.deleteById(id);
  }
}
