package com.codepath.apps.basictwitter;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpResponseHandler;

public class ComposeActivity extends Activity {
    private TwitterClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose);
        client = TwitterClientApp.getRestClient();
    }

    public void composeTweet(String tweetBody){
        Log.d("Debug","In compose method of twitter app");
        client.postNew(new AsyncHttpResponseHandler(){
            @Override
            public void onFailure(Throwable e, String s){
                Log.d("Debug",e.toString());
                Log.d("Debug",s.toString());

            }

            @Override
            public void onSuccess(String s) {
                Log.d("Debug","Success Reply");
                Toast.makeText(getApplicationContext(), "Compose Success", Toast.LENGTH_SHORT).show();
                Log.d("Debug", s.toString());
                finish();

            }
        }, tweetBody);
    }

    public void writeTweet(View v){
        Log.d("Debug","In writeTweet method of twitter app");
        EditText writtenTweet = (EditText) findViewById(R.id.txtCompose);
        String tweetText = writtenTweet.getText().toString();
        Log.d("Debug",tweetText);
        composeTweet(tweetText);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.compose, menu);
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
