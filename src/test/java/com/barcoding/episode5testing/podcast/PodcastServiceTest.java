package com.barcoding.episode5testing.podcast;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static com.barcoding.episode5testing.utils.TestData.SAVED_ENTITY;
import static com.barcoding.episode5testing.utils.TestData.PODCAST;
import static com.barcoding.episode5testing.utils.TestData.SAVING_ENTITY;
import static com.barcoding.episode5testing.utils.TestData.TESTING_HANDLE;
import static com.barcoding.episode5testing.utils.TestData.TESTING_PODCAST;
import static com.barcoding.episode5testing.utils.TestData.UNKNOWN_NAME;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PodcastServiceTest {

  @Mock
  private PodcastRepository podcastRepository;

  @InjectMocks
  private PodcastService podcastService;


  @Nested
  class CreatePodcast {
    @Test
    void createPodcast_wasSuccessful() {
      when(podcastRepository.save(SAVING_ENTITY)).thenReturn(SAVED_ENTITY);
      final Podcast podcast = podcastService.createPodcast(PODCAST);

      assertThat(podcast.getName()).isEqualTo(TESTING_PODCAST);
      assertThat(podcast.getTwitterHandle()).isEqualTo(TESTING_HANDLE);
    }
  }

  @Nested
  class RetrieveAll {
    @Test
    void retrieveAllPodcasts() {
      when(podcastRepository.findAll()).thenReturn(List.of(SAVED_ENTITY));

      final List<Podcast> allPodcasts = podcastService.retrieveAll();

      assertThat(allPodcasts).hasSize(1);
      assertThat(allPodcasts).contains(PODCAST);
    }

    @Test
    void retrieveNoPodcast() {
      when(podcastRepository.findAll()).thenReturn(List.of());

      final List<Podcast> allPodcasts = podcastService.retrieveAll();

      assertThat(allPodcasts).isEmpty();
    }
  }

  @Nested
  class RetrieveByName {
    @Test
    void retrieveAllPodcast() {
      when(podcastRepository.findPodcastEntityByName(TESTING_PODCAST)).thenReturn(SAVED_ENTITY);

      final Optional<Podcast> podcast = podcastService.findByName(TESTING_PODCAST);

      assertThat(podcast).isEqualTo(Optional.of(PODCAST));
    }

    @Test
    void retrievingPodcastByUnknownName_ReturnsEmptyOptional() {
      when(podcastRepository.findPodcastEntityByName(UNKNOWN_NAME)).thenReturn(null);

      final Optional<Podcast> podcast = podcastService.findByName(UNKNOWN_NAME);

      assertThat(podcast).isEqualTo(Optional.empty());
    }
  }

}
