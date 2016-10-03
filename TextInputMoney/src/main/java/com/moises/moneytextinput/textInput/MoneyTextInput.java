package com.moises.moneytextinput.textInput;

import android.content.Context;
import android.support.annotation.StringDef;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.EditText;

import com.moises.moneytextinput.Constants;
import com.moises.moneytextinput.R;
import com.moises.moneytextinput.moneyMaskEu.MoneyMaskDecimalNumbersEu;
import com.moises.moneytextinput.moneyMaskUs.MoneyMaskDecimalNumbers;
import com.moises.moneytextinput.moneyMaskUs.MoneyMaskWholeNoCentsNumbers;
import com.moises.moneytextinput.moneyMaskUs.MoneyMaskWholeNumbers;

/**
 * Created by moisesordunogomez on 26/09/16.
 */

public class MoneyTextInput extends EditText{

    public  String inicial = this.getContext().getString(R.string.currency_dollar)+this.getContext().getString(R.string.tag_init_amount);




    //  private String currencySymbol =this.getContext().getString(R.string.currency_dollar);
    private String currencySymbol =this.getContext().getString(R.string.currency_dollar);

    //states, a MoneyMaskDecimalNumbers, b MoneyMaskWholeNumbers, c MoneyMaskWholeNoCentsNumbers
    private String state=Constants.DECIMAL;
    public MoneyTextInput(Context context) {
        super(context);
    }

    private MoneyMaskDecimalNumbers moneyMaskDecimalNumbers;
    private MoneyMaskWholeNumbers moneyMaskWholeNumbers;
    private MoneyMaskWholeNoCentsNumbers moneyMaskWholeNoCentsNumbers;

    @StringDef({
            Constants.DOLLAR,
            Constants.YEN,
            Constants.EURO,
            Constants.WON,
            Constants.REAL,
            Constants.POUND,
            Constants.RIYAL
    })
    private @interface currencySymbols {}

    @StringDef({
            Constants.DECIMAL,
            Constants.WHOLE,
            Constants.WHOLE_NO_CENTS
    })
    private @interface states {}

    public void setMaxAmount(int maxAmount){
        switch (state){
            case Constants.DECIMAL:
                moneyMaskDecimalNumbers.setMaxAmount(maxAmount);
                break;
            case Constants.WHOLE:
                moneyMaskWholeNumbers.setMaxAmount(maxAmount);
                break;
            case Constants.WHOLE_NO_CENTS:
                moneyMaskWholeNoCentsNumbers.setMaxAmount(maxAmount);
                break;
        }

    }

    public MoneyTextInput(Context context, AttributeSet attrs) {
        super(context, attrs);

        this.setGravity(Gravity.RIGHT | Gravity.CENTER_VERTICAL );
        this.setInputType(InputType.TYPE_CLASS_NUMBER);
        this.setText(inicial);
       // this.setText(this.getContext().getString(R.string.currency_dollar)+this.getContext().getString(R.string.tag_init_amount_no_zeroes));
        this.setSelection(this.getText().length(), this.getText().length());

        moneyMaskDecimalNumbers =new MoneyMaskDecimalNumbers(this);
        moneyMaskWholeNumbers =new MoneyMaskWholeNumbers(this);
        moneyMaskWholeNoCentsNumbers = new MoneyMaskWholeNoCentsNumbers(this);
      //  this.addTextChangedListener(moneyMaskWholeNoCentsNumbers);
        this.addTextChangedListener(moneyMaskDecimalNumbers);

    }

    public String bringCleanAmountNoCents(){
        String amount=this.getText().toString();
        if(state.equals(Constants.WHOLE_NO_CENTS))amount+="00";
        for(int i=0;i<currencySymbol.length();i++){
            String sToRemove="";
            sToRemove+=  currencySymbol.charAt(i);
            amount=amount.replace(sToRemove,".");
        }
        amount=amount.replaceAll("[,.+]", "");
        return amount.substring(0,amount.length()-2);

    }

    public String bringCleanAmount(){
        String amount=this.getText().toString();
        if(state.equals(Constants.WHOLE_NO_CENTS))amount+="00";
        for(int i=0;i<currencySymbol.length();i++){
            String sToRemove="";
            sToRemove+=  currencySymbol.charAt(i);
            amount=amount.replace(sToRemove,",");
        }
        amount=amount.replaceAll("[,+]", "");
        return amount;

    }

