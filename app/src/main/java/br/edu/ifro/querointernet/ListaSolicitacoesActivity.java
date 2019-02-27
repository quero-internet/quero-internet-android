package br.edu.ifro.querointernet;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TwoLineListItem;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifro.querointernet.DAO.SolicitacaoViabilidadeDAO;
import br.edu.ifro.querointernet.model.SolicitacaoViabilidade;

public class ListaSolicitacoesActivity extends AppCompatActivity {

    private FloatingActionButton btnAdd;
    private ListView listView;
    private SolicitacaoViabilidadeDAO dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_solicitacoes);

        this.initializeComponents();

        this.configurarButtons();
        this.atualizarListView();
        registerForContextMenu(listView);
    }

    private void atualizarListView() {
        dao = new SolicitacaoViabilidadeDAO(this);
        List<SolicitacaoViabilidade> lista = dao.listar();

        ArrayAdapter<SolicitacaoViabilidade> adapter = new ArrayAdapter<SolicitacaoViabilidade>(this, android.R.layout.simple_list_item_1, lista);

        this.listView.setAdapter(adapter);
    }

    private void configurarButtons() {
        this.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ListaSolicitacoesActivity.this, FormularioEtapa1Activity.class));
            }
        });
    }

    private void initializeComponents() {
        this.btnAdd = findViewById(R.id.lista_solicitacoes_add_button);
        this.listView = findViewById(R.id.lista_solicitacoes_listview);
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.atualizarListView();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, final ContextMenu.ContextMenuInfo menuInfo) {
        MenuItem itemDetalhes = menu.add("Detalhes");
        MenuItem itemCancelar = menu.add("Cancelar");

        itemCancelar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) menuInfo;

                final SolicitacaoViabilidade solicitacaoViabilidade = (SolicitacaoViabilidade) listView.getItemAtPosition(adapterContextMenuInfo.position);

                new AlertDialog.Builder(ListaSolicitacoesActivity.this)
                        .setTitle("Confirma o cancelamento?")
                        .setMessage("Isso irá notificar os provedores que sua solicitação foi cancelada")
                        .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dao = new SolicitacaoViabilidadeDAO(ListaSolicitacoesActivity.this);
                                dao.remover(solicitacaoViabilidade.getId());
                                atualizarListView();
                            }
                        }).setNegativeButton("Não", null)
                        .show();
                return false;
            }
        });

        itemDetalhes.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) menuInfo;

                final SolicitacaoViabilidade solicitacaoViabilidade = (SolicitacaoViabilidade) listView.getItemAtPosition(adapterContextMenuInfo.position);

                new AlertDialog.Builder(ListaSolicitacoesActivity.this)
                        .setTitle(String.format("Solicitação - "+solicitacaoViabilidade.getId()))
                        .setMessage(solicitacaoViabilidade.getAlertDialogMessage())
                        .show();

                return false;
            }
        });
    }
}
