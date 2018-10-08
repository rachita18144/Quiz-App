package com.example.rachitabhagchandani.quizapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String answer;
    int id;

    RelativeLayoutFragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragment = new RelativeLayoutFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.layout_container, fragment);
        fragmentTransaction.commit();
    }

    public void openQuizFragment(String data, int id) {

        /// For sending data from activity to fragment (if needed)
        /// Would suggest you to use R.string for this.

        Bundle bundle = new Bundle();
        bundle.putString("question", data);
        bundle.putInt("id", id);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        QuizFragment quizFragment = new QuizFragment();
        quizFragment.setArguments(bundle);
        ft.replace(R.id.layout_container, quizFragment, quizFragment.toString());
        ft.addToBackStack(null);
        ft.commit();
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.radio_false:
                if (checked)
                    answer = "false";
                    break;
            case R.id.radio_true:
                if (checked)
                    answer = "true";
                    break;
        }
    }
    public void submitButtonClick(int id){
        Bundle args = new Bundle();
        args.putString("answer", answer);
        args.putInt("id", id);
        fragment.putArguments(args);
        Toast.makeText(this, "Submit button clicked" + id, Toast.LENGTH_LONG).show();
    }

    public void saveButtonClick(int id){
        Bundle args = new Bundle();
        args.putString("answer", answer);
        args.putInt("id", id);
        fragment.putArguments(args);
        Toast.makeText(this, "Save button clicked" + id, Toast.LENGTH_LONG).show();
    }
}
