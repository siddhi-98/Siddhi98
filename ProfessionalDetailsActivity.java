package com.example.sidster.apiintegration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProfessionalDetailsActivity extends AppCompatActivity {

    EditText startedittext,endedittext,orgedittext,designationedittext;
    Button savebtn,updatebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professional_details);

        startedittext = (EditText)findViewById(R.id.startedittext);
        endedittext = (EditText)findViewById(R.id.endedittext);
        orgedittext = (EditText)findViewById(R.id.orgedittext);
        designationedittext = (EditText)findViewById(R.id.designationedittext);
        savebtn = (Button)findViewById(R.id.savebutton);
        updatebtn = (Button)findViewById(R.id.updatebtn);

        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String st = startedittext.getText().toString();
                String end = endedittext.getText().toString();
                String org = orgedittext.getText().toString();
                String des = designationedittext.getText().toString();


                Retrofit retrofit = new Retrofit.Builder().baseUrl("http://139.59.65.145:9090/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                RequestInterface requestInterface = retrofit.create(RequestInterface.class);

                Bundle bu = getIntent().getExtras();
                String pass = bu.getString("id");

                Call<prof_output> call = requestInterface.prof(Integer.parseInt(pass),new prof_input(end,org,des,st));

                call.enqueue(new Callback<prof_output>() {
                    @Override
                    public void onResponse(Call<prof_output> call, Response<prof_output> response) {

                        prof_output ppojo = response.body();

                        profdata data = ppojo.getData();

                       String start = data.getStart_date();
                       String endd = data.getEnd_date();
                       String organization = data.getOrganisation();
                       String d = data.getDesignation();


                        Intent intnt = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intnt);

                    }

                    @Override
                    public void onFailure(Call<prof_output> call, Throwable t) {

                        Toast.makeText(getApplicationContext(),"error "+t.getMessage(),Toast.LENGTH_LONG);

                    }
                });







            }
        });


        updatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String st = startedittext.getText().toString();
                String end = endedittext.getText().toString();
                String org = orgedittext.getText().toString();
                String des = designationedittext.getText().toString();


                Retrofit retrofit = new Retrofit.Builder().baseUrl("http://139.59.65.145:9090/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                RequestInterface requestInterface = retrofit.create(RequestInterface.class);

                Bundle bu = getIntent().getExtras();
                final String pass = bu.getString("id");

                Call<prof_output> call = requestInterface.updateprof(Integer.parseInt(pass),new prof_input(end,org,des,st));

                call.enqueue(new Callback<prof_output>() {
                    @Override
                    public void onResponse(Call<prof_output> call, Response<prof_output> response) {

                        prof_output ppojo = response.body();

                        profdata data = ppojo.getData();

                        String start = data.getStart_date();
                        String endd = data.getEnd_date();
                        String organization = data.getOrganisation();
                        String d = data.getDesignation();

                        Toast.makeText(getApplicationContext(),"Details Updated!",Toast.LENGTH_LONG).show();

                        Bundle b = new Bundle();
                        b.putString("id",pass);

                        Intent intnt = new Intent(getApplicationContext(),ProfessionalDisplay.class);
                        intnt.putExtras(b);
                        startActivity(intnt);

                    }

                    @Override
                    public void onFailure(Call<prof_output> call, Throwable t) {

                        Toast.makeText(getApplicationContext(),"error "+t.getMessage(),Toast.LENGTH_LONG);

                    }
                });










            }
        });


    }
}
