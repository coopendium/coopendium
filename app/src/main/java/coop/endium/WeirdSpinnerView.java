package coop.endium;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import coop.endium.section.Section;

/**
 * Created by mlaux on 12/5/15.
 */
public class WeirdSpinnerView extends ImageView implements View.OnTouchListener {
  private static final int RADIUS = 140;
  private static final String TAG = WeirdSpinnerView.class.getSimpleName();

  private static final Zone[] ZONES = {
    new Zone(350, 450, Section.GOAL_DIR),
    new Zone(750, 450, Section.INT_TRUST),
    new Zone(140, 800, Section.SKILL_SOURCE),
    new Zone(950, 800, Section.TASK_ENGINE),
    new Zone(350, 1150, Section.NEEDS_BANK),
    new Zone(750, 1150, Section.RESOURCE_POOL)
  };

  public WeirdSpinnerView(Context context, AttributeSet attrs) {
    super(context, attrs);
    setup();
  }

  public WeirdSpinnerView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    setup();
  }

  private void setup() {
    setImageResource(R.drawable.spinner_image);
    setOnTouchListener(this);
  }

  @Override
  public boolean onTouch(View v, MotionEvent event) {
    if (event.getAction() == MotionEvent.ACTION_UP) {
      for (Zone zone : ZONES) {
        float dx = event.getX() - zone.centerX;
        float dy = event.getY() - zone.centerY;
        if (dx * dx + dy * dy < RADIUS * RADIUS) {
          Log.e(TAG, "inside " + zone.section.getName());
          getContext().startActivity(zone.section.getLaunchIntent(getContext()));
          ((Activity) getContext()).overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
          break;
        }
      }
    }
    return true;
  }

  private static class Zone {
    final int centerX;
    final int centerY;

    final Section section;

    Zone(int cx, int cy, Section n) {
      centerX = cx;
      centerY = cy;
      section = n;
    }
  }
}
