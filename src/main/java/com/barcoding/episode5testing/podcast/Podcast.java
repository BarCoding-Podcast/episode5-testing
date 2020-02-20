package com.barcoding.episode5testing.podcast;

import java.util.Objects;

public class Podcast {

  private final String name;
  private final String twitterHandle;

  public Podcast(String name, String twitterHandle) {
    this.name = name;
    this.twitterHandle = twitterHandle;
  }

  public String getName() {
    return name;
  }

  public String getTwitterHandle() {
    return twitterHandle;
  }

  public static Podcast fromEntity(PodcastEntity entity) {
    return new Podcast(entity.getName(), entity.getTwitterHandle());
  }

  @Override
  public String toString() {
    return "Podcast{" +
        "name='" + name + '\'' +
        ", twitterHandle='" + twitterHandle + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Podcast podcast = (Podcast) o;
    return Objects.equals(name, podcast.name) &&
        Objects.equals(twitterHandle, podcast.twitterHandle);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, twitterHandle);
  }
}
