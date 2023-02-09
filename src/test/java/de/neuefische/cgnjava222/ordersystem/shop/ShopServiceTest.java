package de.neuefische.cgnjava222.ordersystem.shop;

import de.neuefische.cgnjava222.ordersystem.shop.order.Order;
import de.neuefische.cgnjava222.ordersystem.shop.order.OrderRepo;
import de.neuefische.cgnjava222.ordersystem.shop.product.Product;
import de.neuefische.cgnjava222.ordersystem.shop.product.ProductRepo;
import de.neuefische.cgnjava222.ordersystem.shop.service.IDService;
import de.neuefische.cgnjava222.ordersystem.shop.service.ShopService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;

class ShopServiceTest {

    @Test
    void getProduct() {
        //given
        ProductRepo productRepo = new ProductRepo();
        OrderRepo orderRepo = new OrderRepo();
        IDService idService = new IDService();
        ShopService shopService = new ShopService(productRepo, orderRepo, idService);

        //when
        Product actual = shopService.getProduct(2);

        //then
        assertThat(actual).isEqualTo(new Product(2, "Banane"));
    }

    @Test
    void listProducts() {
        //given
        ProductRepo productRepo = new ProductRepo();
        OrderRepo orderRepo = new OrderRepo();
        IDService idService = new IDService();
        ShopService shopService = new ShopService(productRepo, orderRepo, idService);

        //when
        List<Product> actual = shopService.listProducts();

        //then
        List<Product> expected = List.of(
                new Product(1, "Apfel"),
                new Product(2, "Banane"),
                new Product(3, "Zitrone"),
                new Product(4, "Mandarine")
        );
        assertThat(actual)
                .hasSameElementsAs(expected)
                .hasSize(expected.size());
    }

    @Test
    void addAndGetOrder() {
        //given
        ProductRepo productRepo = new ProductRepo();
        OrderRepo orderRepo = new OrderRepo();
        IDService idService = new IDService();
        ShopService shopService = new ShopService(productRepo, orderRepo, idService);

        //when
        shopService.addOrder(List.of(1, 3, 4));
        Order actual = shopService.getOrder(106);

        //then TODO: Mock Order
//        assertThat(actual)
//                .isEqualTo(
//                        new Order(  idService.generateID(), List.of(
//                                        new Product(1, "Apfel"),
//                                        new Product(3, "Zitrone"),
//                                        new Product(4, "Mandarine")
//                                )
//                        )
//                );
    }

    @Test
    void addAndListOrders() { //TODO: Mock Order
        //given
        ProductRepo productRepo = new ProductRepo();
        OrderRepo orderRepo = new OrderRepo();
        IDService idService = new IDService();
        ShopService shopService = new ShopService(productRepo, orderRepo, idService);

//        //when
//        shopService.addOrder(List.of(1, 3, 4));
//        List<Order> actual = shopService.listOrders();
//
//        //then
//        List<Order> expected = List.of(
//                new Order(
//                        106,
//                        List.of(
//                                new Product(1, "Apfel"),
//                                new Product(3, "Zitrone"),
//                                new Product(4, "Mandarine")
//                        )
//                )
//        );
//        assertThat(actual)
//                .hasSameElementsAs(expected)
//                .hasSize(expected.size());
    }

    @Test
    void expectExceptionWhenReferencingNonexistingProduct() {
        //given
        ProductRepo productRepo = new ProductRepo();
        OrderRepo orderRepo = new OrderRepo();
        IDService idService = new IDService();
        ShopService shopService = new ShopService(productRepo, orderRepo, idService);

        //when
        try {
            shopService.addOrder( List.of(999));
            Assertions.fail("Expected exception was not thrown");
        } catch (NoSuchElementException e) {
            // perfect, exception was thrown
        }
    }
}
