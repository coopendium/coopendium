package coop.endium.section;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/**
 * Created by mlaux on 12/5/15.
 */
public enum Section {
  INT_TRUST("Intellectual Trust", null),
  GOAL_DIR("Goal Directory", null),
  TASK_ENGINE("Task Engine", null),
  SKILL_SOURCE("Skill Source", null),
  RESOURCE_POOL("Resource Pool", ResourcePool.class),
  NEEDS_BANK("Needs Bank", null);

  private final String name;
  private final Class<? extends Activity> activityClass;

  Section(String name, Class<? extends Activity> actClass) {
    this.name = name;
    this.activityClass = actClass;
  }

  public String getName() {
    return name;
  }

  public Intent getLaunchIntent(Context ctx) {
    return new Intent(ctx, activityClass);
  }
}
