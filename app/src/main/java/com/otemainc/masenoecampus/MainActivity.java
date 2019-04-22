package com.otemainc.masenoecampus;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
public class MainActivity extends AppCompatActivity {
private WebView container;
private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        container = findViewById(R.id.container);
        progressBar = findViewById(R.id.progressBar);
        WebSettings mysettings = container.getSettings();
        mysettings.setJavaScriptEnabled(true);
        container.loadUrl("https://elearning.maseno.ac.ke/");
        container.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon); progressBar.setVisibility(View.VISIBLE);
                setTitle("Loading...");
            }
            @Override public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressBar.setVisibility(View.GONE);
                setTitle(view.getTitle());
            }
        });
    }
    public void onBackPressed(){
        if(container.canGoBack()){
            container.goBack();
        }
        else{
            super.onBackPressed();
        }
    }
}