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

public class EducationalDisplay extends AppCompatActivity {

    TextView getdegreetv,getorgtv,getloctv,getstytv,getendytv,getidtv;

    String uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_educational_display);

        getdegreetv = (TextView)findViewById(R.id.getdesigtv);
        getorgtv = (TextView)findViewById(R.id.getorgtv);
        getloctv = (TextView)findViewById(R.id.getloctv);
        getstytv = (TextView)findViewById(R.id.getstytv);
        getendytv = (TextView)findViewById(R.id.getendytv);
        getidtv = (TextView)findViewById(R.id.getidtv);



        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://139.59.65.145:9090/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Bundle bund = getIntent().getExtras();
        String i = bund.getString("id");

        RequestInterface requestInterface = retrofit.create(RequestInterface.class);

        Call<edu_output> calle = requestInterface.dispedu(Integer.parseInt(i));

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
                 uid = data.getId();


                getdegreetv.setText(degree);
                getorgtv.setText(org);
                getloctv.setText(location);
                getstytv.setText(start);
                getendytv.setText(end);
                getidtv.setText(uid);


            }

            @Override
            public void onFailure(Call<edu_output> call, Throwable t) {

                Toast.makeText(getApplicationContext(),"error "+t.getMessage(),Toast.LENGTH_LONG);

            }
        });




    }
}
