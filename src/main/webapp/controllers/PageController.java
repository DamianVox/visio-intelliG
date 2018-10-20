/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.faces.bean.ManagedBean;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author DMHT
 */
@ManagedBean(name = "PageController")
public class PageController {
private Session session;
    //private Login login;

    //private boolean loggedin;

    public String account_page() {

        //System.out.println(login.getLoggedIn());
//        if (session.isLoggedin()) {
            return "account.xhtml";

//        } else {
//            return "index?faces-redirect=true";
//        }
       
    }
        
        public String home_page() {

        //System.out.println(login.getLoggedIn());
//        if (session.isLoggedin()) {
            return "home?faces-redirect=true";

//        } else {
//            return "index?faces-redirect=true";
//        }
        }
}
