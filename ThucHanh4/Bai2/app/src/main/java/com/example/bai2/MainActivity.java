package com.example.bai2;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner spCourlor;
    EditText edCourlor;
    Button btInsert;

    ArrayList<String> danhSachMau;
    ArrayAdapter<String> adapter;

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

        // Ánh xạ view
        spCourlor = findViewById(R.id.spCourlor);
        edCourlor = findViewById(R.id.edCourlor);
        btInsert  = findViewById(R.id.btInsert);

        // Dữ liệu mặc định 4 màu
        danhSachMau = new ArrayList<>();
        danhSachMau.add("Xanh");
        danhSachMau.add("Đỏ");
        danhSachMau.add("Tím");
        danhSachMau.add("Vàng");

        // Gán adapter cho Spinner
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, danhSachMau);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCourlor.setAdapter(adapter);

        // 1. Chọn item trong Spinner → Toast
        spCourlor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String mauDaChon = danhSachMau.get(position);
                Toast.makeText(MainActivity.this, mauDaChon, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });

        // 2. Nhấn Insert → thêm màu mới vào Spinner
        btInsert.setOnClickListener(v -> {
            String tenMau = edCourlor.getText().toString().trim();
            if (tenMau.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập tên màu!", Toast.LENGTH_SHORT).show();
                return;
            }
            danhSachMau.add(tenMau);
            adapter.notifyDataSetChanged();

            // Chọn item vừa thêm để hiển thị
            spCourlor.setSelection(danhSachMau.size() - 1);

            Toast.makeText(this, "Đã thêm: " + tenMau, Toast.LENGTH_SHORT).show();
            edCourlor.setText("");
        });
    }
}