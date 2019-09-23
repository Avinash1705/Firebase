package com.example.searchkaro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class registrationActivity extends AppCompatActivity {
    private static final String TAG ="raw_reg" ;
    private EditText name,address;
private Button register;
private FirebaseUser firebaseUser;
private FirebaseAuth firebaseAuth;

    FirebaseDatabase database = FirebaseDatabase.getInstance();


    DatabaseReference myRef = database.getReference("Details");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        firebaseAuth=FirebaseAuth.getInstance();
        firebaseUser=firebaseAuth.getCurrentUser();
        init();
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WriteToDatabase();
                Toast.makeText(registrationActivity.this,"Database Updated", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(registrationActivity.this,FiveActivityPage.class));
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
        String m_name,m_address,uuid;
        m_name=name.getText().toString().trim();
        m_address=address.getText().toString().trim();
        uuid=firebaseUser.getUid();

        myRef.child(uuid).child("Name").setValue(m_name);
        myRef.child(uuid).child("Address").setValue(m_address);
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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.logout, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_logout:
                firebaseAuth.getInstance().signOut();
                startActivity(new Intent(registrationActivity.this,otpActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public void Logout(MenuItem item) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(registrationActivity.this,otpActivity.class));
    }
}
