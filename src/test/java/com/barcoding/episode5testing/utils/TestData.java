package com.barcoding.episode5testing.utils;

import com.barcoding.episode5testing.podcast.Podcast;
import com.barcoding.episode5testing.podcast.PodcastEntity;

public class TestData {
  public static final String UNKNOWN_NAME = "unknown_name";
  public static final String TESTING_PODCAST = "testing-podcast";
  public static final String TESTING_HANDLE = "@testingHandle";
  public static final PodcastEntity SAVING_ENTITY = new PodcastEntity(TESTING_PODCAST, TESTING_HANDLE);
  public static final PodcastEntity SAVED_ENTITY = new PodcastEntity(12355L, TESTING_PODCAST, TESTING_HANDLE);
  public static final Podcast PODCAST = new Podcast(TESTING_PODCAST , TESTING_HANDLE);
}
