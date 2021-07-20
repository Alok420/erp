/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.repo.Seed.SubSeed;

import com.opamg.erp.DAO.repo.Root.SubRoot.*;
import com.opamg.erp.DAO.repo.Seed.SubSeed.*;
import com.opamg.erp.beans.Seed.SubSeed.SubSeedLevel;
import com.opamg.erp.beans.Seed.SubSeed.SubSeedLevelForm;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author acer
 */
@Repository
public interface SubSeedLevelFormRepository extends JpaRepository<SubSeedLevelForm, Long> {

  List<SubSeedLevelForm> findByLevel(SubSeedLevel level);

}
