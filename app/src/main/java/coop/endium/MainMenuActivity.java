package coop.endium;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by mlaux on 9/23/15.
 */
public class MainMenuActivity extends BaseActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main_menu);
  }

  public void spinner(View view) {
    startActivity(new Intent(this, SpinnerActivity.class));
    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
  }
}
