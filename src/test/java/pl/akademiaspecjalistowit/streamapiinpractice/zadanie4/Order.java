package pl.akademiaspecjalistowit.streamapiinpractice.zadanie4;

import java.util.List;

class Order {
    private List<Product> products;
    private String status;

    public Order(List<Product> products, String status) {
        this.products = products;
        this.status = status;
    }

    public List<Product> getProducts() {
        return products;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Order{" +
            "products=" + products +
            ", status='" + status + '\'' +
            '}';
    }
}