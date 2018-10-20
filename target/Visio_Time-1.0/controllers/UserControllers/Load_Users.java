/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.UserControllers;
import javax.faces.bean.ManagedBean;
import controllers.API;
import controllers.Models.User;

/**
 *
 * @author Visio
 */
@ManagedBean(name = "Load_Users")
public class Load_Users  {
    API api = new API();
    User user = new User();
    
    public  String getUsers() throws Exception{
    String data = null;
    data = api.LoadUsers();
    
        System.out.println(data);
    
    return data;
    }
    
}
