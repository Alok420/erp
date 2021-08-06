/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.repo.Role;

import com.opamg.erp.beans.Role.RoleLevelForm;
import com.opamg.erp.beans.Role.RoleLevelFormField;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author acer
 */
@Repository
public interface RoleLevelFormFieldRepository extends JpaRepository<RoleLevelFormField, Long> {
    List<RoleLevelFormField> findByLevelForm(RoleLevelForm form);

}
