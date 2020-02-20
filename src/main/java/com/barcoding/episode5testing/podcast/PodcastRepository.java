package com.barcoding.episode5testing.podcast;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PodcastRepository extends CrudRepository<PodcastEntity, Long> {

  PodcastEntity findPodcastEntityByName(@Param("name") String name);
}
