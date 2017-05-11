package com.example.dark.work2activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddEmployee extends AppCompatActivity {
    EditText edtEmployeeName;
    EditText edtAddress;
    EditText edtPhone;
    Button btnAdd;
    Button btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);
        edtEmployeeName=(EditText)findViewById(R.id.edtEmployeeName);
        edtAddress=(EditText)findViewById(R.id.edtAddress);
        edtPhone= (EditText) findViewById(R.id.edtPhone);
        btnAdd=(Button)findViewById(R.id.btnAdd);
        btnCancel=(Button)findViewById(R.id.btnCancel);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjEmployee item=new ObjEmployee(edtEmployeeName.getText().toString(),
                        edtAddress.getText().toString(),edtPhone.getText().toString());
                Intent intent=new Intent();
                intent.putExtra("employee",item);
                setResult(Activity.RESULT_OK,intent);
                finish();
            }
        });
    }
}
