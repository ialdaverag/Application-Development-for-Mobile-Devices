package com.example.examenfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.andrognito.patternlockview.PatternLockView;
import com.andrognito.patternlockview.listener.PatternLockViewListener;
import com.andrognito.patternlockview.utils.PatternLockUtils;

import java.util.List;

import io.paperdb.Paper;

public class MainActivity extends AppCompatActivity {

    PatternLockView mPatternLockView;

    String patronGuardado = "pattern_code";
    String patronFinal = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Paper.init(this);
        final String save_pattern = Paper.book().read(patronGuardado);

        if(save_pattern != null && !save_pattern.equals("null")){
            setContentView(R.layout.activity_main);

            mPatternLockView = (PatternLockView)findViewById(R.id.pattern_lock_view);
            mPatternLockView.setTactileFeedbackEnabled(false);
            mPatternLockView.setDotNormalSize(40);
            mPatternLockView.setDotSelectedSize(40);
            mPatternLockView.setNormalStateColor(getResources().getColor(R.color.black));
            mPatternLockView.setCorrectStateColor(getResources().getColor(R.color.black));
            mPatternLockView.setWrongStateColor(getResources().getColor(R.color.red));
            mPatternLockView.setPathWidth(40);

            mPatternLockView.addPatternLockListener(new PatternLockViewListener() {
                @Override
                public void onStarted() { }

                @Override
                public void onProgress(List<PatternLockView.Dot> progressPattern) { }

                @Override
                public void onComplete(List<PatternLockView.Dot> pattern) {
                    patronFinal = PatternLockUtils.patternToString(mPatternLockView,pattern);
                    if(patronFinal.equals(save_pattern)){
                        Toast.makeText(MainActivity.this, "¡Patrón correcto!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, MainActivity3.class);
                        startActivity(intent);

                    } else {
                        Toast.makeText(MainActivity.this, "Patrón incorrecto", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onCleared() { }
            });

        } else {
            setContentView(R.layout.activity_main);

            mPatternLockView = (PatternLockView)findViewById(R.id.pattern_lock_view);
            mPatternLockView.setTactileFeedbackEnabled(false);
            mPatternLockView.setDotNormalSize(40);
            mPatternLockView.setDotSelectedSize(40);
            mPatternLockView.setNormalStateColor(getResources().getColor(R.color.black));
            mPatternLockView.setCorrectStateColor(getResources().getColor(R.color.black));
            mPatternLockView.setWrongStateColor(getResources().getColor(R.color.red));
            mPatternLockView.setPathWidth(40);

            mPatternLockView.addPatternLockListener(new PatternLockViewListener() {
                @Override
                public void onStarted() { }

                @Override
                public void onProgress(List<PatternLockView.Dot> progressPattern) { }

                @Override
                public void onComplete(List<PatternLockView.Dot> pattern) {
                    patronFinal = PatternLockUtils .patternToString(mPatternLockView,pattern);

                }

                @Override
                public void onCleared() { }
            });

            Button btnGuardar = (Button) findViewById(R.id.btnGuardarPatron);
            btnGuardar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Paper.book().write(patronGuardado, patronFinal);
                    Toast.makeText(MainActivity.this, "¡Patrón guardado con éxito!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(intent);
                }
            });
        }
    }
}