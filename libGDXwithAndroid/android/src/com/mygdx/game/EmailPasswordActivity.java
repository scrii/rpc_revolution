package com.mygdx.game;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;

import android.util.Log;
import android.view.View;
import android.widget.EditText;

import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;


import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import cn.zhaiyifan.rememberedittext.RememberEditText;

public class EmailPasswordActivity extends AppCompatActivity implements View.OnClickListener{
    EditText registration_nickname;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    private EditText ETemail;
    private EditText ETpassword;
    int number=0,o;
    String s;
    public void signin (String email, String password)
    {
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    CreatorFiles sd = new CreatorFiles();
                    sd.create();
                    s = registration_nickname.getText().toString();
                    GetterANDSetterFile getterANDSetterFile = new GetterANDSetterFile();
                    getterANDSetterFile.set_Sign(1);
                    getterANDSetterFile.set_Nickname(s);
                    number = 1;
                    if(getterANDSetterFile.get_Nickname()!="")startActivity(new Intent(EmailPasswordActivity.this, ScrollingActivity.class));
                    else Toast.makeText(getApplicationContext(),"Ник не может быть пустым!",Toast.LENGTH_LONG).show();
                } else
                    Toast.makeText(getApplicationContext(), "Aвторизация провалена", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void registration (String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    o++;
                } else
                    o++;
                CreatorFiles sd = new CreatorFiles();
                sd.create();
                s = registration_nickname.getText().toString();
                GetterANDSetterFile getterANDSetterFile = new GetterANDSetterFile();
                getterANDSetterFile.set_Sign(1);
                getterANDSetterFile.set_Nickname(s);
                number = 1;
                if(getterANDSetterFile.get_Nickname()!="")startActivity(new Intent(EmailPasswordActivity.this, ScrollingActivity.class));
                else Toast.makeText(getApplicationContext(),"Ник не может быть пустым!",Toast.LENGTH_LONG).show();
            }
        });
    }
    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_sign_in)
        {
            try {
                CreatorFiles sd = new CreatorFiles();
                sd.create();
                s = registration_nickname.getText().toString();
                GetterANDSetterFile getterANDSetterFile = new GetterANDSetterFile();
                getterANDSetterFile.set_Nickname(s);
                signin(ETemail.getText().toString(),ETpassword.getText().toString());
                number = 1;
            }catch (Exception e) {
                e.printStackTrace();
            }

        }else if (view.getId() == R.id.btn_registration)
        {
            try {
                registration(ETemail.getText().toString(),ETpassword.getText().toString());
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_password);

        CreatorFiles sd = new CreatorFiles();
        sd.create();
        registration_nickname = findViewById(R.id.registration_nickname);
        GetterANDSetterFile getterANDSetterFile = new GetterANDSetterFile();
        number = getterANDSetterFile.get_Sign();
        mAuth = FirebaseAuth.getInstance();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    s = registration_nickname.getText().toString();
                    GetterANDSetterFile getterANDSetterFile = new GetterANDSetterFile();
                    getterANDSetterFile.set_Nickname(s);
                } else {
                    o++;
                }
            }
        };
        ETemail = findViewById(R.id.et_email);
        ETpassword = findViewById(R.id.et_password);
        findViewById(R.id.btn_sign_in).setOnClickListener(this);
        findViewById(R.id.btn_registration).setOnClickListener(this);
    }
}
