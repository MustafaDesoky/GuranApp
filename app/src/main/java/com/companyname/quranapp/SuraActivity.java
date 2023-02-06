package com.companyname.quranapp;

import android.os.Bundle;
import com.companyname.quranapp.adapters.SuraAdapter;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SuraActivity extends AppCompatActivity {

    ArrayList<String> suraItself;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    SuraAdapter adapter;
    TextView textViewSuraName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sura);
        String suraName=getIntent().getStringExtra("sura name");
        String fileName=getIntent().getStringExtra("file name");
        readFile(fileName);
        textViewSuraName=findViewById(R.id.sura_name_tv);
        textViewSuraName.setText(suraName);
        recyclerView=findViewById(R.id.recycle_sura);
        adapter=new SuraAdapter(suraItself);
        layoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }

    public List<String> readFile(String fileName){
        suraItself=new ArrayList<>();
        BufferedReader reader;
        try {
            final InputStream file=getAssets().open(fileName);
            reader = new BufferedReader(new InputStreamReader(file));
            String lineReader=reader.readLine();
            while (lineReader != null){
                suraItself.add(lineReader);
                lineReader=reader.readLine();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return suraItself;
    }

}