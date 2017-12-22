/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import entities.Device;

/**
 *
 * @author bogdanv
 */
public class DeviceRepository implements IRepository<Device> {
    private Repository<Device> _repository;
    
    public DeviceRepository() {
        _repository = new Repository(this);
    }
    
    @Override
    public void SaveOrUpdate(Device entity) {
        //insert SQL query here
    }
    
    public void SaveOrUpdateDevice(Device entity) {
        _repository.SaveOrUpdate(entity);
    }

    @Override
    public void Delete(Device entity) {
        //insert SQL query here
    }
    
    public void DeleteDevice(Device entity) {
        _repository.Delete(entity);
    }

    @Override
    public void DeleteById(int id) {
        //insert SQL query here
    }
    
    public void DeleteDeviceById(int id) {
       _repository.DeleteById(id);
    }

    @Override
    public Device getById(int id) {
       //insert SQL query code here
    }
    
    public Device getDeviceById(int id) {
       Device device = _repository.getById(id);
       return device;
    }
    
}
