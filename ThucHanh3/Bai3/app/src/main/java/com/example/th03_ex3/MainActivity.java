package com.example.th03_ex3;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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

        CheckBox cbWorker = findViewById(R.id.cbWorker);
        CheckBox cbFarmer = findViewById(R.id.cbFarmer);
        CheckBox cbTeacher = findViewById(R.id.cbTeacher);

        RadioGroup oldRadioGroup = findViewById(R.id.oldRadioGroup);
        RadioGroup sexRadioGroup = findViewById(R.id.sexRadioGroup);
        RadioGroup doingRadioGroup = findViewById(R.id.doingRadioGroup);

        Button buttonCheck = findViewById(R.id.buttonCheck);
        TextView totalPoint = findViewById(R.id.totalPoint);

        buttonCheck.setOnClickListener(v -> {
            int total = 0;
            if (cbTeacher.isChecked()) {
                total += 10;
            }
            int selectedOld = oldRadioGroup.getCheckedRadioButtonId();
            if (selectedOld == R.id.rb24) {
                total += 10;
            }
            int selectedSex = sexRadioGroup.getCheckedRadioButtonId();
            if (selectedSex == R.id.rbMale) {
                total += 10;
            }
            int selectedDoing = doingRadioGroup.getCheckedRadioButtonId();
            if (selectedDoing == R.id.rbWorking) {
                total += 10;
            }
            totalPoint.setText(String.valueOf(total));
        });


    }
}