package com.java.base.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.java.base.R;

/**
 * Created by frank on 2016/12/14.
 */

public class TestFragment extends Fragment {

    public final static String CONTENT = "content";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test, container, false);
        String content = getArguments().getString(CONTENT);
        TextView textView = (TextView) view.findViewById(R.id.tv_content);
        textView.setText(content);
        return view;
    }
}
