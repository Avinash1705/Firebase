package com.example.searchkaro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.searchkaro.Model.newData;
import com.example.searchkaro.recycler_view.ImageUploadInfo;
import com.example.searchkaro.recycler_view.RecyclerViewAdapterNEwItem;
import com.example.searchkaro.recycler_view.RecyclerViewAdapterNewItem;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class NewItemActivity extends AppCompatActivity {
    private ListView ll_data;
    private TextView listname;
    private ImageView imageView;
    List<newData> heroList;
    //the listview
    ListView listView;
    // Creating DatabaseReference.
    DatabaseReference databaseReference;

    // Creating RecyclerView.
    RecyclerView recyclerView;

    // Creating RecyclerView.Adapter.
    RecyclerView.Adapter adapter ;

    // Creating Progress dialog
    ProgressDialog progressDialog;
    // Creating List of ImageUploadInfo class.
    List<ImageUploadInfo> list = new ArrayList<>();

    String[] text={"Vivo","Iphone","1+"};
     Integer [] img={R.drawable.advertisement,R.drawable.bussineess,R.drawable.contact};
    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_item);
        // Assign id to RecyclerView.
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        // Setting RecyclerView size true.
        recyclerView.setHasFixedSize(true);
        // Setting RecyclerView layout as LinearLayout.
        recyclerView.setLayoutManager(new LinearLayoutManager(NewItemActivity.this));
        // Assign activity this to progress dialog.
        progressDialog = new ProgressDialog(NewItemActivity.this);

        // Setting up message in Progress dialog.
        progressDialog.setMessage("Loading Images From Firebase.");

        // Showing progress dialog.
        progressDialog.show();

        // Setting up Firebase image upload folder path in databaseReference.
        // The path is already defined in MainActivity.
        databaseReference = FirebaseDatabase.getInstance().getReference("images");

databaseReference.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        for(DataSnapshot snapshot:dataSnapshot.getChildren()){
        //list of images Details
            ImageUploadInfo imageUploadInfo = snapshot.getValue(ImageUploadInfo.class);

            list.add(imageUploadInfo);
        }
        adapter = new RecyclerViewAdapterNEwItem(getApplicationContext(),list);

        recyclerView.setAdapter(adapter);


        // Hiding the progress dialog.
        progressDialog.dismiss();
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
// Hiding the progress dialog.
        progressDialog.dismiss();


    }
});
//        //initilizing object
//        heroList = new ArrayList<>();
////        listView =  findViewById(R.id.lv_allData);
//
//        heroList.add(new newData(R.drawable.advertisement,"advertisement"));
//        heroList.add(new newData(R.drawable.bussineess,"Bussiness"));
//        heroList.add(new newData(R.drawable.advertisement,"advertisement"));
//
//        //creating the adapter
//        newItemDataAdapter adapter = new newItemDataAdapter(this,R.layout.row_data,heroList);
//
//        //attaching adapter to the listview
//        listView.setAdapter(adapter);
    }
}