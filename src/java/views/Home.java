/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.context.FacesContext;

/**
 *
 * @author bogdanv
 */
@Named(value = "home")
@Dependent
public class Home {

    /**
     * Creates a new instance of Home
     */
    public Home() {
    }
    /**
     *
     * @throws IOException
     */
    public void login() throws IOException {
         FacesContext.getCurrentInstance().getExternalContext().redirect("faces/login.xhtml");//add your URL here, instead of list.do
    }    
}
