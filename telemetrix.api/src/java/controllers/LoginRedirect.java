/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import javax.ejb.Stateful;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author bogdanv
 */
@Named(value = "loginRedirect")
@ViewScoped
@Stateful(passivationCapable = true)
public class LoginRedirect {
     
    public void getLoginPage() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("faces/login.xhtml");
    }

    public void login() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("faces/contentViews/navigationBase.xhtml");
    }
    
}
