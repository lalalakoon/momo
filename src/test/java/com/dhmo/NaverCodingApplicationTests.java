package com.dhmo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class NaverCodingApplicationTests {

	@Autowired
    private MockMvc mockMvc;

    @Test
    public void jsonWithParam() throws Exception {

        this.mockMvc.perform(get("/json/rest_find").param("lon", "128.44883116420243").param("lat","35.263795115189694").param("width","0.1").param("height","0.1"))
                .andDo(print()).andExpect(status().isOk());
    }
    
    @Test
    public void xmlWithParam() throws Exception {

        this.mockMvc.perform(get("/xml/rest_find").param("lon", "128.44883116420243").param("lat","35.263795115189694").param("width","0.1").param("height","0.1"))
                .andDo(print()).andExpect(status().isOk());
    }
    
}
