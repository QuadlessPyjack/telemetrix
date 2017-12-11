/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entities.Snapshot;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author bogdanv
 */
@Stateless
public class SnapshotFacade extends AbstractFacade<Snapshot> implements repository.SnapshotFacadeRemote {

    @PersistenceContext(unitName = "telemetrix.persistencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SnapshotFacade() {
        super(Snapshot.class);
    }
    
}