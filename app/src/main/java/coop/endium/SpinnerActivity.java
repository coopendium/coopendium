package coop.endium;

import android.os.Bundle;
import android.widget.ImageView;

/**
 * Created by mlaux on 9/23/15.
 */
public class SpinnerActivity extends BaseActivity {

  private static final float SPEED = 1f;

  private WeirdSpinnerView spinner;
  private float downX;
  private float downY;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_spinner);
    spinner = (WeirdSpinnerView) findViewById(R.id.spinner);
  }

}
