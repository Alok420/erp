/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.repo.Seed;

import com.opamg.erp.beans.Seed.SeedLevel;

import com.opamg.erp.beans.Seed.SeedMain;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author acer
 */
@Repository
public interface SeedLevelRepository extends JpaRepository<SeedLevel, Long> {

  SeedLevel findByName(String name);

  List<SeedLevel> findByMain(SeedMain main);
}
