package br.com.zupacademy.giovannimoratto.casadocodigo.author;

import java.net.URI;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureDataJpa
@ActiveProfiles("test")
class AuthorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
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
    void emailUniqueStatus400() throws Exception {
        URI uri = new URI("/novo-autor");
        String json = "{"
                + "\"name\":\"J.R.R. Tolkien\","
                + "\"email\":\"autor01@email.com\","
                + "\"description\":\"error\""
                + "}";

        mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .content(json).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
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
    void descriptionSizeStatus400() throws Exception {
        URI uri = new URI("/novo-autor");
        String json = "{"
                + "\"name\":\"J.R.R. Tolkien\","
                + "\"email\":\"fail_3@email.com\","
                + "\"description\":\"zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz" +
                "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz" +
                "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz" +
                "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz" +
                "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz\""
                + "}";

        mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .content(json).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

}
