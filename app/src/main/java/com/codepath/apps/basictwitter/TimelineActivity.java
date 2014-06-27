package com.codepath.apps.basictwitter;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.codepath.apps.basictwitter.models.Tweet;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;

import java.util.ArrayList;

public class TimelineActivity extends Activity {
    private TwitterClient client;
    private ArrayList<Tweet> tweets;
    private ArrayAdapter<Tweet> aTweets;
    private ListView lvListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);
        client = TwitterClientApp.getRestClient();
        populateTimeLine();
        lvListView = (ListView)findViewById(R.id.lvTweets);
        tweets = new ArrayList<Tweet>();
        aTweets = new ArrayAdapter<Tweet>(this,android.R.layout.simple_list_item_1,tweets);
        lvListView.setAdapter(aTweets);

    }
     public void populateTimeLine(){
        client.getHomeTimeline(new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(JSONArray json) {
                aTweets.addAll(Tweet.fromJson(json));
                Log.d("Debug", json.toString());

            }

            @Override
            public void onFailure(Throwable e, String s){
                Log.d("Debug",e.toString());
                Log.d("Debug",s.toString());
            }
        });
     }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.timeline, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}