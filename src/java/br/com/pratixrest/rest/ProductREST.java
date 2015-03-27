/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pratixrest.rest;


import br.com.pratix.service.interfaces.ProductService;
import br.com.pratix.service.ProductServiceImpl;
import br.com.pratixrest.model.Product;
import com.google.gson.Gson;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("product")
public class ProductREST {

    ProductService  productService  ;
    /**
     * Creates a new instance of ProductREST
     */
    public ProductREST() {
        init();        
    }

    /**
     * Retrieves representation of an instance of br.com.pratixrest.rest.ProductREST
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {       
        return new Gson().toJson(productService.getListProduct());        
    }

    /**
     * PUT method for updating or creating an instance of ProductREST
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Path("{id}")
    @Consumes({ "application/json"})
    public void putJson(@PathParam("id") Integer id, Product product) {
        
        try {
            product.setId(id);
            productService.udpateProduct(product);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in update ProductREST \n " + e.getMessage()  );
        }        
        
    }
    
    @POST    
    @Consumes({"application/json"})
    public void create(Product product) {

        try {
            productService.saveProduct(product);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in create ProductREST \n " + e.getMessage()  );
        }
                
    }    

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        
        System.out.println("Delete product params : " + id);
        
        try {
            productService.deleteProduct(id);
        } catch (Exception e) {
            System.out.println("Error in delete product ");
            e.printStackTrace();
        }
    }
    
    
    private void init() {
        productService  = new ProductServiceImpl();
    }
    
}
