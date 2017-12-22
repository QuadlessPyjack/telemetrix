/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Device;
import java.util.List;
//import javax.ejb.EJB;
//import javax.ejb.Stateless;
import repositories.DeviceRepository;


/**
 *
 * @author bogdanv
 */
//@Stateless
public class DeviceManagementService {

    private String _deviceName;
    private String _deviceId;
    private Boolean isDirty = false;
    
    //@EJB
    private DeviceRepository deviceRepository;
    
    public String getDeviceName() {
        Device device = deviceRepository.getById(1);
        
     //List<Device> devices = deviceRepository.getAll();
//     if (devices.size() < 1) {
//         return "DB ERROR";
//     }
     //return devices.get(0).getName().split("\\_")[1];
     return "";
    }

    public void setDeviceName(String deviceName) {
        _deviceName = deviceName;
        isDirty = true;
    }

    public String getDeviceId() {
        Device device = deviceRepository.getById(1);
        //_deviceId = device.getName().split("\\_")[0];
        //return (_deviceId);
        return "";
    }

//    public void setDeviceId(String deviceId) {
//        _deviceId = deviceId;
//    }

    public void save() {
        // call repository to save or update the data here
        if (!isDirty) {
            return;
        }
        
        Device updatedDevice = new Device();
        String deviceFullName = _deviceId + "_" + _deviceName;
        //updatedDevice.setName(deviceFullName);
        //updatedDevice.setId(1);
        
        deviceRepository.SaveOrUpdate(updatedDevice);
    }
    
}
