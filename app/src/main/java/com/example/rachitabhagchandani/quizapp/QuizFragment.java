package com.example.rachitabhagchandani.quizapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuizFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //////// IF YOU WANT TO ACCESS DATA INSIDE FRAGMENT USE THIS
        //////// String dataFromActivity = getArguments().getString("data");
        View view = inflater.inflate(R.layout.activity_main, container, false);
        return inflater.inflate(R.layout.quiz_fragment, container, false);
    }
}
