package com.example.bai4;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CheckBox cbCoffee, cbChe, cbKem, cbBimBim;
    EditText edtSL1, edtSL2, edtSL3, edtSL4;
    TextView tvTong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cbCoffee = findViewById(R.id.cbCoffee);
        cbChe = findViewById(R.id.cbChe);
        cbKem = findViewById(R.id.cbKem);
        cbBimBim = findViewById(R.id.cbBimBim);

        edtSL1 = findViewById(R.id.edtSL1);
        edtSL2 = findViewById(R.id.edtSL2);
        edtSL3 = findViewById(R.id.edtSL3);
        edtSL4 = findViewById(R.id.edtSL4);

        tvTong = findViewById(R.id.tvTong);
    }

    public void TongTien(View v) {

        int tong = 0;

        if (cbCoffee.isChecked()) {

            if (edtSL1.getText().toString().trim().isEmpty()) {
                showAlert("Bạn đã chọn Coffee nhưng chưa nhập số lượng!");
                return;
            }

            int sl = Integer.parseInt(edtSL1.getText().toString());
            tong += sl * 18000;
        }

        if (cbChe.isChecked()) {

            if (edtSL2.getText().toString().trim().isEmpty()) {
                showAlert("Bạn đã chọn Chè nhưng chưa nhập số lượng!");
                return;
            }

            int sl = Integer.parseInt(edtSL2.getText().toString());
            tong += sl * 12000;
        }

        if (cbKem.isChecked()) {

            if (edtSL3.getText().toString().trim().isEmpty()) {
                showAlert("Bạn đã chọn Kem nhưng chưa nhập số lượng!");
                return;
            }

            int sl = Integer.parseInt(edtSL3.getText().toString());
            tong += sl * 10000;
        }

        if (cbBimBim.isChecked()) {

            if (edtSL4.getText().toString().trim().isEmpty()) {
                showAlert("Bạn đã chọn Bim bim nhưng chưa nhập số lượng!");
                return;
            }

            int sl = Integer.parseInt(edtSL4.getText().toString());
            tong += sl * 5000;
        }

        tvTong.setText("Tổng tiền: " + tong + " VNĐ");
    }

    private void showAlert(String message) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Cảnh báo");
        builder.setMessage(message);
        builder.setPositiveButton("OK", null);
        builder.show();
    }
}