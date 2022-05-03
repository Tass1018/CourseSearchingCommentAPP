package edu.illinois.cs.cs125.spring2021.mp.models;

import com.github.wrdlbrnft.sortedlistadapter.SortedListAdapter;

/**
 * Model holding the course description information shown in the description list.
 *
 * <p>You will need to complete this model for MP2.
 */
public class Course extends Summary implements SortedListAdapter.ViewModel {
  private String description;
  /**
   * Get the description for this Course.
   *
   * @return the description for this Course
   */
  public String getDescription() {
    return description;
  }

  /** Create an empty Summary. */
  @SuppressWarnings({"unused", "RedundantSuppression"})
  public Course() {}

  /**
   * Create a Course with the provided fields.
   * @param setDescription
   */
  public Course(
          final String setDescription) {
    description = setDescription;
  }


}
