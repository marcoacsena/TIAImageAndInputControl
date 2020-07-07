package com.example.tiaimageandinputcontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import static com.example.tiaimageandinputcontrol.MainActivity.EXTRA_MESSAGE;

public class OrderActivity extends AppCompatActivity {

    private TextView tvOrderMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        tvOrderMessage = findViewById(R.id.tvOrderMessage);

        Intent intent = getIntent();
        String message = "Your order: " +intent.getStringExtra(EXTRA_MESSAGE);
        tvOrderMessage.setText(message);
    }
}
