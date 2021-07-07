package br.com.zupacademy.giovannimoratto.casadocodigo.author;

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
class AuthorControllerTest {

    /* Injections */
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    // Test Config
    private final String urlTemplate = "/autor";

    /* Methods */
    // POST Request
    @Test
    @DisplayName("200 OK - Succeed and persist the Author in the Database")
    void createAuthorStatus200() throws Exception {
        // Values to Success Test
        AuthorRequest request = new AuthorRequest();
        request.setName("Fulano de Tal");
        request.setEmail("fulano@email.com");
        request.setDescription("bla bla bla");
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
        AuthorRequest request = new AuthorRequest();
        request.setName("Goku");
        request.setEmail("goku@email.com");
        request.setDescription("bla bla bla");
        String jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders.post("/playstation")       // <---------- FAIL
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
        AuthorRequest request = new AuthorRequest();
        request.setName("");       // <---------- FAIL
        request.setEmail("test01@email.com");
        request.setDescription("test01");
        String jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders.post(urlTemplate)
                .content(jsonRequest)
                .characterEncoding("UTF-8")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    // POST Request
    @Test
    @DisplayName("400 Bad Request - When trying to POST with empty EMAIL")
    void emailEmptyStatus400() throws Exception {
        // Values to Fail Test
        AuthorRequest request = new AuthorRequest();
        request.setName("test02");
        request.setEmail("");       // <---------- FAIL
        request.setDescription("test02");
        String jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders.post(urlTemplate)
                .content(jsonRequest)
                .characterEncoding("UTF-8")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    // POST Request
    @Test
    @DisplayName("400 Bad Request - When trying to POST with an invalid format EMAIL")
    void emailFormatStatus400() throws Exception {
        // Values to Fail Test
        AuthorRequest request = new AuthorRequest();
        request.setName("test03");
        request.setEmail("sgfasgagagaa");       // <---------- FAIL
        request.setDescription("test03");
        String jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders.post(urlTemplate)
                .content(jsonRequest)
                .characterEncoding("UTF-8")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    // POST Request
    @Test
    @DisplayName("400 Bad Request - When trying to POST with an EMAIL already registered")
    void emailUniqueStatus400() throws Exception {
        // Values to Fail Test
        AuthorRequest request = new AuthorRequest();
        request.setName("test04");
        request.setEmail("duplicate_email@email.com");       // <---------- FAIL
        request.setDescription("test04");
        String jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders.post(urlTemplate)
                .content(jsonRequest)
                .characterEncoding("UTF-8")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    // POST Request
    @Test
    @DisplayName("400 Bad Request - When trying to POST with empty DESCRIPTION")
    void descriptionEmptyStatus400() throws Exception {
        // Values to Fail Test
        AuthorRequest request = new AuthorRequest();
        request.setName("test05");
        request.setEmail("test05@email.com");
        request.setDescription("");       // <---------- FAIL
        String jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders.post(urlTemplate)
                .content(jsonRequest)
                .characterEncoding("UTF-8")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    // POST Request
    @Test
    @DisplayName("400 Bad Request - When trying to POST with a DESCRIPTION longer than 400 characters")
    void descriptionSizeStatus400() throws Exception {
        // Values to Fail Test
        AuthorRequest request = new AuthorRequest();
        request.setName("test06");
        request.setEmail("test06@email.com");
        request.setDescription("a".repeat(401));       // <---------- FAIL
        String jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders.post(urlTemplate)
                .content(jsonRequest)
                .characterEncoding("UTF-8")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

}