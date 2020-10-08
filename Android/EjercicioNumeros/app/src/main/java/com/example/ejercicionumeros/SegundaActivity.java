package com.example.ejercicionumeros;

import android.os.Bundle;
import android.app.Activity;
import android.widget.*;

public class SegundaActivity extends Activity{
    TextView jtw, jtw2, jtw3, jtw4, jtw5;
    Bundle bdl;
    int n;
    String iter, esprimo, esmaravilloso, espalindromo, esfibonacci;

    public void onCreate(Bundle b){
        super.onCreate(b);

        setContentView(R.layout.activity_segunda);

        jtw = findViewById(R.id.xtv1);
        jtw2 = findViewById(R.id.xtv2);
        jtw3 = findViewById(R.id.xtv3);
        jtw4 = findViewById(R.id.xtv4);
        jtw5 = findViewById(R.id.xtv5);
        bdl = getIntent().getExtras();

        n = Integer.parseInt(bdl.getString("numero"));

        if(esPrimo(n)) esprimo = "Es primo";
        else esprimo = "";

        if(esFibonacci(n)) esfibonacci = "Pertenece a la serie de Fibonacci";
        else esfibonacci = "";

        if(esMaravilloso(n)) esmaravilloso = "Es maravilloso";
        else esmaravilloso = "";

        if(esPalindromo(n)) espalindromo = "Es palindromo";
        else espalindromo = "";

        jtw.setText(iter);
        jtw2.setText(esmaravilloso);
        jtw3.setText(esprimo);
        jtw4.setText(espalindromo);
        jtw5.setText(esfibonacci);
    }


    private boolean esPrimo(int n) {
        if (n <= 1)
            return false;

        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;

        return true;
    }

    private  boolean esCuadradoPerfecto(int x) {
        int s = (int) Math.sqrt(x);
        return (s*s == x);
    }

    private boolean esFibonacci(int n) {
        // n es Fibonacci si uno de 5*n*n + 4 o 5*n*n - 4 o ambos
        // es un cuadrado perfecto
        return esCuadradoPerfecto(5*n*n + 4) ||
                esCuadradoPerfecto(5*n*n - 4);
    }

    private boolean esMaravilloso(int n){
        return n > 0;
    }

    public String maravillosoSecuencia(int n) {
        String iter2 = "";
        while (n != 1) {
            iter = n + " ";
            iter2 = iter2 + iter;
            System.out.println(iter2);
            // Si n es impar
            if ((n & 1) == 1)
                n = 3 * n + 1;

                // Si es par
            else
                n = n / 2;
        }

        System.out.println(iter2 + n);
        return iter2 + n;
    }

    private boolean esPalindromo(int n){
        int divisor = 1;

        while (n / divisor >= 10)
            divisor *= 10;

        while (n != 0) {
            int leading = n / divisor;
            int trailing = n % 10;

            if (leading != trailing)
                return false;

            n = (n % divisor) / 10;
            divisor = divisor / 100;
        }

        return true;
    }
}