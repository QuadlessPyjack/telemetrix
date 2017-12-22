/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

/**
 *
 * @author bogdanv
 * @param <T>
 */
public interface IRepository<T> {
    public void SaveOrUpdate(T entity);
    
    public void Delete(T entity);
    
    public void DeleteById(int id);    
    
    public T getById(int id);
}
