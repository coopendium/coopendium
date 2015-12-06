package coop.endium;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

/**
 * Created by mlaux on 9/22/15.
 */
public class SignupActivity extends BaseActivity {
  private static final String OUT_EXTRA_HOUSE = "house";
  private static final String OUT_EXTRA_NAME = "name";
  private static final String OUT_EXTRA_EMAIL = "email";
  private static final String OUT_EXTRA_SKILLS = "skills";

  private ViewPager pager;
  private Button bottomButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_signup);

    pager = (ViewPager) findViewById(R.id.pager);
    pager.setAdapter(new SignupAdapter(this, pager));
    pager.addOnPageChangeListener(new PageChangeListener());

    bottomButton = (Button) findViewById(R.id.bottom_button);
    bottomButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (getString(R.string.finish).equals(bottomButton.getText())) {
          Intent out = new Intent();
          out.putExtra(OUT_EXTRA_HOUSE, SignupAdapter.Page.HOUSE.primaryInput);
          out.putExtra(OUT_EXTRA_NAME, SignupAdapter.Page.INFO.primaryInput);
          out.putExtra(OUT_EXTRA_EMAIL, SignupAdapter.Page.INFO.secondaryInput);
          out.putExtra(OUT_EXTRA_SKILLS, SignupAdapter.Page.SKILLS.primaryInput);

          setResult(RESULT_OK, out);
          finish();
        } else {
          pager.setCurrentItem(pager.getCurrentItem() + 1);
        }
      }
    });
  }

  private class PageChangeListener extends ViewPager.SimpleOnPageChangeListener {
    @Override
    public void onPageSelected(int position) {
      if (position == SignupAdapter.getNumPages() - 1) {
        bottomButton.setText(R.string.finish);
      } else {
        bottomButton.setText(R.string.next);
      }
    }
  }
}
