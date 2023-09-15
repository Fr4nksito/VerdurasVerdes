package com.example.verdurasverdes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText textom2;
    EditText textoCV;

    Button boton;
    Button botonLimpiar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textom2=findViewById(R.id.txtHectarea);
        textoCV=findViewById(R.id.txtCostoVerduras);
        boton= findViewById(R.id.btnCalcular);
        botonLimpiar= findViewById(R.id.btnLimpiar);
        botonLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textom2.setText("");
                textoCV.setText("");
            }
        });
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtén los valores ingresados por el usuario
                String m2str = textom2.getText().toString();
                String CVstr = textoCV.getText().toString();
// Convierte los valores a números (puedes agregar validación de entrada)
                double metrosCuadrados = Double.parseDouble(m2str);
                double costoVerduras= Double.parseDouble(CVstr);
                // Convierte metros cuadrados a hectáreas (1 hectárea = 10,000 metros cuadrados)
                double hectareas = metrosCuadrados/ 10000;

                double costoTotal= hectareas * costoVerduras;

                Intent intent = new Intent(
                        getApplicationContext(),
                        Resultado.class
                );
                intent.putExtra("resultado",costoTotal);
                startActivity(intent);
            }
        });
    }
}