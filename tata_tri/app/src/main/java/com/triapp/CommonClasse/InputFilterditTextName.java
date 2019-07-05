package com.triapp.CommonClasse;

import android.text.InputFilter;
import android.text.Spanned;

/**
 * Created by Developer on 9/5/2017.
 */

public class InputFilterditTextName implements InputFilter {
    private String blockCharacterSet = "~#^|$%₹&*!@`:,.?/{}[]|+-_\"\';=<>()";
    private String inputText;

    public InputFilterditTextName(String inputText) {
        this.inputText = inputText;
    }

    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {

        inputText = source.toString();

        if (isValidCharcters(inputText)) {
            return null;
        }
        return "";
    }

    private boolean isValidCharcters(String a) {

        if(a != null && blockCharacterSet.contains(("" + a)) ){
            return false;
        } else {
            return true;
        }
    }


}
