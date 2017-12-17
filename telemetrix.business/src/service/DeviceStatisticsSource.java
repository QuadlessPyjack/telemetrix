/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
public class DeviceStatisticsSource implements IStatisticsSource {
    @Override
    public StatisticsModel generateModel(ChartEnum type) {
        StatisticsModel deviceStatisticsModel = new StatisticsModel();
        List<FilterModel> filterModelList = generateFilterModel();
        List<DataModel> dataModelList = generateDataModel();
        deviceStatisticsModel.setLabel("Device Telemetry");
        deviceStatisticsModel.setType(type);
        deviceStatisticsModel.setFilterModel(filterModelList);
        deviceStatisticsModel.setData(dataModelList);

        return deviceStatisticsModel;
    }

    private List<FilterModel> generateFilterModel() {
        List<FilterModel> filterModels = new ArrayList<>();
        filterModels.add(new FilterModel(0, "BLE Latency"));
        filterModels.add(new FilterModel(1, "Framerate (FPS)"));
        filterModels.add(new FilterModel(2, "Frame Processing Time (ms)"));

        return filterModels;
    }

    private List<DataModel> generateDataModel() {

        List<DataModel> dataModelList = new ArrayList<>();
        dataModelList.add(new DataModel("BLE Latency", getValuePairsForDataModel("latency")));
        dataModelList.add(new DataModel("Framerate (FPS)", getValuePairsForDataModel("fps")));
        dataModelList.add(new DataModel("Frame Processing Time (ms)", getValuePairsForDataModel("fpt")));
        
        return dataModelList;
    }
    
    private List<Map.Entry<Object, Object>> getValuePairsForDataModel(String dataModelId) {
        List<Map.Entry<Object, Object>> valuePairs = new ArrayList<>();
        
        //TODO: get this from repository
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        LocalDateTime time0 = LocalDateTime.from(f.parse("16-12-2017 15:10"));
        LocalDateTime time1 = LocalDateTime.from(f.parse("16-12-2017 15:15"));
        LocalDateTime time2 = LocalDateTime.from(f.parse("16-12-2017 15:20"));
        LocalDateTime time3 = LocalDateTime.from(f.parse("16-12-2017 15:25"));
        valuePairs.add(new SimpleImmutableEntry<>(time0.toString(), 150));
        valuePairs.add(new SimpleImmutableEntry<>(time1.toString(), 145));
        valuePairs.add(new SimpleImmutableEntry<>(time2.toString(), 200));
        valuePairs.add(new SimpleImmutableEntry<>(time3.toString(), 170));
        
        return valuePairs;
    };

}
