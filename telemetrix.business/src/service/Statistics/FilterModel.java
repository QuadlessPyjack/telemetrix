/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.Statistics;

/**
 *
 * @author bogdanv
 */
public class FilterModel {
    private int action;
    private String name;
    
    public FilterModel(int paramAction, String paramName) {
        action = paramAction;
        name = paramName;
    }

    /**
     * @return the action
     */
    public int getAction() {
        return action;
    }

    /**
     * @param action the action to set
     */
    public void setAction(int action) {
        this.action = action;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}
