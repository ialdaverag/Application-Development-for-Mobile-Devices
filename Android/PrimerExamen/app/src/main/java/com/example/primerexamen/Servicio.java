package com.example.primerexamen;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;

import static android.content.ContentValues.TAG;

public class Servicio extends Service {
    public static MainActivity UPDATE_LISTENER;
    private Handler h;

    public static void setUpdateListener(MainActivity sta) {
        UPDATE_LISTENER = sta;
    }

    @Override
    public IBinder onBind(Intent arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "SERVICIO CREADO");
    }

    @Override
    public void onStart(Intent intent, int startId) {
        // TODO Auto-generated method stub
        super.onStart(intent, startId);

        Log.i(TAG, "Servicio started");
        Bundle extras = intent.getExtras();

        int n = (int) extras.get("n");
        final int[][] arreglo = magico(n);

        h = new Handler()
        {
            @Override public void handleMessage(Message msg) { UPDATE_LISTENER.pintaTabla(arreglo); }
        };
        h.sendEmptyMessage(0);

        this.onDestroy();
    }


    @Override
    public void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        Log.i(TAG, "FirstService destroyed");

    }

    public int[][] magico(int n) {
        Log.i(TAG, "MAGIA *3*");

        int[][] arr = new int[n][n] ;
        int contador = 1;
        int fi = 0;
        int col = (n/2);
        int[] antFi = new int[n*n];
        int[] antCol = new int[n*n];

        for(int i = 0; i < n*n; i++) {
            if(i == 0) {
                arr[fi][col] = contador;
                fi--;
                col++;
            } else {
                if(fi < 0) {
                    fi  = n - 1;
                }

                if(col == n) {
                    col = 0;
                }

                if(arr[fi][col] > 0) {
                    fi = antFi[i-1];
                    col = antCol[i-1];
                    fi++;
                }

                arr[fi][col] = contador;
                antFi[i] = fi;
                antCol[i] = col;
                fi--;
                col++;
            }
            contador++;
        }
        return arr;
    }
}
