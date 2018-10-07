package com.example.rachitabhagchandani.quizapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RelativeLayoutFragment fragment = new RelativeLayoutFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.layout_container, fragment);
        fragmentTransaction.commit();
    }

    public void openQuizFragment(String data) {

        /// For sending data from activity to fragment (if needed)
        /// Would suggest you to use R.string for this. Maine jaldi jaldi me kar diya hai ye

        Bundle bundle = new Bundle();
        bundle.putString("data", data);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        QuizFragment quizFragment = new QuizFragment();
        quizFragment.setArguments(bundle);
        ft.replace(R.id.layout_container, quizFragment, quizFragment.toString());
        ft.addToBackStack(null);
        ft.commit();
    }
}
