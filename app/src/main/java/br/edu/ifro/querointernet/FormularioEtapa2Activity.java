package br.edu.ifro.querointernet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FormularioEtapa2Activity extends AppCompatActivity {
    private Button avancarBtnEtapa3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_etapa_2);

        this.initializeComponents();
    }

    private void initializeComponents() {
        avancarBtnEtapa3 = findViewById(R.id.activity_formulario_etapa_2_avancar);

        avancarBtnEtapa3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FormularioEtapa2Activity.this, FormularioEtapa4Endereco.class));
            }
        });
    }
}
