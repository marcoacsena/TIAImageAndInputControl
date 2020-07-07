package com.example.tiaimageandinputcontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.tiaimageandinputcontrol.MainActivity.EXTRA_MESSAGE;

public class OrderActivity extends AppCompatActivity {

    private TextView tvOrderMessage;
    private RadioButton rbMesmoDia, rbProximoDia, rbRetirarNaLoja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        tvOrderMessage = findViewById(R.id.tvOrderMessage);
        rbMesmoDia = findViewById(R.id.rbMesmoDia);
        rbProximoDia = findViewById(R.id.rbProximoDia);
        rbRetirarNaLoja = findViewById(R.id.rbRetirarNaLoja);

        Intent intent = getIntent();
        String message = "Your order: " +intent.getStringExtra(EXTRA_MESSAGE);
        tvOrderMessage.setText(message);
    }

    public void onRadioButtonClicked(View view) {

        switch (view.getId()){

            case R.id.rbMesmoDia:
                Toast.makeText(this, R.string.same_day_messenger_service, Toast.LENGTH_SHORT).show();
                break;
            case R.id.rbProximoDia:
                Toast.makeText(this, R.string.next_day_ground_delivery, Toast.LENGTH_SHORT).show();
                break;
            case R.id.rbRetirarNaLoja:
                Toast.makeText(this, R.string.retirar_na_loja, Toast.LENGTH_SHORT).show();

        }

    }
}
