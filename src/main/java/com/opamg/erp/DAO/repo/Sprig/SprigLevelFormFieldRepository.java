/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.repo.Sprig;

import com.opamg.erp.beans.Sprig.SprigLevelForm;
import com.opamg.erp.beans.Sprig.SprigLevelFormField;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author acer
 */
@Repository
public interface SprigLevelFormFieldRepository extends JpaRepository<SprigLevelFormField, Long> {
    List<SprigLevelFormField> findByLevelForm(SprigLevelForm form);

}
