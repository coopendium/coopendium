package coop.endium;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class LandingActivity extends BaseActivity {
  private static final int REQUEST_CODE_SIGN_UP = 100;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
      getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
              | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }
    setContentView(R.layout.activity_landing);
  }

  public void newUserClicked(View view) {
    startActivityForResult(new Intent(this, SignupActivity.class), REQUEST_CODE_SIGN_UP);
    doTransition();
  }

  public void existingUserClicked(View view) {
    startSpinner();
  }

  private void startSpinner() {
    startActivity(new Intent(this, MainMenuActivity.class));
    doTransition();
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (requestCode == REQUEST_CODE_SIGN_UP && resultCode == RESULT_OK) {
      startSpinner();
    }
  }

  private void doTransition() {
    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
  }
}
