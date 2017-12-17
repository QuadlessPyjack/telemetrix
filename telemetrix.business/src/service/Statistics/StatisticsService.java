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
public class StatisticsService {
    private StatisticsModel _currentModel;
    
    public void setCurrentModel(String modelName, String type) {
        ChartEnum chartType = ChartEnum.valueOf(type.toUpperCase());
        _currentModel = StatisticsProvider.getProvider(modelName).generateModel(chartType);
    }
    
    public DataModel getCurrentModel() {
        return _currentModel.getData().get(0);
    }
    
    public List<FilterModel> currentModelFilters() {
        return _currentModel.getFilterModel();
    }
    
    
}
