package com.example.welcome.egrocers;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Confirm extends AppCompatActivity {
    EditText txtt,txttt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.orderr);

         txtt= (EditText)findViewById(R.id.tabbb);
         txttt= (EditText)findViewById(R.id.phonee);
        Button btn= (Button) findViewById(R.id.btnn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i= new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("smsto:+923088933720"));
                i.putExtra("sms_body",txtt.getText().toString());
                   i.putExtra("sms_body",txttt.getText().toString());
                startActivity(i);



            }
        });




    }
}
