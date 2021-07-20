/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.Trunk;

import com.opamg.erp.beans.Trunk.TrunkLevel;
import com.opamg.erp.beans.Trunk.TrunkMain;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.DAO.repo.Trunk.TrunkLevelRepository;

/**
 *
 * @author acer
 */
@Service
public class TrunkLevelService {

   @Autowired
   TrunkLevelRepository levelRepository;
//----------------------------------------------------------level-------------------

   public TrunkLevelRepository getLeveleRepository() {
      return levelRepository;
   }

   public List findAllLevel() {
      return levelRepository.findAll();
   }

   public TrunkLevel findOneById(long id) {
      if (id < 1) {
	return null;
      } else {
	return levelRepository.findById(id).get();
      }
   }

   public List FindLevelByMain(TrunkMain main) {
      return levelRepository.findByMain(main);
   }

   public void deleteLevel(long id) {
      levelRepository.deleteById(id);
   }

}
