package com.bowling.game.service;

import com.bowling.game.models.GameParticipantModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc(addFilters = false)
public class PlayerControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlayerService playerService;

    @Test
    public void testMoreThen3Players() throws Exception {
        String model = "{\"gameId\":1,\"laneId\":1,\"playerIds\":[1,2,3,4]}";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/player/startGame")
                .contentType(MediaType.APPLICATION_JSON)
                .content(model);
        mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void test3Players() throws Exception {
        String model = "{\"gameId\":1,\"laneId\":1,\"playerIds\":[1,2,3]}";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/player/startGame")
                .contentType(MediaType.APPLICATION_JSON)
                .content(model);
        mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
