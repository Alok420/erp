/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.repo.Sprig.SubSprig;


import com.opamg.erp.DAO.repo.Root.SubRoot.*;
import com.opamg.erp.DAO.repo.Sprig.SubSprig.*;
import com.opamg.erp.beans.Sprig.SubSprig.SubSprigLevel;
import com.opamg.erp.beans.Sprig.SubSprig.SubSprigMain;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author acer
 */
@Repository
public interface SubSprigLevelRepository extends JpaRepository<SubSprigLevel, Long> {

  SubSprigLevel findByName(String name);

  List<SubSprigLevel> findByMain(SubSprigMain main);
}
