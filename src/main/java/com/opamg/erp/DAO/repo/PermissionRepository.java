/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.repo;

import com.opamg.erp.beans.Permission;
import com.opamg.erp.beans.Role;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author acer
 */
@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {

    List<Permission> findByType(String type);

    List<Permission> findByRole(Role role);

}
