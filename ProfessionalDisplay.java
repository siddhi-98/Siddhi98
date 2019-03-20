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

public class ProfessionalDisplay extends AppCompatActivity {

    TextView getdesigtv,getorgtv,getstdtv,getenddtv,getidtv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professional_display);


        getdesigtv = (TextView)findViewById(R.id.getdesigtv);
        getorgtv = (TextView)findViewById(R.id.getorgtv);
        getstdtv = (TextView)findViewById(R.id.getstdtv);
        getenddtv  = (TextView)findViewById(R.id.getenddtv);
        getidtv = (TextView) findViewById(R.id.getidtv);

        Bundle b;
        b = getIntent().getExtras();
        String pid = b.getString("id");

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://139.59.65.145:9090/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestInterface requestInterface = retrofit.create(RequestInterface.class);

        Call<prof_output> call = requestInterface.dispprof(Integer.parseInt(pid));

        call.enqueue(new Callback<prof_output>() {
            @Override
            public void onResponse(Call<prof_output> call, Response<prof_output> response) {

                prof_output ppojo = response.body();

                profdata data = ppojo.getData();

                String start = data.getStart_date();
                String endd = data.getEnd_date();
                String organization = data.getOrganisation();
                String d = data.getDesignation();
                String uid = data.getId();

                getdesigtv.setText(d);
                getorgtv.setText(organization);
                getstdtv.setText(start);
                getenddtv.setText(endd);
                getidtv.setText(uid);


            }

            @Override
            public void onFailure(Call<prof_output> call, Throwable t) {

                Toast.makeText(getApplicationContext(),"error "+t.getMessage(),Toast.LENGTH_LONG);
            }
        });


    }
}
