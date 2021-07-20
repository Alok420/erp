/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.repo.Fruit.SubFruit;


import com.opamg.erp.DAO.repo.Root.SubRoot.*;
import com.opamg.erp.DAO.repo.Fruit.SubFruit.*;
import com.opamg.erp.beans.Fruit.SubFruit.SubFruitLevel;
import com.opamg.erp.beans.Fruit.SubFruit.SubFruitMain;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author acer
 */
@Repository
public interface SubFruitLevelRepository extends JpaRepository<SubFruitLevel, Long> {

   SubFruitLevel findByName(String name);

   List<SubFruitLevel> findByMain(SubFruitMain main);
}
