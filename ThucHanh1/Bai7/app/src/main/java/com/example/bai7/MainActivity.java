package com.example.bai7;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    CheckBox cbCanh, cbDui, cbCombo, cbPhu;
    TextView tvTongTien;
    int tongTien = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Edge to Edge
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Ánh xạ view
        cbCanh = findViewById(R.id.checkBox);
        cbDui = findViewById(R.id.checkBox2);
        cbCombo = findViewById(R.id.checkBox5);
        cbPhu = findViewById(R.id.checkBox6);
        tvTongTien = findViewById(R.id.textView2);

        // Xử lý check
        cbCanh.setOnCheckedChangeListener((buttonView, isChecked) -> {
            tongTien += isChecked ? 89000 : -89000;
            updateTongTien();
        });

        cbDui.setOnCheckedChangeListener((buttonView, isChecked) -> {
            tongTien += isChecked ? 92000 : -92000;
            updateTongTien();
        });

        cbCombo.setOnCheckedChangeListener((buttonView, isChecked) -> {
            tongTien += isChecked ? 156000 : -156000;
            updateTongTien();
        });

        cbPhu.setOnCheckedChangeListener((buttonView, isChecked) -> {
            tongTien += isChecked ? 34000 : -34000;
            updateTongTien();
        });
    }

    private void updateTongTien() {
        tvTongTien.setText("Tổng tiền: " + tongTien + " VND");
    }
}
