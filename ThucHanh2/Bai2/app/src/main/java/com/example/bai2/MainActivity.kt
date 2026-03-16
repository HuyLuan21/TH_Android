package com.example.bai2
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun onclickTong(v: View?) {
        //Khai báo các biến điều khiển tương ứng
        val height = findViewById<EditText>(R.id.height)
            .text.toString().toFloatOrNull()
        val weight = findViewById<EditText>(R.id.weight).text.toString().toFloatOrNull()


        if(height!= null && weight !=null){
            var BMI = weight/(height*height)
            val result: TextView = findViewById(R.id.Result)
            when (BMI) {
                in 0.0..18.49 -> result.text = "Chỉ số BMI của bạn là $BMI đang ở mức Bạn quá gầy"
                in 18.5..24.9 -> result.text = "Chỉ số BMI của bạn là $BMI đang ở mức Bình thường"
                in 25.0..29.9 -> result.text = "Chỉ số BMI của bạn là $BMI đang ở mức Tiền béo phì"
                in 30.0..34.9 -> result.text = "Chỉ số BMI của bạn là $BMI đang ở mức Béo phì độ I"
                in 35.0..39.9 -> result.text = "Chỉ số BMI của bạn là $BMI đang ở mức Béo phì độ II"
                else -> result.text = "Chỉ số BMI của bạn là $BMI đang ở mức Béo phì độ III"
            }
        }
    }
}