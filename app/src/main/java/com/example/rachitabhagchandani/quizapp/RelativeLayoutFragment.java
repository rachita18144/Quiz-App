package com.example.rachitabhagchandani.quizapp;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class RelativeLayoutFragment extends Fragment implements RecyclerViewClickListener {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.relative_layout_fragment, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        //recyclerView = new RecyclerView(getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        String[] myDataset = {"Cheese", "Pepperoni", "Black Olives", "Cheese", "Pepperoni", "Black Olives", "Cheese", "Pepperoni", "Black Olives"};
        recyclerView.setAdapter(new RecyclerViewAdapter(myDataset));
        return view;
    }


    @Override
    public void onClick(View view, int position) {
        Toast.makeText(getActivity(), position, Toast.LENGTH_LONG).show();
    }

    /*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.relative_layout_fragment);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);

        String[] myDataset = {"Cheese", "Pepperoni", "Black Olives", "Cheese", "Pepperoni", "Black Olives", "Cheese", "Pepperoni", "Black Olives"};
        mAdapter = new RecyclerViewAdapter(myDataset);
        recyclerView.setAdapter(mAdapter);
    }*/
}


