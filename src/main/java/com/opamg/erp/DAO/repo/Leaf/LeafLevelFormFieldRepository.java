/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.repo.Leaf;

import com.opamg.erp.beans.Leaf.LeafLevelForm;
import com.opamg.erp.beans.Leaf.LeafLevelFormField;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author acer
 */
@Repository
public interface LeafLevelFormFieldRepository extends JpaRepository<LeafLevelFormField, Long> {
    List<LeafLevelFormField> findByLevelForm(LeafLevelForm form);

}
