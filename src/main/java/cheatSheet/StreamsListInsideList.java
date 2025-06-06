package cheatSheet;


import java.util.*;
import java.util.stream.*;

public class StreamsListInsideList {

    public static void main(String[] args) {
        // Sample data
        List<Store> stores = Arrays.asList(
                new Store("Store 1", Arrays.asList(
                        new Products("Laptop", "Electronics", 900),
                        new Products("Phone", "Electronics", 600),
                        new Products("Shirt", "Clothing", 50))),
                new Store("Store 2", Arrays.asList(
                        new Products("TV", "Electronics", 1500),
                        new Products("Fridge", "Appliances", 1200))),
                new Store("Store 3", Arrays.asList(
                        new Products("Pants", "Clothing", 80),
                        new Products("Washing Machine", "Appliances", 800),
                        new Products("Watch", "Accessories", 200)))
        );


        // Need to get Store whse product price is above 1000


        List<Store> collect = stores.stream().filter(store -> store.getProducts().stream().anyMatch(
                products -> products.getPrice() >= 1000
        )).collect(Collectors.toList());

        collect.forEach(System.out::println);
    }
}

class Store {
    private String name;
    private List<Products> products;

    public Store(String name, List<Products> products) {
        this.name = name;
        this.products = products;
    }

    public List<Products> getProducts() {
        return products;
    }
}

class Products {
    private String name;
    private String category;
    private double price;

    public Products(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }
}

