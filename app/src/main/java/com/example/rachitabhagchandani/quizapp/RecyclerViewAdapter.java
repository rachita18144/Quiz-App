package com.example.rachitabhagchandani.quizapp;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private String[] mDataset;

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public CardView myCardView;
        public TextView mTextView;
        public MyViewHolder(View view) {
            super(view);
            view.setOnClickListener(this);
            mTextView = (TextView) view.findViewById(R.id.textView);
            myCardView = (CardView) view.findViewById(R.id.card_view);
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(), "position = " + getLayoutPosition(), Toast.LENGTH_SHORT).show();
            Fragment myFragment = new QuizFragment();
            myFragment.getChildFragmentManager().beginTransaction().add(R.id.ques_container, myFragment).addToBackStack(null).commit();
        }
    }

    public RecyclerViewAdapter (String[] myDataset) {
        mDataset = myDataset;
    }

    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_view, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.mTextView.setText(mDataset[position]);
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }

}
