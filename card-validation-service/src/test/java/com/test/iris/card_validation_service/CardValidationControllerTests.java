package com.test.iris.card_validation_service;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.test.iris.card_validation_service.controller.CardValidationController;
import com.test.iris.card_validation_service.request.CardDetailsRequest;
import com.test.iris.card_validation_service.service.CardValidationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(CardValidationController.class)
@AutoConfigureMockMvc
class CardValidationControllerTests {

    //@Value("${test.bearer.token}")
    private String bearerToken ="eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyQDE0MDEiLCJpYXQiOjE3MzY4NDA4MzksImV4cCI6MTczNjg0MTEzOX0.rd5GXIMapl7iPIlF5mIxqblM8Yi0xxPIhbV7mQ0cexQ";

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private CardValidationController cardValidationController;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CardValidationService cardValidationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void testValidateCard_Success() throws Exception {
        String jsonRequest="{\n" +
                "  \"cardNumber\": \"414111111111111\",\n" +
                "  \"cardHolderName\": \"John Doe\",\n" +
                "  \"cardType\": \"VISA\",\n" +
                "  \"expirationMonth\": 12,\n" +
                "  \"expirationYear\": 2025,\n" +
                "  \"cvv\": \"123\",\n" +
                "  \"userId\": 156\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders.post("/validate-card")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization", bearerToken)
                        .content(objectMapper.writeValueAsString(jsonRequest)))
                .andExpect(status().isOk());
    }

    @Test
    void testValidateCard_InvalidRequest() throws Exception {
        CardDetailsRequest request = new CardDetailsRequest();
        // Set invalid request fields
        if (request.getCardNumber() == null) {
            request.setCardNumber("1234");
        }
        //when(cardValidationService.validateCard(request, bearerToken)).thenThrow(new IllegalArgumentException());

        mockMvc.perform(MockMvcRequestBuilders.post("/validate-card")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization", bearerToken)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testSaveCardofUser_Success() throws Exception {
       String JsonCardRequest="{\"cardNumber\":\"1234567890123456\",\"cardHolderName\":\"John Doe\",\"expiryDate\":\"12/2023\",\"cvv\":\"123\"}";

        mockMvc.perform(MockMvcRequestBuilders.post("/create-card")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization", bearerToken)
                        .content(objectMapper.writeValueAsString(JsonCardRequest)))
                .andExpect(status().isOk());
    }

    @Test
    void testGetCardByUserId_Success() throws Exception {
        Long userId = 152L;

       // when(cardValidationService.getCardByuserId(userId)).thenReturn(ResponseEntity.ok(null));

        mockMvc.perform(MockMvcRequestBuilders.get("/userId/{userId}", userId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void testUpdateCardByUserId_Success() throws Exception {
        Long userId = 152L;
        String jsonRequest="{\n" +
                "  \"cardNumber\": \"414111111111111\",\n" +
                "  \"cardHolderName\": \"John Doe\",\n" +
                "  \"cardType\": \"VISA\",\n" +
                "  \"expirationMonth\": 12,\n" +
                "  \"expirationYear\": 2025,\n" +
                "  \"cvv\": \"123\",\n" +
                "  \"userId\": 156\n" +
                "}";
        // Set request fields

     //   CardDetailsResponse response = new CardDetailsResponse();
        // Set response fields

        //when(cardValidationService.updateCardByUserId(userId, request)).thenReturn(ResponseEntity.ok(response));

        mockMvc.perform(MockMvcRequestBuilders.put("/userId/{userId}", userId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(jsonRequest)))
                .andExpect(status().isOk());
    }

    @Test
    void testDeleteCardByUserId_Success() throws Exception {
        Long userId = 156L;


        mockMvc.perform(MockMvcRequestBuilders.delete("/userId/{userId}", userId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void testGetAllCardDetails_Success() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


}