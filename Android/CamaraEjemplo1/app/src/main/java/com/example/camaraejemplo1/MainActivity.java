package com.example.camaraejemplo1;

import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import android.os.*;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    private final String ruta = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/misfotos/";
    private File f = new File(ruta);
    private Button jbn;

    @Override protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        jbn = (Button) findViewById(R.id.xbn);
        f.mkdirs();
        jbn.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View v) {
                String s = ruta + getCode() + ".jpg";
                File f1 = new File(s);

                try{
                    f1.createNewFile();
                }catch(IOException ex){
                    Log.e("Error", "Error:" + ex);
                }

                Uri u = Uri.fromFile(f1);
                Intent in = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                in.putExtra(MediaStore.EXTRA_OUTPUT, u);
                startActivityForResult(in, 0);
            } });
    }

    private String getCode(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyymmddhhmmss");
        String n = "pic_" + sdf.format(new Date());; return n;
    }
}