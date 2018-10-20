/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author DMHT
 */
@ManagedBean(name = "Login")
@RequestScoped
public class Login implements Serializable{
    //API api = new API();
    //Session session;
    PageController pagecontroller;

    UserDatabaseController db = new UserDatabaseController();
    
    private String email;
    private String passwd;

    public Login() throws Exception {
    }
    //private Boolean loggedIn;

    public String login() throws Exception{
    if(db.userExists(email, passwd)){
        //session.setLoggedin(true);
        //System.out.println("User found");
        return "home?faces-redirect=true";
        //return "home?faces-redirect=true";
    }else{
    System.out.println("! ! ! User not found ! ! !");
    //session.setLoggedin(false);
    return pagecontroller.home_page();
    }
    }
    //Ally-edit start
    // Logout set user if login - true to login - false return login page
    public String logout() throws Exception{
        //session.setLoggedin(false);
    //if (!session.isLoggedin()){
        //System.out.println("User logged out");
        return "index?faces-redirect=true";
    //}else{
        //System.err.println("There was a problem login out");
        //return "home?faces-redirect=true";
    //}
    }
    //Ally-edit stop

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }  
}
