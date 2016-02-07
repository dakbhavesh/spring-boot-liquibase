package com.meetup;

import com.meetup.web.resource.UserResource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class)
@WebIntegrationTest
public class UserResourceIntegrationTests {

    private MockMvc userResource;

    @Before
    public void setUp(){
        userResource = MockMvcBuilders.standaloneSetup(new UserResource()).build();
    }

    @Test
    public void testIndex() throws Exception{

        String userJson = "{\n" +
                "\"firstName\": \"Dhaval\",\n" +
                "\"lastName\": \"Patel\",\n" +
                "\"username\": \"dhaval.patel\"\n" +
                "}";

        userResource.perform(MockMvcRequestBuilders.post("/users").contentType(MediaType.APPLICATION_JSON).content(userJson).
                accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(content().json(toString()));
    }
}
