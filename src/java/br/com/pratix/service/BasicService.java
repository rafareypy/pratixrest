/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pratix.service;



import br.com.pratixrest.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

public class BasicService  implements java.io.Serializable {
    
    private static final long serialVersionUID = 2L;
     
    @PersistenceContext(unitName = "pratixPU")
    private EntityManager em;
    
    
    public BasicService() 
    {
        
    }
        
    public EntityManager getEm() {
        if(em == null )
            em = JPAUtil.getEntityManager();
        return em;
    }
    public <T> List<T> getList(Class<T> classToCast,String query,Object... values) {
        Query qr = createQuery(query, values);
        return qr.getResultList();
    }
    private Query createQuery(String query, Object[] values) {
        Query qr = em.createQuery(query);
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                Object object = values[i];
                qr.setParameter(i + 1, object);
            }
    }
    return qr;
}
    
    public void sysou(String message){
        System.out.println(" \n " + message );
    }
    
}
