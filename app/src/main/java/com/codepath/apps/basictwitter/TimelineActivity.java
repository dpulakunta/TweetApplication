package com.codepath.apps.basictwitter;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.codepath.apps.basictwitter.fragments.HomeTimelineFragment;
import com.codepath.apps.basictwitter.fragments.MentionsTimelineFragment;
import com.codepath.apps.basictwitter.listener.FragmentTabListener;

public class TimelineActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);
        setupTabs();
    }
    private void setupTabs() {
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.setDisplayShowTitleEnabled(true);

        ActionBar.Tab tab1 = actionBar
                .newTab()
                .setText("Home")
                .setIcon(R.drawable.ic_home)
                .setTag("HomeTimelineFragment")
                .setTabListener(
                        new FragmentTabListener<HomeTimelineFragment>(R.id.flContainer, this, "first",
                                HomeTimelineFragment.class));

        actionBar.addTab(tab1);
        actionBar.selectTab(tab1);

        ActionBar.Tab tab2 = actionBar
                .newTab()
                .setText("Mentions  ")
                .setIcon(R.drawable.ic_mention)
                .setTag("MentionsTimelineFragment")
                .setTabListener(
                        new FragmentTabListener<MentionsTimelineFragment>(R.id.flContainer, this, "second",
                                MentionsTimelineFragment.class));

        actionBar.addTab(tab2);
    }

}
