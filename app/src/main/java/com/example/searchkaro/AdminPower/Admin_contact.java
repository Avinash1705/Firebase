package com.example.searchkaro.AdminPower;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.searchkaro.Contact;
import com.example.searchkaro.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Admin_contact extends AppCompatActivity {
private EditText allData;
private Button update_contact;
    FirebaseDatabase database;
    DatabaseReference myRef ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_contact);
        init();
         database = FirebaseDatabase.getInstance();
         myRef = database.getReference("Updating Admin Contact");

        update_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writeToDatabase();
//                ReadToDatabase();
                Toast.makeText(getApplicationContext(),"Upload Complete",Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void init(){
        allData=findViewById(R.id.admin_allData);
        update_contact=findViewById(R.id.updateContact);
    }
    private  void writeToDatabase(){
        String text=allData.getText().toString();
        myRef.setValue(text);
    }
//    private void ReadToDatabase(){
//        // Read from the database
//        myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                // This method is called once with the initial value and again
//                // whenever data at this location is updated.
//                String value = dataSnapshot.getValue(String.class);
//                Intent i = new Intent(getApplicationContext(), Contact.class);
//                i.putExtra("ReadContactFromDatabase", value);
////                Log.d(TAG, "Value is: " + value);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError error) {
//                // Failed to read value
////                Log.w(TAG, "Failed to read value.", error.toException());
//                Toast.makeText(getApplicationContext(),"Failed To read VAlue",Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
}
