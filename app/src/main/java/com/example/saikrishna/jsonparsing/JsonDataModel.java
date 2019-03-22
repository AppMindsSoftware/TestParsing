package com.example.saikrishna.jsonparsing;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Parsing on 2/2/2018.
 */

public class JsonDataModel
{
String id,name,email,address,gender,mobile,home,office;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public JsonDataModel(String responseResult)
    {
        try {
            JSONObject jsonObject = new JSONObject(responseResult);
            id = jsonObject.isNull("id") ? "" : jsonObject.getString("id");
            name = jsonObject.isNull("name") ? "" : jsonObject.getString("name");
            email = jsonObject.isNull("email") ? "" : jsonObject.getString("email");
            address = jsonObject.isNull("address") ? "" : jsonObject.getString("address");
            gender = jsonObject.isNull("gender") ? "" : jsonObject.getString("gender");
            JSONObject jsonObject1 = jsonObject.getJSONObject("phone");
            mobile=jsonObject1.isNull("mobile") ? "" : jsonObject1.getString("mobile");
            home=jsonObject1.isNull("home") ? "" : jsonObject1.getString("home");

            office=jsonObject1.isNull("office") ? "" : jsonObject1.getString("office");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}



