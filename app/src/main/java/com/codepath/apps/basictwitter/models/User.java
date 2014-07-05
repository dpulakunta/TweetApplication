package com.codepath.apps.basictwitter.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import org.json.JSONObject;

/**
 * Created by dharm on 6/26/14.
 */
@Table(name = "Users")
public class User extends Model{
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

    @Column(name = "Name")
    private String name;
    @Column(name = "Uid", unique = true, onUniqueConflict = Column.ConflictAction.REPLACE)
    private Long uid;
    @Column(name = "screenName")
    private String screenName;
    @Column(name = "profileImageUrl")
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
        //user.save();
    return user;
    }
}