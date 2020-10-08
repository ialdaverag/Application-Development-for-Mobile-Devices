package com.example.edittextejemplo16;

import android.app.*;
import android.os.*;
import android.text.Editable;
import android.widget.EditText;
public class MainActivity extends Activity {
    EditText jet1;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        jet1 = (EditText) findViewById(R.id.xet1);
        jet1.selectAll();
    }
}