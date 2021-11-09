package com.atharv.loginsystem;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class registration extends AppCompatActivity {
    private EditText user,pass,repass,name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name=(EditText)findViewById(R.id.create_name);
        user = (EditText)findViewById(R.id.create_user);
        pass = (EditText)findViewById(R.id.create_pass);
        repass=(EditText) findViewById(R.id.create_repass);
    }

    public void login(View view) {
        String Name=name.getText().toString().trim();
        String username=user.getText().toString().trim();
        String password=pass.getText().toString().trim();
        String repassword=pass.getText().toString().trim();

        StringRequest stringRequest=new StringRequest(Request.Method.POST, Constants.URL_CREATE, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.getMessage(), Toast.LENGTH_LONG).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("name",Name);
                params.put("user",username);
                params.put("pass",password);
                params.put("conpass",repassword);
                return params;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
