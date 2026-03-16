package com.example.bai3;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lvClass;
    private Button button;
    private EditText editTextText;
    private TextView textView;

    private ArrayList<String> classList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ view — khớp đúng ID trong XML
        lvClass      = findViewById(R.id.lvClass);
        button       = findViewById(R.id.button);
        editTextText = findViewById(R.id.editTextText);
        textView     = findViewById(R.id.textView);

        textView.setText("Danh sách lớp");

        // Khởi tạo danh sách và adapter
        classList = new ArrayList<>();
        classList.add("CNTT01");
        classList.add("CNTT02");
        classList.add("KTPM01");

        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                classList);
        lvClass.setAdapter(adapter);

        // Yêu cầu 1: Chọn item → AlertDialog hiển thị giá trị
        lvClass.setOnItemClickListener((parent, view, position, id) -> {
            String selectedClass = classList.get(position);

            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Thông tin lớp")
                    .setMessage("Bạn đã chọn lớp: " + selectedClass)
                    .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                    .show();
        });

        // Yêu cầu 2: Nhập tên lớp → click Insert → thêm vào ListView + AlertDialog
        button.setOnClickListener(v -> {
            String newClass = editTextText.getText().toString().trim();

            if (newClass.isEmpty()) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Lỗi")
                        .setMessage("Vui lòng nhập tên lớp!")
                        .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                        .show();
                return;
            }

            if (classList.contains(newClass)) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Lỗi")
                        .setMessage("Lớp \"" + newClass + "\" đã tồn tại!")
                        .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                        .show();
                return;
            }

            classList.add(newClass);
            adapter.notifyDataSetChanged();
            editTextText.setText("");
            editTextText.clearFocus();

            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Thành công")
                    .setMessage("Đã thêm lớp \"" + newClass + "\" vào danh sách!")
                    .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                    .show();
        });
    }
}