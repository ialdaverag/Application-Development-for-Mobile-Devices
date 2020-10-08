package com.david.matriz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    public int matSize;

    //Magic square
    public int[][] generateSquare() {
        int n = matSize;
        int[][] magicSquare = new int[n][n];

        // Initialize position for 1
        int i = n/2;
        int j = n-1;

        // One by one put all values in magic square
        for (int num=1; num <= n*n; )
        {
            if (i==-1 && j==n) //3rd condition
            {
                j = n-2;
                i = 0;
            }
            else
            {
                //1st condition helper if next number
                // goes to out of square's right side
                if (j == n)
                    j = 0;

                //1st condition helper if next number is
                // goes to out of square's upper side
                if (i < 0)
                    i=n-1;
            }

            //2nd condition
            if (magicSquare[i][j] != 0)
            {
                j -= 2;
                i++;
                continue;
            }
            else
                //set number
                magicSquare[i][j] = num++;

            //1st condition
            j++;  i--;
        }

        return magicSquare;
    }



    public void createMat(View v){
        TableLayout  table =  findViewById(R.id.table);
        table.removeAllViews();
        EditText ed = findViewById(R.id.editText);

        matSize = Integer.parseInt(ed.getText().toString());

        int[][] mat = generateSquare();

        int suma = 0;

        for(int i = 0; i < matSize; i++){
            //suma += mat[0][i];
        }

        for(int i = 0; i < matSize+1; i++ ){
            TableRow tr = new TableRow(this);
            for(int j = 0; j < matSize+1; j++ ){
                TextView tv = new TextView(this );
                tv.setText(" "+ mat[i][j] + " ");
                tr.addView(tv);
                if(i == matSize ){
                    TextView tc  = new TextView(this );
                    tc.setText(" "+ suma + " ");
                }

            }

            table.addView(tr);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
