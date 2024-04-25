package com.kzdev.jokenpo;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        setupListeners();
    }

    public void setupListeners() {

        // O primeiro é o exemplo de uma forma mais passo a passo de como fazer o setOnClickListener
        View ivStone = findViewById(R.id.bt_stone);
        ivStone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectChoice("stone");
            }
        });

        // Agora neste exemplo é uma forma mais avançada usando expressões lambda para simplificar "->"
        findViewById(R.id.bt_paper).setOnClickListener(v -> selectChoice("paper"));

        findViewById(R.id.bt_scissor).setOnClickListener(v -> selectChoice("scissor"));

    }

    public void selectChoice(String selectChoice) {

        ImageView imageView = findViewById(R.id.iv_app_choice);

        TextView textResult = findViewById(R.id.tv_result);

        int number = new Random().nextInt(3);

        String[] options = {"stone", "paper", "scissor"};

        String optionsApp = options[number];

        switch (optionsApp) {

            case "stone":
                imageView.setImageResource(R.drawable.pedra);
                break;

            case "paper":
                imageView.setImageResource(R.drawable.papel);
                break;

            case "scissor":
                imageView.setImageResource(R.drawable.tesoura);
                break;

        }

        if (
            // app ganha
                (optionsApp == "scissor" && selectChoice == "paper") ||
                        (optionsApp == "paper" && selectChoice == "stone") ||
                        (optionsApp == "stone" && selectChoice == "scissor")
        ) {
            textResult.setText(R.string.you_lose);

        } else if (
            // usuario ganha
                (selectChoice == "scissor" && optionsApp == "paper") ||
                        (selectChoice == "paper" && optionsApp == "stone") ||
                        (selectChoice == "stone" && optionsApp == "scissor")
        ) {
            textResult.setText(R.string.you_win);

        } else {
            textResult.setText(R.string.we_have_draw);
        }
    }
}