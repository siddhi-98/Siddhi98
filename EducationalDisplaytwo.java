package com.example.sidster.apiintegration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EducationalDisplaytwo extends AppCompatActivity {

    TextView getdegreetv,getorgtv,getloctv,getstytv,getendytv,getidtv;

    String uid,start,end,org,location,degree;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_educational_displaytwo);

        getdegreetv = (TextView)findViewById(R.id.getdesigtv);
        getorgtv = (TextView)findViewById(R.id.getorgtv);
        getloctv = (TextView)findViewById(R.id.getloctv);
        getstytv = (TextView)findViewById(R.id.getstytv);
        getendytv = (TextView)findViewById(R.id.getendytv);
        getidtv = (TextView)findViewById(R.id.getidtv);


                String m = "Details deleted!";

              /*  Retrofit retrofit = new Retrofit.Builder().baseUrl("http://139.59.65.145:9090/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                RequestInterface requestInterface = retrofit.create(RequestInterface.class);*/



                Bundle bund = getIntent().getExtras();
                String i = bund.getString("id");


              /*  Call< statusMessage > calle = requestInterface.deleteedu(Integer.parseInt(i));
                calle.enqueue(new Callback<statusMessage>() {

                    String m="Details deleted!";
                    @Override
                    public void onResponse(Call<statusMessage> call, Response<statusMessage> response) {

                        statusMessage message = response.body();

                        if (message != null)
                            m = message.getStatus_message();


                        Toast.makeText(getApplicationContext(), m, Toast.LENGTH_LONG).show();*/

                        getdegreetv.setText("");
                        getorgtv.setText("");
                        getloctv.setText("");
                        getstytv.setText("");
                        getendytv.setText("");
                        getidtv.setText("");




                  /* @Override
                    public void onFailure(Call<statusMessage> call, Throwable t) {

                        Toast.makeText(getApplicationContext(),"error "+t.getMessage(),Toast.LENGTH_LONG);

                    }
                });*/






    }
}

