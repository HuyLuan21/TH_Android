package com.example.bai4

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var cbCoffee: CheckBox
    private lateinit var cbKem: CheckBox
    private lateinit var cbBim: CheckBox
    private lateinit var cbSuaChua: CheckBox
    private lateinit var cbNepCam: CheckBox
    private lateinit var tvTongTien: TextView
    private lateinit var btnDatHang: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Ánh xạ view (phải đúng id trong XML của bạn)
        cbCoffee = findViewById(R.id.cbCoffee)
        cbKem = findViewById(R.id.cbKem)
        cbBim = findViewById(R.id.cbBim)
        cbSuaChua = findViewById(R.id.cbSuaChua)
        cbNepCam = findViewById(R.id.cbNepCam)
        tvTongTien = findViewById(R.id.tvTongTien)
        btnDatHang = findViewById(R.id.btnDatHang)

        btnDatHang.setOnClickListener {
            var tongTien = 0

            if (cbCoffee.isChecked) tongTien += 20000
            if (cbKem.isChecked) tongTien += 10000
            if (cbBim.isChecked) tongTien += 5000
            if (cbSuaChua.isChecked) tongTien += 6000
            if (cbNepCam.isChecked) tongTien += 12000

            tvTongTien.text = "Tổng tiền: $tongTien VND"
        }
    }
}