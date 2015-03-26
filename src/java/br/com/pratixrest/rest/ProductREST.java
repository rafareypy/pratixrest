/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pratixrest.rest;

import br.com.pratix.service.ProductServiceImpl;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

import br.com.pratix.service.interfaces.ProductService;
import br.com.pratix.service.ProductServiceImpl;
import br.com.pratixrest.model.Product;
import com.google.gson.Gson;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;

@Path("product")
public class ProductREST {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ProductREST
     */
    public ProductREST() {
    }

    /**
     * Retrieves representation of an instance of br.com.pratixrest.rest.ProductREST
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
            //ProductService productService = new ProductServiceImpl();
        ProductService  productService  = new ProductServiceImpl();
        
                Product product = new Product();
            product.setName("product test");


            productService.saveProduct(product);

        
            return new Gson().toJson(productService.getListProduct());
        
         // return new Gson().toJson(new Product());
            

            

    }

    /**
     * PUT method for updating or creating an instance of ProductREST
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
    
    @POST
    @Consumes("application/json")
    public void postJson(String content) {
        System.out.println("Creating Product to APi");
        
        System.out.println("Creating Product to APi");
        
        
        
        System.out.println(content);
        
        ProductService  productService  = new ProductServiceImpl();
        
        Product product = new Product();
        product.setName("product test");
        
        
        productService.saveProduct(product);
        
        
        
        
        
        
    }

    
    
}
