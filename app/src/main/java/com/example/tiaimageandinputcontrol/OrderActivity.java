package com.example.tiaimageandinputcontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.tiaimageandinputcontrol.MainActivity.EXTRA_MESSAGE;

public class OrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private TextView tvOrderMessage;
    private RadioButton rbMesmoDia, rbProximoDia, rbRetirarNaLoja;
    private Spinner spTipoDeFone;

    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        tvOrderMessage = findViewById(R.id.tvOrderMessage);
        rbMesmoDia = findViewById(R.id.rbMesmoDia);
        rbProximoDia = findViewById(R.id.rbProximoDia);
        rbRetirarNaLoja = findViewById(R.id.rbRetirarNaLoja);
        spTipoDeFone = findViewById(R.id.spTipoDeFone);
        rbProximoDia.setChecked(true);

        Intent intent = getIntent();
        String message = "Your order: " +intent.getStringExtra(EXTRA_MESSAGE);
        tvOrderMessage.setText(message);

        if(spTipoDeFone != null){

            spTipoDeFone.setOnItemSelectedListener(this);
        }

        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(getApplicationContext(),
                R.array.spinner_options, R.layout.support_simple_spinner_dropdown_item);

        arrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        if(spTipoDeFone != null){
            spTipoDeFone.setAdapter(arrayAdapter);
        }

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

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        String itemSelecionado = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(this, "O tipo de telefone selecionado foi: " +itemSelecionado, Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
