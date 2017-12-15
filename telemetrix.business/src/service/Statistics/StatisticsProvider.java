/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.Statistics;

import service.DeviceStatisticsSource;
import service.UserStatisticsSource;

/**
 *
 * @author bogdanv
 */
public class StatisticsProvider {
    
    static IStatisticsSource getProvider(String type) {
        switch(type) {
            case "device":
                return new DeviceStatisticsSource();
            case "user":
                return new UserStatisticsSource();
            default:
                return null;
        }                
    }
    
}
