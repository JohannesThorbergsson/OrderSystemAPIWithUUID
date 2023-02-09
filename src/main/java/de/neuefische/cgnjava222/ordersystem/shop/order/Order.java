package de.neuefische.cgnjava222.ordersystem.shop.order;

import de.neuefische.cgnjava222.ordersystem.shop.product.Product;

import java.util.List;

public record Order(
        int id,
        List<Product> products
) {
}
