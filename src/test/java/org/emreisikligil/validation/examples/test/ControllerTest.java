package org.emreisikligil.validation.examples.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.emreisikligil.validation.examples.DemoApplication;
import org.emreisikligil.validation.examples.message.PersonRequest;
import org.emreisikligil.validation.examples.model.Person;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringApplicationConfiguration(classes = DemoApplication.class)
public class ControllerTest {

    @Autowired
    protected WebApplicationContext applicationContext;

    protected static ObjectMapper objectMapper;

    protected MockMvc mvc;

    @Before
    public void setup() {
        objectMapper = new ObjectMapper();

        mvc = MockMvcBuilders
                .webAppContextSetup(applicationContext)
                .build();
    }

    @Test
    public void controllerTest() throws Exception {
        Person person = new Person();
        person.setName("Emre");
        person.setLastname("Isikligil");
        person.setId("1234-5678");

        PersonRequest personRequest = new PersonRequest();
        personRequest.setPerson(person);

        mvc.perform(post("/demo2")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(personRequest)))
            .andDo(MockMvcResultHandlers.print());
    }
}
