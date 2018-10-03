package comlucifer017.github.absdelivery;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OrderActivity extends AppCompatActivity {

    public static final String LIST_ORDER = "list_order";
    @BindView(R.id.menu_makan_satu)
    EditText menuMakanSatu;
    @BindView(R.id.menu_makan_empat)
    EditText menuMakanEmpat;
    @BindView(R.id.menu_makan_dua)
    EditText menuMakanDua;
    @BindView(R.id.menu_makan_tiga)
    EditText menuMakanTiga;
    @BindView(R.id.menu_minum_satu)
    EditText menuMinumSatu;
    @BindView(R.id.menu_minum_dua)
    EditText menuMinumDua;
    @BindView(R.id.menu_minum_tiga)
    EditText menuMinumTiga;

    List<Order> listOrder = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        ButterKnife.bind(this);
        initToolbar();
    }

    private void initToolbar() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Menu Pemesanan");
    }

    @OnClick(R.id.btn_pesan)
    public void buttonPesan(){
        if(!TextUtils.isEmpty(menuMakanSatu.getText().toString())){
            listOrder.add(new Order(getString(R.string.nasi), menuMinumSatu.getText().toString(), 3000));
        }
        if(!TextUtils.isEmpty(menuMakanDua.getText().toString())){
            listOrder.add(new Order(getString(R.string.ayam_bakar), menuMakanDua.getText().toString(), 15000));
        }
        if(!TextUtils.isEmpty(menuMakanTiga.getText().toString())){
            listOrder.add(new Order(getString(R.string.ayam_sayur), menuMakanTiga.getText().toString(), 12000));
        }
        if(!TextUtils.isEmpty(menuMakanEmpat.getText().toString())){
            listOrder.add(new Order(getString(R.string.rendang), menuMakanDua.getText().toString(), 15000));
        }
        if(!TextUtils.isEmpty(menuMinumSatu.getText().toString())){
            listOrder.add(new Order(getString(R.string.es_teh_manis), menuMinumSatu.getText().toString(), 5000));
        }
        if(!TextUtils.isEmpty(menuMinumDua.getText().toString())){
            listOrder.add(new Order(getString(R.string.aneka_jus), menuMinumDua.getText().toString(), 7000));
        }
        if(!TextUtils.isEmpty(menuMinumTiga.getText().toString())){
            listOrder.add(new Order(getString(R.string.air_mineral), menuMinumTiga.getText().toString(), 3000));
        }
        Intent i = new Intent(OrderActivity.this, InvoiceActivity.class);
        i.putExtra(LIST_ORDER, (ArrayList<Order>) listOrder);
        startActivity(i);
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home : {
                finish();
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
