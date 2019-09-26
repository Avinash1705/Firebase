package com.example.searchkaro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.searchkaro.AdminPower.ChooseAdminPage;

public class AdminLoginActivity extends AppCompatActivity {
    private EditText Admin_nameD,Admin_passD;
    private Button Authenticate_adminD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
//        init();
        Admin_nameD=findViewById(R.id.Admin_name);
        Admin_passD=findViewById(R.id.Admin_pass);
        Authenticate_adminD=findViewById(R.id.Authenticate_admin);

        Authenticate_adminD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String  m_name=Admin_nameD.getText().toString();
                String  m_pass=Admin_passD.getText().toString();
                if(m_name.equals("admin") && m_pass.equals("admin")){
                    startActivity(new Intent(getApplicationContext(), ChooseAdminPage.class));
                }
                else{
                    Toast.makeText(getApplicationContext(),"Please Enter Correct Password & Username",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
//    private void init(){
//
//    }
}
