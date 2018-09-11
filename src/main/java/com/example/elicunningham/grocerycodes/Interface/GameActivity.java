package com.example.elicunningham.grocerycodes.Interface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import com.example.elicunningham.grocerycodes.Application.GameManger;
import com.example.elicunningham.grocerycodes.Model.GroceryCode;
import com.example.elicunningham.grocerycodes.R;

public class GameActivity extends AppCompatActivity {

    private EditText answerField;
    private GameManger manager;
    private GroceryCode currCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        manager = new GameManger();

        setupBoard();

        answerField = findViewById(R.id.editText);

        answerField.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                textEdited();
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            public void onTextChanged(CharSequence s, int start, int count, int after){}
        });
    }

    private void setupBoard(){

        if(manager.hasCodesLeft()) {
            currCode = manager.getNextCode();

            TextView codeNameLabel = findViewById(R.id.textView);

            codeNameLabel.setText(currCode.getName());
        }
    }

    public void textEdited(){
        String answer = answerField.getText().toString();
        if (answer.length() == 4){
            // check if it's the right answer, if not clear the display
            if(answer.equals(currCode.getCode())){
                rightAnswer();
            } else {
                wrongAnswer(answerField);
            }
        }
    }

    private void rightAnswer(){
        //manager.rightAnswer();
        setupBoard();
    }

    private void wrongAnswer(EditText answerField){
        //manager.wrongAnswer();
        answerField.setText("");
    }
}
