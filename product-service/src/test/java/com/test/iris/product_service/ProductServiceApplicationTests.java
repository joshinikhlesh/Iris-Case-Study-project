package com.test.iris.product_service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class ProductServiceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testGetAllProducts() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/getAllProducts"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void testGetProductById() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/getProductByProductId/productId/{productId}", 779))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void testCreateProduct() throws Exception {
		String newProductJson = "{\n" +
				"        \"productId\" :779,\n" +
				"        \"name\": \"Bluetooth-ds \",\n" +
				"        \"description\": \" Bluetooth\",\n" +
				"        \"price\": 250,\n" +
				"        \"category\": \"Accessiories\",\n" +
				"        \"quantity\": 200\n" +
				"    }";
		mockMvc.perform(MockMvcRequestBuilders.post("/addProduct")
						.contentType("application/json")
						.content(newProductJson))
				.andExpect(MockMvcResultMatchers.status().isCreated());
	}

	@Test
	public void testUpdateProduct() throws Exception {
		String updatedProductJson = "{       \n" +
				"\n" +
				"        \"name\": \"Bluetooth Speaker\",\n" +
				"        \"description\": \"Portable Bluetooth speaker with 10 hours battery\",\n" +
				"        \"price\": 252,\n" +
				"        \"category\": \"Audio\",\n" +
				"        \"quantity\": 50\n" +
				"    }";
		mockMvc.perform(MockMvcRequestBuilders.put("/updateProduct/productId/{productId}", 779)
						.contentType("application/json")
						.content(updatedProductJson))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void testDeleteProduct() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/deleteProduct/productId/{productId}", 779))
				.andExpect(MockMvcResultMatchers.status().isNoContent());
	}

}
