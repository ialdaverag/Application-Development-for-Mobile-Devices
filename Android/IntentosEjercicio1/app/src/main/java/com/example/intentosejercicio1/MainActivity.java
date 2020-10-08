package com.example.intentosejercicio1;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.*;
import android.content.Intent;
import android.widget.*;

public class MainActivity extends Activity{
    EditText jet, jet2;
    Button jbn;
    Bundle bdl, bdl2;
    Intent itn;

    public void onCreate(Bundle b) {
        super.onCreate(b);

        setContentView(R.layout.activity_main);

        jet = (EditText) findViewById(R.id.xet);
        jet2 = (EditText) findViewById(R.id.xet2);

        jbn = (Button) findViewById(R.id.xbn);
        jbn.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                itn = new Intent(MainActivity.this, activity_segunda.class);

                bdl = new Bundle();
                bdl.putString("NOMBRE", jet.getText().toString());
                itn.putExtras(bdl);

                bdl2 = new Bundle();
                bdl2.putString("APELLIDO", jet2.getText().toString());
                itn.putExtras(bdl2);

                startActivity(itn);
            }
        });
    }
}