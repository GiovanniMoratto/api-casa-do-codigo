package br.com.zupacademy.giovannimoratto.casadocodigo.book;

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
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @Author giovanni.moratto
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class BookControllerTest {

    /* Injections */
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    // Test Config
    private final String urlTemplate = "/livro";
    final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    /* Methods */
    // POST Request
    @Test
    @DisplayName("200 OK - Succeed and persist the Book in the Database")
    void createBookStatus200() throws Exception {
        // Values to Success Test
        BookRequest request = new BookRequest();
        request.setTitle("The Lord of the Rings");
        request.setOverview("Lord ".repeat(5));
        request.setSummary("Rings ".repeat(8));
        request.setPrice(new BigDecimal(90));
        request.setNumberOfPages(1000);
        request.setIsbn("wxy".repeat(7));
        request.setPublicationDate(LocalDate.parse("30/12/2060", formatter));
        request.setIdCategory(1L);
        request.setIdAuthor(1L);
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
        BookRequest request = new BookRequest();
        request.setTitle("The Hobbit");
        request.setOverview("The".repeat(2));
        request.setSummary("Hobbit".repeat(4));
        request.setPrice(new BigDecimal(50));
        request.setNumberOfPages(600);
        request.setIsbn("abc".repeat(7));
        request.setPublicationDate(LocalDate.parse("15/07/2060", formatter));
        request.setIdCategory(1L);
        request.setIdAuthor(1L);
        String jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders.post("/xbox")       // <---------- FAIL
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
    @DisplayName("400 Bad Request - When trying to POST with empty TITLE")
    void titleEmptyStatus400() throws Exception {
        // Values to Fail Test
        BookRequest request = new BookRequest();
        request.setTitle("");       // <---------- FAIL
        request.setOverview("test01");
        request.setSummary("test01");
        request.setPrice(new BigDecimal(30));
        request.setNumberOfPages(200);
        request.setIsbn("test01");
        request.setPublicationDate(LocalDate.parse("30/12/2050", formatter));
        request.setIdCategory(2L);
        request.setIdAuthor(2L);
        String jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders.post(urlTemplate)
                .content(jsonRequest)
                .characterEncoding("UTF-8")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    // POST Request
    @Test
    @DisplayName("400 Bad Request - When trying to POST with a TITLE already registered")
    void titleUniqueStatus400() throws Exception {
        // Values to Fail Test
        BookRequest request = new BookRequest();
        request.setTitle("Title duplicated");       // <---------- FAIL
        request.setOverview("test02");
        request.setSummary("test02");
        request.setPrice(new BigDecimal(30));
        request.setNumberOfPages(200);
        request.setIsbn("test02");
        request.setPublicationDate(LocalDate.parse("30/12/2050", formatter));
        request.setIdCategory(2L);
        request.setIdAuthor(2L);
        String jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders.post(urlTemplate)
                .content(jsonRequest)
                .characterEncoding("UTF-8")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    // POST Request
    @Test
    @DisplayName("400 Bad Request - When trying to POST with empty OVERVIEW")
    void overviewEmptyStatus400() throws Exception {
        // Values to Fail Test
        BookRequest request = new BookRequest();
        request.setTitle("test03");
        request.setOverview("");       // <---------- FAIL
        request.setSummary("test03");
        request.setPrice(new BigDecimal(30));
        request.setNumberOfPages(200);
        request.setIsbn("test03");
        request.setPublicationDate(LocalDate.parse("30/12/2050", formatter));
        request.setIdCategory(2L);
        request.setIdAuthor(2L);
        String jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders.post(urlTemplate)
                .content(jsonRequest)
                .characterEncoding("UTF-8")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    // POST Request
    @Test
    @DisplayName("400 Bad Request - When trying to POST with an OVERVIEW longer than 500 characters")
    void overviewSizeStatus400() throws Exception {
        // Values to Fail Test
        BookRequest request = new BookRequest();
        request.setTitle("test04");
        request.setOverview("x".repeat(501));       // <---------- FAIL
        request.setSummary("test04");
        request.setPrice(new BigDecimal(30));
        request.setNumberOfPages(200);
        request.setIsbn("test04");
        request.setPublicationDate(LocalDate.parse("30/12/2050", formatter));
        request.setIdCategory(2L);
        request.setIdAuthor(2L);
        String jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders.post(urlTemplate)
                .content(jsonRequest)
                .characterEncoding("UTF-8")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    // POST Request
    @Test
    @DisplayName("400 Bad Request - When trying to POST with empty PRICE")
    void priceNullStatus400() throws Exception {
        // Values to Fail Test
        BookRequest request = new BookRequest();
        request.setTitle("test05");
        request.setOverview("test05");
        request.setSummary("test05");
        request.setPrice(null);       // <---------- FAIL
        request.setNumberOfPages(200);
        request.setIsbn("test05");
        request.setPublicationDate(LocalDate.parse("30/12/2050", formatter));
        request.setIdCategory(2L);
        request.setIdAuthor(2L);
        String jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders.post(urlTemplate)
                .content(jsonRequest)
                .characterEncoding("UTF-8")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    // POST Request
    @Test
    @DisplayName("400 Bad Request - When trying to POST with a PRICE less than 20")
    void priceLowStatus400() throws Exception {
        // Values to Fail Test
        BookRequest request = new BookRequest();
        request.setTitle("test06");
        request.setOverview("test06");
        request.setSummary("test06");
        request.setPrice(new BigDecimal(19));       // <---------- FAIL
        request.setNumberOfPages(200);
        request.setIsbn("test06");
        request.setPublicationDate(LocalDate.parse("30/12/2050", formatter));
        request.setIdCategory(2L);
        request.setIdAuthor(2L);
        String jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders.post(urlTemplate)
                .content(jsonRequest)
                .characterEncoding("UTF-8")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    // POST Request
    @Test
    @DisplayName("400 Bad Request - When trying to POST with empty NUMBER OF PAGES")
    void numberOfPagesNullStatus400() throws Exception {
        // Values to Fail Test
        BookRequest request = new BookRequest();
        request.setTitle("test07");
        request.setOverview("test07");
        request.setSummary("test07");
        request.setPrice(new BigDecimal(20));
        request.setNumberOfPages(null);       // <---------- FAIL
        request.setIsbn("test07");
        request.setPublicationDate(LocalDate.parse("30/12/2050", formatter));
        request.setIdCategory(2L);
        request.setIdAuthor(2L);
        String jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders.post(urlTemplate)
                .content(jsonRequest)
                .characterEncoding("UTF-8")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    // POST Request
    @Test
    @DisplayName("400 Bad Request - When trying to POST with a NUMBER OF PAGES less than 100")
    void numberOfPagesLowStatus400() throws Exception {
        // Values to Fail Test
        BookRequest request = new BookRequest();
        request.setTitle("test08");
        request.setOverview("test08");
        request.setSummary("test08");
        request.setPrice(new BigDecimal(20));
        request.setNumberOfPages(99);       // <---------- FAIL
        request.setIsbn("test08");
        request.setPublicationDate(LocalDate.parse("30/12/2050", formatter));
        request.setIdCategory(2L);
        request.setIdAuthor(2L);
        String jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders.post(urlTemplate)
                .content(jsonRequest)
                .characterEncoding("UTF-8")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    // POST Request
    @Test
    @DisplayName("400 Bad Request - When trying to POST with empty ISBN")
    void isbnEmptyStatus400() throws Exception {
        // Values to Fail Test
        BookRequest request = new BookRequest();
        request.setTitle("test09");
        request.setOverview("test09");
        request.setSummary("test09");
        request.setPrice(new BigDecimal(20));
        request.setNumberOfPages(100);
        request.setIsbn("");       // <---------- FAIL
        request.setPublicationDate(LocalDate.parse("30/12/2050", formatter));
        request.setIdCategory(2L);
        request.setIdAuthor(2L);
        String jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders.post(urlTemplate)
                .content(jsonRequest)
                .characterEncoding("UTF-8")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    // POST Request
    @Test
    @DisplayName("400 Bad Request - When trying to POST with a ISBN already registered")
    void isbnUniqueStatus400() throws Exception {
        // Values to Fail Test
        BookRequest request = new BookRequest();
        request.setTitle("test10");
        request.setOverview("test10");
        request.setSummary("test10");
        request.setPrice(new BigDecimal(20));
        request.setNumberOfPages(100);
        request.setIsbn("isbn duplicated");       // <---------- FAIL
        request.setPublicationDate(LocalDate.parse("30/12/2050", formatter));
        request.setIdCategory(2L);
        request.setIdAuthor(2L);
        String jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders.post(urlTemplate)
                .content(jsonRequest)
                .characterEncoding("UTF-8")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    // POST Request
    @Test
    @DisplayName("400 Bad Request - When trying to POST a PUBLICATION DATE with current date or earlier than the " +
                 "present date")
    void publicationDateFutureStatus400() throws Exception {
        // Values to Fail Test
        BookRequest request = new BookRequest();
        request.setTitle("test11");
        request.setOverview("test11");
        request.setSummary("test11");
        request.setPrice(new BigDecimal(20));
        request.setNumberOfPages(100);
        request.setIsbn("test11");
        request.setPublicationDate(LocalDate.parse("06/07/2021", formatter));       // <---------- FAIL
        request.setIdCategory(2L);
        request.setIdAuthor(2L);
        String jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders.post(urlTemplate)
                .content(jsonRequest)
                .characterEncoding("UTF-8")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    // POST Request
    @Test
    @DisplayName("400 Bad Request - When trying to POST with empty PUBLICATION DATE")
    void publicationDateEmptyStatus400() throws Exception {
        // Values to Fail Test
        BookRequest request = new BookRequest();
        request.setTitle("test12");
        request.setOverview("test12");
        request.setSummary("test12");
        request.setPrice(new BigDecimal(20));
        request.setNumberOfPages(100);
        request.setIsbn("test12");
        request.setPublicationDate(null);       // <---------- FAIL
        request.setIdCategory(2L);
        request.setIdAuthor(2L);
        String jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders.post(urlTemplate)
                .content(jsonRequest)
                .characterEncoding("UTF-8")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    // POST Request
    @Test
    @DisplayName("400 Bad Request - When trying to POST with empty CATEGORY")
    void idCategoryEmptyStatus400() throws Exception {
        // Values to Fail Test
        BookRequest request = new BookRequest();
        request.setTitle("test13");
        request.setOverview("test13");
        request.setSummary("test13");
        request.setPrice(new BigDecimal(20));
        request.setNumberOfPages(100);
        request.setIsbn("test13");
        request.setPublicationDate(LocalDate.parse("30/12/2050", formatter));
        request.setIdCategory(null);       // <---------- FAIL
        request.setIdAuthor(2L);
        String jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders.post(urlTemplate)
                .content(jsonRequest)
                .characterEncoding("UTF-8")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    // POST Request
    @Test
    @DisplayName("400 Bad Request - When trying to POST with an unregistered CATEGORY")
    void idCategoryExistsStatus400() throws Exception {
        // Values to Fail Test
        BookRequest request = new BookRequest();
        request.setTitle("test14");
        request.setOverview("test14");
        request.setSummary("test14");
        request.setPrice(new BigDecimal(20));
        request.setNumberOfPages(100);
        request.setIsbn("test14");
        request.setPublicationDate(LocalDate.parse("30/12/2050", formatter));
        request.setIdCategory(999999999999L);       // <---------- FAIL
        request.setIdAuthor(2L);
        String jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders.post(urlTemplate)
                .content(jsonRequest)
                .characterEncoding("UTF-8")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    // POST Request
    @Test
    @DisplayName("400 Bad Request - When trying to POST with empty AUTHOR")
    void idAuthorEmptyStatus400() throws Exception {
        // Values to Fail Test
        BookRequest request = new BookRequest();
        request.setTitle("test14");
        request.setOverview("test14");
        request.setSummary("test14");
        request.setPrice(new BigDecimal(20));
        request.setNumberOfPages(100);
        request.setIsbn("test14");
        request.setPublicationDate(LocalDate.parse("30/12/2050", formatter));
        request.setIdCategory(2L);
        request.setIdAuthor(null);       // <---------- FAIL
        String jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders.post(urlTemplate)
                .content(jsonRequest)
                .characterEncoding("UTF-8")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    // POST Request
    @Test
    @DisplayName("400 Bad Request - When trying to POST with an unregistered AUTHOR")
    void idAuthorExistsStatus400() throws Exception {
        // Values to Fail Test
        BookRequest request = new BookRequest();
        request.setTitle("test14");
        request.setOverview("test14");
        request.setSummary("test14");
        request.setPrice(new BigDecimal(20));
        request.setNumberOfPages(100);
        request.setIsbn("test14");
        request.setPublicationDate(LocalDate.parse("30/12/2050", formatter));
        request.setIdCategory(2L);
        request.setIdAuthor(999999999999L);       // <---------- FAIL
        String jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders.post(urlTemplate)
                .content(jsonRequest)
                .characterEncoding("UTF-8")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    // GET Request
    @Test
    @DisplayName("200 OK - Succeed and get all books")
    void getAllBooksStatus200() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .get(urlTemplate)
                .characterEncoding("UTF-8")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andReturn();

        String resultContent = result.getResponse().getContentAsString();
        System.out.println(resultContent);
    }

    // GET Request
    @Test
    @DisplayName("404 Not Found - When trying to GET with invalid ENDPOINT")
    void getInvalidStatus404() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .get("/x")       // <---------- FAIL
                .characterEncoding("UTF-8")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(404))
                .andReturn();

        String resultContent = result.getResponse().getContentAsString();
        System.out.println(resultContent);
    }

    // GET Request
    @Test
    @DisplayName("404 Not Found - When trying to GET with invalid ID")
    void getInvalidIdStatus404() throws Exception {
        String id = "/999999999999";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .get(urlTemplate + id)
                .characterEncoding("UTF-8")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(404))
                .andReturn();

        String resultContent = result.getResponse().getContentAsString();
        System.out.println(resultContent);
    }

    // GET Request
    @Test
    @DisplayName("200 OK - Succeed and get a book")
    void getBookStatus200() throws Exception {
        String id = "/1";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .get(urlTemplate + id)
                .characterEncoding("UTF-8")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andReturn();

        String resultContent = result.getResponse().getContentAsString();
        System.out.println(resultContent);
    }

}
