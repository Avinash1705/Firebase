package com.example.searchkaro.Bussiness_Registration;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.searchkaro.R;

public class Bussiness_type_registration extends AppCompatActivity implements View.OnClickListener{
        private TextView trade,product,bussiness,bussiness_card
                ,premium_10km,Luxary_50km,silver,gold,platinum,diamond;
        private LinearLayout rv_trade_list,rv_product_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bussiness_type_registration);
        init();
        setOnclick();

    }
    private void init(){
        trade=findViewById(R.id.trade_list);
        bussiness=findViewById(R.id.bussiness_list);
        product=findViewById(R.id.product_list);
        rv_trade_list=findViewById(R.id.rv_trade_list);
        rv_product_list=findViewById(R.id.rv_product_list);
        bussiness_card=findViewById(R.id.bussiness_card);
        premium_10km=findViewById(R.id.premium_10km);
        Luxary_50km=findViewById(R.id.Luxary_50km);
        silver=findViewById(R.id.silver);
        gold =findViewById(R.id.gold);
        platinum=findViewById(R.id.platinum);
        diamond=findViewById(R.id.diamond);
    }

    public void bussiness_list(View view) {
            trade.setVisibility(View.GONE);
            product.setVisibility(View.GONE);
        bussiness_card.setVisibility(View.VISIBLE);
    }

    public void product_list(View view) {
        bussiness.setVisibility(View.GONE);
        trade.setVisibility(View.GONE);
        rv_product_list.setVisibility(View.VISIBLE);

    }

    public void trade_list(View view) {
        bussiness.setVisibility(View.GONE);
        product.setVisibility(View.GONE);
        rv_trade_list.setVisibility(View.VISIBLE);

    }
    private void setOnclick(){
        bussiness_card.setOnClickListener(this);
        premium_10km.setOnClickListener(this);
        Luxary_50km.setOnClickListener(this);
        silver.setOnClickListener(this);
        gold .setOnClickListener(this);
        platinum.setOnClickListener(this);
        diamond.setOnClickListener(this);
        Toast.makeText(getApplicationContext(),"Payment for Your Service",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bussiness_card:
                //Redirect to payment
                break;
            case R.id.premium_10km:
                break;
            case R.id.Luxary_50km:
                break;
            case R.id.silver:
                break;
            case R.id.gold:
                break;
            case R.id.platinum:
                break;
            case R.id.diamond:
                break;
        }
    }
}
