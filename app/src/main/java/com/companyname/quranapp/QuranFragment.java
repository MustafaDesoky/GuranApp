package com.companyname.quranapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.companyname.quranapp.adapters.QuranAdapter;


public class QuranFragment extends Fragment {
   public QuranFragment() {
        // Required empty public constructor
    }

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    QuranAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_quran, container, false);
        recyclerView=view.findViewById(R.id.quran_recyclerViwe);
        // cant give it this as context coz im in fragment so i gotta say getcontext
        layoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        adapter=new QuranAdapter(SwarHolder.arSwar);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        SnapHelper snapHelper=new LinearSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);

        adapter.setOnitemClickListener(new QuranAdapter.OnitemClickListener() {
            @Override
            public void onItemClik(int position,String suraName) {
                Intent intent=new Intent(getActivity(),SuraActivity.class);
                intent.putExtra("sura name",suraName);
                intent.putExtra("file name",(position+1)+".txt");
                startActivity(intent);
            }
        });
        return view;
    }
}