    //check if the amount is zero
    public boolean isValueEmpty(){
        String amount=this.getText().toString();
        if(state.equals(Constants.WHOLE_NO_CENTS))amount+="00";
        for(int i=0;i<currencySymbol.length();i++){
            String sToRemove="";
            sToRemove+=  currencySymbol.charAt(i);
            amount=amount.replace(sToRemove,",");
        }
        amount=amount.replaceAll("[,.+]", "");
        float floatAmount = Float.parseFloat(amount);
        return floatAmount==0;

    }



    public void setSymbol(@currencySymbols String symbol){

        switch (symbol){
            case Constants.DOLLAR:

                switch (state){
                    case Constants.DECIMAL:
                        moneyMaskDecimalNumbers.setCurrencySymbol(this.getContext().getString(R.string.currency_dollar));
                        break;
                    case Constants.WHOLE:
                        moneyMaskWholeNumbers.setCurrencySymbol(this.getContext().getString(R.string.currency_dollar));
                        break;
                    case Constants.WHOLE_NO_CENTS:
                        moneyMaskWholeNoCentsNumbers.setCurrencySymbol(this.getContext().getString(R.string.currency_dollar));
                        break;
                }

                this.setText(this.getContext().getString(R.string.currency_dollar)+this.getContext().getString(R.string.tag_init_amount));
                this.setSelection(this.getText().length(), this.getText().length());
                currencySymbol=this.getContext().getString(R.string.currency_dollar);
                break;
            case Constants.YEN:
                switch (state){
                    case Constants.DECIMAL:
                        moneyMaskDecimalNumbers.setCurrencySymbol(this.getContext().getString(R.string.currency_yen));
                        break;
                    case Constants.WHOLE:
                        moneyMaskWholeNumbers.setCurrencySymbol(this.getContext().getString(R.string.currency_yen));
                        break;
                    case Constants.WHOLE_NO_CENTS:
                        moneyMaskWholeNoCentsNumbers.setCurrencySymbol(this.getContext().getString(R.string.currency_yen));
                        break;
                }

                this.setText(this.getContext().getString(R.string.currency_yen)+this.getContext().getString(R.string.tag_init_amount));
                this.setSelection(this.getText().length(), this.getText().length());
                currencySymbol=this.getContext().getString(R.string.currency_yen);
                break;
            case Constants.EURO:
                switch (state){
                    case Constants.DECIMAL:
                        moneyMaskDecimalNumbers.setCurrencySymbol(this.getContext().getString(R.string.currency_euro));
                        break;
                    case Constants.WHOLE:
                        moneyMaskWholeNumbers.setCurrencySymbol(this.getContext().getString(R.string.currency_euro));
                        break;
                    case Constants.WHOLE_NO_CENTS:
                        moneyMaskWholeNoCentsNumbers.setCurrencySymbol(this.getContext().getString(R.string.currency_euro));
                        break;
                }

                this.setText(this.getContext().getString(R.string.currency_euro) + this.getContext().getString(R.string.tag_init_amount));
                this.setSelection(this.getText().length(), this.getText().length());
                currencySymbol = this.getContext().getString(R.string.currency_euro);
                break;
            case Constants.WON:
                switch (state){
                    case Constants.DECIMAL:
                        moneyMaskDecimalNumbers.setCurrencySymbol(this.getContext().getString(R.string.currency_won));
                        break;
                    case Constants.WHOLE:
                        moneyMaskWholeNumbers.setCurrencySymbol(this.getContext().getString(R.string.currency_won));
                        break;
                    case Constants.WHOLE_NO_CENTS:
                        moneyMaskWholeNoCentsNumbers.setCurrencySymbol(this.getContext().getString(R.string.currency_won));
                        break;
                }

                this.setText(this.getContext().getString(R.string.currency_won)+this.getContext().getString(R.string.tag_init_amount));
                this.setSelection(this.getText().length(), this.getText().length());
                currencySymbol=this.getContext().getString(R.string.currency_won);
                break;
            case Constants.REAL:
                switch (state){
                    case Constants.DECIMAL:
                        moneyMaskDecimalNumbers.setCurrencySymbol(this.getContext().getString(R.string.currency_real));
                        break;
                    case Constants.WHOLE:
                        moneyMaskWholeNumbers.setCurrencySymbol(this.getContext().getString(R.string.currency_real));
                        break;
                    case Constants.WHOLE_NO_CENTS:
                        moneyMaskWholeNoCentsNumbers.setCurrencySymbol(this.getContext().getString(R.string.currency_real));
                        break;
                }

                this.setText(this.getContext().getString(R.string.currency_real)+this.getContext().getString(R.string.tag_init_amount));
                this.setSelection(this.getText().length(), this.getText().length());
                currencySymbol=this.getContext().getString(R.string.currency_real);
                break;
            case Constants.POUND:
                switch (state){
                    case Constants.DECIMAL:
                        moneyMaskDecimalNumbers.setCurrencySymbol(this.getContext().getString(R.string.currency_pound));
                        break;
                    case Constants.WHOLE:
                        moneyMaskWholeNumbers.setCurrencySymbol(this.getContext().getString(R.string.currency_pound));
                        break;
                    case Constants.WHOLE_NO_CENTS:
                        moneyMaskWholeNoCentsNumbers.setCurrencySymbol(this.getContext().getString(R.string.currency_pound));

                }

                this.setText(this.getContext().getString(R.string.currency_pound)+this.getContext().getString(R.string.tag_init_amount));
                //          this.setText(this.getContext().getString(R.string.currency_pound));

                this.setSelection(this.getText().length(), this.getText().length());
                currencySymbol=this.getContext().getString(R.string.currency_pound);
                break;
            case Constants.RIYAL:
                switch (state){
                    case Constants.DECIMAL:
                        moneyMaskDecimalNumbers.setCurrencySymbol(this.getContext().getString(R.string.currency_riyal));
                        break;
                    case Constants.WHOLE:
                        moneyMaskWholeNumbers.setCurrencySymbol(this.getContext().getString(R.string.currency_riyal));
                        break;
                    case Constants.WHOLE_NO_CENTS:
                        moneyMaskWholeNoCentsNumbers.setCurrencySymbol(this.getContext().getString(R.string.currency_riyal));

                }

                this.setText(this.getContext().getString(R.string.currency_riyal)+this.getContext().getString(R.string.tag_init_amount));
                this.setSelection(this.getText().length(), this.getText().length());
                currencySymbol=this.getContext().getString(R.string.currency_riyal);
                break;
            default:
                switch (state){
                    case Constants.DECIMAL:
                        moneyMaskDecimalNumbers.setCurrencySymbol(this.getContext().getString(R.string.currency_dollar));
                        break;
                    case Constants.WHOLE:
                        moneyMaskWholeNumbers.setCurrencySymbol(this.getContext().getString(R.string.currency_dollar));
                        break;
                    case Constants.WHOLE_NO_CENTS:
                        moneyMaskWholeNoCentsNumbers.setCurrencySymbol(this.getContext().getString(R.string.currency_dollar));

                }

                this.setText(this.getContext().getString(R.string.currency_dollar)+this.getContext().getString(R.string.tag_init_amount));
                this.setSelection(this.getText().length(), this.getText().length());
                currencySymbol=this.getContext().getString(R.string.currency_dollar);
                break;
        }

    }

