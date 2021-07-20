/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.repo.Trunk;

import com.opamg.erp.beans.Trunk.TrunkLevel;

import com.opamg.erp.beans.Trunk.TrunkMain;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author acer
 */
@Repository
public interface TrunkLevelRepository extends JpaRepository<TrunkLevel, Long> {

  TrunkLevel findByName(String name);

  List<TrunkLevel> findByMain(TrunkMain main);
}
