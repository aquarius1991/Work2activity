package com.example.dark.work2activity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dark on 5/6/2017.
 */

public class ObjEmployee implements Serializable{
    private String Name;
    private String Address;
    private String Phone;
    public static List<ObjEmployee> listEmployee;

    public ObjEmployee(String name, String address, String phone) {
        this.Name = name;
        this.Address = address;
        this.Phone = phone;
    }

    public String getName() {
        return Name;
    }

    public String getAddress() {
        return Address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public static List<ObjEmployee> getListEmployee(){
        listEmployee=new ArrayList<ObjEmployee>();
        listEmployee.add(new ObjEmployee("ABC1","addr1","0123456789"));
        listEmployee.add(new ObjEmployee("ABC2","addr2","0123456789"));
        listEmployee.add(new ObjEmployee("ABC3","addr3","0123456789"));
        listEmployee.add(new ObjEmployee("ABC4","addr4","0123456789"));
        listEmployee.add(new ObjEmployee("ABC5","addr5","0123456789"));
        listEmployee.add(new ObjEmployee("ABC6","addr6","0123456789"));
        return listEmployee;
    }
}
