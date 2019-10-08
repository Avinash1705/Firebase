package com.example.searchkaro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.searchkaro.Model.newData;
import com.example.searchkaro.Viewholder.newitemholder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NewItemActivity extends AppCompatActivity {
RecyclerView mrecyclerView;
FirebaseDatabase mfirebaseDatabase;
DatabaseReference mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_item);

        //Action Bar
        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("post List ");

        //Recycler View
        mrecyclerView=findViewById(R.id.recyclerview_newItem);
        mrecyclerView.hasFixedSize();

        //set Layout as Linearlaout
        mrecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Query to firebase
        mfirebaseDatabase=FirebaseDatabase.getInstance();
        mRef=mfirebaseDatabase.getReference("ImageData");
    }
    //load Data into recyclerView onStart

    @Override
    protected void onStart() {
        super.onStart();
        mRef.keepSynced(true);
        FirebaseRecyclerAdapter<newData, newitemholder> firebaseRecyclerAdapter=
                new FirebaseRecyclerAdapter<newData, newitemholder>(
                        newData.class,
                        R.layout.new_item_row,
                        newitemholder.class,
                        mRef
                ) {
                    @Override
                    protected void onBindViewHolder(@NonNull newitemholder newitemholder, int i, @NonNull newData newData) {
                        newitemholder.setDetails(getApplicationContext(),newData.getTitle(),newData.getDescription(),newData.getImage());

                    }

                    @NonNull
                    @Override
                    public newitemholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                        View view = LayoutInflater.from(parent.getContext())
                                .inflate(R.layout.new_item_row, parent, false);
                        return new newitemholder(view);
                    }
                };
        //set Adapter to recycler view
        firebaseRecyclerAdapter.startListening();
        mrecyclerView.setAdapter(firebaseRecyclerAdapter);
    }
}