package com.example.tiaimageandinputcontrol;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView ivDonut, ivIceCream, ivFroyo;
    private TextView tvDonut, tvIceCream, tvFroyo, tvFone;
    private EditText etFone;

    private String clientOrder;
    public static final String EXTRA_MESSAGE = "orderMessage";
    public static final String FONE_DO_CAFE = "0154899167-1227";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ivDonut = findViewById(R.id.ivDonut);
        ivIceCream = findViewById(R.id.ivIceCream);
        ivFroyo = findViewById(R.id.ivFroyo);
        tvFone = findViewById(R.id.tvFone);
        //etFone = findViewById(R.id.etFone);


        tvFone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numeroDeTelefone = FONE_DO_CAFE;
                Uri uri = Uri.parse("tel:" +FONE_DO_CAFE);
                Intent i = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(i);

                
            }
        });


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
        if (id == R.id.action_order) {
            Toast.makeText(this, R.string.action_order_message, Toast.LENGTH_SHORT).show();
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
