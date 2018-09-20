package com.example.elicunningham.grocerycodes.Interface;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import com.example.elicunningham.grocerycodes.Application.GameManager;
import com.example.elicunningham.grocerycodes.Application.GroceryCodesApp;
import com.example.elicunningham.grocerycodes.Model.GroceryCode;
import com.example.elicunningham.grocerycodes.R;

public class GameActivity extends AppCompatActivity {

    private EditText answerField;
    private GameManager manager;
    private GroceryCode currCode;

    /**
     * Creates a GameActivity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // get the gameManager
        GroceryCodesApp app = (GroceryCodesApp) getApplicationContext();
        manager = app.getManager();

        answerField = findViewById(R.id.editText);

        setupBoard();

        // every time there is a change in the answerField, send it to the textEdited() method
        answerField.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                textEdited();
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            public void onTextChanged(CharSequence s, int start, int count, int after){}
        });
    }

    /**
     * Setup the board (main game screen) Get the next grocery code,
     * If the manager has no more codes, return to the main screen
     */
    // TODO make this return to a win screen instead of the main screen
    private void setupBoard(){

        if(manager.hasCodesLeft()) {
            currCode = manager.getNextCode();

            TextView codeNameLabel = findViewById(R.id.textView);

            codeNameLabel.setText(currCode.getName());

            answerField.setText("");
        } else {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }

    /**
     * Whenever the text in the answerField has been edited, this method checks
     * if they have the right answer
     */
    public void textEdited(){
        String answer = answerField.getText().toString();
        // if they haven't input the number of characters in the answer, let them keep typing
        if (answer.length() == currCode.getCode().length()){
            // check if it's the right answer, if not clear the display
            if(answer.equals(currCode.getCode())){
                rightAnswer();
            } else {
                wrongAnswer(answerField);
            }
        }
    }

    private void rightAnswer(){
        manager.rightAnswer();
        setupBoard();
    }

    private void wrongAnswer(EditText answerField){
        manager.wrongAnswer();
        answerField.setText("");
    }
}
