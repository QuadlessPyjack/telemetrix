/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entities.Dataset;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author bogdanv
 */
@Remote
public interface DatasetFacadeRemote {

    void create(entities.Dataset dataset);

    void edit(entities.Dataset dataset);

    void remove(entities.Dataset dataset);

    entities.Dataset find(Object id);

    List<Dataset> findAll();

    List<Dataset> findRange(int[] range);

    int count();
    
}
