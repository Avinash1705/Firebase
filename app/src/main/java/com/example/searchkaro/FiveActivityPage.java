package com.example.searchkaro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.searchkaro.Bussiness_Registration.Bussiness_type_registration;
import com.google.firebase.auth.FirebaseAuth;

public class FiveActivityPage extends AppCompatActivity {
private ImageView user,bussiness,newItem,adver,contact,m_serach;
    private FirebaseAuth mAuth;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // remove title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_five_page);
        mAuth = FirebaseAuth.getInstance();
        firebaseAuth=FirebaseAuth.getInstance();
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
        startActivity(new Intent(FiveActivityPage.this, Bussiness_type_registration.class));
        Toast.makeText(this,"Busssineess Working",Toast.LENGTH_SHORT).show();

    }

    public void Advertisement(View view) {
        startActivity(new Intent(FiveActivityPage.this,Advertise_User.class));

    }

    public void serachMid(View view) {
        startActivity(new Intent(FiveActivityPage.this,SearchKaro.class));

    }

    public void Admin_Contact(View view) {
        startActivity(new Intent(FiveActivityPage.this,Contact.class));

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
                startActivity(new Intent(FiveActivityPage.this,otpActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public void Logout(MenuItem item) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(FiveActivityPage.this,otpActivity.class));
    }
}
