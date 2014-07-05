package com.codepath.apps.basictwitter.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by dharm on 6/26/14.
 */
@Table(name = "Tweets")
public class Tweet extends Model {
    @Column(name = "Body")
    private String body;
    @Column(name = "Uid",unique = true)
    private Long uid;
    @Column(name = "CreatedAt")
    private String createdAt;
    @Column(name = "User", onDelete = Column.ForeignKeyAction.CASCADE)
    private User user;



    public String getBody() {
        return body;
    }

    public Long getUid() {
        return uid;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public User getUser() {
        return user;
    }

    public static Tweet fromJson(JSONObject jsonObject){
        Tweet tweet = new Tweet();
        //Extract the values in between
        try{
            tweet.body = jsonObject.getString("text");
            tweet.uid = jsonObject.getLong("id");
            tweet.createdAt = jsonObject.getString("created_at");
            tweet.user = User.fromJson(jsonObject.getJSONObject("user"));
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }

        //tweet.save();
        return tweet;
    }
    public static ArrayList<Tweet> fromJson(JSONArray jsonArray){
        ArrayList<Tweet> tweets = new ArrayList<Tweet>();
        for(int i = 0; i < jsonArray.length();i++){
            JSONObject tweetJson = null;
            try{
                tweetJson = jsonArray.getJSONObject(i);
            } catch(Exception e){

            }
            Tweet tweet = Tweet.fromJson(tweetJson);
            if(tweet != null){
                tweets.add(tweet);
            }
        }
        return tweets;
    }

    @Override
    public String toString() {
        return getBody() + " - " + getUser().getScreenName();
    }
}
