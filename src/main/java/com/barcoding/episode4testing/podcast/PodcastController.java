package com.barcoding.episode4testing.podcast;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/v1/podcasts")
public class PodcastController {

  private PodcastService podcastService;

  @Autowired
  public PodcastController(PodcastService podcastService) {
    this.podcastService = podcastService;
  }

  @GetMapping
  public ResponseEntity<List<Podcast>> all() {
    final List<Podcast> podcasts = podcastService.retrieveAll();
    return ResponseEntity.ok(podcasts);
  }

  @GetMapping(path = "{name}")
  public ResponseEntity<Podcast> retrieveByName(@PathVariable("name") String name) {
    return podcastService.findByName(name)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<Podcast> create(@RequestBody Podcast newPodcast) {
    final Podcast podcast = podcastService.createPodcast(newPodcast);
    return ResponseEntity.ok(podcast);
  }
}