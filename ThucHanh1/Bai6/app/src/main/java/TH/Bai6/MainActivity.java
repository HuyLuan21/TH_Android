package TH.Bai6;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    Button submitBtn;
    TextInputEditText heightInput;
    TextInputEditText weightInput;
    TextInputEditText resultInput;
    TextInputEditText danhGia;

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

        initViews();
        listener();
    }

    private void initViews () {
        submitBtn = findViewById(R.id.submitbtn);
        heightInput = findViewById(R.id.height);
        weightInput = findViewById(R.id.weight);
        resultInput = findViewById(R.id.result);
        danhGia = findViewById(R.id.danhgia);
    }

    private void listener() {
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String heightValue = heightInput.getText().toString().trim();
                String weightValue = weightInput.getText().toString().trim();

                float result = (float) (
                        Float.parseFloat(weightValue) /
                                Math.pow(Float.parseFloat(heightValue), 2)
                );

                resultInput.setText(String.valueOf(result));

                if (result < 18.5) {
                    danhGia.setText("Gầy");
                } else if (result >= 18.5 && result < 25) {
                    danhGia.setText("Bình thường");
                } else {
                    danhGia.setText("Béoooooooooooooooooooooo");
                }
            }
        });
    }
}