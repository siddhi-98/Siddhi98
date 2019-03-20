package com.example.sidster.apiintegration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dashboard extends AppCompatActivity {

    Button displaybtn,updatebtn,deletebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        displaybtn = (Button)findViewById(R.id.displaybtn);
        updatebtn = (Button)findViewById(R.id.updatebtn);
        deletebtn = (Button)findViewById(R.id.deletebtn);

        displaybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle b = getIntent().getExtras();
                String id =b.getString("p");
                Intent i = new Intent(getApplicationContext(),DisplayDetails.class);
                Bundle bund = new Bundle();
                bund.putString("id",id);
                i.putExtras(bund);
                startActivity(i);


            }
        });

        updatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle b = getIntent().getExtras();
                String id =b.getString("p");
                Intent i = new Intent(getApplicationContext(),UpdateDetails.class);
                Bundle bund = new Bundle();
                bund.putString("id",id);
                i.putExtras(bund);
                startActivity(i);

                }
        });

        deletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle b = getIntent().getExtras();
                String id = b.getString("id");

                Intent i = new Intent(getApplicationContext(),deleteDetails.class);
                Bundle bund = new Bundle();
                bund.putString("id",id);
                i.putExtras(bund);
                startActivity(i);

            }
        });





    }
}
