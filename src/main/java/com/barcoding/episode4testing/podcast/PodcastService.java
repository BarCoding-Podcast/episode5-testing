package com.barcoding.episode4testing.podcast;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PodcastService {

  private PodcastRepository podcastRepository;

  @Autowired
  public PodcastService(PodcastRepository podcastRepository) {
    this.podcastRepository = podcastRepository;
  }

  public Podcast createPodcast(Podcast newPodcast) {
    final PodcastEntity savedPodcast = podcastRepository.save(PodcastEntity.fromDomain(newPodcast));

    return Podcast.fromEntity(savedPodcast);
  }

  public List<Podcast> retrieveAll() {
    List<Podcast> podcasts = new ArrayList<>();
    podcastRepository.findAll().forEach(it -> podcasts.add(Podcast.fromEntity(it)));
    return podcasts;
  }

  public Optional<Podcast> findByName(String name) {
    final PodcastEntity podcastEntityByName = podcastRepository.findPodcastEntityByName(name);

    if (podcastEntityByName != null) {
      return Optional.of(Podcast.fromEntity(podcastEntityByName));
    }
    return Optional.empty();
  }
}
