/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.repo.Trunk.SubTrunk;


import com.opamg.erp.DAO.repo.Root.SubRoot.*;
import com.opamg.erp.DAO.repo.Trunk.SubTrunk.*;
import com.opamg.erp.beans.Trunk.SubTrunk.SubTrunkLevel;
import com.opamg.erp.beans.Trunk.SubTrunk.SubTrunkMain;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author acer
 */
@Repository
public interface SubTrunkLevelRepository extends JpaRepository<SubTrunkLevel, Long> {

  SubTrunkLevel findByName(String name);

  List<SubTrunkLevel> findByMain(SubTrunkMain main);
}
