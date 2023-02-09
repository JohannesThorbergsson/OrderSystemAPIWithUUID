package de.neuefische.cgnjava222.ordersystem.shop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ShopControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DirtiesContext
    void postOrders() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/orders")
                .contentType(MediaType.APPLICATION_JSON)
                .content("[1,2]"))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                [
                    {
                        "products": [
                            {
                                "id": 1,
                                "name": "Apfel"
                            },
                            {
                                "id": 2,
                                "name": "Banane"
                            }
                        ]
                    }
                ]
                """))
                .andExpect(jsonPath("$.id").isNotEmpty());

    }
}