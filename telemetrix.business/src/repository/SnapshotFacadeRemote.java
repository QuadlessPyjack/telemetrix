/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entities.Snapshot;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author bogdanv
 */
@Remote
public interface SnapshotFacadeRemote {

    void create(Snapshot snapshot);

    void edit(Snapshot snapshot);

    void remove(Snapshot snapshot);

    Snapshot find(Object id);

    List<Snapshot> findAll();

    List<Snapshot> findRange(int[] range);

    int count();
    
}
