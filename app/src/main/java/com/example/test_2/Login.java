package com.example.test_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText LoginEmail,LoginPassword;
    Button Login;
    Dbhelper dbhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        LoginEmail = (EditText) findViewById(R.id.Loginemail);
        LoginPassword = (EditText) findViewById(R.id.Loginpassword);
        Login = (Button) findViewById(R.id.Login);
        dbhelper = new Dbhelper(Login.this);
        Login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String logemail = LoginEmail.getText().toString();
                String logpass = LoginPassword.getText().toString();
            boolean checklogin =dbhelper.logincheck(logemail , logpass);
            if (checklogin == true){
                Toast.makeText(Login.this, "Successfully login", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Login.this , Index.class);
                intent.putExtra("useremail" , logemail);
                startActivity(intent);
            }
            else {
                Toast.makeText(Login.this, "Inv", Toast.LENGTH_SHORT).show();

            }
            }
        });
    }
}