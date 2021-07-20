/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.beans;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 *
 * @author acer
 */
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull(message = "First name is mendatory")
    private String first_name;
    @NotNull(message = "First name is mendatory")
    private String last_name;
    private String address, image;
    @NotNull(message = "Password is mendatory")
    @Min(value = 5,message = "Minimum 5 character")
    private String password;
    private String status, verification;
    @Column(unique = true, nullable = false)
    @NotNull(message = "Email is mendatory")
    @Email(message = "Email is invalid")
    private String email;
    @Column(unique = true, nullable = true)
    private String contact;
    
    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private Set<Role> role = new HashSet<Role>();
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date created;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modify_date")
    private Date updated;

    public User() {
    }

    public User(String first_name, String last_name, String address, String image, String password, String status, String email, String contact) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
        this.image = image;
        this.password = password;
        this.status = status;
        this.email = email;
        this.contact = contact;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }

   
    public String getVerification() {
        return verification;
    }

    public void setVerification(String verification) {
        this.verification = verification;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", address=" + address + ", image=" + image + ", password=" + password + ", status=" + status + ", verification=" + verification + ", email=" + email + ", contact=" + contact + ", role=" + role + ", created=" + created + ", updated=" + updated + '}';
    }
    

}
