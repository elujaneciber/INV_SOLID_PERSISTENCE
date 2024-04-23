/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package inventory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author nn
 */
public class TableInventory {

    private List<Product> listProducts;

    public TableInventory() {
        this.listProducts = new ArrayList<>();
    }

    public List<Product> getListProducts() {
        return this.listProducts;
    }

    public void addProduct(Product product) {
        this.listProducts.add(product);
    }

    public void deleteProduct(int id) {
        Iterator<Product> iterator = this.listProducts.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getId() == id) {
                iterator.remove();
                return;
            }
        }
    }

    public void updateProduct(int id, String newName, double newPrice, int newStock) {
        for (Product product : this.listProducts) {
            if (product.getId() == id) {
                product.setName(newName);
                product.setPrice(newPrice);
                product.setStock(newStock);
                return;
            }
        }
    }

    public boolean checkInventory(int id) {
        for (Product product : this.listProducts) {
            if (product.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public boolean checkInventory(String name) {
        for (Product product : this.listProducts) {
            String productName = product.getName();
            if (productName != null && productName.equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public int consecutiveId() {
        int id = 0;
        for (Product product : this.listProducts) {
            id = product.getId();
        }
        return id;
    }
}