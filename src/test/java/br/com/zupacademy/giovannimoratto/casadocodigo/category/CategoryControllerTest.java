package br.com.zupacademy.giovannimoratto.casadocodigo.category;

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
class CategoryControllerTest {

    /* Injections */
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    // Test Config
    private final String urlTemplate = "/categoria";

    /* Methods */
    // POST Request
    @Test
    @DisplayName("200 OK - Succeed and persist the Category in the Database")
    void createCategoryStatus200() throws Exception {
        // Values to Success Test
        CategoryRequest request = new CategoryRequest();
        request.setName("Sci-fi");
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
        CategoryRequest request = new CategoryRequest();
        request.setName("Horror");
        String jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders.post("/lol")       // <---------- FAIL
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
        CategoryRequest request = new CategoryRequest();
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
    void nameUniqueStatus400() throws Exception {
        // Values to Fail Test
        CategoryRequest request = new CategoryRequest();
        request.setName("Duplicated");       // <---------- FAIL
        String jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders.post(urlTemplate)
                .content(jsonRequest)
                .characterEncoding("UTF-8")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

}