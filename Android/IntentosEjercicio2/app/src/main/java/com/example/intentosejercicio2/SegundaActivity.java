package com.example.intentosejercicio2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {
    TextView jetr1, jetr2, jet2, jet3;
    Bundle bdl;
    int grado;
    double a, b, c;
    double x1, x2, discriminante;
    String ca, cb, cc;
    String raiz1, raiz2, tipo, ecuacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        jetr1 = findViewById(R.id.xtvr1);
        jetr2 = findViewById(R.id.xtvr2);
        jet2 = findViewById(R.id.xtv2);
        jet3 = findViewById(R.id.xtv3);
        bdl = getIntent().getExtras();

        a = Double.parseDouble(bdl.getString("ca"));
        b = Double.parseDouble(bdl.getString("cb"));
        c = Double.parseDouble(bdl.getString("cc"));

        grado = identificarEcuacion(a, b, c);

        if(grado == 1){
            tipo = "Una raíz real";
            raiz1 = calcularRaiz(b, c);
        }
        else if(grado == 2){
            discriminante = calcularDiscriminante(a, b, c);

            if(discriminante > 0){
                tipo = "Raíces reales diferentes";
                raiz1 = calcularRaizReal1(a, b, c);
                raiz2 = calcularRaizReal2(a, b, c);
            }else if(discriminante == 0){
                tipo = "Raíces reales iguales";
                raiz1 = calcularRaizReal1(a, b, c);
                raiz2 = calcularRaizReal2(a, b, c);
            }else{
                tipo = "Raíces complejas";
                raiz1 = calcularRaizCompleja1(a, b, c);
                raiz2 = calcularRaizCompleja2(a, b, c);
            }
        } else
            System.out.println("No hay ecuación");

        ecuacion = representarEcuacion(a, b, c);

        jet3.setText(ecuacion);
        jet2.setText(tipo);
        jetr1.setText(raiz1);
        jetr2.setText(raiz2);
        jet3.setGravity(1);
    }

    public static int identificarEcuacion(double a, double b, double c){
        if(a != 0)
            return 2;
        else if(a == 0 && b != 0)
            return 1;
        else
            return 0;
    }

    public static double calcularDiscriminante(double a, double b, double c){
        double discriminante;

        discriminante = Math.sqrt(b*b - 4*a*c);

        return discriminante;
    }

    public static String calcularRaiz(double b, double c){
        double x;
        String raiz;

        x = -c / b;

        raiz = "X1 = "+x;

        return raiz;
    }

    public static String calcularRaizReal1(double a, double b, double c){
        double x1;
        String raiz1;

        x1 = (-b + Math.sqrt(b*b - 4*a*c)) / 2*a;

        raiz1 = "X1 = "+x1;

        return raiz1;
    }

    public static String calcularRaizReal2(double a, double b, double c){
        double x2;
        String raiz2;

        x2 = (-b - Math.sqrt(b*b - 4*a*c)) / 2*a;

        raiz2 = "X2 = "+x2;

        return raiz2;
    }

    public static String calcularRaizCompleja1(double a, double b, double c){
        double x11, x12;
        String raiz1;

        x11 = -b / 2*a;
        x12 = Math.sqrt(-(b*b - 4*a*c)) / 2*a;

        raiz1 = "X1 = "+x11+" + "+x12+"i ";

        return raiz1;
    }

    public static String calcularRaizCompleja2(double a, double b, double c){
        double x21, x22;
        String raiz2;

        x21 = -b / 2*a;
        x22 = Math.sqrt(-(b*b - 4*a*c)) / 2*a;

        raiz2 = "X2 = "+x21+" - "+x22+"i";

        return raiz2;
    }

    public static String representarEcuacion(double a, double b, double c){
        String ca, cb, cc, ecuacion;

        if(a == 0)
            ca = "";
        else if(a == 1)
            ca = "X²";
        else if(a == -1)
            ca = "- X²";
        else if(a > 0)
            ca = ""+a+"X²";
        else
            ca = "- "+a+"X²";

        if(a == 0){
            if(b == 0)
                cb = "";
            else if(b == 1)
                cb = "X";
            else if(b == -1)
                cb = "- X";
            else if(b > 0)
                cb = +b+"X";
            else
                cb = "- "+-b+"X";
        }
        else{
            if(b == 0)
                cb = "";
            else if(b == 1)
                cb = " + X";
            else if(b == -1)
                cb = " - X";
            else if(b > 0)
                cb = " + "+b+"X";
            else
                cb = " - "+-b+"x";
        }

        if(c == 0)
            cc = "";
        else if(c > 0)
            cc = " + "+c;
        else
            cc = " - "+-c;

        ecuacion = ca+cb+cc;

        return ecuacion;
    }

}
