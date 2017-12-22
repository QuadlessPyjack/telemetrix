/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import common.ConnectionManager;

/**
 *
 * @author bogdanv
 * @param <T>
 */

public class Repository<T> {
    private final IRepository<T> _repository;
    public T getById(int id) {
        ConnectionManager.getInstance().connect();
        T entity = _repository.getById(id);
        ConnectionManager.getInstance().disconnect();
        return entity;
    }
    
    public Repository(IRepository<T> repository) {
        _repository = repository;
    }
    
    public void SaveOrUpdate(T entity) {
        ConnectionManager.getInstance().connect();
        _repository.SaveOrUpdate(entity);
        ConnectionManager.getInstance().disconnect();
    }
    
    public void Delete(T entity) {
        ConnectionManager.getInstance().connect();
        _repository.Delete(entity);
        ConnectionManager.getInstance().disconnect();
    }
    
    public void DeleteById(int id) {
        ConnectionManager.getInstance().connect();
        _repository.DeleteById(id);
        ConnectionManager.getInstance().disconnect();
    }
}
