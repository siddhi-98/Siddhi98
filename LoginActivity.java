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

public class LoginActivity extends AppCompatActivity {

    EditText emailedittext,passwordedittext;
    Button loginbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailedittext = (EditText)findViewById(R.id.emailedittext);
        passwordedittext = (EditText)findViewById(R.id.passwordedittext);
        loginbutton = (Button)findViewById(R.id.loginbutton);


        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Retrofit retrofit = new Retrofit.Builder().baseUrl("http://139.59.65.145:9090/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                String e = emailedittext.getText().toString();
                String p = passwordedittext.getText().toString();

                RequestInterface requestInterface = retrofit.create(RequestInterface.class);
                Call<login_output_pojo> call = requestInterface.login(new login_input_pojo(e,p));

                call.enqueue(new Callback<login_output_pojo>() {
                    @Override
                    public void onResponse(Call<login_output_pojo> call, Response<login_output_pojo> response) {

                        login_output_pojo opojo = response.body();

                        Data data = opojo.getData();

                        String email = data.getEmail();
                        String password = data.getId();


                        Toast.makeText(getApplicationContext(), "Logged in successfully!", Toast.LENGTH_LONG).show();

                        Bundle b = new Bundle();
                        b.putString("p",password);
                        Intent intent = new Intent(getApplicationContext(),Dashboard.class);
                        intent.putExtras(b);
                        startActivity(intent);

                    }

                    @Override
                    public void onFailure(Call<login_output_pojo> call, Throwable t) {

                        Toast.makeText(getApplicationContext(),"error "+t.getMessage(), Toast.LENGTH_LONG);

                    }
                });


            }
        });





    }
}
