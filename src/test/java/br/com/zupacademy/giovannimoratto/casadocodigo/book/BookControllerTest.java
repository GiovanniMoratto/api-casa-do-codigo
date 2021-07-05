package br.com.zupacademy.giovannimoratto.casadocodigo.book;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
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
class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void createBookStatus200() throws Exception {
        URI uri = new URI("/livro");
        String json = "{" +
                "\"title\":\"O Senhor dos Anéis\"," +
                "\"overview\":\"aaaaaaaaaaaaaaaaaaaaaa\"," +
                "\"summary\":\"aaaaaaaaaaaaaaaaaa\"," +
                "\"price\":50," +
                "\"numberOfPages\":500," +
                "\"isbn\":\"aaaaaaaaaaa\"," +
                "\"publicationDate\":\"12-12-2021\"," +
                "\"idCategory\":1," +
                "\"idAuthor\":1" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .content(json)
                .characterEncoding("UTF-8")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }
    /*
    @Test
    @Order(2)
    void titleEmptyStatus400() throws Exception {
        URI uri = new URI("/novo-livro");
        String json = "{"
                + "\"title\":\"\","
                + "\"overview\":\"aaaaaaaaaaaaaaaaaaaaaa\","
                + "\"summary\":\"aaaaaaaaaaaaaaaaaa\","
                + "\"price\":50,"
                + "\"numberOfPages\":500,"
                + "\"isbn\":\"xx\","
                + "\"publicationDate\":\"12-12-2021\","
                + "\"idCategory\":1,"
                + "\"idAuthor\":1"
                + "}";

        mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .content(json).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    @Order(3)
    void titleUniqueStatus400() throws Exception {
        URI uri = new URI("/novo-livro");
        String json = "{"
                + "\"title\":\"titulo duplicado\","
                + "\"overview\":\"aaaaaaaaaaaaaaaaaaaaaa\","
                + "\"summary\":\"aaaaaaaaaaaaaaaaaa\","
                + "\"price\":50,"
                + "\"numberOfPages\":500,"
                + "\"isbn\":\"xxx\","
                + "\"publicationDate\":\"12-12-2021\","
                + "\"idCategory\":1,"
                + "\"idAuthor\":1"
                + "}";

        mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .content(json).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    @Order(4)
    void overviewEmptyStatus400() throws Exception {
        URI uri = new URI("/novo-livro");
        String json = "{"
                + "\"title\":\"teste02\","
                + "\"overview\":\"\","
                + "\"summary\":\"aaaaaaaaaaaaaaaaaa\","
                + "\"price\":50,"
                + "\"numberOfPages\":500,"
                + "\"isbn\":\"xxxx\","
                + "\"publicationDate\":\"12-12-2021\","
                + "\"idCategory\":1,"
                + "\"idAuthor\":1"
                + "}";

        mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .content(json).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    @Order(5)
    void overviewSizeStatus400() throws Exception {
        URI uri = new URI("/novo-livro");
        String overview = "z".repeat(0);
        String json = "{"
                + "\"title\":\"teste03\","
                + "\"overview\":overview,"
                + "\"summary\":\"aaaaaaaaaaaaaaaaaa\","
                + "\"price\":50,"
                + "\"numberOfPages\":500,"
                + "\"isbn\":\"xxxxx\","
                + "\"publicationDate\":\"12-12-2021\","
                + "\"idCategory\":1,"
                + "\"idAuthor\":1"
                + "}";

        mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .content(json).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    @Order(6)
    void priceNullStatus400() throws Exception {
        URI uri = new URI("/novo-livro");
        String json = "{"
                + "\"title\":\"teste04\","
                + "\"overview\":\"casasfsaas\","
                + "\"summary\":\"aaaaaaaaaaaaaaaaaa\","
                + "\"price\":,"
                + "\"numberOfPages\":500,"
                + "\"isbn\":\"xxxxxx\","
                + "\"publicationDate\":\"12-12-2021\","
                + "\"idCategory\":1,"
                + "\"idAuthor\":1"
                + "}";

        mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .content(json).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    @Order(7)
    void priceLowStatus400() throws Exception {
        URI uri = new URI("/novo-livro");
        String json = "{"
                + "\"title\":\"teste05\","
                + "\"overview\":\"casasfsaas\","
                + "\"summary\":\"aaaaaaaaaaaaaaaaaa\","
                + "\"price\":10,"
                + "\"numberOfPages\":500,"
                + "\"isbn\":\"xxxxxxx\","
                + "\"publicationDate\":\"12-12-2021\","
                + "\"idCategory\":1,"
                + "\"idAuthor\":1"
                + "}";

        mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .content(json).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    @Order(8)
    void numberOfPagesNullStatus400() throws Exception {
        URI uri = new URI("/novo-livro");
        String json = "{"
                + "\"title\":\"teste06\","
                + "\"overview\":\"casasfsaas\","
                + "\"summary\":\"aaaaaaaaaaaaaaaaaa\","
                + "\"price\":50,"
                + "\"numberOfPages\":,"
                + "\"isbn\":\"xxxxxxxx\","
                + "\"publicationDate\":\"12-12-2021\","
                + "\"idCategory\":1,"
                + "\"idAuthor\":1"
                + "}";

        mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .content(json).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    @Order(9)
    void numberOfPagesLowStatus400() throws Exception {
        URI uri = new URI("/novo-livro");
        String json = "{"
                + "\"title\":\"teste07\","
                + "\"overview\":\"casasfsaas\","
                + "\"summary\":\"aaaaaaaaaaaaaaaaaa\","
                + "\"price\":50,"
                + "\"numberOfPages\":50,"
                + "\"isbn\":\"xxxxxxxxx\","
                + "\"publicationDate\":\"12-12-2021\","
                + "\"idCategory\":1,"
                + "\"idAuthor\":1"
                + "}";

        mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .content(json).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    @Order(10)
    void isbnEmptyStatus400() throws Exception {
        URI uri = new URI("/novo-livro");
        String json = "{"
                + "\"title\":\"teste08\","
                + "\"overview\":\"aaaaaaaaaaaaaaaaaaaaaa\","
                + "\"summary\":\"aaaaaaaaaaaaaaaaaa\","
                + "\"price\":50,"
                + "\"numberOfPages\":500,"
                + "\"isbn\":\"\","
                + "\"publicationDate\":\"12-12-2021\","
                + "\"idCategory\":1,"
                + "\"idAuthor\":1"
                + "}";

        mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .content(json).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    @Order(11)
    void isbnUniqueStatus400() throws Exception {
        URI uri = new URI("/novo-livro");
        String json = "{"
                + "\"title\":\"teste09\","
                + "\"overview\":\"aaaaaaaaaaaaaaaaaaaaaa\","
                + "\"summary\":\"aaaaaaaaaaaaaaaaaa\","
                + "\"price\":50,"
                + "\"numberOfPages\":500,"
                + "\"isbn\":\"qqqqqq\","
                + "\"publicationDate\":\"12-12-2021\","
                + "\"idCategory\":1,"
                + "\"idAuthor\":1"
                + "}";

        mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .content(json).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    @Order(12)
    void publicationDateFutureStatus400() throws Exception {
        URI uri = new URI("/novo-livro");
        String json = "{"
                + "\"title\":\"teste10\","
                + "\"overview\":\"aaaaaaaaaaaaaaaaaaaaaa\","
                + "\"summary\":\"aaaaaaaaaaaaaaaaaa\","
                + "\"price\":50,"
                + "\"numberOfPages\":500,"
                + "\"isbn\":\"xxxxxxxxx\","
                + "\"publicationDate\":\"01-01-1990\","
                + "\"idCategory\":1,"
                + "\"idAuthor\":1"
                + "}";

        mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .content(json).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    @Order(13)
    void publicationDateFormatStatus400() throws Exception {
        URI uri = new URI("/novo-livro");
        String json = "{"
                + "\"title\":\"teste11\","
                + "\"overview\":\"aaaaaaaaaaaaaaaaaaaaaa\","
                + "\"summary\":\"aaaaaaaaaaaaaaaaaa\","
                + "\"price\":50,"
                + "\"numberOfPages\":500,"
                + "\"isbn\":\"xxxxxxxxxx\","
                + "\"publicationDate\":\"01011990\","
                + "\"idCategory\":1,"
                + "\"idAuthor\":1"
                + "}";

        mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .content(json).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    @Order(14)
    void idCategoryExistsStatus400() throws Exception {
        URI uri = new URI("/novo-livro");
        String json = "{"
                + "\"title\":\"teste12\","
                + "\"overview\":\"aaaaaaaaaaaaaaaaaaaaaa\","
                + "\"summary\":\"aaaaaaaaaaaaaaaaaa\","
                + "\"price\":50,"
                + "\"numberOfPages\":500,"
                + "\"isbn\":\"xxxxxxxxxxx\","
                + "\"publicationDate\":\"12-12-2021\","
                + "\"idCategory\":100,"
                + "\"idAuthor\":1"
                + "}";

        mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .content(json).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    @Order(15)
    void idAuthorExistsStatus400() throws Exception {
        URI uri = new URI("/novo-livro");
        String json = "{"
                + "\"title\":\"teste13\","
                + "\"overview\":\"aaaaaaaaaaaaaaaaaaaaaa\","
                + "\"summary\":\"aaaaaaaaaaaaaaaaaa\","
                + "\"price\":50,"
                + "\"numberOfPages\":500,"
                + "\"isbn\":\"xxxxxxxxxxxx\","
                + "\"publicationDate\":\"12-12-2021\","
                + "\"idCategory\":1,"
                + "\"idAuthor\":100"
                + "}";

        mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .content(json).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }
    */
}
