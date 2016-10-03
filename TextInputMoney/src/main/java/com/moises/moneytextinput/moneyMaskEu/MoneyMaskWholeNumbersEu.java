package com.moises.moneytextinput.moneyMaskEu;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.Locale;


/**
 * Created by moisesordunogomez on 18/08/16.
 */
public class MoneyMaskWholeNumbersEu implements TextWatcher {

    private String currencySymbol = "$";
    private EditText editText;
    public MoneyMaskWholeNumbersEu(EditText editText) {
        this.editText=editText;
    }
    private int maxAmount=1000000;

    public void setCurrencySymbol(String currencySymbol){
        this.currencySymbol = currencySymbol;
    }

    public void setMaxAmount(int maxAmount){
        this.maxAmount = maxAmount;
    }

    private String formateToMoney(float balance){

        //if the amount is more than a million it gets divided to make it smaller
        if(balance>maxAmount)balance/=10;
        balance= (float) Math.floor(balance);

        //have to pick the US format, which is dots separate decimals and commas thousands
        String formattedBalance=currencySymbol+(String.format(new Locale("en", "US"),"%,f", balance));

        return formattedBalance.substring(0, formattedBalance.indexOf(".") + 3);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }


    @Override
    public void afterTextChanged(Editable editable) {

        if (editText == null) return;
        String s = editable.toString();

        try {

            String formatted;

            editText.removeTextChangedListener(this);
            //remove all the unwated chars
            String cleanString=s.toString().replaceAll("/", ".");
            cleanString=cleanString.replaceAll("N",".");
            for(int i = 0; i< currencySymbol.length(); i++){
                String sToRemove="";
                sToRemove+=  currencySymbol.charAt(i);
                cleanString=cleanString.replace(sToRemove,".");
            }
            cleanString = cleanString.replaceAll("[#$,.*;\\(\\)\\s+]", "");

            //if the string is smaller than 3 chars, it means it is zero
            if (cleanString.length() < 3) {

                cleanString = "000";
            }
            //if not the user inputs an amount instead of erasing it will have two zeroes together, so the zeroes in between
            //have to be removed
            if (cleanString.charAt(cleanString.length() - 3) == '0' && cleanString.charAt(cleanString.length() - 2) == '0')
                formatted = formateToMoney(Float.parseFloat(cleanString.substring(0, cleanString.length() - 3) + cleanString.charAt(cleanString.length() - 1)));
                //on the contrary if the user erases, just one zero has to be removed
            else
                formatted = formateToMoney(Float.parseFloat(cleanString.substring(0, cleanString.length() - 2)));

            editText.setText(formatted);
            editText.setSelection(formatted.length(),formatted.length());
            editText.addTextChangedListener(this);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
