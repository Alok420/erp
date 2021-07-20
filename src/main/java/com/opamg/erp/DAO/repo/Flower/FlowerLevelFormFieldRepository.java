/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.repo.Flower;

import com.opamg.erp.beans.Flower.FlowerLevelForm;
import com.opamg.erp.beans.Flower.FlowerLevelFormField;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author acer
 */
@Repository
public interface FlowerLevelFormFieldRepository extends JpaRepository<FlowerLevelFormField, Long> {
    List<FlowerLevelFormField> findByLevelForm(FlowerLevelForm form);

}
