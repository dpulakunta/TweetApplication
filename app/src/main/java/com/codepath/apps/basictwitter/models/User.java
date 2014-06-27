package com.codepath.apps.basictwitter.models;

import org.json.JSONObject;

/**
 * Created by dharm on 6/26/14.
 */
public class User {
    public String getName() {
        return name;
    }

    public Long getUid() {
        return uid;
    }

    public String getScreenName() {
        return screenName;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    private String name;
    private Long uid;
    private String screenName;
    private String profileImageUrl;

    public static User fromJson(JSONObject json) {
        User user = new User();
        try{
            user.name = json.getString("name");
            user.uid = json.getLong("id");
            user.screenName = json.getString("screen_name");
            user.profileImageUrl = json.getString("profile_image_url");
        } catch(Exception e){
            e.printStackTrace();
            return null;
        }
    return user;
    }
}