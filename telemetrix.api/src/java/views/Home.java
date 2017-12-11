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
import service.HomeService;

/**
 *
 * @author bogdanv
 */
@Named(value = "home")
@Dependent
public class Home {

    HomeService _homeService = new HomeService();
    /**
     * Creates a new instance of Home
     */
    public Home() {
    }
    /**
     *
     * @throws IOException
     */
    public void getLoginPage() throws IOException {
         FacesContext.getCurrentInstance().getExternalContext().redirect("faces/login.xhtml");
    }
    
    public void login() throws IOException {
         FacesContext.getCurrentInstance().getExternalContext().redirect("faces/contentViews/default.xhtml");
    }
    
    public void setCurrentPage(String pageName) {
        _homeService.setCurrentPage(pageName);
    }
    
    public String getCurrentPage() {
        return _homeService.getCurrentPage();
    }
}
