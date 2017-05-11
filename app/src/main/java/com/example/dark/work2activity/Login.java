package com.example.dark.work2activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    EditText edtUserName;
    EditText edtPassword;
    Button btnLogin;
    Button btnCancel;
    CheckBox ckbRemember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edtUserName=(EditText)findViewById(R.id.edtUserName);
        edtPassword=(EditText)findViewById(R.id.edtPassword);
        btnLogin=(Button)findViewById(R.id.btnLogin);
        ckbRemember=(CheckBox)findViewById(R.id.ckbRemember);
        reloadInfor();
        btnCancel=(Button)findViewById(R.id.btnCancel);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName=edtUserName.getText().toString().trim();
                String password=edtPassword.getText().toString().trim();
                if(userName.equals("admin")&&password.equals("123")){
                    if (ckbRemember.isChecked()){
                        SaveInfor(userName,password);
                    }else {
                        SharedPreferences.Editor editor=getSharedPreferences("Key",MODE_PRIVATE).edit();
                        if(editor!=null){
                            editor.remove("userName");
                            editor.remove("password");
                            editor.commit();
                        }
                    }
                    Intent intent=new Intent(Login.this,MainActivity.class);
                    startActivity(intent);
                }else {
                    final AlertDialog.Builder builder=new AlertDialog.Builder(Login.this);
                    builder.setTitle("login");
                    builder.setView(android.support.v7.appcompat.R.layout.abc_alert_dialog_title_material);
                    builder.setPositiveButton("Ok",new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    builder.setNegativeButton("Cancel",new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    }).create();
                    builder.show();
                }
            }
        });
    }
    private void SaveInfor(String userName, String password)
    {
        SharedPreferences.Editor editor = getSharedPreferences("Key",MODE_PRIVATE).edit();
        editor.putString("userName",userName);
        editor.putString("password",password);
        editor.commit();
    }
    private void reloadInfor()
    {
        SharedPreferences prefs = getSharedPreferences("Key", MODE_PRIVATE);
        if(prefs != null) {
            edtUserName.setText(prefs.getString("userName", ""));
            edtPassword.setText(prefs.getString("password", ""));
        }
    }
}
