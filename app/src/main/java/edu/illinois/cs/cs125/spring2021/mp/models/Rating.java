package edu.illinois.cs.cs125.spring2021.mp.models;


/**
 * Model holding the course rating.
 *
 */
public class Rating {
  /**
   * not rated.
   */
  public static final double NOT_RATED = -1.0;


  private String id;
  private double rating = NOT_RATED;



  /**
     *
     * @param setId
     * @param setRating
   */
  public Rating(final String setId, final double setRating) {
    id = setId;
    rating = setRating;
  }

    /**
     * Get id.
     * @return null.
     */
  public String getId() {
    return id;
  }

    /**
     *
     * @return notrated
     */
  public double getRating() {

    return rating;
  }

  /**
   *
   */
  public Rating() {}


}
