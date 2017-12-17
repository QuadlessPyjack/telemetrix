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
    private int _currentFilterIndex;
    
    public void setCurrentModel(String modelName, String type) {
        ChartEnum chartType = ChartEnum.valueOf(type.toUpperCase());
        _currentModel = StatisticsProvider.getProvider(modelName).generateModel(chartType);
    }
    
    public DataModel getModelByName(String modelName, int filterIndex, String type) {
        ChartEnum chartType = ChartEnum.valueOf(type.toUpperCase());
        StatisticsModel model = StatisticsProvider.getProvider(modelName).generateModel(chartType);
        return model.getData().get(filterIndex);
    }
    
    public DataModel getCurrentModel() {
        return _currentModel.getData().get(_currentFilterIndex);
    }
    
    public List<FilterModel> currentModelFilters() {
        return _currentModel.getFilterModel();
    }

    public void setCurrentFilter(int filterIndex) {
        _currentFilterIndex = filterIndex;
    }

    public List<FilterModel> getFiltersByModel(String modelName) {
        StatisticsModel model = StatisticsProvider.getProvider(modelName).generateModel(ChartEnum.BAR);
        return model.getFilterModel();
    }
    
    
}
