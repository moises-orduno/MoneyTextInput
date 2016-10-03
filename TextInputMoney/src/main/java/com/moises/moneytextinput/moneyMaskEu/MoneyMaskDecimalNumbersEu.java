package com.moises.moneytextinput.moneyMaskEu;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.math.BigDecimal;
import java.util.Locale;


/**
 * Created by moisesordunogomez on 22/09/16.
 */
public class MoneyMaskDecimalNumbersEu implements TextWatcher {

    private String currencySymbol = "$";
    private EditText editText;
    public MoneyMaskDecimalNumbersEu(EditText editText) {
        this.editText = editText;
    }
    private int maxAmount=1000000;

    public void setCurrencySymbol(String currencySymbol){
        this.currencySymbol = currencySymbol;
    }

    public void setMaxAmount(int maxAmount){
        this.maxAmount = maxAmount;
    }

    private String formateToMoney(BigDecimal balance ){

        float floatAmount = Float.parseFloat(balance.toString());
        if(floatAmount>maxAmount)balance=balance.divide(new BigDecimal(10), BigDecimal.ROUND_FLOOR);
        String formattedBalance=currencySymbol+(String.format(new Locale("de", "AT"),"%,f", balance));


        return formattedBalance.substring(0, formattedBalance.indexOf(",") + 3);
    }





    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }



    @Override
    public void afterTextChanged(Editable editable) {
        try {

            if (editText == null) return;
            String s = editable.toString();
            editText.removeTextChangedListener(this);
            String cleanString=s.toString().replaceAll("/", ",");
            cleanString=cleanString.replaceAll("N",",");
            for(int i = 0; i< currencySymbol.length(); i++){
                String sToRemove="";
                sToRemove+=  currencySymbol.charAt(i);
                cleanString=cleanString.replaceAll(sToRemove,",");
            }
            cleanString = cleanString.replaceAll("[#$,.*;\\(\\)\\s+]", "");
            BigDecimal parsed = new BigDecimal(cleanString).setScale(2, BigDecimal.ROUND_FLOOR).divide(new BigDecimal(100), BigDecimal.ROUND_FLOOR);
            String formatted = formateToMoney(parsed);
            editText.setText(formatted);
            editText.setSelection(formatted.length());
            editText.addTextChangedListener(this);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
