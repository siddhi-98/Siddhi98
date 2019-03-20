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

public class deleteDetails extends AppCompatActivity {

    Button profbtn,edbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_details);


       edbtn = (Button)findViewById(R.id.edbtn);
       profbtn = (Button)findViewById(R.id.profbtn);

        profbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle b = getIntent().getExtras();
                String id = b.getString("id");

                Intent i = new Intent(getApplicationContext(),ProfessionalDisplaytwo.class);
                Bundle bund = new Bundle();
                bund.putString("id",id);
                i.putExtras(bund);
                startActivity(i);

                Toast.makeText(getApplicationContext(), "Details deleted!", Toast.LENGTH_SHORT).show();

            }
        });

        edbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle b = getIntent().getExtras();
                String id = b.getString("id");

                Intent i = new Intent(getApplicationContext(),EducationalDisplaytwo.class);
                Bundle bund = new Bundle();
                bund.putString("id",id);
                i.putExtras(bund);
                startActivity(i);

                Toast.makeText(getApplicationContext(), "Details deleted!", Toast.LENGTH_SHORT).show();


            }
        });




    }
}
