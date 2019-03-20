package com.example.sidster.apiintegration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DisplayDetails extends AppCompatActivity {

    Button pdbtn,edbtn,profbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_details);


        pdbtn = (Button)findViewById(R.id.pdbtn);
        edbtn = (Button)findViewById(R.id.edbtn);
        profbtn = (Button)findViewById(R.id.profbtn);

        pdbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle b = getIntent().getExtras();
                String id = b.getString("id");

                Intent i = new Intent(getApplicationContext(),PersonalDisplay.class);
                Bundle bund = new Bundle();
                bund.putString("id",id);
                i.putExtras(bund);
                startActivity(i);

            }
        });

        edbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle b = getIntent().getExtras();
                String id = b.getString("id");

                Intent i = new Intent(getApplicationContext(),EducationalDisplay.class);
                Bundle bund = new Bundle();
                bund.putString("id",id);
                i.putExtras(bund);
                startActivity(i);


            }
        });

        profbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle b = getIntent().getExtras();
                String id = b.getString("id");

                Intent i = new Intent(getApplicationContext(),ProfessionalDisplay.class);
                Bundle bund = new Bundle();
                bund.putString("id",id);
                i.putExtras(bund);
                startActivity(i);

            }
        });

    }
}
