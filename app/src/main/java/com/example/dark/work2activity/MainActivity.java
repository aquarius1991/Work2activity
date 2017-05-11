package com.example.dark.work2activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final int REQUEST_CODE=10;
    ListView lvEmployee;
    List<ObjEmployee> listData;
    EmployeeAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvEmployee=(ListView)findViewById(R.id.lvEmployee);
        // lay du lieu
        listData=ObjEmployee.getListEmployee();
        adapter=new EmployeeAdapter(MainActivity.this,R.layout.row_employee,listData);
        lvEmployee.setAdapter(adapter);
    }

    //hien thi actionbar len activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.actionbarmenu,menu);
        return true;
    }
    // chon item tren actionbar, send intent co gia tri tra ve
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.addItem:
                Intent intent=new Intent(MainActivity.this,AddEmployee.class);
                startActivityForResult(intent,REQUEST_CODE);
                break;
        }
        return true;
    }

    // lay gia tri tra ve cua intent
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_CODE && resultCode== Activity.RESULT_OK){
            ObjEmployee employee =(ObjEmployee)data.getSerializableExtra("employee");
            if(employee!=null){
                listData.add(employee);
                adapter.notifyDataSetChanged();
                Toast.makeText(this,"them thanh cong",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
