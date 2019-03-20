package com.example.sidster.apiintegration;

import android.app.VoiceInteractor;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    EditText pass;
    EditText emailid;
    String email,password;
    Button signin,login;

    SharedPreferences sp;


    public void login(View v)
    {
        Intent i = new Intent(getApplicationContext(),LoginActivity.class);
        startActivity(i);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        pass = (EditText)findViewById(R.id.pass);
        emailid = (EditText) findViewById(R.id.emailid);
        signin = (Button)findViewById(R.id.signinbtn);
        login = (Button)findViewById(R.id.loginbtn);

         sp  = this.getSharedPreferences("com.example.sidster.apiintegration", Context.MODE_PRIVATE);


         signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String e = emailid.getText().toString();
                String p = pass.getText().toString();


                Retrofit retrofit = new Retrofit.Builder().baseUrl("http://139.59.65.145:9090/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestInterface requestInterface = retrofit.create(RequestInterface.class);



        Call<signin_output_pojo> call = requestInterface.signin(new signin_input_pojo(e,p));

        call.enqueue(new Callback<signin_output_pojo>() {
            @Override
            public void onResponse(Call<signin_output_pojo> call, Response<signin_output_pojo> response) {

                signin_output_pojo opojo = response.body();

                Data data = opojo.getData();

                email = data.getEmail();
                password = data.getId();


               // textView.setText("\n"+email+"\n"+password);
                Bundle b = new Bundle();
                b.putString("id",password);
                Toast.makeText(getApplicationContext(),"ID: "+password,Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(),PersonalDetailActivity.class);
                intent.putExtras(b);
                startActivity(intent);

            }

            @Override
            public void onFailure(Call<signin_output_pojo> call, Throwable t) {

                Toast.makeText(getApplicationContext(),"error "+t.getMessage(),Toast.LENGTH_LONG);

            }
        });

              /*  */





            }
});







        //Call<testPojo> call=requestInterface.test();

        /*call.enqueue(new Callback<testPojo>() {
            @Override
            public void onResponse(Call<testPojo> call, Response<testPojo> response) {

                testPojo pojo = response.body();

                String server_name = pojo.getServer_name();
                String method = pojo.getMethod();
                String port = pojo.getPort();
                String status = pojo.getStatus();

                textView.setText(server_name+"\n"+method+"\n"+port+"\n"+status);

            }

            @Override
            public void onFailure(Call<testPojo> call, Throwable t) {

                Toast.makeText(getApplicationContext(), "Error occurred "+t.getMessage(), Toast.LENGTH_LONG);

            }
        });*/






        }}



