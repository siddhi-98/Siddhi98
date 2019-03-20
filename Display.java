package com.example.sidster.apiintegration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Display extends AppCompatActivity {

    Button pdbtn,edbtn,editpbtn,profbtn,editebtn,editprofbtn,deleteedubtn;
    String uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        pdbtn = (Button)findViewById(R.id.pdbutton);
        edbtn = (Button)findViewById(R.id.edbutton);
        editpbtn = (Button)findViewById(R.id.editpbtn);
        profbtn = (Button)findViewById(R.id.profbutton);
        editebtn = (Button)findViewById(R.id.editebtn);
        editprofbtn=(Button)findViewById(R.id.editprofbtn);
        deleteedubtn = (Button)findViewById(R.id.deleteedubtn);

        pdbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle b = getIntent().getExtras();
                String id = b.getString("p");

                Bundle bund = new Bundle();
                bund.putString("id",id);
                Intent i = new Intent(getApplicationContext(),PersonalDisplay.class);
                i.putExtras(bund);
                startActivity(i);

            }
        });

        edbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle b = getIntent().getExtras();
                String id = b.getString("p");

                Bundle bund = new Bundle();
                bund.putString("id",id);
                Intent i = new Intent(getApplicationContext(),EducationalDisplay.class);
                i.putExtras(bund);
                startActivity(i);

            }
        });

        profbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle b = getIntent().getExtras();
                String id = b.getString("p");

                Bundle bund = new Bundle();
                bund.putString("id",id);
                Intent i = new Intent(getApplicationContext(),ProfessionalDisplay.class);
                i.putExtras(bund);
                startActivity(i);

            }
        });


        editpbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle b = getIntent().getExtras();
                String id = b.getString("p");

                Bundle bund = new Bundle();
                bund.putString("id",id);
                Intent i = new Intent(getApplicationContext(),PersonalDetailActivity.class);
                i.putExtras(bund);
                startActivity(i);

            }
        });

        editebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle b = getIntent().getExtras();
                String id = b.getString("p");

                Bundle bund = new Bundle();
                bund.putString("id",id);
                Intent i = new Intent(getApplicationContext(),EducationalDetailsActivity.class);
                i.putExtras(bund);
                startActivity(i);



            }
        });

        editprofbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle b = getIntent().getExtras();
                String id = b.getString("p");

                Bundle bund = new Bundle();
                bund.putString("id",id);
                Intent i = new Intent(getApplicationContext(),ProfessionalDetailsActivity.class);
                i.putExtras(bund);
                startActivity(i);

            }
        });


        deleteedubtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Bundle b = getIntent().getExtras();
                String id = b.getString("p");


                        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://139.59.65.145:9090/")
                                .addConverterFactory(GsonConverterFactory.create())
                                .build();

                        RequestInterface requestInterface = retrofit.create(RequestInterface.class);


                        Call < statusMessage > calle = requestInterface.deleteedu(Integer.parseInt(id));
                        calle.enqueue(new Callback<statusMessage>() {
                            @Override
                            public void onResponse(Call<statusMessage> call, Response<statusMessage> response) {

                                statusMessage message = response.body();

                                String m = message.getStatus_message();

                                Toast.makeText(getApplicationContext(),m,Toast.LENGTH_LONG).show();


                            }

                            @Override
                            public void onFailure(Call<statusMessage> call, Throwable t) {

                                Toast.makeText(getApplicationContext(),"error "+t.getMessage(),Toast.LENGTH_LONG);

                            }
                        });




                    }
                });







            }
        };






