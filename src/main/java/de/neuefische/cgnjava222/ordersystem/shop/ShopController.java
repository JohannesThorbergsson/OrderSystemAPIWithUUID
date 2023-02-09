package de.neuefische.cgnjava222.ordersystem.shop;

import de.neuefische.cgnjava222.ordersystem.shop.order.Order;
import de.neuefische.cgnjava222.ordersystem.shop.order.OrderRepo;
import de.neuefische.cgnjava222.ordersystem.shop.product.Product;
import de.neuefische.cgnjava222.ordersystem.shop.product.ProductRepo;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class ShopController {
    ShopService testService;

    public ShopController(ShopService testService) {
        this.testService = testService;
    }

    @GetMapping("/products")
    public List<Product> getProducts (){
        return testService.listProducts();
    }
    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable int id) {
        return testService.getProduct(id);
    }
    @GetMapping ("/orders")
    public List<Order> getOrders() {
        return testService.listOrders();
    }
    @GetMapping("/orders/{id}")
    public Order getOrder(@PathVariable int id){
        return testService.getOrder(id);
    }
    @PostMapping("/orders/{id}")
    public List<Order> postOrders (@RequestBody int[] orderArray, @PathVariable int id){
        Integer[] orders = Arrays.stream(orderArray).boxed().toArray(Integer[]::new);
        testService.addOrder(id, new ArrayList<>(List.of(orders)));
        return testService.listOrders();
    }
}
