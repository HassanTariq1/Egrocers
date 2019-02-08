package com.example.welcome.egrocers;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

public class RegisterActivity extends AppCompatActivity {

    MaterialEditText phone, name, passeord;
    Button regs;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        regs=(Button) findViewById(R.id.regg);
        phone=(MaterialEditText) findViewById(R.id.phnoo);
        name=(MaterialEditText) findViewById(R.id.namee);
        passeord=(MaterialEditText) findViewById(R.id.psrdd);

        final   FirebaseDatabase database= FirebaseDatabase.getInstance();
        final DatabaseReference tableuser= database.getReference("User");


        regs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



//                final ProgressDialog mDialog= new ProgressDialog(RegisterActivity.this);
//                mDialog.setMessage("Please Wait");
//                mDialog.show();

tableuser.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {



        if(dataSnapshot.child(phone.getText().toString()).exists()){
            //mDialog.dismiss();
            Toast.makeText(RegisterActivity.this,"Phone Already Register ",Toast.LENGTH_SHORT).show();



        }

        else{

          //  mDialog.dismiss();
User user= new User(name.getText().toString(),passeord.getText().toString());
            tableuser.child(phone.getText().toString()).setValue(user);
            Toast.makeText(RegisterActivity.this,"Sign Up Success ",Toast.LENGTH_SHORT).show();
finish();



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
