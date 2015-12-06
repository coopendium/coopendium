package coop.endium.section;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import coop.endium.BaseActivity;
import coop.endium.R;

/**
 * Created by mlaux on 12/5/15.
 */
public class ResourcePool extends BaseActivity {
  private ListView resourcesList;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_resource_pool);
    resourcesList = (ListView) findViewById(R.id.resources);
    resourcesList.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
            android.R.id.text1, getResources().getStringArray(R.array.resource_pool_demo_items)));
  }
}
