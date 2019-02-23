package br.edu.ifro.querointernet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FormularioEtapa1Activity extends AppCompatActivity {

    private Button avancarBtnEtapa1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_etapa_1);

        this.initializeComponents();
    }

    private void initializeComponents() {
        this.avancarBtnEtapa1 = findViewById(R.id.activity_formulario_etapa_1_avancar);

        this.avancarBtnEtapa1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FormularioEtapa1Activity.this, FormularioEtapa2Activity.class));
            }
        });
    }
}
