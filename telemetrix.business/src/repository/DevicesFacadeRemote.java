/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entities.Devices;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author bogdanv
 */
@Remote
public interface DevicesFacadeRemote {

    void create(Devices devices);

    void edit(Devices devices);

    void remove(Devices devices);

    Devices find(Object id);

    List<Devices> findAll();

    List<Devices> findRange(int[] range);

    int count();
    
}
