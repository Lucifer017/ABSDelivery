package comlucifer017.github.absdelivery;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static comlucifer017.github.absdelivery.OrderActivity.LIST_ORDER;

public class InvoiceActivity extends AppCompatActivity {

    @BindView(R.id.rv_pesanan)
    RecyclerView rvPesanan;
    @BindView(R.id.txt_total_cost)
    TextView txtTotalPrice;

    List<Order> listOrder = new ArrayList<>();
    OrderAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice);
        ButterKnife.bind(this);
        initToolbar();
        initData();
    }

    private void initData() {
        listOrder = (ArrayList<Order>)getIntent().getSerializableExtra(LIST_ORDER);
        int total = 0;
        for(int i=0; i<listOrder.size(); i++){
            Order order = listOrder.get(i);
            total = total + (Integer.parseInt(order.getJumlah()) * order.getHarga());
        }
        txtTotalPrice.setText("Rp. "+total);

        adapter = new OrderAdapter(InvoiceActivity.this, listOrder);
        rvPesanan.setHasFixedSize(true);
        rvPesanan.setLayoutManager(new LinearLayoutManager(InvoiceActivity.this));
        rvPesanan.setAdapter(adapter);

        rvPesanan.setAdapter(new OrderAdapter(InvoiceActivity.this, listOrder));
        adapter.notifyDataSetChanged();
    }

    private void initToolbar() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Menu Invoice");
    }

    @OnClick(R.id.btn_selesai)
    public void buttonSelesai(){
        new AlertDialog.Builder(this)
                .setTitle("Pesanan Diterima")
                .setMessage("Terima kasih anda sudah memesan di Ayam Bakar Sultan")
                .setPositiveButton("Oke", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i = new Intent(InvoiceActivity.this, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(i);
                        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                    }
                })
                .show();
    }

    @Override
    public void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
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
