package com.barcoding.episode5testing;

import com.barcoding.episode5testing.podcast.PodcastRepository;
import com.barcoding.episode5testing.podcast.PodcastService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static com.barcoding.episode5testing.utils.TestData.PODCAST;
import static com.barcoding.episode5testing.utils.TestData.TESTING_HANDLE;
import static com.barcoding.episode5testing.utils.TestData.TESTING_PODCAST;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
class Episode5TestingApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PodcastService podcastService;

    @Autowired
    private PodcastRepository podcastRepository;

    @Test
    void getPodcasts_withNoPodcasts_returnsNoPodcasts() throws Exception {
        mockMvc
            .perform(get("/v1/podcasts"))
            .andExpect(status().isOk())
            .andExpect(content()
                           .json("[]")
            );
    }

    @Test
    void getPodcasts_withPodcast_returnsPodcasts() throws Exception {
        podcastService.createPodcast(PODCAST);
        mockMvc
            .perform(get("/v1/podcasts"))
            .andExpect(status().isOk())
            .andExpect(content()
                           .json("[{'name':'" + TESTING_PODCAST + "','twitterHandle':'" + TESTING_HANDLE + "'}]")
            );
    }

    @AfterEach
    void cleanupTestData(){
        podcastRepository.deleteAll();
    }
}
