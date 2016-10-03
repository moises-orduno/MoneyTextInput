package com.moises.moneytextinput.textView;

import android.content.Context;
import android.support.annotation.StringDef;
import android.util.AttributeSet;
import android.widget.TextView;

import com.moises.moneytextinput.Constants;
import com.moises.moneytextinput.R;

import java.util.Locale;

/**
 * Created by moisesordunogomez on 29/09/16.
 */

public class MoneyTextView extends TextView{
    public MoneyTextView(Context context) {
        super(context);
    }

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

    private String formateToMoney(float balance ){
        String formattedBalance=(String.format(new Locale("en", "US"),"%,f", balance));
        return formattedBalance.substring(0, formattedBalance.indexOf(".")+3);
    }

    private String formateToMoney(double balance ){
        String formattedBalance=(String.format(new Locale("en", "US"),"%,f", balance));
        return "$"+formattedBalance.substring(0, formattedBalance.indexOf(".")+3);
    }
    public  String inicial = this.getContext().getString(R.string.currency_dollar)+this.getContext().getString(R.string.tag_init_amount);

    private String currencySymbol =this.getContext().getString(R.string.currency_dollar);


    public MoneyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public String bringCleanAmount(){
        String amount=this.getText().toString();
        for(int i=0;i<currencySymbol.length();i++){
            String sToRemove="";
            sToRemove+=  currencySymbol.charAt(i);
            amount=amount.replaceAll(sToRemove,".");
        }
        amount=amount.replaceAll("[,.+]", "");
        return amount;

    }

    public String bringCleanAmountWithCents(){
        String amount=this.getText().toString();
        for(int i=0;i<currencySymbol.length();i++){
            String sToRemove="";
            sToRemove+=  currencySymbol.charAt(i);
            amount=amount.replaceAll(sToRemove,",");
        }
        amount=amount.replaceAll("[,+]", "");
        return amount;

    }

    //check if the amount is zero
    public boolean isValueEmpty(){
        String amount=this.getText().toString();
        for(int i=0;i<currencySymbol.length();i++){
            String sToRemove="";
            sToRemove+=  currencySymbol.charAt(i);
            amount=amount.replaceAll(sToRemove,".");
        }
        amount=amount.replaceAll("[,.+]", "");
        float floatAmount = Float.parseFloat(amount);
        return floatAmount==0;

    }



    public void setSymbol(@currencySymbols String symbol){

        switch (symbol){
            case Constants.DOLLAR:
                this.setText(this.getContext().getString(R.string.currency_dollar)+this.getContext().getString(R.string.tag_init_amount));
                currencySymbol=this.getContext().getString(R.string.currency_dollar);
                break;
            case Constants.YEN:
                this.setText(this.getContext().getString(R.string.currency_yen)+this.getContext().getString(R.string.tag_init_amount));
                currencySymbol=this.getContext().getString(R.string.currency_yen);
                break;
            case Constants.EURO:
                this.setText(this.getContext().getString(R.string.currency_euro)+this.getContext().getString(R.string.tag_init_amount));
                currencySymbol=this.getContext().getString(R.string.currency_euro);
                break;
            case Constants.WON:
                this.setText(this.getContext().getString(R.string.currency_won)+this.getContext().getString(R.string.tag_init_amount));
                currencySymbol=this.getContext().getString(R.string.currency_won);
                break;
            case Constants.REAL:
                this.setText(this.getContext().getString(R.string.currency_real)+this.getContext().getString(R.string.tag_init_amount));
                currencySymbol=this.getContext().getString(R.string.currency_real);
                break;
            case Constants.POUND:
                this.setText(this.getContext().getString(R.string.currency_pound)+this.getContext().getString(R.string.tag_init_amount));
                currencySymbol=this.getContext().getString(R.string.currency_pound);
                break;
            case Constants.RIYAL:
                this.setText(this.getContext().getString(R.string.currency_riyal)+this.getContext().getString(R.string.tag_init_amount));
                currencySymbol=this.getContext().getString(R.string.currency_riyal);
                break;
            default:
                this.setText(this.getContext().getString(R.string.currency_dollar)+this.getContext().getString(R.string.tag_init_amount));
                currencySymbol=this.getContext().getString(R.string.currency_dollar);
                break;
        }

    }

    public void setSideTextAndSymbol(String sideText,@currencySymbols String symbol){
        String symbolAndSideText;
        switch (symbol){
            case Constants.DOLLAR:
                symbolAndSideText=sideText+this.getContext().getString(R.string.currency_dollar);
                this.setText(symbolAndSideText+this.getContext().getString(R.string.tag_init_amount));
                currencySymbol=symbolAndSideText;
                break;
            case Constants.YEN:
                this.setText(this.getContext().getString(R.string.currency_yen)+this.getContext().getString(R.string.tag_init_amount));
                currencySymbol=this.getContext().getString(R.string.currency_yen);
                break;
            case Constants.EURO:
                this.setText(this.getContext().getString(R.string.currency_euro)+this.getContext().getString(R.string.tag_init_amount));
                currencySymbol=this.getContext().getString(R.string.currency_euro);
                break;
            case Constants.WON:
                this.setText(this.getContext().getString(R.string.currency_won)+this.getContext().getString(R.string.tag_init_amount));
                currencySymbol=this.getContext().getString(R.string.currency_won);
                break;
            case Constants.REAL:
                this.setText(this.getContext().getString(R.string.currency_real)+this.getContext().getString(R.string.tag_init_amount));
                currencySymbol=this.getContext().getString(R.string.currency_real);
                break;
            case Constants.POUND:
                this.setText(this.getContext().getString(R.string.currency_pound)+this.getContext().getString(R.string.tag_init_amount));
                currencySymbol=this.getContext().getString(R.string.currency_pound);
                break;
            case Constants.RIYAL:
                this.setText(this.getContext().getString(R.string.currency_riyal)+this.getContext().getString(R.string.tag_init_amount));
                currencySymbol=this.getContext().getString(R.string.currency_riyal);
                break;
            default:
                this.setText(this.getContext().getString(R.string.currency_dollar)+this.getContext().getString(R.string.tag_init_amount));
                currencySymbol=this.getContext().getString(R.string.currency_dollar);
                break;
        }

    }

    public void setSideTextNoSymbol(String sideText){

        this.setText(sideText+this.getContext().getString(R.string.tag_init_amount));
        currencySymbol=sideText;
    }

    public void setNoSymbol(){
        this.setText(""+this.getContext().getString(R.string.tag_init_amount));
        currencySymbol="";
    }

    public void setText(float text){
        this.setText(currencySymbol+formateToMoney(text));
    }

    public void setText(double text){
        this.setText(currencySymbol+formateToMoney(text));
    }


}
