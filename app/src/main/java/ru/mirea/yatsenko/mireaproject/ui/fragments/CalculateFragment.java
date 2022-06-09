package ru.mirea.yatsenko.mireaproject.ui.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import ru.mirea.yatsenko.mireaproject.R;


public class CalculateFragment extends Fragment {
    private EditText editText;
    private EditText editText2;
    private TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calculate, container, false);
        view.findViewById(R.id.buttonPlus).setOnClickListener(this::onClickPlus);
        view.findViewById(R.id.buttonMinus).setOnClickListener(this::onClickMinus);
        view.findViewById(R.id.buttonMult).setOnClickListener(this::onClickMult);
        view.findViewById(R.id.buttonDivide).setOnClickListener(this::onClickDiv);
        editText = view.findViewById(R.id.firstVar);
        editText2 = view.findViewById(R.id.secondVar);
        textView = view.findViewById(R.id.answer);
        return view;
    }

    private void onClickDiv(View view) {
        double result = 0;
        try {
            double x = Double.parseDouble(editText.getText().toString());
            double y = Double.parseDouble(editText2.getText().toString());
            result = x/y;

            textView.setText(Double.toString(result));
        } catch (Exception e) {
            textView.setText("Вы ввели некорректное выражение");
        }
    }

    private void onClickMult(View view) {
        double result = 0;
        try {
            double x = Double.parseDouble(editText.getText().toString());
            double y = Double.parseDouble(editText2.getText().toString());
            result = x*y;

            textView.setText(Double.toString(result));
        } catch (Exception e) {
            textView.setText("Вы ввели некорректное выражение");
        }
    }

    private void onClickMinus(View view) {
        double result = 0;
        try {
            double x = Double.parseDouble(editText.getText().toString());
            double y = Double.parseDouble(editText2.getText().toString());
            result = x-y;

            textView.setText(Double.toString(result));
        } catch (Exception e) {
            textView.setText("Вы ввели некорректное выражение");
        }
    }


    private void onClickPlus(View view) {
        double result = 0;
        try {
            double x = Double.parseDouble(editText.getText().toString());
            double y = Double.parseDouble(editText2.getText().toString());
            result = x + y;

            textView.setText(Double.toString(result));
        } catch (Exception e) {
            textView.setText("Вы ввели некорректное выражение");
        }
    }
}