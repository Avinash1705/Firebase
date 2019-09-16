package com.example.searchkaro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class registrationActivity extends AppCompatActivity {
    private static final String TAG ="raw_reg" ;
    private EditText name,address;
private Button register;

    FirebaseDatabase database = FirebaseDatabase.getInstance();

    DatabaseReference myRef = database.getReference("message");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        init();
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WriteToDatabase();
                Toast.makeText(registrationActivity.this,"Database Updated", Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void init(){
        name=findViewById(R.id.et_name);
        address=findViewById(R.id.et_address);
        register=findViewById(R.id.bt_registration);
    }
    private void WriteToDatabase(){
        // Write a message to the database


        myRef.setValue("Hello, World!");
    }
    private void ReadDatabase(){
        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w(TAG, "Failed to read value.", databaseError.toException());
            }


        });
    }
}
