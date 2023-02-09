package de.neuefische.cgnjava222.ordersystem;

import de.neuefische.cgnjava222.ordersystem.shop.ShopController;
import de.neuefische.cgnjava222.ordersystem.shop.service.IDService;
import de.neuefische.cgnjava222.ordersystem.shop.service.ShopService;
import de.neuefische.cgnjava222.ordersystem.shop.order.Order;
import de.neuefische.cgnjava222.ordersystem.shop.order.OrderRepo;
import de.neuefische.cgnjava222.ordersystem.shop.product.Product;
import de.neuefische.cgnjava222.ordersystem.shop.product.ProductRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
       /* ProductRepo productRepo = new ProductRepo();
        OrderRepo orderRepo = new OrderRepo();
        ShopService shopService = new ShopService(productRepo, orderRepo, new IDService());

        Product product = shopService.getProduct(3);
        System.out.println(product);

        List<Product> products = shopService.listProducts();
        System.out.println(products);

        shopService.addOrder(List.of(2,3));
        shopService.addOrder(List.of(1));


        System.out.println(order);

        List<Order> orders = shopService.listOrders();
        System.out.println(orders);
        ShopController shpContr = new ShopController();*/
    }
}
