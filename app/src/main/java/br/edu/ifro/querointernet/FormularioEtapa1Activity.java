package br.edu.ifro.querointernet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class FormularioEtapa1Activity extends AppCompatActivity {

    private Button avancarBtnEtapa1;
    private Spinner spinnerTiposTecnologia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_etapa_1);

        this.initializeComponents();
    }

    private void initializeComponents() {
        //Itens do Spinner
        String[] tiposTecnologia = {"Via rádio", "Fibra óptica", "ADSL", "Internet móvel"};
        spinnerTiposTecnologia = findViewById(R.id.activity_formulario_etapa_1_tipos_tecnologia);

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tiposTecnologia);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTiposTecnologia.setAdapter(spinnerArrayAdapter);

        //Ação da botão avançar
        this.avancarBtnEtapa1 = findViewById(R.id.activity_formulario_etapa_1_avancar);

        this.avancarBtnEtapa1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FormularioEtapa1Activity.this, FormularioEtapa2Activity.class));
            }
        });
    }
}
