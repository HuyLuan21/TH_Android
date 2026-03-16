package com.example.bai1;

import android.os.Bundle;
import android.widget.*;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button btnAdd;
    ListView listView;

    ArrayList<String> danhSach;
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
        editText = findViewById(R.id.editText);
        btnAdd   = findViewById(R.id.btnAdd);
        listView = findViewById(R.id.listView);

        // Khởi tạo danh sách và adapter
        danhSach = new ArrayList<>();
        adapter  = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, danhSach);
        listView.setAdapter(adapter);

        // Nút "Please Click Me!" → thêm vào ListView
        btnAdd.setOnClickListener(v -> {
            String text = editText.getText().toString().trim();
            if (text.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập giá trị!", Toast.LENGTH_SHORT).show();
                return;
            }
            danhSach.add(text);
            adapter.notifyDataSetChanged();
            editText.setText("");
        });

        // Click item → hiển thị lên màn hình (Toast)
        listView.setOnItemClickListener((parent, view, position, id) -> {
            String giaTri = danhSach.get(position);
            Toast.makeText(this, giaTri, Toast.LENGTH_SHORT).show();
        });
    }
}