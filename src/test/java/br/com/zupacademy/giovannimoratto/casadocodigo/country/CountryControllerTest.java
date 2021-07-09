package br.com.zupacademy.giovannimoratto.casadocodigo.country;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @Author giovanni.moratto
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class CountryControllerTest {

    /* Test Endpoint Config */
    private final String urlTemplate = "/pais";
    /* Injections */
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    /* Methods */
    // POST Request
    @Test
    @DisplayName("200 OK - Succeed and persist the Country in the Database")
    void createCountryStatus200() throws Exception {
        // Values to Success Test
        CountryRequest request = new CountryRequest();
        request.setName("Brazil");
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
        CountryRequest request = new CountryRequest();
        request.setName("Ireland");
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
        CountryRequest request = new CountryRequest();
        request.setName("");       // <---------- FAIL
        String jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders.post(urlTemplate)
                .content(jsonRequest)
                .characterEncoding("UTF-8")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    // POST Request
    @Test
    @DisplayName("400 Bad Request - When trying to POST with a NAME already registered")
    void nameNotUniqueStatus400() throws Exception {
        // Values to Fail Test
        CountryRequest request = new CountryRequest();
        request.setName("Duplicated");       // <---------- FAIL
        String jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders.post(urlTemplate)
                .content(jsonRequest)
                .characterEncoding("UTF-8")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

}