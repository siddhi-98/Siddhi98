package com.example.sidster.apiintegration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PersonalDisplay extends AppCompatActivity {

    TextView getnametv,getlocationtv,getcontacttv,getlinktv,getskillstv,getidtv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_display);

        getnametv = (TextView)findViewById(R.id.getdesigtv);
        getlocationtv = (TextView)findViewById(R.id.getloctv);
        getcontacttv = (TextView)findViewById(R.id.getcontacttv);
        getidtv = (TextView)findViewById(R.id.getidtv);
        getlinktv = (TextView)findViewById(R.id.getlinktv);
        getskillstv = (TextView)findViewById(R.id.getskillstv);

        Bundle b;
        b = getIntent().getExtras();
        String pid = b.getString("id");

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://139.59.65.145:9090/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestInterface requestInterface = retrofit.create(RequestInterface.class);

        Call<personal_output> call = requestInterface.disppersonal(Integer.parseInt(pid));

        call.enqueue(new Callback<personal_output>() {
            @Override
            public void onResponse(Call<personal_output> call, Response<personal_output> response) {

                personal_output ppojo = response.body();

                Data data = ppojo.getData();

                String name = data.getName();
                String loc = data.getLocation();
                String mob = data.getMobile_no();
                String links = data.getLinks();
                String skill = data.getSkills();
                String Id = data.getId();


                getnametv.setText(name);
                getlocationtv.setText(loc);
                getcontacttv.setText(mob);
                getlinktv.setText(links);
                getskillstv.setText(skill);
                getidtv.setText(Id);


            }

            @Override
            public void onFailure(Call<personal_output> call, Throwable t) {

                Toast.makeText(getApplicationContext(),"error "+t.getMessage(),Toast.LENGTH_LONG);
            }
        });

    }
}
