/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.repo.Root;

import com.opamg.erp.beans.Root.RootMain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author acer
 */
@Repository
public interface RootMainRepository extends JpaRepository<RootMain, Long> {

   RootMain findByName(String name);

   RootMain findTopByOrderByIdAsc();
}
