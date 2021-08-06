/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.controller;

import com.opamg.erp.DAO.service.PermissionService;
import com.opamg.erp.DAO.service.RoleService;
import com.opamg.erp.beans.Permission;
import com.opamg.erp.beans.MyRole;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author acer
 */
@Controller
public class PermissionController {

    @Autowired
    RoleService roleService;
    @Autowired
    PermissionService permissionService;

    @PostMapping("permission/save")
    String permissionSave(HttpServletRequest req) {

        String type = req.getParameter("type");
        long role_id = Long.parseLong(req.getParameter("role_id"));
        MyRole role = roleService.getRepository().getOne(role_id);
        Permission permission = new Permission(type, role);
        permissionService.insert(permission);
        return "redirect:/role/permission";
    }

    @GetMapping("permission/delete")
    String permissionDelete(HttpServletRequest req) {
        permissionService.getRepository().deleteById(Long.parseLong(req.getParameter("id")));
        return "redirect:/role/permission";
    }

}
