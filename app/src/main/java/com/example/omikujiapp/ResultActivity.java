package com.example.omikujiapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActivity extends AppCompatActivity {

    private static final String KEY_OMIKUJI_NUMBER = "Key_omikuji_number";

    private static final int ERROR_CODE = -1;

    public static Intent newIntent(Context context, int number) {
        Intent intent = new Intent(context, ResultActivity.class);
        intent.putExtra(KEY_OMIKUJI_NUMBER, number);
        return intent;
    }

    private ImageView omikujiImageView;
    private TextView omikujiTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        omikujiTextView = findViewById(R.id.result_title);
        omikujiImageView = findViewById(R.id.result_image);

        int number = getIntent().getIntExtra(KEY_OMIKUJI_NUMBER, ERROR_CODE);

        int imageResId = -1;
        switch (number) {
            case 0: // 大吉
                imageResId = R.drawable.middle_blessing;
                break;
            case 1: // 中吉
                imageResId = R.drawable.great_blessing;
                break;
            case 2: // 小吉
                imageResId = R.drawable.small_blessing;
                break;
            case 3: // 吉
                imageResId = R.drawable.blessing;
                break;
            case 4: // 末吉
                imageResId = R.drawable.uncertain_luck;
                break;
            case 5: // 凶
                imageResId = R.drawable.curse;
                break;
            case 6: // 大凶
                imageResId = R.drawable.great_curse;
                break;
            default:
                throw new RuntimeException("error: number is not found.");
        }
        omikujiImageView.setImageResource(imageResId);
    }
}