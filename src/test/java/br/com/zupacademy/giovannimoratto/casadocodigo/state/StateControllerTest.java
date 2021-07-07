package br.com.zupacademy.giovannimoratto.casadocodigo.state;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @Author giovanni.moratto
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class StateControllerTest {

    /* Injections */
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    // Test Config
    private final String urlTemplate = "/estado";

    /* Methods */
    // POST Request
    @Test
    @DisplayName("200 OK - Succeed and persist the State in the Database")
    void createStateStatus200() throws Exception {
        // Values to Success Test
        StateRequest request = new StateRequest();
        request.setName("Quebec");
        request.setIdCountry(1L);
        String jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders.post(urlTemplate)
                .content(jsonRequest)
                .characterEncoding("UTF-8")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    // POST Request
    @Test
    @DisplayName("404 Not Found - When trying to POST with invalid ENDPOINT")
    void invalidEndpointStatus404() throws Exception {
        // Values to Success Test
        StateRequest request = new StateRequest();
        request.setName("Ontario");
        request.setIdCountry(1L);
        String jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders.post("/hello")       // <---------- FAIL
                .content(jsonRequest)
                .characterEncoding("UTF-8")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(404));
    }

    // POST Request
    @Test
    @DisplayName("400 Bad Request - When trying to POST with empty BODY")
    void emptyBodyStatus400() throws Exception {
        // Values to Fail Test
        String jsonRequest = "";       // <---------- FAIL

        mockMvc.perform(MockMvcRequestBuilders.post(urlTemplate)
                .content(jsonRequest)
                .characterEncoding("UTF-8")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    // POST Request
    @Test
    @DisplayName("400 Bad Request - When trying to POST with empty NAME")
    void nameEmptyStatus400() throws Exception {
        // Values to Fail Test
        StateRequest request = new StateRequest();
        request.setName("");       // <---------- FAIL
        request.setIdCountry(1L);
        String jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders.post(urlTemplate)
                .content(jsonRequest)
                .characterEncoding("UTF-8")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    // POST Request
    @Test
    @DisplayName("400 Bad Request - When trying to POST with a NAME already registered in the same COUNTRY")
    void nameUniqueForStateStatus400() throws Exception {
        // Values to Fail Test
        StateRequest request = new StateRequest();
        request.setName("Duplicated");       // <---------- FAIL
        request.setIdCountry(2L);
        String jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders.post(urlTemplate)
                .content(jsonRequest)
                .characterEncoding("UTF-8")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    // POST Request
    @Test
    @DisplayName("200 OK - When trying to POST with a NAME already registered but in different COUNTRY")
    void sameNameDifferentStateStatus200() throws Exception {
        // Values to Success Test
        StateRequest request = new StateRequest();
        request.setName("Duplicated");
        request.setIdCountry(1L);
        String jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders.post(urlTemplate)
                .content(jsonRequest)
                .characterEncoding("UTF-8")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    // POST Request
    @Test
    @DisplayName("400 Bad Request - When trying to POST with empty COUNTRY")
    void countryEmptyStatus400() throws Exception {
        // Values to Fail Test
        StateRequest request = new StateRequest();
        request.setName("São Paulo");
        request.setIdCountry(null);       // <---------- FAIL
        String jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders.post(urlTemplate)
                .content(jsonRequest)
                .characterEncoding("UTF-8")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

}
