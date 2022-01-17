package com.example.test_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Index extends AppCompatActivity {
    TextView loginuser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        loginuser = (TextView) findViewById(R.id.loginuser) ;
        Intent getdata = getIntent();
       String useremail= getdata.getStringExtra("useremail");
        loginuser.setText("Welcome " + useremail);
    }
}