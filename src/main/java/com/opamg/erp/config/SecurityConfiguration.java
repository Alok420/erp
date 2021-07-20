/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.config;

import com.opamg.erp.DAO.service.PermissionService;
import com.opamg.erp.beans.Permission;
import com.opamg.erp.beans.Role;
import java.util.List;
import java.util.ListIterator;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 *
 * @author acer
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    DataSource dataSource;
    @Value("${spring.queries.users-query}")
    private String usersQuery;
    @Autowired
    PermissionService permissionService;

    @Value("${spring.queries.roles-query}")
    private String rolesQuery;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        List<Permission> permissions = permissionService.getRepository().findAll();
        ListIterator lit = permissions.listIterator();
        String root = "", sprig = "", seed = "", leaf = "", branch = "", flower = "", fruit = "", trunk = "";
        while (lit.hasNext()) {
            Permission permission = (Permission) lit.next();
            switch (permission.getType().toLowerCase()) {
                case "flower": {
                    Role role = permission.getRole();
                    flower += role.getName() + ",";
                    break;
                }
                case "fruit": {
                    Role role = permission.getRole();
                    fruit += role.getName() + ",";
                    break;
                }
                case "leaf": {
                    Role role = permission.getRole();
                    leaf += role.getName() + ",";
                    break;
                }
                case "mybranch": {
                    Role role = permission.getRole();
                    branch += role.getName() + ",";
                    break;
                }
                case "root": {
                    Role role = permission.getRole();
                    root += role.getName() + ",";
                    break;
                }
                case "sprig": {
                    Role role = permission.getRole();
                    sprig += role.getName() + ",";
                    break;
                }
                case "seed": {
                    Role role = permission.getRole();
                    seed += role.getName() + ",";
                    break;
                }
                case "trunk": {
                    Role role = permission.getRole();
                    trunk += role.getName() + ",";
                    break;
                }
            }
        }
        System.err.println("**************** roles"+branch);
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/admin/home/**").permitAll()
                .antMatchers("/role/**").hasAnyAuthority("Admin")
                .antMatchers("/flower/**").hasAnyAuthority(flower.replaceAll(", $", ""))
                .antMatchers("/fruit/**").hasAnyAuthority(fruit.replaceAll(", $", ""))
                .antMatchers("/leaf/**").hasAnyAuthority(leaf.replaceAll(", $", ""))
                .antMatchers("/mybranch/**").hasAnyAuthority(branch.replaceAll(", $", ""))
                .antMatchers("/root/**").hasAnyAuthority(root.replaceAll(", $", ""))
                .antMatchers("/seed/**").hasAnyAuthority(seed.replaceAll(", $", ""))
                .antMatchers("/sprig/**").hasAnyAuthority(sprig.replaceAll(", $", ""))
                .antMatchers("/trunk/**").hasAnyAuthority(trunk.replaceAll(", $", ""))
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll()
                .and()
                .csrf().disable().formLogin()
                .loginPage("/login")
                .failureUrl("/login?error=true")
                .defaultSuccessUrl("/")
                .usernameParameter("email")
                .passwordParameter("password")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/")
                .and()
                .exceptionHandling()
                .accessDeniedPage("/access-denied");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication()
                .usersByUsernameQuery(usersQuery)
                .authoritiesByUsernameQuery(rolesQuery)
                .dataSource(dataSource)
                .passwordEncoder(bCryptPasswordEncoder);

    }

}
