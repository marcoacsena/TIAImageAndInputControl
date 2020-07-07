package com.example.tiaimageandinputcontrol;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView ivDonut, ivIceCream, ivFroyo;
    private TextView tvDonut, tvIceCream, tvFroyo;

    private String clientOrder;
    public static final String EXTRA_MESSAGE = "orderMessage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ivDonut = findViewById(R.id.ivDonut);
        ivIceCream = findViewById(R.id.ivIceCream);
        ivFroyo = findViewById(R.id.ivFroyo);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();

                if(clientOrder != null) {
                    Intent intent = new Intent(getApplicationContext(), OrderActivity.class);
                    intent.putExtra(EXTRA_MESSAGE, clientOrder);
                    startActivity(intent);
                }else Toast.makeText(MainActivity.this, R.string.mensagem_de_opcao_nao_selecionada_no_cardapio, Toast.LENGTH_LONG).show();
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
//
//    public void displayToast (String message){
//
//        Toast.makeText(this, "message", Toast.LENGTH_SHORT).show();
//    }


    public void showDonutOrder(View view){

        clientOrder = getString(R.string.donut_order_message);
        Toast.makeText(this, clientOrder, Toast.LENGTH_SHORT).show();

    }

    public void showIcecreamOrder(View view){

        clientOrder = getString(R.string.ice_cream_order_message);
        Toast.makeText(this, clientOrder, Toast.LENGTH_SHORT).show();

    }

    public void showFroyoOrder(View view){

        clientOrder = getString(R.string.froyo_order_message);
        Toast.makeText(this, clientOrder, Toast.LENGTH_SHORT).show();

    }

}
