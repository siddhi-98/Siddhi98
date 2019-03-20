package com.example.sidster.apiintegration;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PersonalDetailActivity extends AppCompatActivity {

    TextView ptextview;
    EditText nameet;
    EditText emailet;
    EditText locet;
    EditText skillet;
    EditText contactet;
    Button savebtn,updatebtn;
    EditText linket;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_detail);

        nameet = (EditText)findViewById(R.id.namet);
        emailet = (EditText)findViewById(R.id.emailet);
        locet = (EditText)findViewById(R.id.locationet);
        contactet = (EditText)findViewById(R.id.contactet);
        skillet = (EditText)findViewById(R.id.skillet);
        linket = (EditText)findViewById(R.id.linket);
        savebtn = (Button)findViewById(R.id.savebutton);
        updatebtn = (Button)findViewById(R.id.updatebtn);


        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Retrofit retrofit = new Retrofit.Builder().baseUrl("http://139.59.65.145:9090/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                RequestInterface requestInterface = retrofit.create(RequestInterface.class);

                String n = nameet.getText().toString();
                String e = emailet.getText().toString();
                String s = skillet.getText().toString();
                String l = locet.getText().toString();
                String c = contactet.getText().toString();
                String lk = linket.getText().toString();



               Bundle b = getIntent().getExtras();
               final String pass = b.getString("id");



                Call<personal_output> call = requestInterface.personal(Integer.parseInt(pass),new personal_input(s,c,n,lk,l,e));

                call.enqueue(new Callback<personal_output>() {
                    @Override
                    public void onResponse(Call<personal_output> call, Response<personal_output> response) {

                        personal_output ppojo = response.body();


                        Data data = ppojo.getData();


                        String skill = data.getSkills();

                        String mob = data.getMobile_no();
                        String name = data.getName();
                        String links = data.getLinks();
                        String loc = data.getLocation();

                        String em = data.getEmail();

                        Bundle bun = new Bundle();
                        bun.putString("id",pass);
                       Intent intent = new Intent(getApplicationContext(),EducationalDetailsActivity.class);
                       intent.putExtras(bun);
                       startActivity(intent);

                    }

                    @Override
                    public void onFailure(Call<personal_output> call, Throwable t) {

                        Toast.makeText(getApplicationContext(),"error "+t.getMessage(),Toast.LENGTH_LONG);

                    }
                });



            }
        });


        updatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Retrofit retrofit = new Retrofit.Builder().baseUrl("http://139.59.65.145:9090/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                RequestInterface requestInterface = retrofit.create(RequestInterface.class);

                String n = nameet.getText().toString();
                String e = emailet.getText().toString();
                String s = skillet.getText().toString();
                String l = locet.getText().toString();
                String c = contactet.getText().toString();
                String lk = linket.getText().toString();



                Bundle b = getIntent().getExtras();
                final String pass = b.getString("id");



                Call<personal_output> call = requestInterface.updatepersonal(Integer.parseInt(pass),new personal_input(s,c,n,lk,l,e));

                call.enqueue(new Callback<personal_output>() {
                    @Override
                    public void onResponse(Call<personal_output> call, Response<personal_output> response) {

                        personal_output ppojo = response.body();


                        Data data = ppojo.getData();


                        String skill = data.getSkills();

                        String mob = data.getMobile_no();
                        String name = data.getName();
                        String links = data.getLinks();
                        String loc = data.getLocation();

                        String em = data.getEmail();


                         Toast.makeText(getApplicationContext(),"Details Updated!",Toast.LENGTH_LONG).show();

                        Bundle bun = new Bundle();
                        bun.putString("id",pass);
                        Intent intent = new Intent(getApplicationContext(),PersonalDisplay.class);
                        intent.putExtras(bun);
                        startActivity(intent);

                    }

                    @Override
                    public void onFailure(Call<personal_output> call, Throwable t) {

                        Toast.makeText(getApplicationContext(),"error "+t.getMessage(),Toast.LENGTH_LONG);

                    }
                });






            }
        });



    }
}
