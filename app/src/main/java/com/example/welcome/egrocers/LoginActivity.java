package com.example.welcome.egrocers;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

import io.paperdb.Paper;

public class LoginActivity extends AppCompatActivity {

    MaterialEditText phone, name, passeord;
    Button regs;
CheckBox chk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        regs=(Button) findViewById(R.id.reg);
        phone=(MaterialEditText) findViewById(R.id.phno);
chk=(CheckBox)findViewById(R.id.chekbox);
        passeord=(MaterialEditText) findViewById(R.id.psrd);


        Paper.init(this);
      final  FirebaseDatabase database= FirebaseDatabase.getInstance();
        final DatabaseReference tableuser= database.getReference("User");

//        final ProgressDialog mDialog= new ProgressDialog(LoginActivity.this);
//        mDialog.setMessage("Please Wait");
//        mDialog.show();


        regs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {






               tableuser.addValueEventListener(new ValueEventListener() {
                   @Override
                   public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                       if (dataSnapshot.child(phone.getText().toString()).exists()) {
                         //  mDialog.dismiss();


                           User user = dataSnapshot.child(phone.getText().toString()).getValue(User.class);

                           if (user.getPassword().equals(passeord.getText().toString())) {

                               Toast.makeText(LoginActivity.this, "Sign in success", Toast.LENGTH_SHORT).show();
Intent ii = new Intent(LoginActivity.this, Home.class);
Common.currentuser=user;
startActivity(ii);
finish();



                           }

                           else {
                               Toast.makeText(LoginActivity.this, "Incorrect Password", Toast.LENGTH_SHORT).show();


                           }

                       }
                       else {
                           Toast.makeText(LoginActivity.this, "Sign not", Toast.LENGTH_SHORT).show();


                       }
                   }

                   @Override
                   public void onCancelled(@NonNull DatabaseError databaseError) {

                   }
               });


            }
        });


    }
}
