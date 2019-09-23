//package com.example.searchkaro.AdminPower;
//
//import android.os.Bundle;
//import android.view.Window;
//import android.view.WindowManager;
//import android.widget.ArrayAdapter;
//import android.widget.ListView;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.example.searchkaro.R;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class ChoosePageToEdit extends AppCompatActivity {
//    private ListView lv_admin;
//    List heroList;
//String option []=new String[]{"New Item Add","Advertise Item Add","Edit your Contact"};
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        // remove title
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        setContentView(R.layout.choose_page_to_edit);
//        init();
//
//        heroList = new ArrayList<>();
//        heroList.add("New Item Add");
//        heroList.add("Advertise Item Add");
//        heroList.add("Edit your Contact");
//        ArrayAdapter<String> adapter=new ArrayAdapter<String >(this,android.R.layout.simple_list_item_1,option);
//        lv_admin.setAdapter(adapter);
//
//    }
//
//    private void init() {
//       lv_admin=findViewById(R.id.lv_chooseActivity);
//    }
//}
