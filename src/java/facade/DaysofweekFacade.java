/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.domain.Daysofweek;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sawad
 */
@Stateless
public class DaysofweekFacade extends AbstractFacade<Daysofweek> {

    @PersistenceContext(unitName = "MaweedPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DaysofweekFacade() {
        super(Daysofweek.class);
    }
    
}