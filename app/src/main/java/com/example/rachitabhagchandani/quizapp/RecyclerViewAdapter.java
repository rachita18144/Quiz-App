package com.example.rachitabhagchandani.quizapp;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    String[] mDataset = new String[100];
    Context mContext;

    public RecyclerViewAdapter(String[] dataSet, Context mcontext) {
        this.mDataset = dataSet;
        this.mContext = mcontext;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView txtViewTitle;
        public CardView cardView;
        public IMyViewHolderClicks mListener;

        public ViewHolder(View itemLayoutView, IMyViewHolderClicks listener) {
            super(itemLayoutView);
            mListener = listener;
            cardView = (CardView) itemLayoutView.findViewById(R.id.card_view);
            txtViewTitle = (TextView) itemLayoutView.findViewById(R.id.textView);
            txtViewTitle.setOnClickListener(this);
            itemLayoutView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (v instanceof CardView) {
                mListener.itemClicked((CardView) v);
            }
        }

        public static interface IMyViewHolderClicks {
            public void itemClicked(CardView cardView);
        }

    }


    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_view, parent, false);

        RecyclerViewAdapter.ViewHolder vh = new ViewHolder(v, new RecyclerViewAdapter.ViewHolder.IMyViewHolderClicks() {
            public void itemClicked(CardView cardView) {
                MainActivity mainActivity = (MainActivity) mContext;

                // this will open replace current frgament to quiz fragment
                mainActivity.openQuizFragment(mDataset[Integer.parseInt(cardView.getTag(R.string.list_index).toString())]);
            }
        });
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txtViewTitle.setText(mDataset[position]);
        holder.cardView.setTag(R.string.list_index, position);

    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}
