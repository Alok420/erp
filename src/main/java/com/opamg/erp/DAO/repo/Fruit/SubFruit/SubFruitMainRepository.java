/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.repo.Fruit.SubFruit;

import com.opamg.erp.beans.Fruit.FruitLevelForm;
import com.opamg.erp.beans.Fruit.SubFruit.SubFruitMain;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author acer
 */
@Repository
public interface SubFruitMainRepository extends JpaRepository<SubFruitMain, Long> {

   SubFruitMain findByName(String name);

   List findByPLevelForm(FruitLevelForm PLevelForm);

   SubFruitMain findTopByOrderByIdAsc();
}
