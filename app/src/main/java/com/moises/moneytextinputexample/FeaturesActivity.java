package com.moises.moneytextinputexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import com.moises.moneytextinput.Constants;
import com.moises.moneytextinput.textInput.MoneyTextInput;

public class FeaturesActivity extends AppCompatActivity {

    MoneyTextInput moneyTextInput;
    TextView textViewCleanNocents;
    TextView textViewClean;
    TextView textViewIsEmpty;
    RadioGroup radioGroupMaxAmount;
    RadioGroup radioGroupSetState;
    public void showResults(View view){

        textViewIsEmpty.setText("Is Empty : "+moneyTextInput.isValueEmpty()+"");
        textViewClean.setText("Clean amount : "+moneyTextInput.bringCleanAmount());
        textViewCleanNocents.setText("Clean no cents : "+moneyTextInput.bringCleanAmountNoCents());


    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_button_100:
                if (checked){
                    ((RadioButton) radioGroupMaxAmount.getChildAt(0)).setChecked(true);
                    ((RadioButton) radioGroupMaxAmount.getChildAt(1)).setChecked(false);
                    ((RadioButton) radioGroupMaxAmount.getChildAt(2)).setChecked(false);
                    moneyTextInput.setMaxAmount(100);

                }
                break;
            case R.id.radio_button_1000:
                if (checked){
                    ((RadioButton) radioGroupMaxAmount.getChildAt(0)).setChecked(false);
                    ((RadioButton) radioGroupMaxAmount.getChildAt(1)).setChecked(true);
                    ((RadioButton) radioGroupMaxAmount.getChildAt(2)).setChecked(false);
                    moneyTextInput.setMaxAmount(1000);
                }
                break;
            case R.id.radio_button_10000:
                if (checked){
                    ((RadioButton) radioGroupMaxAmount.getChildAt(0)).setChecked(false);
                    ((RadioButton) radioGroupMaxAmount.getChildAt(1)).setChecked(false);
                    ((RadioButton) radioGroupMaxAmount.getChildAt(2)).setChecked(true);
                    moneyTextInput.setMaxAmount(10000);
                }
                break;
        }
        moneyTextInput.reset();
    }

    public void onRadioButtonClickedSetState(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_button_decimal:
                if (checked){
                    ((RadioButton) radioGroupSetState.getChildAt(0)).setChecked(true);
                    ((RadioButton) radioGroupSetState.getChildAt(1)).setChecked(false);
                    ((RadioButton) radioGroupSetState.getChildAt(2)).setChecked(false);
                    moneyTextInput.setState(Constants.DECIMAL);

                }
                break;
            case R.id.radio_button_whole:
                if (checked){
                    ((RadioButton) radioGroupSetState.getChildAt(0)).setChecked(false);
                    ((RadioButton) radioGroupSetState.getChildAt(1)).setChecked(true);
                    ((RadioButton) radioGroupSetState.getChildAt(2)).setChecked(false);
                    moneyTextInput.setState(Constants.WHOLE);
                }
                break;
            case R.id.radio_button_whole_no_cents:
                if (checked){
                    ((RadioButton) radioGroupSetState.getChildAt(0)).setChecked(false);
                    ((RadioButton) radioGroupSetState.getChildAt(1)).setChecked(false);
                    ((RadioButton) radioGroupSetState.getChildAt(2)).setChecked(true);
                    moneyTextInput.setState(Constants.WHOLE_NO_CENTS);
                }
                break;
        }
        moneyTextInput.reset();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_features);

        moneyTextInput=(MoneyTextInput)findViewById(R.id.money_text_input);
        textViewCleanNocents=(TextView)findViewById(R.id.text_view_clean_no_cents);
        textViewClean=(TextView)findViewById(R.id.text_view_clean);
        textViewIsEmpty=(TextView)findViewById(R.id.text_view_is_empty);


        radioGroupMaxAmount=(RadioGroup)findViewById(R.id.radio_group_max_amount);
        radioGroupSetState=(RadioGroup)findViewById(R.id.radio_group_set_state);


    }
}
