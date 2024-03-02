//package com.example.browser;
//
//import android.os.Build;
//import android.os.Bundle;
//import android.webkit.WebView;
//import android.app.Activity;
//import android.webkit.WebResourceError;
//import android.webkit.WebResourceRequest;
//import android.webkit.WebViewClient;
//import android.widget.Toast;
//import android.annotation.TargetApi;
//import androidx.appcompat.app.AppCompatActivity;
//
//public class MainActivity extends AppCompatActivity {
//
//    WebView webView;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        webView = new WebView(this);
//        webView.getSettings().setJavaScriptEnabled(true);
//
//        final Activity activity = this;
//
//        return webView.setWebViewClient(new WebViewClient() {
//            @SuppressWarnings("deprecation")
//            @Override
//            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
//                Toast.makeText(activity, description, Toast.LENGTH_SHORT).show();
//            }
//
//            @TargetApi(Build.VERSION_CODES.M)
//            @Override
//            public void onReceivedError(WebView view, WebResourceRequest req, WebResourceError rerr) {
//                onReceivedError(view, rerr.getErrorCode(), rerr.getDescription().toString(), req.getUrl().toString());
//            }
//        }};
//        webView.loadUrl("")
//
//        setContentView(webView);
//    }
//}



package com.example.browser;

import android.os.Build;
import android.os.Bundle;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        webView = new WebView(this);
        webView.getSettings().setJavaScriptEnabled(true);

        final AppCompatActivity activity = this;

        webView.setWebViewClient(new WebViewClient() {

            @SuppressWarnings("deprecation")
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                //Toast.makeText(activity, description, Toast.LENGTH_SHORT).show();
            }

            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onReceivedError(WebView view, WebResourceRequest req, WebResourceError rerr) {
                onReceivedError(view, rerr.getErrorCode(), rerr.getDescription().toString(), req.getUrl().toString());
            }
        });

        webView.loadUrl("https://gamerant.com");

        setContentView(webView);
    }
}
