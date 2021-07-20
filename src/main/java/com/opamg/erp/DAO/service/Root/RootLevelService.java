/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.Root;

import com.opamg.erp.beans.Root.RootLevel;
import com.opamg.erp.beans.Root.RootMain;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.DAO.repo.Root.RootLevelRepository;

/**
 *
 * @author acer
 */
@Service
public class RootLevelService {

   @Autowired
   RootLevelRepository levelRepository;
//----------------------------------------------------------level-------------------

   public RootLevelRepository getLeveleRepository() {
      return levelRepository;
   }

   public List findAllLevel() {
      return levelRepository.findAll();
   }

   public RootLevel findOneById(long id) {
      if (id < 1) {
	return null;
      } else {
	return levelRepository.findById(id).get();
      }
   }

   public List FindLevelByMain(RootMain main) {
      return levelRepository.findByMain(main);
   }

   public void deleteLevel(long id) {
      levelRepository.deleteById(id);
   }

   public RootLevel findById(Long id) {
      return levelRepository.findById(id).get();
   }
}
