package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    } //Phương thức tính tổng
    public void TongTien(View v) {
        int Tong = 0;
        //Khai báo điều khiển
        RadioButton cbCanh, cbDui, cbCom, cbKhac;
        TextView tv;
        cbCanh = (RadioButton) findViewById(R.id.cbCanhGaRan);
        cbDui = (RadioButton) findViewById(R.id.cbDuiGaRan);
        cbCom = (RadioButton) findViewById(R.id.cbCombo);
        cbKhac = (RadioButton) findViewById(R.id.cbThucAnPhu);
        tv = (TextView) findViewById(R.id.tvTong);
        if (cbCanh.isChecked()) {
            Tong = Tong + 89000;
        }
        if (cbDui.isChecked()) {
            Tong = Tong + 92000;
        }
        if (cbCom.isChecked()) {
            Tong = Tong + 156000;
        }
        if (cbKhac.isChecked()) {
            Tong = Tong + 34000;
        }
        tv.setText(Tong + "");
    }
}