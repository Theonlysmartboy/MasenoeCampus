package com.otemainc.masenoecampus;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {
private WebView container;
private ProgressBar progressBar;
    private AdView mAdView;
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
        MobileAds.initialize(this, "ca-app-pub-8916451669489221~4463415772");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
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