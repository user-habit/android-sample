package com.userhabit.todo.todoapp.ui;

import android.graphics.Bitmap;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.userhabit.todo.todoapp.R;

import io.userhabit.service.Userhabit;

public class WebviewFragment extends Fragment {

    WebView webview;
    WebViewClient client;

    public static Fragment newInstance() {
        return new WebviewFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_webview, container, false);
        webview = view.findViewById(R.id.webview);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setWebview();
        webview.loadUrl("https://www.userhabit.io/");
    }

    void setWebview() {
        WebSettings ws = webview.getSettings();
        ws.setJavaScriptEnabled(true);
        client = new CustomWebviewClient();
        webview.setWebViewClient(client);
        webview.setWebChromeClient(new WebChromeClient());

        /**
         * Userhabit 웹뷰 화면 분석
         */
        Userhabit.addWebView(webview, client);
        Userhabit.addScrollView(webview);
    }
}


class CustomWebviewClient extends WebViewClient {

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        return super.shouldOverrideUrlLoading(view, request);
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
    }
}
