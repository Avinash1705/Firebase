package com.example.searchkaro.AdminPower;

import androidx.appcompat.app.AppCompatActivity;

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
        setContentView(R.layout.choose_page_to_edit);
        lv_admin=findViewById(R.id.lv_chooseActivityNew);

        ArrayAdapter<String> adapter=new ArrayAdapter<String >(this,android.R.layout.simple_list_item_1,option);
        lv_admin.setAdapter(adapter);

        lv_admin.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String selection = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(getApplicationContext(),selection,Toast.LENGTH_SHORT).show();
//                switch (i){
//                    case 0:
//                        Toast.makeText(getBaseContext(), "text 1", Toast.LENGTH_SHORT);
//                        break;
//                    case 1:
//                        Toast.makeText(getBaseContext(), "text 2", Toast.LENGTH_SHORT);
//                        break;
//                    case 2:
//                        Toast.makeText(getBaseContext(), "text 3", Toast.LENGTH_SHORT);
//                        break;
//                }
            }
        });


    }

}
