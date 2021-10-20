package com.adeprasetyo.formapps;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class DashboardActivity extends AppCompatActivity {

    private ActivityResultLauncher<Intent> resultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        TextView tvName = (TextView) findViewById(R.id.tvName);
        TextView tvEmail = (TextView) findViewById(R.id.tvEmail);
        TextView tvPhone = (TextView) findViewById(R.id.tvPhone);

        tvName.setText(getIntent().getStringExtra(MainActivity.EXTRA_NAME));
        tvEmail.setText(getIntent().getStringExtra(MainActivity.EXTRA_EMAIL));
        tvPhone.setText(getIntent().getStringExtra(MainActivity.EXTRA_PHONE));

        Button buttonCall = (Button) findViewById(R.id.buttonCall);
        buttonCall.setOnClickListener(v -> {
            String number = "*123#";
            Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+number));
            startActivity(callIntent);
        });

        Button buttonQuiz = (Button) findViewById(R.id.buttonQuiz);
        buttonQuiz.setOnClickListener(v -> {
            Intent quizIntent = new Intent(DashboardActivity.this, QuizActivity.class);
            resultLauncher.launch(quizIntent);
        });

        TextView tvResult = (TextView) findViewById(R.id.tvResult);
        resultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if(result.getResultCode() == QuizActivity.RESULT_CODE && result.getData() != null){
                int answer = result.getData().getIntExtra(QuizActivity.EXTRA_ANSWER,0);
                if(answer == 1)
                    tvResult.setText("Jawaban anda Benar");
                else tvResult.setText("Jawaban anda Salah");
            }
        });

    }
}