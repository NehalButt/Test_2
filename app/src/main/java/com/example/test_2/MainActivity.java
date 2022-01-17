package com.example.test_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText Username,Email,Password,Confirmpassword,Salary,ProjectHandle,Speciality;
    Button Register;
    Dbhelper dbhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Username = (EditText) findViewById(R.id.username);
        Email = (EditText) findViewById(R.id.Email);
        Password = (EditText) findViewById(R.id.Password);
        Confirmpassword = (EditText) findViewById(R.id.Confirmpassword);
        Salary = (EditText) findViewById(R.id.Salary);
        ProjectHandle = (EditText) findViewById(R.id.projecthandle);
        Speciality = (EditText) findViewById(R.id.Speciality);
        Register = (Button) findViewById(R.id.Register);
        dbhelper = new Dbhelper(MainActivity.this);
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = Username.getText().toString();
                String email = Email.getText().toString();
                String password = Password.getText().toString();
                String confirmpassword = Confirmpassword.getText().toString();
                int salary = Integer.parseInt(Salary.getText().toString());
                int projecthandle = Integer.parseInt(ProjectHandle.getText().toString());
                String speciality = Speciality.getText().toString();
                boolean emailcheck = dbhelper.emailcheck(email);
                if (password.equals(confirmpassword)) {
                    if (salary < 25000) {
                        Toast.makeText(MainActivity.this, "Salary must be 25000", Toast.LENGTH_SHORT).show();
                    } else if (salary > 75000) {
                        Toast.makeText(MainActivity.this, "Salary must be under 75000", Toast.LENGTH_SHORT).show();
                    } else {
                    if (emailcheck == true) {
                        Toast.makeText(MainActivity.this, "Email Already Exists", Toast.LENGTH_SHORT).show();
                    } else {

                            boolean successfullyinserted = dbhelper.Inserted(username, email, password, salary, projecthandle, speciality);
                            if (successfullyinserted == true) {
                                Toast.makeText(MainActivity.this, "Successfully Register", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(MainActivity.this, Login.class);
                                startActivity(intent);

                            } else {
                                Toast.makeText(MainActivity.this, "Invalid data", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }
                else {
                    Toast.makeText(MainActivity.this, "Password Not Match", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}