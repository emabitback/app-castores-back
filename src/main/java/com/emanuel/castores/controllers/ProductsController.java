package com.emanuel.castores.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.web.bind.annotation.*;
import com.emanuel.castores.entity.Products;
import com.emanuel.castores.services.ProductService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://192.168.0.4:3000",})
public class ProductsController {

    @Autowired
    ProductService productService;
    @Autowired
    private EntityManager entityManager;

    @PostMapping(value = "/product/add", produces = "application/json")
    public ResponseEntity<Object> addProduct(@RequestBody Products p) {
        productService.addProduct(p);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("success", true);
        map.put("message", "producto creado correctamente");

        return new ResponseEntity<Object>(map, HttpStatus.OK);
    }

    @PostMapping("/product/list")
    public List<Products> getALl() {
        return productService.getALlProducts();
    }


    @GetMapping("/product/{idProduct}/{id}")
    @Transactional
    public ResponseEntity<Object> changeStatus(@PathVariable("idProduct") Integer idProduct, @PathVariable("id") Integer status) {
        System.out.println("Product: " + idProduct);
        System.out.println(" Status: " + status);
        if (status == 1) {
            status = 0;
        } else {
            status = 1;
        }
        System.out.println("set Status: " + status);
        String sql = "UPDATE products SET status = :status  WHERE id_product = :idProduct";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("idProduct", idProduct);
        query.setParameter("status", status);
        int result = query.executeUpdate();
        //return "Result: " + query.executeUpdate();

        Map<String, Object> map = new HashMap<String, Object>();

        if (result != 1 ) {
            map.put("success", false);
            map.put("message", "Ocurrio un error al actualizar el status del producto");
            return new ResponseEntity<Object>(map, HttpStatus.BAD_REQUEST);
        }

        map.put("success", true);
        map.put("message", "operacion exitosa");
        return new ResponseEntity<Object>(map, HttpStatus.OK);
    }
}
