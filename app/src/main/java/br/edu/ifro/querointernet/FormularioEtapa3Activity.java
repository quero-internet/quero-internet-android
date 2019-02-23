package br.edu.ifro.querointernet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FormularioEtapa3Activity extends AppCompatActivity {
    private Button enderecoMapa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_etapa_3);

        this.initializeComponents();


    }

    private void initializeComponents() {

        enderecoMapa = findViewById(R.id.activity_formulario_mapa);

        enderecoMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FormularioEtapa3Activity.this, MapaActivity.class));
            }
        });

    }
}