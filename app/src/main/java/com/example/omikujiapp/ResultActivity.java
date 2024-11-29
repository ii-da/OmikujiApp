package com.example.omikujiapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
    private TextView omikujiMessageTextView;
    private ImageView backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        omikujiTextView = findViewById(R.id.result_title);
        omikujiImageView = findViewById(R.id.result_image);
        omikujiMessageTextView = findViewById(R.id.result_text);
        backButton = findViewById(R.id.back_btn);

        int number = getIntent().getIntExtra(KEY_OMIKUJI_NUMBER, ERROR_CODE);

        int imageResId = -1;
        int stringResId = -1;
        int stringMessageResId = -1;

        switch (number) {
            case 0: // 大吉
                imageResId = R.drawable.middle_blessing;
                stringResId = R.string.great_blessing;
                stringMessageResId = R.string.great_blessing_message;
                break;
            case 1: // 中吉
                imageResId = R.drawable.great_blessing;
                stringResId = R.string.middle_blessing;
                stringMessageResId = R.string.middle_blessing_message;
                break;
            case 2: // 小吉
                imageResId = R.drawable.small_blessing;
                stringResId = R.string.small_blessing;
                stringMessageResId = R.string.small_blessing_message;
                break;
            case 3: // 吉
                imageResId = R.drawable.blessing;
                stringResId = R.string.blessing;
                stringMessageResId = R.string.blessing_message;
                break;
            case 4: // 末吉
                imageResId = R.drawable.uncertain_luck;
                stringResId = R.string.future_blessing;
                stringMessageResId = R.string.future_blessing_message;
                break;
            case 5: // 凶
                imageResId = R.drawable.curse;
                stringResId = R.string.curse;
                stringMessageResId = R.string.curse_message;
                break;
            case 6: // 大凶
                imageResId = R.drawable.great_curse;
                stringResId = R.string.great_curse;
                stringMessageResId = R.string.great_curse_message;
                break;
            default:
                throw new RuntimeException("error: number is not found.");
        }
        omikujiImageView.setImageResource(imageResId);
        omikujiTextView.setText(stringResId);
        omikujiMessageTextView.setText(stringMessageResId);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getOnBackPressedDispatcher().onBackPressed();
            }
        });
    }
}