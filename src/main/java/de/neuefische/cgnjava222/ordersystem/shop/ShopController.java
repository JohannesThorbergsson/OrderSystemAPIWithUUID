package de.neuefische.cgnjava222.ordersystem.shop;

import de.neuefische.cgnjava222.ordersystem.shop.order.Order;
import de.neuefische.cgnjava222.ordersystem.shop.product.Product;
import de.neuefische.cgnjava222.ordersystem.shop.service.ShopService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class ShopController {
    private final ShopService testService;

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

    @PostMapping("/orders")
    public List<Order> postOrders (@RequestBody int[] orderArray){
        Integer[] orders = Arrays.stream(orderArray).boxed().toArray(Integer[]::new);
        testService.addOrder(new ArrayList<>(List.of(orders)));
        return testService.listOrders();
    }
}
