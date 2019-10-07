package com.example.searchkaro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import android.view.View;

import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.searchkaro.AdminPower.ChooseAdminPage;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.concurrent.TimeUnit;

public class otpActivity extends AppCompatActivity {
    private static final String TAG ="raw_otp" ;
    private FirebaseAuth mAuth;
    private EditText otp,number,name,address;
    private String mnumber,VerificatinCode;
    private Button ap_btn;
    FirebaseUser currentUser;
    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;

    @Override
    protected void onStart() {

        super.onStart();
        currentUser = mAuth.getCurrentUser();
        //  updateUI(currentUser);


        if(currentUser !=null){

            Log.d(TAG, "UUId "+currentUser.getUid());
            Toast.makeText(getApplicationContext(),"Already Registred",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(otpActivity.this,registrationActivity.class));
        }
        else{
            Toast.makeText(getApplicationContext(),"Register First",Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
//        // remove title
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        init();
        mAuth = FirebaseAuth.getInstance();

        ap_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(otpActivity.this, AdminLoginActivity.class));
            }
        });


        mCallbacks=new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {

            }

            @Override
            public void onVerificationFailed(FirebaseException e) {

            }

            @Override
            public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(s, forceResendingToken);
                VerificatinCode=s;
                Toast.makeText(getApplicationContext(),"otp Send TO number",Toast.LENGTH_SHORT).show();

            }
        };

    }
    private void writeToDb(){
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Registered").child(currentUser.getUid());

        myRef.child("Name").setValue(name.getText().toString());
        myRef.child("mobile Number").setValue(number.getText().toString());
        myRef.child("Address").setValue(address.getText().toString());

    }

    private void init(){
        ap_btn=findViewById(R.id.ap_btn);
        name=findViewById(R.id.otp_name);
        otp=findViewById(R.id.et_otp);
        number=findViewById(R.id.otp_number);
        address=findViewById(R.id.otp_address);
    }
    public void sendSms(View view){

        mnumber="+91"+number.getText().toString();
        if(mnumber!=null ){

            PhoneAuthProvider.getInstance().verifyPhoneNumber(
                    mnumber,        // Phone number to verify
                    60,                 // Timeout duration
                    TimeUnit.SECONDS,   // Unit of timeout
                    this,               // Activity (for callback binding)
                    mCallbacks);        // OnVerificationStateChangedCallbacks
        }
        else{
            Toast.makeText(getApplicationContext(),"Fill All Fields",Toast.LENGTH_SHORT).show();
        }
    }
    public void SignInWithPhone(PhoneAuthCredential credential){
        mAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                Toast.makeText(getApplicationContext(),"USer Success SignIN",Toast.LENGTH_SHORT).show();
//                writeToDb();
                startActivity(new Intent(otpActivity.this,registrationActivity.class));
            }
        });
    }
    public void Verify(View v){
        String  input_code=otp.getText().toString();
        verifyPhoneNumber(VerificatinCode,input_code);

//        if(VerificatinCode.equals("")){
//            }
    }

    private void verifyPhoneNumber(String verificatinCode, String input_code) {
        PhoneAuthCredential credential=PhoneAuthProvider.getCredential(verificatinCode,input_code);
        SignInWithPhone(credential);
    }



}