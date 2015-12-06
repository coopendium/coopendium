package coop.endium;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by mlaux on 9/23/15.
 */
public class BaseActivity extends AppCompatActivity {
  @Override
  public void finish() {
    super.finish();
    overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
  }
}
