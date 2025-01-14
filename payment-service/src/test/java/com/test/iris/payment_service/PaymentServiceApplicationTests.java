package com.test.iris.payment_service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.iris.payment_service.controller.PaymentGatewayController;
import com.test.iris.payment_service.service.PaymentService;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PaymentGatewayController.class)
@AutoConfigureMockMvc
class PaymentGatewayControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@InjectMocks
	private PaymentGatewayController paymentGatewayController;

	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private PaymentService paymentGatewayService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testProcessPayment_Success() throws Exception {
	String jsonRequest= "{\n" +
			"  \"orderId\": 2002,\n" +
			"  \"userId\": 405,\n" +
			"  \"amount\": 45.5,\n" +
			"  \"paymentGateway\": \"Gateway\",\n" +
			"  \"paymentMethod\": \"CARD\",\n" +
			"  \"cardDetailsRequest\" :\n" +
			"  {\n" +
			"  \"cardNumber\": \"4111111111111111\",\n" +
			"  \"cardHolderName\": \"John Doe\",\n" +
			"  \"cardType\": \"VISA\",\n" +
			"  \"expirationMonth\": 12,\n" +
			"  \"expirationYear\": 2025,\n" +
			"  \"cvv\": \"123\",\n" +
			"  \"userId\": 156\n" +
			"}\n" +
			"}";
		// Set request fields

		//when(paymentGatewayService.processPayment(request)).thenReturn(ResponseEntity.ok(null));

		mockMvc.perform(MockMvcRequestBuilders.post("/createPayment")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(jsonRequest)))
				.andExpect(status().isOk());
	}

	@Test
	void testGetPaymentStatus_Success() throws Exception {
		Long paymentId = 3072526426075566420L;
		Long userId= 196L;

		//when(paymentGatewayService.getPaymentStatus(paymentId)).thenReturn(ResponseEntity.ok(null));

		mockMvc.perform(MockMvcRequestBuilders.get("/getPaymentById/paymentId/{paymentId}/userId/{userId}", paymentId,userId)
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	void testCancelPayment_Success() throws Exception {
		Long paymentId = 3072526426075566420L;

		mockMvc.perform(MockMvcRequestBuilders.delete("/cancel-payment/{paymentId}", paymentId)
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
}