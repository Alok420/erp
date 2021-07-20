/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.repo.Root.SubRoot;


import com.opamg.erp.beans.Root.SubRoot.SubRootLevel;
import com.opamg.erp.beans.Root.SubRoot.SubRootMain;
import com.opamg.erp.beans.Sprig.SubSprig.SubSprigLevel;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author acer
 */
@Repository
public interface SubRootLevelRepository extends JpaRepository<SubRootLevel, Long> {

   SubRootLevel findByName(String name);

   List<SubRootLevel> findByMain(SubRootMain main);
}
