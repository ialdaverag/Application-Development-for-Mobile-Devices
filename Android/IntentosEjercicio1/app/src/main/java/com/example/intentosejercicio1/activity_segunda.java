package com.example.intentosejercicio1;

import android.os.Bundle;
import android.app.Activity;
import android.widget.*;

public class activity_segunda extends Activity{
    EditText jet;
    Bundle bdl;

    public void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.activity_segunda);
        jet = (EditText) findViewById(R.id.xet1);
        bdl = getIntent().getExtras();
        jet.append("Hola " + bdl.getString("NOMBRE") +" "+ bdl.getString("APELLIDO"));
    }
}