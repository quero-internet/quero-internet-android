package br.edu.ifro.querointernet;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifro.querointernet.model.Parceiros;

public class ParceitosActivity extends AppCompatActivity {
    private ListView listarParceirosView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parceitos);

        this.initializeComponents();
        this.initializeList();
        registerForContextMenu(listarParceirosView);

    }

    private void initializeList() {
        List<Parceiros> lista = new ArrayList<Parceiros>();
        lista.add(new Parceiros("Internet 5.0","3321-0000"," Rua Amazonas N°351", "sememail@sememail.com"));
        lista.add(new Parceiros("Via Radio Net","3321-0000"," Rua Amazonas N°351", "sememail@sememail.com"));
        lista.add(new Parceiros("Yume Net","3321-0000"," Rua Amazonas N°351", "sememail@sememail.com"));
        lista.add(new Parceiros("Info Fibra","3321-0000"," Rua Amazonas N°351", "sememail@sememail.com"));
        lista.add(new Parceiros("Zé da Fibra","3321-0000"," Rua Amazonas N°351", "sememail@sememail.com"));
        lista.add(new Parceiros("Autorizada Oi","3321-0000"," Rua Amazonas N°351", "sememail@sememail.com"));
        lista.add(new Parceiros("Autorizada Claro","3321-0000"," Rua Amazonas N°351", "sememail@sememail.com"));
        lista.add(new Parceiros("Autorizada Vivo","3321-0000"," Rua Amazonas N°351", "sememail@sememail.com"));
        lista.add(new Parceiros("Autorizada Tim","3321-0000"," Rua Amazonas N°351", "sememail@sememail.com"));
        ArrayAdapter<Parceiros> adapter = new ArrayAdapter<Parceiros>(this,android.R.layout.simple_list_item_1,lista);
        listarParceirosView.setAdapter(adapter);
    }

    private void initializeComponents() {
        listarParceirosView = findViewById(R.id.parceiros_listView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, final ContextMenu.ContextMenuInfo menuInfo) {
        MenuItem itemDetalhes = menu.add("Detalhes");

        itemDetalhes.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) menuInfo;

                Parceiros parceiro = (Parceiros) listarParceirosView.getItemAtPosition(adapterContextMenuInfo.position);

                new AlertDialog.Builder(ParceitosActivity.this).setTitle(parceiro.getNome()).setMessage(parceiro.getAlertDialogMessage()).show();
                return false;
            }
        });
    }
}


