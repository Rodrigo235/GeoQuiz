package com.example.clientepg.geoquiz.Controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.clientepg.geoquiz.R;

import Model.Question;

public class QuizActivity extends AppCompatActivity {

    private Button botaoVerdade;
    private Button botaoFalso;

    private TextView textoDaQuestao;
    private Question[] arrayDeQuestoes;
    private int indiceAtual = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        botaoVerdade = (Button) findViewById(R.id.botao_verdadeiro);
        botaoFalso = (Button) findViewById(R.id.botao_falso);

        arrayDeQuestoes = new Question[]{
                new Question(R.string.questao1, true),
                new Question(R.string.questao2, true),
                new Question(R.string.questao3, false),
        };

        botaoVerdade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checarResposta(true);
            }
        });

        botaoFalso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checarResposta(false);
            }
        });

        textoDaQuestao = (TextView) findViewById(R.id.question_text);
        updateQuestion();

    }

    private void updateQuestion() {
        indiceAtual = (indiceAtual + 1) % arrayDeQuestoes.length;
        int question = arrayDeQuestoes[indiceAtual].getIdPergunta();
        textoDaQuestao.setText(question);
    }

    private void checarResposta(boolean respostaDoUsuario) {
        if(respostaDoUsuario == arrayDeQuestoes[indiceAtual].isRespostaCorreta()){
            Toast.makeText(QuizActivity.this, R.string.correct_toast, Toast.LENGTH_SHORT).show();
            updateQuestion();
        } else {
            Toast.makeText(QuizActivity.this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
        }
    }

}
