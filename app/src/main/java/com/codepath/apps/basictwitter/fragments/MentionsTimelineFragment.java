package com.codepath.apps.basictwitter.fragments;

import android.os.Bundle;
import android.util.Log;

import com.codepath.apps.basictwitter.TwitterClient;
import com.codepath.apps.basictwitter.TwitterClientApp;
import com.codepath.apps.basictwitter.models.Tweet;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;

/**
 * Created by dharm on 7/4/14.
 */
public class MentionsTimelineFragment extends TweetsListFragment {
    private TwitterClient client;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        client = TwitterClientApp.getRestClient();

        populateTimeLine();
    }

    public void populateTimeLine(){

        client.getMentionsTimeline(new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(JSONArray json) {
                addAll(Tweet.fromJson(json));
                Log.d("Debug", json.toString());

            }

            @Override
            public void onFailure(Throwable e, String s){
                Log.d("Debug",e.toString());

            }
        });
    }
}
