/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author acer
 */
@Entity
public class Role {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    @Column(unique = true)
    private String name;
    
    @Column(columnDefinition = "TEXT")
    private String description;

    public Role() {
    }

    public Role(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Role{" + "id=" + id + ", name=" + name + ", description=" + description + '}';
    }

}
