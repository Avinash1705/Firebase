package com.example.searchkaro.AdminPower;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.searchkaro.R;

public class ChooseAdminPage extends AppCompatActivity {
    private ListView lv_admin;
    String option []=new String[]{"New Item Add","Advertise Item Add","Edit your Contact"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_admin_page);
//        // remove title
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        setContentView(R.layout.choose_page_to_edit);
        lv_admin=findViewById(R.id.lv_chooseActivityNew);

        ArrayAdapter<String> adapter=new ArrayAdapter<String >(this,android.R.layout.simple_list_item_1,option);
        lv_admin.setAdapter(adapter);

        lv_admin.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String selection = adapterView.getItemAtPosition(i).toString();
//                Toast.makeText(getApplicationContext(), option[i],Toast.LENGTH_SHORT).show();
//                switch (option[i]){
//                    case if(option[i].equals("New Item Add"):
//                        Toast.makeText(getBaseContext(), "text 1", Toast.LENGTH_SHORT);
//                        break;
//                    case "Advertise Item Add":
//                        Toast.makeText(getBaseContext(), "text 2", Toast.LENGTH_SHORT);
//                        break;
//                    case "Edit your Contact":
//                        Toast.makeText(getBaseContext(), "text 3", Toast.LENGTH_SHORT);
//                        break;
//                }
                if(option[i].equals("New Item Add")){
                    Toast.makeText(getApplicationContext(),"New Item Add",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(),Admin_newItem.class));
                }
                else if(option[i].equals("Advertise Item Add")){
                    Toast.makeText(getApplicationContext(),"Advertise Item Add",Toast.LENGTH_SHORT).show();
                }
                else if(option[i].equals("Edit your Contact")){
                    Toast.makeText(getApplicationContext(),"Edit your Contact",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(),Admin_contact.class));

                }
            }
        });


    }

}
