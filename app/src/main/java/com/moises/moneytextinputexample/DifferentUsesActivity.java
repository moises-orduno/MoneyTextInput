package com.moises.moneytextinputexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.moises.moneytextinput.Constants;
import com.moises.moneytextinput.textInput.MoneyTextInput;
import com.moises.moneytextinput.textView.MoneyTextView;

public class DifferentUsesActivity extends AppCompatActivity {

    MoneyTextInput moneyTextInput1;
    MoneyTextInput moneyTextInput2;
    MoneyTextInput moneyTextInput3;
    MoneyTextInput moneyTextInput4;
    MoneyTextView moneyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_different_uses);

        moneyTextInput1=(MoneyTextInput)findViewById(R.id.moneyTextInput1);
        moneyTextInput2=(MoneyTextInput)findViewById(R.id.moneyTextInput2);
        moneyTextInput3=(MoneyTextInput)findViewById(R.id.moneyTextInput3);
        moneyTextInput4=(MoneyTextInput)findViewById(R.id.moneyTextInput4);
        moneyTextView = (MoneyTextView)findViewById(R.id.moneyTextView);

        //edit text

        moneyTextInput1.setSideTextNoSymbol("Money ");

        moneyTextInput2.setSideTextAndSymbol("Mexico ", Constants.EURO);

        moneyTextInput3.setSymbol(Constants.POUND);

        moneyTextInput4.setNoSymbol();

        //textviews

        moneyTextView.setSymbol(Constants.EURO);

        moneyTextView.setText(345.2f);
    }
}
