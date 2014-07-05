package com.codepath.apps.basictwitter.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.codepath.apps.basictwitter.R;
import com.codepath.apps.basictwitter.TweetAdapter;
import com.codepath.apps.basictwitter.models.Tweet;

import java.util.ArrayList;

/**
 * Created by dharm on 7/4/14.
 */
public class TweetsListFragment extends Fragment {
    private ArrayList<Tweet> tweets;
    private TweetAdapter aTweets;
    private ListView lvListView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tweets = new ArrayList<Tweet>();
        aTweets = new TweetAdapter(getActivity(),tweets);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tweets_list, container, false);

        lvListView = (ListView)v.findViewById(R.id.lvTweets);
        lvListView.setAdapter(aTweets);

//        lvListView.setOnScrollListener(new EndlessScrollListener() {
//            @Override
//            public void onLoadMore(int page, int totalItemsCount) {
//                Log.d("Debug", "setting pull to refresh");
//                if (totalItemsCount != 0) {
//                    Tweet lastTweet = tweets.get(totalItemsCount - 1);
//                    long max = lastTweet.getUid();
//                    client.getHomeTimeline(new JsonHttpResponseHandler() {
//                        @Override
//                        public void onSuccess(JSONArray json) {
//                            aTweets.addAll(Tweet.fromJson(json));
//                            Log.d("Debug", json.toString());
//
//                        }
//
//                        @Override
//                        public void onFailure(Throwable e, String s) {
//                            Log.d("Debug", e.toString());
//
//                        }
//                    }, Long.toString(max));
//
//                }
//            }
//        });

        return v;
    }

    public void addAll(ArrayList<Tweet> tweets){
        aTweets.addAll(tweets);
    }

}
