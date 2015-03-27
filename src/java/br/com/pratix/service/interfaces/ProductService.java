/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pratix.service.interfaces;

import br.com.pratixrest.model.Product;
import java.util.List;

/**
 *
 * @author pontocom
 */
public interface ProductService {
    
    public Product saveProduct(Product product);
    public Product udpateProduct(Product product);
    public Boolean deleteProduct(Product product);
    public Boolean deleteProduct(Integer id);
    public Product getProduct(Product product);
    public Product getProduct(Integer id);
    public List<Product> getListProduct();
    public List<Product> getListProductByName(String name);
    
}
