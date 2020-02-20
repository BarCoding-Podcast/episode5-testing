package com.barcoding.episode5testing.podcast;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class PodcastEntity {
  @Id
  @GeneratedValue()
  private Long id;

  private String name;
  private String twitterHandle;

  public PodcastEntity(){}

  public PodcastEntity(Long id, String name, String twitterHandle) {
    this.id = id;
    this.name = name;
    this.twitterHandle = twitterHandle;
  }

  public PodcastEntity(String name, String twitterHandle) {
    this.name = name;
    this.twitterHandle = twitterHandle;
  }

  public static PodcastEntity fromDomain(Podcast podcast) {
    return new PodcastEntity(podcast.getName(), podcast.getTwitterHandle());
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setTwitterHandle(String twitterHandle) {
    this.twitterHandle = twitterHandle;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getTwitterHandle() {
    return twitterHandle;
  }

  @Override
  public String toString() {
    return "PodcastEntity{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", twitterHandle='" + twitterHandle + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    PodcastEntity that = (PodcastEntity) o;
    return Objects.equals(id, that.id) &&
        Objects.equals(name, that.name) &&
        Objects.equals(twitterHandle, that.twitterHandle);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, twitterHandle);
  }
}
