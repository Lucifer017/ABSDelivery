package comlucifer017.github.absdelivery;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        String title = null;
        switch (item.getItemId()){
            case R.id.action_kontak:
                title="Mode List";
//                showListCountry();
                break;
            case R.id.action_home:
                title="ABSDelivery";
//                showRecyclerGrid();
                break;
//            case R.id.action_cardview:
//                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @OnClick({R.id.btn_kontak, R.id.btn_menu})
    public void actionButton(View v){
        switch (v.getId()){
            case R.id.btn_kontak : {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:08121409681"));
                startActivity(intent);
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                break;
            }
            case R.id.btn_menu : {
                startActivity(new Intent(MainActivity.this, OrderActivity.class));
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                break;
            }
        }
    }
}
