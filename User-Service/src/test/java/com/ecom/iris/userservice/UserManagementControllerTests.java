package com.ecom.iris.userservice;

import com.ecom.iris.userservice.controller.UserManagementController;
import com.ecom.iris.userservice.service.UsersService;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(UserManagementController.class)
@AutoConfigureMockMvc
public class UserManagementControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UsersService userService;

//	private User user;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		//user = new User(1L, "John", "Doe", "john.doe@example.com");
	}

	@Test
	void testGetUserById() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/userId/{userId}"))
				.andExpect(status().isOk());
	}

	@Test
	void testCreateUser() throws Exception {


		mockMvc.perform(MockMvcRequestBuilders.post("/users")
						.contentType(MediaType.APPLICATION_JSON)
						.content("{\"firstName\": \"John\", \"lastName\": \"Doe\", \"email\": \"john.doe@example.com\"}"))
				.andExpect(status().isCreated());
	}

	@Test
	void testUpdateUser() throws Exception {
	//when(userService.updateUser(1L, user)).thenReturn(user);

		mockMvc.perform(MockMvcRequestBuilders.put("/userId/{userId}",502L)
						.contentType(MediaType.APPLICATION_JSON)
						.content("{\"firstName\": \"John\", \"lastName\": \"Doe\", \"email\": \"john.doe@example.com\"}"))
				.andExpect(status().isOk());
	}

	@Test
	void testDeleteUser() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("userId/{userId}",452L))
				.andExpect(status().isNoContent());
	}
}
