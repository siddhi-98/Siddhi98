package com.example.sidster.apiintegration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ProfessionalDisplaytwo extends AppCompatActivity {

    TextView getdesigtv,getorgtv,getstdtv,getenddtv,getidtv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professional_displaytwo);


        getdesigtv = (TextView)findViewById(R.id.getdesigtv);
        getorgtv = (TextView)findViewById(R.id.getorgtv);
        getstdtv = (TextView)findViewById(R.id.getstdtv);
        getenddtv = (TextView)findViewById(R.id.getenddtv);
        getidtv = (TextView)findViewById(R.id.getidtv);


        String m = "Details deleted!";

              /*  Retrofit retrofit = new Retrofit.Builder().baseUrl("http://139.59.65.145:9090/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                RequestInterface requestInterface = retrofit.create(RequestInterface.class);*/



        Bundle bund = getIntent().getExtras();
        String i = bund.getString("id");


              /*  Call< statusMessage > calle = requestInterface.deleteprof(Integer.parseInt(i));
                calle.enqueue(new Callback<statusMessage>() {

                    String m="Details deleted!";
                    @Override
                    public void onResponse(Call<statusMessage> call, Response<statusMessage> response) {

                        statusMessage message = response.body();

                        if (message != null)
                            m = message.getStatus_message();


                        Toast.makeText(getApplicationContext(), m, Toast.LENGTH_LONG).show();*/

        getdesigtv.setText("");
        getorgtv.setText("");
        getstdtv.setText("");
        getenddtv.setText("");
        getidtv.setText("");




                  /* @Override
                    public void onFailure(Call<statusMessage> call, Throwable t) {

                        Toast.makeText(getApplicationContext(),"error "+t.getMessage(),Toast.LENGTH_LONG);

                    }
                });*/





    }
}
