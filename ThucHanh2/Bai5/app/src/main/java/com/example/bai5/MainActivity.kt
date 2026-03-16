package com.example.bai5

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var cbCoffee: CheckBox
    private lateinit var cbKem: CheckBox
    private lateinit var cbBim: CheckBox
    private lateinit var cbSuaChua: CheckBox
    private lateinit var cbNepCam: CheckBox

    private lateinit var edtCoffee: EditText
    private lateinit var edtKem: EditText
    private lateinit var edtBim: EditText
    private lateinit var edtSuaChua: EditText
    private lateinit var edtNepCam: EditText

    private lateinit var tvTongTien: TextView
    private lateinit var btnDatHang: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Ánh xạ CheckBox
        cbCoffee = findViewById(R.id.cbCoffee)
        cbKem = findViewById(R.id.cbKem)
        cbBim = findViewById(R.id.cbBim)
        cbSuaChua = findViewById(R.id.cbSuaChua)
        cbNepCam = findViewById(R.id.cbNepCam)

        // Ánh xạ EditText
        edtCoffee = findViewById(R.id.edtCoffee)
        edtKem = findViewById(R.id.edtKem)
        edtBim = findViewById(R.id.edtBim)
        edtSuaChua = findViewById(R.id.edtSuaChua)
        edtNepCam = findViewById(R.id.edtNepCam)

        tvTongTien = findViewById(R.id.tvTongTien)
        btnDatHang = findViewById(R.id.btnDatHang)

        btnDatHang.setOnClickListener {

            var tongTien = 0

            if (cbCoffee.isChecked) {
                val soLuong = edtCoffee.text.toString().toIntOrNull() ?: 0
                tongTien += soLuong * 20000
            }

            if (cbKem.isChecked) {
                val soLuong = edtKem.text.toString().toIntOrNull() ?: 0
                tongTien += soLuong * 10000
            }

            if (cbBim.isChecked) {
                val soLuong = edtBim.text.toString().toIntOrNull() ?: 0
                tongTien += soLuong * 5000
            }

            if (cbSuaChua.isChecked) {
                val soLuong = edtSuaChua.text.toString().toIntOrNull() ?: 0
                tongTien += soLuong * 6000
            }

            if (cbNepCam.isChecked) {
                val soLuong = edtNepCam.text.toString().toIntOrNull() ?: 0
                tongTien += soLuong * 12000
            }

            tvTongTien.text = "Tổng tiền: $tongTien VND"
        }
    }
}