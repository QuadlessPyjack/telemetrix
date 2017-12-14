/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.util.Date;
import javax.enterprise.context.Dependent;
import javax.inject.Named;

/**
 *
 * @author bogdanv
 */
@Named(value = "credentials")
@Dependent
public class Credentials {

    private String userName;
    private String password;
    private Date date;
    
    private String userNameWarning;
    private String passwordWarning;

    public String getUserNameWarning() {
        return userNameWarning;
    }

    public void setUserNameWarning(String userNameWarning) {
        this.userNameWarning = userNameWarning;
    }

    public String getPasswordWarning() {
        return passwordWarning;
    }

    public void setPasswordWarning(String passwordWarning) {
        this.passwordWarning = passwordWarning;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String username) {
        this.userName = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Credentials() {
    }
    
}
