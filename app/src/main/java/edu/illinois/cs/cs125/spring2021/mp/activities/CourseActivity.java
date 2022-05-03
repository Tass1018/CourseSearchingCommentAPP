package edu.illinois.cs.cs125.spring2021.mp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


import edu.illinois.cs.cs125.spring2021.mp.R;
import edu.illinois.cs.cs125.spring2021.mp.application.CourseableApplication;
import edu.illinois.cs.cs125.spring2021.mp.databinding.ActivityCourseBinding;
import edu.illinois.cs.cs125.spring2021.mp.models.Course;
import edu.illinois.cs.cs125.spring2021.mp.models.Rating;
import edu.illinois.cs.cs125.spring2021.mp.models.Summary;
import edu.illinois.cs.cs125.spring2021.mp.network.Client;

/** Course activity showing the course summary list. */
public class CourseActivity extends AppCompatActivity implements Client.CourseClientCallbacks {
  @SuppressWarnings({"unused", "RedundantSuppression"})
    private static final String TAG = CourseActivity.class.getSimpleName();

  // Binding to the layout in activity_main.xml
  private ActivityCourseBinding binding;
    /**
     * Called when this activity is created.
     *
     * <p>Because this is the course activity for this app, this method is called when the app is
     * started, and any time that this view is shown.
     *
     * @param  savedInstanceState saved instance state, currently unused and always empty or null
     */
  @Override
  public void onCreate(final @Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Log.i(TAG, "CourseActivity launched");

    Intent intent = getIntent();
    String course = intent.getStringExtra("COURSE");
    Log.i(TAG, course);

    // Bind to the layout in activity_course.xml
    binding = DataBindingUtil.setContentView(this, R.layout.activity_course);

    // to deserialize the string to summary
    ObjectMapper mapper = new ObjectMapper();
    Summary coursesummary = null;

    try {
      mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
      coursesummary = mapper.readValue(course, Summary.class);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }

    CourseableApplication application = (CourseableApplication) getApplication();
    application.getCourseClient().getCourse(coursesummary, this);

  }




  /**
   *
   * @param summary
   * @param course
   */
  public void courseResponse(final Summary summary, final Course course) {

    //add title and description
    binding.title.setText(summary.getTitle());
    binding.description.setText(course.getDescription());
  }

  /**
   *
   * @param summary
   * @param rating
   */
  public void yourRating(final Summary summary, final Rating rating) {
    binding.rating.setRating((float) rating.getRating());
  }

}

