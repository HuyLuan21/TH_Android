package com.example.th03_ex2;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        CheckBox red = findViewById(R.id.red);
        CheckBox blue = findViewById(R.id.blue);
        CheckBox green = findViewById(R.id.green);

        TextView textView = findViewById(R.id.textView);

        CompoundButton.OnCheckedChangeListener listener = (buttonView, isChecked) -> {
            int r = red.isChecked() ? 255 : 0;
            int g = green.isChecked() ? 255 : 0;
            int b = blue.isChecked() ? 255 : 0;

            textView.setTextColor(Color.rgb(r, g, b));
        };

        red.setOnCheckedChangeListener(listener);
        green.setOnCheckedChangeListener(listener);
        blue.setOnCheckedChangeListener(listener);

    }
}