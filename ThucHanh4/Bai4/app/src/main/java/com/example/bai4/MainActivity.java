package com.example.bai4;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private Spinner spCountry, spList;
    private Button btSubmit;

    private ArrayList<String> countryList;
    private ArrayAdapter<String> countryAdapter;
    private String selectedCountry = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ view
        spCountry = findViewById(R.id.spCountry);
        spList    = findViewById(R.id.spList);
        btSubmit  = findViewById(R.id.btSubmit);

        // ============================================================
        // Khởi tạo dữ liệu spCountry
        // ============================================================
        countryList = new ArrayList<>(Arrays.asList(
                "Malaysia", "United States", "Indonesia", "France"
        ));

        countryAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, countryList);
        countryAdapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        spCountry.setAdapter(countryAdapter);

        // ============================================================
        // Khởi tạo dữ liệu spList (mẫu)
        // ============================================================
        ArrayList<String> listItems = new ArrayList<>(Arrays.asList(
                "list 1", "list 2", "list 3"
        ));
        ArrayAdapter<String> listAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, listItems);
        listAdapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        spList.setAdapter(listAdapter);

        // ============================================================
        // Yêu cầu 1: Chọn item trong spCountry → AlertDialog
        // ============================================================
        spCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            boolean isFirst = true; // Bỏ qua lần trigger tự động khi load

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                if (isFirst) { isFirst = false; return; }

                selectedCountry = countryList.get(position);

                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Quốc gia đã chọn")
                        .setMessage("OnItemSelectedListener : " + selectedCountry)
                        .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                        .show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });

        // ============================================================
        // Yêu cầu 2: Click btSubmit → xóa item đang chọn khỏi spCountry
        // ============================================================
        btSubmit.setOnClickListener(v -> {
            if (countryList.isEmpty()) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Thông báo")
                        .setMessage("Danh sách quốc gia đã trống!")
                        .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                        .show();
                return;
            }

            int selectedPos = spCountry.getSelectedItemPosition();
            String removedCountry = countryList.get(selectedPos);

            countryList.remove(selectedPos);
            countryAdapter.notifyDataSetChanged();

            // Reset về item đầu tiên nếu còn phần tử
            if (!countryList.isEmpty()) {
                spCountry.setSelection(0);
            }

            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Đã xóa")
                    .setMessage("Đã xóa \"" + removedCountry + "\" khỏi danh sách!")
                    .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                    .show();
        });
    }
}