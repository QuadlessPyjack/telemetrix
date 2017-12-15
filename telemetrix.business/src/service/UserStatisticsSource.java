/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import service.Statistics.ChartEnum;
import service.Statistics.DataModel;
import service.Statistics.FilterModel;
import service.Statistics.IStatisticsSource;
import service.Statistics.StatisticsModel;

/**
 *
 * @author bogdanv
 */
public class UserStatisticsSource implements IStatisticsSource {

    private final String viewName = "userStatisticsView";

    @Override
    public StatisticsModel generateModel(ChartEnum type) {
        StatisticsModel deviceStatisticsModel = new StatisticsModel();
        List<FilterModel> filterModelList = generateFilterModel();
        List<DataModel> dataModelList = generateDataModel();
        deviceStatisticsModel.setLabel("User Statistics");
        deviceStatisticsModel.setType(type);
        deviceStatisticsModel.setFilterModel(filterModelList);
        deviceStatisticsModel.setData(dataModelList);

        return deviceStatisticsModel;
    }

// currently we have only one entry    
    private List<FilterModel> generateFilterModel() {
        List<FilterModel> filterModels = new ArrayList<>();
//      filterModels.add(new FilterModel(viewName + "toggleLatency", "BLE Latency"));
        return filterModels;
    }

    private List<DataModel> generateDataModel() {

        List<DataModel> dataModelList = new ArrayList<>();
        dataModelList.add(new DataModel("Uptime", getValuePairsForDataModel("uptime")));
        
        return dataModelList;
    }
    
    private List<Map.Entry<Object, Object>> getValuePairsForDataModel(String dataModelId) {
        List<Map.Entry<Object, Object>> valuePairs = new ArrayList<>();
        
        //TODO: get this from repository
        valuePairs.add(new SimpleImmutableEntry<>("", ""));
        
        return valuePairs;
    };

}