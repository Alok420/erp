/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.repo.Fruit;

import com.opamg.erp.beans.Fruit.FruitLevel;
import com.opamg.erp.beans.Fruit.FruitLevelForm;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author acer
 */
@Repository
public interface FruitLevelFormRepository extends JpaRepository<FruitLevelForm, Long> {

   List<FruitLevelForm> findByLevel(FruitLevel level);

}
