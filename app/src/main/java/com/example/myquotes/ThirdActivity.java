package com.example.myquotes;


import android.os.Bundle;


import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        RecyclerView quoteList = findViewById(R.id.quote);
        quoteList.setLayoutManager(new LinearLayoutManager(this ));
        quoteList.setAdapter(new QuotesAdapter(getQuotes(), this));
    }

    private List<String> getQuotes(){
        List<String> quotes = new ArrayList<>();
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new InputStreamReader(this.getAssets().open("quotes.txt"), "UTF-8"));
            String line;
            while ((line = bufferedReader.readLine()) != null){
                quotes.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return  quotes;
    }
}
