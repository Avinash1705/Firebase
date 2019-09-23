package com.example.searchkaro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

public class FiveActivityPage extends AppCompatActivity {
private ImageView user,bussiness,newItem,adver,contact,m_serach;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // remove title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_five_page);
        init();
    }
    private void init(){
        user=findViewById(R.id.im_user);
        bussiness=findViewById(R.id.im_bussiness);
        newItem=findViewById(R.id.im_newItem);
        adver=findViewById(R.id.im_advertisement);
        contact=findViewById(R.id.im_contact);
        m_serach=findViewById(R.id.search_mid);
    }

    public void userDetail(View view) {
//        registrationActivity registration_obj=new  registrationActivity();
        startActivity(new Intent(FiveActivityPage.this,registrationActivity.class));
    }

    public void NewDetail(View view) {
        startActivity(new Intent(FiveActivityPage.this,NewItemActivity.class));
    }

    public void Busssinees(View view) {
//        startActivity(new Intent(FiveActivityPage.this,NewItemActivity.class));
        Toast.makeText(this,"Busssineess Working",Toast.LENGTH_SHORT).show();

    }

    public void Advertisement(View view) {
        startActivity(new Intent(FiveActivityPage.this,Advertise_User.class));

    }

    public void serachMid(View view) {
        startActivity(new Intent(FiveActivityPage.this,SearchKaro.class));

    }
}
