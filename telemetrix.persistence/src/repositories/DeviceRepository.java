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
    private Repository _repository;
    
    public DeviceRepository() {
        _repository = new Repository(this);
    }
    
    @Override
    public void SaveOrUpdate(Device entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Delete(Device entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void DeleteById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Device getById(int id) {
        return _repository.getById(id);
    }
    
}
