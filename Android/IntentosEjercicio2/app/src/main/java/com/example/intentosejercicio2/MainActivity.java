package com.example.intentosejercicio2;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.*;
import android.content.Intent;
import android.widget.*;

public class MainActivity extends Activity{
    EditText jeta, jetb, jetc;
    Button jbn;
    Bundle bdl;
    Intent itn;

    public void onCreate(Bundle b) {
        super.onCreate(b);

        setContentView(R.layout.activity_main);

        jeta = (EditText) findViewById(R.id.xeta);
        jetb = (EditText) findViewById(R.id.xetb);
        jetc = (EditText) findViewById(R.id.xetc);

        jbn = (Button) findViewById(R.id.xbn);
        jbn.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                itn = new Intent(MainActivity.this, SegundaActivity.class);

                bdl = new Bundle();
                bdl.putString("ca", jeta.getText().toString());
                bdl.putString("cb", jetb.getText().toString());
                bdl.putString("cc", jetc.getText().toString());

                itn.putExtras(bdl);

                startActivity(itn);
            }
        });
    }
}