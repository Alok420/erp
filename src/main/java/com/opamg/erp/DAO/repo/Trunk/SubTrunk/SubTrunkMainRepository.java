/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.repo.Trunk.SubTrunk;

import com.opamg.erp.beans.Trunk.TrunkLevelForm;
import com.opamg.erp.beans.Trunk.SubTrunk.SubTrunkMain;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author acer
 */
@Repository
public interface SubTrunkMainRepository extends JpaRepository<SubTrunkMain, Long> {

   SubTrunkMain findByName(String name);

   List findByPLevelForm(TrunkLevelForm PLevelForm);

   SubTrunkMain findTopByOrderByIdAsc();
}