    public void setSideTextAndSymbol(String sideText,@currencySymbols String symbol){
        String symbolAndSideText;
        switch (symbol){
            case Constants.DOLLAR:
                symbolAndSideText=sideText+this.getContext().getString(R.string.currency_dollar);
                break;
            case Constants.YEN:
                symbolAndSideText=sideText+this.getContext().getString(R.string.currency_yen);
                break;
            case Constants.EURO:
                symbolAndSideText=sideText+this.getContext().getString(R.string.currency_euro);
                break;
            case Constants.WON:
                symbolAndSideText=sideText+=this.getContext().getString(R.string.currency_won);
                break;
            case Constants.REAL:
                symbolAndSideText=sideText+=this.getContext().getString(R.string.currency_real);
                break;
            case Constants.POUND:
                symbolAndSideText=sideText+=this.getContext().getString(R.string.currency_pound);
                break;
            case Constants.RIYAL:
                symbolAndSideText=sideText+=this.getContext().getString(R.string.currency_riyal);
                break;
            default:
                symbolAndSideText=sideText+=this.getContext().getString(R.string.currency_dollar);
                break;
        }
        switch (state){
            case Constants.DECIMAL:
                moneyMaskDecimalNumbers.setCurrencySymbol(symbolAndSideText);
                break;
            case Constants.WHOLE:
                moneyMaskWholeNumbers.setCurrencySymbol(symbolAndSideText);
                break;
            case Constants.WHOLE_NO_CENTS:
                moneyMaskWholeNoCentsNumbers.setCurrencySymbol(symbolAndSideText);

        }

        this.setText(symbolAndSideText+this.getContext().getString(R.string.tag_init_amount));
        this.setSelection(this.getText().length(), this.getText().length());
        currencySymbol=symbolAndSideText;

    }

