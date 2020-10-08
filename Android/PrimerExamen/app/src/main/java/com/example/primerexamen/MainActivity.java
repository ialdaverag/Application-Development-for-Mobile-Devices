package com.example.primerexamen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity {

    Button most;
    TextView error, meh;
    EditText num;
    String valor;
    ConstraintLayout main;

    int numero_n;
    int cadena[] = new int[1000];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main = findViewById(R.id.main);
        most = findViewById(R.id.botonMostrar);
        num = findViewById(R.id.Numero);
        meh = findViewById(R.id.meh);
        error = findViewById(R.id.error);

        most.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v) {
                valor = num.getText().toString();

                if(valor.matches("")) {
                    error.setText("Mete un numero >:c");
                } else {
                    numero_n = Integer.parseInt(valor);
                    if(numero_n % 2 == 0) {
                        error.setText("El número debe ser impar");
                    } else {
                        calcula(numero_n);
                        main.setVisibility(View.INVISIBLE);
                    }
                }
            }
        });

        Servicio.setUpdateListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    protected void calcula(int n) {
        Intent serviceIntent = new Intent(this,Servicio.class);
        serviceIntent.putExtra("n", n);
        startService(serviceIntent);
        detenServicio(serviceIntent);
    }

    public void pintaTabla(int[][] magico) {
        int contador = 0;

        Log.i(TAG, "Pintando tabla");

        for(int i = 0; i < numero_n; i++) {
            for(int j = 0; j < numero_n; j++) {
                cadena[contador] = magico[i][j];
                contador++;
            }
        }

        android.app.FragmentManager fm = getFragmentManager();
        final android.app.FragmentTransaction ft = fm.beginTransaction();
        Fragmento fragmento = new Fragmento();

        Bundle bundle = new Bundle();
        bundle.putIntArray("cadena", cadena);
        Log.i(TAG, "Cadena -3- ");
        bundle.putInt("numero", numero_n);
        fragmento.setArguments(bundle);
        ft.replace(android.R.id.content, fragmento);
        ft.commit();
    }

    public void detenServicio(Intent i) {
        stopService(i);
    }
}