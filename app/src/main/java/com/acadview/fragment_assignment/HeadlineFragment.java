package com.acadview.fragment_assignment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class HeadlineFragment extends Fragment {

    TextView Headline;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.article_layout, container, false);
        Headline = v.findViewById(R.id.headLine);


        Bundle bundle = getArguments();


        Headline.setText(bundle.getString("headline"));


        return v;


    }
}