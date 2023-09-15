package com.example.verdurasverdes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {
TextView TextoRecibido;
Button botonVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        TextoRecibido =findViewById(R.id.txtRecibir);
        double resultado = getIntent().getDoubleExtra("resultado",0);
        TextoRecibido.setText("$" + resultado);

        botonVolver=findViewById(R.id.btnVolver);
        botonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        getApplicationContext(),
                        MainActivity.class
                        );
                startActivity(intent);
            }
        });
    }
}