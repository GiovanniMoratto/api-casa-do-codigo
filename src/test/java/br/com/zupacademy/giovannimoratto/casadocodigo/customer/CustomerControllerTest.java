package br.com.zupacademy.giovannimoratto.casadocodigo.customer;

import br.com.zupacademy.giovannimoratto.casadocodigo.payment_flow.customer.CustomerRequest;
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
class CustomerControllerTest {

    // Test Config
    private final String urlTemplate = "/cliente";
    /* Injections */
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    /* Methods */
    // POST Request
    @Test
    @DisplayName("200 OK - Succeed and persist the Customer in the Database")
    void createCustomerStatus200() throws Exception {
        // Values to Success Test
        CustomerRequest request = new CustomerRequest();
        request.setEmail("stark@email.com");
        request.setFirstName("Tony");
        request.setLastName("Stark");
        request.setDocument("41113968010");
        request.setAddress("10880 Malibu Point");
        request.setComplement("Point Dume");
        request.setCity("Malibu");
        request.setIdCountry(1L);
        request.setIdState(1L);
        request.setPhoneNumber("2129704133");
        request.setZipCode("90265");
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
        CustomerRequest request = new CustomerRequest();
        request.setEmail("valid_test@email.com");
        request.setFirstName("Sheldon");
        request.setLastName("Test");
        request.setDocument("491.944.720-50");
        request.setAddress("4521 Test01 Street");
        request.setComplement("Ok");
        request.setCity("There");
        request.setIdCountry(1L);
        request.setIdState(1L);
        request.setPhoneNumber("2025550198");
        request.setZipCode("53998");
        String jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders.post("/steam")       // <---------- FAIL
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
    @DisplayName("400 Bad Request - When trying to POST with empty EMAIL")
    void emailEmptyStatus400() throws Exception {
        // Values to Fail Test
        CustomerRequest request = new CustomerRequest();
        request.setEmail("");       // <---------- FAIL
        request.setFirstName("Sheldon");
        request.setLastName("Cooper");
        request.setDocument("828.403.710-65");
        request.setAddress("2311 Los Robles Avenue");
        request.setComplement("The Big Bang Theory");
        request.setCity("Pasadena");
        request.setIdCountry(1L);
        request.setIdState(1L);
        request.setPhoneNumber("2095507302");
        request.setZipCode("95354");
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
        CustomerRequest request = new CustomerRequest();
        request.setEmail("wrongemail.com");       // <---------- FAIL
        request.setFirstName("Sheldon");
        request.setLastName("Cooper");
        request.setDocument("828.403.710-65");
        request.setAddress("2311 Los Robles Avenue");
        request.setComplement("The Big Bang Theory");
        request.setCity("Pasadena");
        request.setIdCountry(1L);
        request.setIdState(1L);
        request.setPhoneNumber("2095507302");
        request.setZipCode("95354");
        String jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders.post(urlTemplate)
                .content(jsonRequest)
                .characterEncoding("UTF-8")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    // POST Request
    @Test
    @DisplayName("400 Bad Request - When trying to POST with a EMAIL already registered")
    void emailUniqueStatus400() throws Exception {
        // Values to Fail Test
        CustomerRequest request = new CustomerRequest();
        request.setEmail("duplicate_email@email.com");       // <---------- FAIL
        request.setFirstName("Sheldon");
        request.setLastName("Cooper");
        request.setDocument("828.403.710-65");
        request.setAddress("2311 Los Robles Avenue");
        request.setComplement("The Big Bang Theory");
        request.setCity("Pasadena");
        request.setIdCountry(2L);
        request.setIdState(2L);
        request.setPhoneNumber("2095507302");
        request.setZipCode("95354");
        String jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders.post(urlTemplate)
                .content(jsonRequest)
                .characterEncoding("UTF-8")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    // POST Request
    @Test
    @DisplayName("400 Bad Request - When trying to POST with empty FIRST NAME")
    void firstNameEmptyStatus400() throws Exception {
        // Values to Fail Test
        CustomerRequest request = new CustomerRequest();
        request.setEmail("sheldon.cooper@email.com");
        request.setFirstName("");       // <---------- FAIL
        request.setLastName("Cooper");
        request.setDocument("828.403.710-65");
        request.setAddress("2311 Los Robles Avenue");
        request.setComplement("The Big Bang Theory");
        request.setCity("Pasadena");
        request.setIdCountry(2L);
        request.setIdState(2L);
        request.setPhoneNumber("2095507302");
        request.setZipCode("95354");
        String jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders.post(urlTemplate)
                .content(jsonRequest)
                .characterEncoding("UTF-8")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    // POST Request
    @Test
    @DisplayName("400 Bad Request - When trying to POST with empty LAST NAME")
    void lastNameEmptyStatus400() throws Exception {
        // Values to Fail Test
        CustomerRequest request = new CustomerRequest();
        request.setEmail("sheldon.cooper@email.com");
        request.setFirstName("Sheldon");
        request.setLastName("");       // <---------- FAIL
        request.setDocument("828.403.710-65");
        request.setAddress("2311 Los Robles Avenue");
        request.setComplement("The Big Bang Theory");
        request.setCity("Pasadena");
        request.setIdCountry(2L);
        request.setIdState(2L);
        request.setPhoneNumber("2095507302");
        request.setZipCode("95354");
        String jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders.post(urlTemplate)
                .content(jsonRequest)
                .characterEncoding("UTF-8")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    // POST Request
    @Test
    @DisplayName("400 Bad Request - When trying to POST with empty DOCUMENT")
    void documentEmptyStatus400() throws Exception {
        // Values to Fail Test
        CustomerRequest request = new CustomerRequest();
        request.setEmail("sheldon.cooper@email.com");
        request.setFirstName("Sheldon");
        request.setLastName("Cooper");
        request.setDocument("");       // <---------- FAIL
        request.setAddress("2311 Los Robles Avenue");
        request.setComplement("The Big Bang Theory");
        request.setCity("Pasadena");
        request.setIdCountry(2L);
        request.setIdState(2L);
        request.setPhoneNumber("2095507302");
        request.setZipCode("95354");
        String jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders.post(urlTemplate)
                .content(jsonRequest)
                .characterEncoding("UTF-8")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    // POST Request
    @Test
    @DisplayName("400 Bad Request - When trying to POST with an invalid format DOCUMENT")
    void documentFormatStatus400() throws Exception {
        // Values to Fail Test
        CustomerRequest request = new CustomerRequest();
        request.setEmail("sheldon.cooper@email.com");
        request.setFirstName("Sheldon");
        request.setLastName("Cooper");
        request.setDocument("95955");       // <---------- FAIL
        request.setAddress("2311 Los Robles Avenue");
        request.setComplement("The Big Bang Theory");
        request.setCity("Pasadena");
        request.setIdCountry(2L);
        request.setIdState(2L);
        request.setPhoneNumber("2095507302");
        request.setZipCode("95354");
        String jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders.post(urlTemplate)
                .content(jsonRequest)
                .characterEncoding("UTF-8")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    // POST Request
    @Test
    @DisplayName("400 Bad Request - When trying to POST with a DOCUMENT already registered")
    void documentUniqueStatus400() throws Exception {
        // Values to Fail Test
        CustomerRequest request = new CustomerRequest();
        request.setEmail("sheldon.cooper@email.com");
        request.setFirstName("Sheldon");
        request.setLastName("Cooper");
        request.setDocument("394.408.380-60");       // <---------- FAIL
        request.setAddress("2311 Los Robles Avenue");
        request.setComplement("The Big Bang Theory");
        request.setCity("Pasadena");
        request.setIdCountry(2L);
        request.setIdState(2L);
        request.setPhoneNumber("2095507302");
        request.setZipCode("95354");
        String jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders.post(urlTemplate)
                .content(jsonRequest)
                .characterEncoding("UTF-8")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    // POST Request
    @Test
    @DisplayName("400 Bad Request - When trying to POST with empty ADDRESS")
    void addressEmptyStatus400() throws Exception {
        // Values to Fail Test
        CustomerRequest request = new CustomerRequest();
        request.setEmail("sheldon.cooper@email.com");
        request.setFirstName("Sheldon");
        request.setLastName("Cooper");
        request.setDocument("828.403.710-65");
        request.setAddress("");       // <---------- FAIL
        request.setComplement("The Big Bang Theory");
        request.setCity("Pasadena");
        request.setIdCountry(2L);
        request.setIdState(2L);
        request.setPhoneNumber("2095507302");
        request.setZipCode("95354");
        String jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders.post(urlTemplate)
                .content(jsonRequest)
                .characterEncoding("UTF-8")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    // POST Request
    @Test
    @DisplayName("400 Bad Request - When trying to POST with empty COMPLEMENT")
    void complementEmptyStatus400() throws Exception {
        // Values to Fail Test
        CustomerRequest request = new CustomerRequest();
        request.setEmail("sheldon.cooper@email.com");
        request.setFirstName("Sheldon");
        request.setLastName("Cooper");
        request.setDocument("828.403.710-65");
        request.setAddress("2311 Los Robles Avenue");
        request.setComplement("");       // <---------- FAIL
        request.setCity("Pasadena");
        request.setIdCountry(2L);
        request.setIdState(2L);
        request.setPhoneNumber("2095507302");
        request.setZipCode("95354");
        String jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders.post(urlTemplate)
                .content(jsonRequest)
                .characterEncoding("UTF-8")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    // POST Request
    @Test
    @DisplayName("400 Bad Request - When trying to POST with empty CITY")
    void cityEmptyStatus400() throws Exception {
        // Values to Fail Test
        CustomerRequest request = new CustomerRequest();
        request.setEmail("sheldon.cooper@email.com");
        request.setFirstName("Sheldon");
        request.setLastName("Cooper");
        request.setDocument("828.403.710-65");
        request.setAddress("2311 Los Robles Avenue");
        request.setComplement("The Big Bang Theory");
        request.setCity("");       // <---------- FAIL
        request.setIdCountry(2L);
        request.setIdState(2L);
        request.setPhoneNumber("2095507302");
        request.setZipCode("95354");
        String jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders.post(urlTemplate)
                .content(jsonRequest)
                .characterEncoding("UTF-8")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    // POST Request
    @Test
    @DisplayName("400 Bad Request - When trying to POST with empty COUNTRY")
    void countryEmptyStatus400() throws Exception {
        // Values to Fail Test
        CustomerRequest request = new CustomerRequest();
        request.setEmail("sheldon.cooper@email.com");
        request.setFirstName("Sheldon");
        request.setLastName("Cooper");
        request.setDocument("828.403.710-65");
        request.setAddress("2311 Los Robles Avenue");
        request.setComplement("The Big Bang Theory");
        request.setCity("Pasadena");
        request.setIdCountry(null);       // <---------- FAIL
        request.setIdState(2L);
        request.setPhoneNumber("2095507302");
        request.setZipCode("95354");
        String jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders.post(urlTemplate)
                .content(jsonRequest)
                .characterEncoding("UTF-8")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    // POST Request
    @Test
    @DisplayName("400 Bad Request - When trying to POST with invalid COUNTRY")
    void countryInvalidStatus400() throws Exception {
        // Values to Fail Test
        CustomerRequest request = new CustomerRequest();
        request.setEmail("sheldon.cooper@email.com");
        request.setFirstName("Sheldon");
        request.setLastName("Cooper");
        request.setDocument("828.403.710-65");
        request.setAddress("2311 Los Robles Avenue");
        request.setComplement("The Big Bang Theory");
        request.setCity("Pasadena");
        request.setIdCountry(99999999999999999L);       // <---------- FAIL
        request.setIdState(2L);
        request.setPhoneNumber("2095507302");
        request.setZipCode("95354");
        String jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders.post(urlTemplate)
                .content(jsonRequest)
                .characterEncoding("UTF-8")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    // POST Request
    @Test
    @DisplayName("200 OK - When trying to POST with empty STATE when it doesn't exist for a COUNTRY")
    void countryInvalidStatus200() throws Exception {
        // Values to Success Test
        CustomerRequest request = new CustomerRequest();
        request.setEmail("sheldon.cooper2@email.com");
        request.setFirstName("Sheldon");
        request.setLastName("Cooper");
        request.setDocument("828.403.710-65");
        request.setAddress("2311 Los Robles Avenue");
        request.setComplement("The Big Bang Theory");
        request.setCity("Pasadena");
        request.setIdCountry(2L);
        request.setIdState(null);       // <---------- SUCCESS
        request.setPhoneNumber("2095507302");
        request.setZipCode("95354");
        String jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders.post(urlTemplate)
                .content(jsonRequest)
                .characterEncoding("UTF-8")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    // POST Request
    @Test
    @DisplayName("400 Bad Request - When trying to POST with invalid STATE")
    void stateInvalidStatus400() throws Exception {
        // Values to Fail Test
        CustomerRequest request = new CustomerRequest();
        request.setEmail("sheldon.cooper@email.com");
        request.setFirstName("Sheldon");
        request.setLastName("Cooper");
        request.setDocument("828.403.710-65");
        request.setAddress("2311 Los Robles Avenue");
        request.setComplement("The Big Bang Theory");
        request.setCity("Pasadena");
        request.setIdCountry(2L);
        request.setIdState(99999999999999999L);       // <---------- FAIL
        request.setPhoneNumber("2095507302");
        request.setZipCode("95354");
        String jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders.post(urlTemplate)
                .content(jsonRequest)
                .characterEncoding("UTF-8")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    // POST Request
    @Test
    @DisplayName("400 Bad Request - When trying to POST with empty PHONE NUMBER")
    void phoneNumberEmptyStatus400() throws Exception {
        // Values to Fail Test
        CustomerRequest request = new CustomerRequest();
        request.setEmail("sheldon.cooper@email.com");
        request.setFirstName("Sheldon");
        request.setLastName("Cooper");
        request.setDocument("828.403.710-65");
        request.setAddress("2311 Los Robles Avenue");
        request.setComplement("The Big Bang Theory");
        request.setCity("Pasadena");
        request.setIdCountry(2L);
        request.setIdState(2L);
        request.setPhoneNumber("");       // <---------- FAIL
        request.setZipCode("95354");
        String jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders.post(urlTemplate)
                .content(jsonRequest)
                .characterEncoding("UTF-8")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    // POST Request
    @Test
    @DisplayName("400 Bad Request - When trying to POST with empty ZIP CODE")
    void zipCodeEmptyStatus400() throws Exception {
        // Values to Fail Test
        CustomerRequest request = new CustomerRequest();
        request.setEmail("sheldon.cooper@email.com");
        request.setFirstName("Sheldon");
        request.setLastName("Cooper");
        request.setDocument("828.403.710-65");
        request.setAddress("2311 Los Robles Avenue");
        request.setComplement("The Big Bang Theory");
        request.setCity("Pasadena");
        request.setIdCountry(2L);
        request.setIdState(2L);
        request.setPhoneNumber("2095507302");
        request.setZipCode("");       // <---------- FAIL
        String jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders.post(urlTemplate)
                .content(jsonRequest)
                .characterEncoding("UTF-8")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    // POST Request
    @Test
    @DisplayName("400 Bad Request - When trying to POST with a non-numeric characters PHONE NUMBER")
    void phoneNumberInvalidStatus400() throws Exception {
        // Values to Fail Test
        CustomerRequest request = new CustomerRequest();
        request.setEmail("sheldon.cooper@email.com");
        request.setFirstName("Sheldon");
        request.setLastName("Cooper");
        request.setDocument("828.403.710-65");
        request.setAddress("2311 Los Robles Avenue");
        request.setComplement("The Big Bang Theory");
        request.setCity("Pasadena");
        request.setIdCountry(2L);
        request.setIdState(2L);
        request.setPhoneNumber("dfznhbdfnd");       // <---------- FAIL
        request.setZipCode("95354");
        String jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders.post(urlTemplate)
                .content(jsonRequest)
                .characterEncoding("UTF-8")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    // POST Request
    @Test
    @DisplayName("400 Bad Request - When trying to POST with a non-numeric characters ZIP CODE")
    void zipCodeInvalidStatus400() throws Exception {
        // Values to Fail Test
        CustomerRequest request = new CustomerRequest();
        request.setEmail("sheldon.cooper@email.com");
        request.setFirstName("Sheldon");
        request.setLastName("Cooper");
        request.setDocument("828.403.710-65");
        request.setAddress("2311 Los Robles Avenue");
        request.setComplement("The Big Bang Theory");
        request.setCity("Pasadena");
        request.setIdCountry(2L);
        request.setIdState(2L);
        request.setPhoneNumber("2095507302");
        request.setZipCode("sdbdsbvsabva");       // <---------- FAIL
        String jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders.post(urlTemplate)
                .content(jsonRequest)
                .characterEncoding("UTF-8")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }
}
