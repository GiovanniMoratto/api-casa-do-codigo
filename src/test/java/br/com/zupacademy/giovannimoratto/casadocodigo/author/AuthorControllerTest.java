package br.com.zupacademy.giovannimoratto.casadocodigo.author;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;

/**
 * @Author giovanni.moratto
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AuthorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Order(1)
    void createAuthorStatus200() throws Exception {
        URI uri = new URI("/novo-autor");
        String json = "{"
                + "\"name\":\"J.R.R. Tolkien\","
                + "\"email\":\"tolien@email.com\","
                + "\"description\":\"ok\""
                + "}";

        mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .content(json).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @Test
    @Order(2)
    void nameEmptyStatus400() throws Exception {
        URI uri = new URI("/novo-autor");
        String json = "{"
                + "\"name\":\"\","
                + "\"email\":\"fail_1@email.com\","
                + "\"description\":\"error\""
                + "}";

        mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .content(json).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    @Order(3)
    void emailEmptyStatus400() throws Exception {
        URI uri = new URI("/novo-autor");
        String json = "{"
                + "\"name\":\"J.R.R. Tolkien\","
                + "\"email\":\"\","
                + "\"description\":\"error\""
                + "}";

        mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .content(json).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    @Order(4)
    void emailFormatStatus400() throws Exception {
        URI uri = new URI("/novo-autor");
        String json = "{"
                + "\"name\":\"J.R.R. Tolkien\","
                + "\"email\":\"afagagagagag\","
                + "\"description\":\"error\""
                + "}";

        mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .content(json).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    @Order(5)
    void emailUniqueStatus400() throws Exception {
        URI uri = new URI("/novo-autor");
        String json = "{"
                + "\"name\":\"J.R.R. Tolkien\","
                + "\"email\":\"email_repetido@email.com\","
                + "\"description\":\"error\""
                + "}";

        mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .content(json).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    @Order(6)
    void descriptionEmptyStatus400() throws Exception {
        URI uri = new URI("/novo-autor");
        String json = "{"
                + "\"name\":\"J.R.R. Tolkien\","
                + "\"email\":\"fail_2@email.com\","
                + "\"description\":\"\""
                + "}";

        mockMvc.perform(MockMvcRequestBuilders.post(uri).content(json)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    @Order(7)
    void descriptionSizeStatus400() throws Exception {
        URI uri = new URI("/novo-autor");
        String text = "a".repeat(401);
        String json = "{"
                + "\"name\":\"J.R.R. Tolkien\","
                + "\"email\":\"fail_3@email.com\","
                + "\"description\":text\""
                + "}";

        mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .content(json).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

}
