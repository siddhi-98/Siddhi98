package com.example.sidster.apiintegration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EducationalDetailsActivity extends AppCompatActivity {

    TextView etextview;
    EditText degreeedittext;
    EditText orgedittext;
    EditText locedittext;
    EditText startyedittext;
    EditText endyedittext;
    Button savebutton,updatebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_educational_details);

        etextview = (TextView)findViewById(R.id.etextview);
        degreeedittext = (EditText)findViewById(R.id.degreeedittext);
        orgedittext = (EditText)findViewById(R.id.orgedittext);
        locedittext = (EditText)findViewById(R.id.locedittext);
        startyedittext = (EditText)findViewById(R.id.startyedittext);
        endyedittext = (EditText)findViewById(R.id.endyedittext);
        savebutton = (Button)findViewById(R.id.savebutton);
        updatebtn = (Button)findViewById(R.id.updatebtn);



        savebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Retrofit retrofit = new Retrofit.Builder().baseUrl("http://139.59.65.145:9090/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                Bundle bund = getIntent().getExtras();
                final String i = bund.getString("id");

                RequestInterface requestInterface = retrofit.create(RequestInterface.class);

                String d = degreeedittext.getText().toString();
                String o = orgedittext.getText().toString();
                String l = locedittext.getText().toString();
                String s = startyedittext.getText().toString();
                String e = endyedittext.getText().toString();

                Call<edu_output> calle = requestInterface.education(Integer.parseInt(i),new edu_input(s,d,o,l,e));

                calle.enqueue(new Callback<edu_output>() {
                    @Override
                    public void onResponse(Call<edu_output> call, Response<edu_output> response) {

                        edu_output epojo = response.body();

                        pdata data = epojo.getData();


                        String start = data.getStart_year();
                        String end = data.getEnd_year();
                        String location = data.getLocation();
                        String org = data.getOrganisation();
                        String degree = data.getDegree();
                        String id = data.getId();


                        Bundle b = new Bundle();
                        b.putString("id",i);
                        Intent intent = new Intent(getApplicationContext(),ProfessionalDetailsActivity.class);
                        intent.putExtras(b);
                        startActivity(intent);

                    }

                    @Override
                    public void onFailure(Call<edu_output> call, Throwable t) {

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

                Bundle bund = getIntent().getExtras();
                final String i = bund.getString("id");

                RequestInterface requestInterface = retrofit.create(RequestInterface.class);

                String d = degreeedittext.getText().toString();
                String o = orgedittext.getText().toString();
                String l = locedittext.getText().toString();
                String s = startyedittext.getText().toString();
                String e = endyedittext.getText().toString();

                Call<edu_output> calle = requestInterface.updateedu(Integer.parseInt(i),new edu_input(s,d,o,l,e));

                calle.enqueue(new Callback<edu_output>() {
                    @Override
                    public void onResponse(Call<edu_output> call, Response<edu_output> response) {

                        edu_output epojo = response.body();

                        pdata data = epojo.getData();


                        String start = data.getStart_year();
                        String end = data.getEnd_year();
                        String location = data.getLocation();
                        String org = data.getOrganisation();
                        String degree = data.getDegree();
                        String id = data.getId();


                        Toast.makeText(getApplicationContext(),"Details Updated!",Toast.LENGTH_LONG).show();

                        Bundle b = new Bundle();
                        b.putString("id",i);

                        Intent intent = new Intent(getApplicationContext(),EducationalDisplay.class);
                        intent.putExtras(b);
                        startActivity(intent);

                    }

                    @Override
                    public void onFailure(Call<edu_output> call, Throwable t) {

                        Toast.makeText(getApplicationContext(),"error "+t.getMessage(),Toast.LENGTH_LONG);

                    }
                });


                }
        });

    }
}