    public void setSideTextNoSymbol(String sideText){

        switch (state){
            case Constants.DECIMAL:
                moneyMaskDecimalNumbers.setCurrencySymbol(sideText);
                break;
            case Constants.WHOLE:
                moneyMaskWholeNumbers.setCurrencySymbol(sideText);
                break;
            case Constants.WHOLE_NO_CENTS:
                moneyMaskWholeNoCentsNumbers.setCurrencySymbol(sideText);
                break;
        }
        this.setText(sideText+this.getContext().getString(R.string.tag_init_amount));
        this.setSelection(this.getText().length(), this.getText().length());
        currencySymbol=sideText;
    }


    public void setNoSymbol(){

        switch (state){
            case Constants.DECIMAL:
                moneyMaskDecimalNumbers.setCurrencySymbol("");
                break;
            case Constants.WHOLE:
                moneyMaskWholeNumbers.setCurrencySymbol("");
                break;
            case Constants.WHOLE_NO_CENTS:
                moneyMaskWholeNoCentsNumbers.setCurrencySymbol("");
                break;
        }
        this.setText(""+this.getContext().getString(R.string.tag_init_amount));
        this.setSelection(this.getText().length(), this.getText().length());
        currencySymbol="";
    }

    public void setState(@states String newState){
        switch (newState){
            case Constants.DECIMAL:
                if(state.equals(Constants.WHOLE))this.removeTextChangedListener(moneyMaskWholeNumbers);
                if(state.equals(Constants.WHOLE_NO_CENTS))this.removeTextChangedListener(moneyMaskWholeNoCentsNumbers);
                this.addTextChangedListener(moneyMaskDecimalNumbers);
                state=Constants.DECIMAL;
                break;
            case Constants.WHOLE:
                if(state.equals(Constants.WHOLE))this.removeTextChangedListener(moneyMaskWholeNumbers);
                if(state.equals(Constants.WHOLE_NO_CENTS))this.removeTextChangedListener(moneyMaskWholeNoCentsNumbers);
                this.addTextChangedListener(moneyMaskWholeNumbers);
                state=Constants.WHOLE;
                break;
            case Constants.WHOLE_NO_CENTS:
                if(state.equals(Constants.DECIMAL))this.removeTextChangedListener(moneyMaskDecimalNumbers);
                if(state.equals(Constants.WHOLE))this.removeTextChangedListener(moneyMaskWholeNumbers);

                this.setText(this.getContext().getString(R.string.currency_dollar)+this.getContext().getString(R.string.tag_init_amount_no_zeroes));
                this.setSelection(this.getText().length(), this.getText().length());
                this.addTextChangedListener(moneyMaskWholeNoCentsNumbers);
                state=Constants.WHOLE_NO_CENTS;
                break;
            default:
                if(state.equals(Constants.WHOLE))this.removeTextChangedListener(moneyMaskWholeNumbers);
                if(state.equals(Constants.WHOLE_NO_CENTS))this.removeTextChangedListener(moneyMaskWholeNoCentsNumbers);
                this.addTextChangedListener(moneyMaskDecimalNumbers);
                state=Constants.DECIMAL;
                break;
        }
    }

    public void reset(){
        this.setText(currencySymbol+this.getContext().getString(R.string.tag_init_amount));
        this.setSelection(this.getText().length(), this.getText().length());



    }
//    https://msdn.microsoft.com/en-us/library/ee825488(v=cs.20).aspx

}
