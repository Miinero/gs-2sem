package com.fiap.gs2sem.watchers;

import android.text.Editable;
import android.text.TextWatcher;

public class CPFInputWatcher implements TextWatcher {

    private int wordSize;

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        wordSize = s.length();
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    @Override
    public void afterTextChanged(Editable s) {
        int newWordLength = s.length();

        if (newWordLength < wordSize) return;

        // 123.456.789-00
        if (newWordLength == 3 || newWordLength == 7) s.append(".");
        else if (newWordLength == 11) s.append("-");
    }
}
