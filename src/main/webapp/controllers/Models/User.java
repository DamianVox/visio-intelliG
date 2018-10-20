/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.Models;

/**
 *
 * @author Visio
 */
public class User {
    private String id;
    private String name;
    private String surname;
    private String email;
    private String user_name;
    private String password;
    private String account_type;
    private String phone;

    public void User(){}
    
    public void User(String id, String name,String surname,String email,String user_name,String password,String account_type,String phone){
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.email = email;
    this.user_name = user_name;
    this.password = password;
    this.account_type = account_type;
    this.phone = phone;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    
    
}
