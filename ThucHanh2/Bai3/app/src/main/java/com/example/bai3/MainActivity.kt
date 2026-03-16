package com.example.bai3

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var edtSo1: EditText
    private lateinit var edtSo2: EditText
    private lateinit var btnCong: Button
    private lateinit var btnTru: Button
    private lateinit var btnNhan: Button
    private lateinit var btnChia: Button
    private lateinit var tvKetQua: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Ánh xạ view
        edtSo1 = findViewById(R.id.edtSo1)
        edtSo2 = findViewById(R.id.edtSo2)
        btnCong = findViewById(R.id.btnCong)
        btnTru = findViewById(R.id.btnTru)
        btnNhan = findViewById(R.id.btnNhan)
        btnChia = findViewById(R.id.btnChia)
        tvKetQua = findViewById(R.id.tvKetQua)

        btnCong.setOnClickListener { tinhToan("+") }
        btnTru.setOnClickListener { tinhToan("-") }
        btnNhan.setOnClickListener { tinhToan("*") }
        btnChia.setOnClickListener { tinhToan("/") }
    }

    private fun tinhToan(phepToan: String) {

        val so1 = edtSo1.text.toString().toDoubleOrNull()
        val so2 = edtSo2.text.toString().toDoubleOrNull()

        if (so1 == null || so2 == null) {
            tvKetQua.text = "Vui lòng nhập đủ 2 số!"
            return
        }

        val ketQua = when (phepToan) {
            "+" -> so1 + so2
            "-" -> so1 - so2
            "*" -> so1 * so2
            "/" -> {
                if (so2 == 0.0) {
                    tvKetQua.text = "Không thể chia cho 0!"
                    return
                }
                so1 / so2
            }
            else -> 0.0
        }

        tvKetQua.text = "Kết quả: $ketQua"
    }
}