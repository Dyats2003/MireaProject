package ru.mirea.yatsenko.mireaproject.ui.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;


import ru.mirea.yatsenko.mireaproject.R;


public class BrowserFragment extends Fragment {

    private WebView webView;
    private EditText finder;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_browser, container, false);
        view.findViewById(R.id.buttonSearch).setOnClickListener(this::onClickSearch);
        finder=view.findViewById(R.id.finder);
        webView =view.findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://yandex.ru/");
        return view;
    }

    private void onClickSearch(View view) {
        String search ="https://"+finder.getText().toString();
        webView.loadUrl(search);
    }
}