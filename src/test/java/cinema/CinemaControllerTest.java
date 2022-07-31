package cinema;

import cinema.controller.CinemaController;
import cinema.model.Cinema;
import cinema.services.CinemaService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CinemaControllerTest {
    @MockBean
    private CinemaService service;
    @Autowired
    private MockMvc mockMvc;
    @InjectMocks
    private CinemaController cinemaController;

    @Test
    @DisplayName("Get available seats")
    void getAvailableSeatsTest() throws Exception {
        when(service.showCinema()).thenReturn(Cinema.getInstance());
        mockMvc.perform(MockMvcRequestBuilders.get("/seats"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.total_rows", is(9)))
                .andExpect(jsonPath("$.total_columns", is(9)))
                .andExpect(jsonPath("$.available_seats", hasSize(81)));
    }

//    @Test
//    @DisplayName("Get stats passing password with no sales")
//    void getStats() throws Exception {
//        mockMvc = MockMvcBuilders.standaloneSetup(cinemaController).build();
//        mockMvc.perform(MockMvcRequestBuilders.get("/stats?password=super_secret"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.current_income", is(0)))
//                .andExpect(jsonPath("$.number_of_available_seats", is(81)))
//                .andExpect(jsonPath("$.number_of_purchased_tickets", is(0)));
//    }
}
