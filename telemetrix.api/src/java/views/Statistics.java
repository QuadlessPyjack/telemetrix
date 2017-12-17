/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import service.Statistics.DataModel;
//import org.modelmapper.ModelMapper;

import service.Statistics.FilterModel;
import service.Statistics.StatisticsService;

import org.chartistjsf.model.chart.AspectRatio;
import org.chartistjsf.model.chart.BarChartModel;
import org.chartistjsf.model.chart.ChartSeries;

/**
 *
 * @author bogdanv
 */
@Named(value = "statistics")
@ViewScoped
@Stateful(passivationCapable = true)
public class Statistics {

    private StatisticsService _statisticsService;
    private BarChartModel _currentModel;

    private List<FilterModel> _currentModelFilters;

    public List<FilterModel> getCurrentModelFilters() {
        return _statisticsService.currentModelFilters();
    }

    public void setCurrentModel(String modelName, String chartType, String caller) {
        _statisticsService.setCurrentModel(modelName, chartType);
    }

    public void setCurrentModelFilter(int filterIndex) {
        _statisticsService.setCurrentFilter(filterIndex);
    }

    public BarChartModel getModel(String category, int filterIndex, String chartType) {
        DataModel data = _statisticsService.getModelByName(category, filterIndex, chartType);
        _currentModel = dataModelToBarChart(data, chartType);

        return _currentModel;
    }
    
    public List<FilterModel> getFiltersByModel(String modelName) {
        return _statisticsService.getFiltersByModel(modelName);
    }

    public BarChartModel getCurrentModel() {
        //TODO: Figure out how to load current model and spit out a BarChartModel from it
        DataModel data = _statisticsService.getCurrentModel();

        _currentModel = dataModelToBarChart(data, "bar");

        return _currentModel;
    }

    private BarChartModel dataModelToBarChart(DataModel model, String chartType) {
        ChartSeries series = new ChartSeries();
        series.setName(model.getName());
        Collection<Number> keyValues = model.getDataMap().values();
        Set<Object> labels = model.getDataMap().keySet();

        ArrayList<Number> values = new ArrayList<>();
        keyValues.forEach(v -> values.add(v));
        series.setData(values);

        BarChartModel chartModel = new BarChartModel();

        labels.forEach(label -> chartModel.addLabel(label));

        chartModel.addSeries(series);
        chartModel.setAnimatePath(true);
        chartModel.setAspectRatio(AspectRatio.MAJOR_TWELFTH);

//        switch (chartType) {
//            case "bar": {
//                chartModel = new BarChartModel();
//                chartModel.addSeries(series);
//                break;
//            }
//            case "line": {
//                chartModel = new LineChartModel();
//                chartModel.addSeries(series);
//                break;
//            }
//            default:
//                chartModel = null;
//        }
        return chartModel;
    }

    /**
     * Creates a new instance of Statistics
     */
    public Statistics() {
    }

    @PostConstruct
    public void init() {
        _statisticsService = new StatisticsService();
//        _statisticsService.setCurrentModel("device", "bar");
//        _currentModelFilters = _statisticsService.currentModelFilters();
//        
//        DataModel data = _statisticsService.getCurrentModel();
//        _currentModel = dataModelToBarChart(data, "bar");
    }
}
