package com.acadview.fragment_assignment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONObject;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity implements clickListener {

    String headline,article;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_articles);



        String json = null;
        try {
            InputStream is = getApplication().getAssets().open("news.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
            Log.d("TEST",json);
            JSONObject obj = new JSONObject(json);

            headline=obj.getString("news");
            article=obj.getString("headline");

        } catch (Exception ex) {
            ex.printStackTrace();}




        HeadlineFragment headlineFragment = new HeadlineFragment();
        Fragment fragment = headlineFragment;
        Bundle bundle = new Bundle();
        bundle.putString("headline",headline);
        headlineFragment.setArguments(bundle);

        FragmentManager fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction().add(R.id.fragment_container,headlineFragment).commit();




        ArticleFragment articleFragment = new ArticleFragment();
        Fragment fragmentArticles = headlineFragment;
        Bundle bundleA = new Bundle();
        bundle.putString("article",article);
        headlineFragment.setArguments(bundle);

        FragmentManager fragmentManager2 = getSupportFragmentManager();

        fragmentManager.beginTransaction().add(R.id.fragment_container,articleFragment).commit();




    }

    @Override
    public void onClick() {

    }
}
