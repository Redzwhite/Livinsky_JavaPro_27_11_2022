package org.example.homework32;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class Cart {
    private List<Product> products;

    public Cart() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProductById(int id) {
        products.removeIf(p -> p.getId() == id);
    }

    public List<Product> getProducts() {
        return products;
    }
}
