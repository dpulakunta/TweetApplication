package com.codepath.apps.basictwitter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.codepath.apps.basictwitter.models.Tweet;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by dharm on 6/26/14.
 */
public class TweetAdapter extends ArrayAdapter<Tweet> {
    public TweetAdapter(Context context, List<Tweet> tweets) {
        super(context, 0, tweets);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Tweet tweet = getItem(position);
        View v;
        if(convertView == null){
            LayoutInflater inflator = LayoutInflater.from(getContext());
            v = inflator.inflate(R.layout.tweet_layout,parent,false);

        } else {
            v = convertView;
        }
        ImageView ivProfileImage = (ImageView) v.findViewById(R.id.ivProfileImage);
        TextView tvUserName = (TextView) v.findViewById(R.id.tvScreenName);
        TextView tvBody = (TextView) v.findViewById(R.id.tvBody);
        TextView created = (TextView) v.findViewById(R.id.timeStamp);
        ivProfileImage.setImageResource(android.R.color.transparent);
        ImageLoader imgLoader = ImageLoader.getInstance();

        imgLoader.displayImage(tweet.getUser().getProfileImageUrl(),ivProfileImage);
        tvUserName.setText(tweet.getUser().getScreenName());
        tvBody.setText(tweet.getBody());

        String createdTime = tweet.getCreatedAt();
        created.setText(timeCalci(createdTime));
        Log.d("Debug",createdTime);

        return v;

    }
    public String timeCalci(String createdTime){
        DateFormat df = new SimpleDateFormat("EEE MMM dd HH:mm:ss ZZZZZ yyyy");
        String currentTime = df.format(Calendar.getInstance().getTime());
        Date startDate = null;
        Date curTime = null;
        String created = new String();
        try {
            startDate = df.parse(createdTime);
            curTime = df.parse(currentTime);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        long diff = curTime.getTime() - startDate.getTime();
        long diffDays = diff / (24 * 60 * 60 * 1000);
        if(diffDays > 1) {
            created = (diffDays + " d");
            return created;
        }
        long diffHours = diff / (60 * 60 * 1000) % 24;
        if(diffHours > 1) {
            created = (diffHours + " hr");
            return created;
        }
        long diffMinutes = diff / (60 * 1000) % 60;
        if(diffMinutes > 1) {
            created = (diffMinutes + " m");
            return created;
        }
        long diffSeconds = diff / 1000 % 60;

        created = (diffSeconds + " s");
        return created;
    }
}
