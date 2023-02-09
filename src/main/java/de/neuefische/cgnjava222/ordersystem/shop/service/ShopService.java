package de.neuefische.cgnjava222.ordersystem.shop.service;

import de.neuefische.cgnjava222.ordersystem.shop.order.Order;
import de.neuefische.cgnjava222.ordersystem.shop.order.OrderRepo;
import de.neuefische.cgnjava222.ordersystem.shop.product.Product;
import de.neuefische.cgnjava222.ordersystem.shop.product.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShopService {
    private final ProductRepo productRepo;
    private final OrderRepo orderRepo;
    private final IDService idService;

    public ShopService(
            ProductRepo productRepo,
            OrderRepo orderRepo, IDService idService) {
        this.productRepo = productRepo;
        this.orderRepo = orderRepo;
        this.idService = idService;
    }

    public Product getProduct(int id) {
        return productRepo.getProduct(id);
    }

    public List<Product> listProducts() {
        return productRepo.listProducts();
    }

    public void addOrder( List<Integer> productIds) {
        List<Product> products = new ArrayList<>();
        for (int productId : productIds) {
            Product product = productRepo.getProduct(productId);
            products.add(product);
        }
        Order order = new Order(idService.generateID(), products);
        orderRepo.addOrder(order);

    }

    public Order getOrder(int orderId) {
        return orderRepo.getOrder(orderId);
    }

    public List<Order> listOrders() {
        return orderRepo.listOrders();
    }
}
