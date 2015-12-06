package coop.endium;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by mlaux on 9/22/15.
 */
public class SignupAdapter extends PagerAdapter {

  private Context context;

  public SignupAdapter(Context context, ViewPager pager) {
    this.context = context;
    pager.addOnPageChangeListener(new PageChangeListener());
  }

  @Override
  public int getCount() {
    return getNumPages();
  }

  @Override
  public boolean isViewFromObject(View view, Object object) {
    return view == object;
  }

  @Override
  public Object instantiateItem(ViewGroup container, int position) {
    Page page = Page.values()[position];
    page.view = LayoutInflater.from(context).inflate(page.layout, container, false);
    ScrollView sv = new ScrollView(context);
    sv.addView(page.view);
    container.addView(sv);
    return sv;
  }

  @Override
  public void destroyItem(ViewGroup container, int position, Object object) {
    Page page = Page.values()[position];
    container.removeView((View) object);
    page.view = null;
  }

  public static int getNumPages() {
    return Page.values().length;
  }

  enum Page {
    HOUSE(R.layout.what_house),
    INFO(R.layout.personal_info),
    SKILLS(R.layout.what_skills);

    int layout;
    View view;
    String primaryInput;
    String secondaryInput;

    Page(int layout) {
      this.layout = layout;
    }
  }

  private class PageChangeListener extends ViewPager.SimpleOnPageChangeListener {
    private int curPos;

    @Override
    public void onPageSelected(int position) {
      super.onPageSelected(position);
      // save input from old page
      Page oldPage = Page.values()[curPos];
      View first = oldPage.view.findViewById(R.id.primaryInput);
      if (first != null) {
        oldPage.primaryInput = resolveContent(first);
      }

      TextView second = (TextView) oldPage.view.findViewById(R.id.secondaryInput);
      if (second != null) {
        oldPage.secondaryInput = resolveContent(second);
      }
      curPos = position;
    }
  }

  private static final String UNKNOWN_VALUE = "unknown";
  private String resolveContent(View view) {
    if (view instanceof Spinner) {
      return ((Spinner) view).getSelectedItem().toString();
    } else if (view instanceof TextView) {
      return ((TextView) view).getText().toString();
    } else {
      return UNKNOWN_VALUE;
    }
  }
}
