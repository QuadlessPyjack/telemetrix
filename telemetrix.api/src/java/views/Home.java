/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import javax.ejb.Stateful;
import javax.inject.Named;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import service.HomeService;

/**
 *
 * @author bogdanv
 */
@Named(value = "home")
@ViewScoped
@Stateful(passivationCapable = true)
public class Home {

    HomeService _homeService = new HomeService();

    /**
     * Creates a new instance of Home
     */
    public Home() {
    }

    public void setCurrentPage(String pageName) {
        _homeService.setCurrentPage(pageName);
        String newPage = _homeService.getCurrentPage();
        
        UIViewRoot view = FacesContext.getCurrentInstance().getViewRoot();
        UIComponent component = view.findComponent(":container");
        component.getAttributes().put("include", newPage);
    }

    public String getCurrentPage() {
        return _homeService.getCurrentPage();
    }
}
