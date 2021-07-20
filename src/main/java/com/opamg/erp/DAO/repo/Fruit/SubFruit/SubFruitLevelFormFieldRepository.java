/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.repo.Fruit.SubFruit;

import com.opamg.erp.DAO.repo.Root.SubRoot.*;
import com.opamg.erp.DAO.repo.Fruit.SubFruit.*;
import com.opamg.erp.beans.Fruit.SubFruit.SubFruitLevelForm;
import com.opamg.erp.beans.Fruit.SubFruit.SubFruitLevelFormField;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author acer
 */
@Repository
public interface SubFruitLevelFormFieldRepository extends JpaRepository<SubFruitLevelFormField, Long> {

   List<SubFruitLevelFormField> findByLevelForm(SubFruitLevelForm form);

}
