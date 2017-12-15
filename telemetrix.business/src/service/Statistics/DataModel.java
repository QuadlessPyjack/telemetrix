/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.Statistics;

import java.util.List;
import java.util.Map;

/**
 *
 * @author bogdanv
 */
public class DataModel {
    private String _name;
    private List<Map.Entry<Object,Object>> _data;

    public DataModel(String nameParam, List<Map.Entry<Object,Object>> valuePairs) {
        _name = nameParam;
        _data = valuePairs;
    }
            
    
    /**
     * @return the _name
     */
    public String getName() {
        return _name;
    }

    /**
     * @param _name the _name to set
     */
    public void setName(String _name) {
        this._name = _name;
    }

    /**
     * @return the _data
     */
    public List<Map.Entry<Object,Object>> getData() {
        return _data;
    }

    /**
     * @param _data the _data to set
     */
    public void setData(List<Map.Entry<Object,Object>> _data) {
        this._data = _data;
    }
    
    
}
