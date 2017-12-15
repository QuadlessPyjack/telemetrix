/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.Statistics;

import java.util.List;

/**
 *
 * @author bogdanv
 */
public class StatisticsModel {
    private List<FilterModel> _filterModelList;
    private ChartEnum _type;
    private String _label;
    private List<DataModel> _data;

    /**
     * @return the _filterModel
     */
    public List<FilterModel> getFilterModel() {
        return _filterModelList;
    }

    /**
     * @param _filterModel the _filterModel to set
     */
    public void setFilterModel(List<FilterModel> _filterModel) {
        this._filterModelList = _filterModel;
    }

    /**
     * @return the _type
     */
    public ChartEnum getType() {
        return _type;
    }

    /**
     * @param _type the _type to set
     */
    public void setType(ChartEnum _type) {
        this._type = _type;
    }

    /**
     * @return the _label
     */
    public String getLabel() {
        return _label;
    }

    /**
     * @param _label the _label to set
     */
    public void setLabel(String _label) {
        this._label = _label;
    }

    /**
     * @return the _data
     */
    public List<DataModel> getData() {
        return _data;
    }

    /**
     * @param _data the _data to set
     */
    public void setData(List<DataModel> _data) {
        this._data = _data;
    }
    
}
