/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pratix.service;

import br.com.pratixrest.model.* ;
import br.com.pratix.service.interfaces.ProductService;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


@Stateless
public class ProductServiceImpl extends BasicService implements ProductService, Serializable{
    
    @Override
    public Product saveProduct(Product product) {
        
        
        getEm().getTransaction().begin();
        getEm().persist(product);
        getEm().getTransaction().commit();
        
//        System.out.println("Save product to ProductService");
//        
//        EntityManagerFactory  emf = Persistence.createEntityManagerFactory("pratixPU");
//        EntityManager  em = emf.createEntityManager();
//        
//        System.out.println("Save product to ProductService");
//        
//        try {
//            
//            em.getTransaction().begin();
//            em.persist(product);
//            em.getTransaction().commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//            
//        }finally{
//            em.close();
//            emf.close();
//        }
        
        
        
        return product ;
        
    }
    @Override
    public Product udpateProduct(Product product) {
        return new Product();
    }
    @Override
    public Boolean deleteProduct(Product product) {
        return true ;
    }
    @Override
    public Product getProduct(Product product) {
        return getEm().find(Product.class, product.getId());
    }
    @Override
    public Product getProduct(Integer id) {
        return getEm().find(Product.class, id);
    }
    @Override
    public List<Product> getListProduct() {
        return getEm().createQuery("from Product").getResultList();
    }
    @Override
    public List<Product> getListProductByName(String name) {
        return getEm().createQuery("from Product ").getResultList();
    }

    
}
