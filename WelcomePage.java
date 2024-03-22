package com.example.fragmentdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class WelcomePage extends AppCompatActivity {

    int cout =0;
    
    WebView webView;
    ProgressDialog progressDialog;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);

        webView=findViewById(R.id.webview);

        // Progress bar xmlfile
        
      //   <ProgressBar
      // android:id="@+id/determinateBar"
      // style="@android:style/Widget.ProgressBar.Horizontal"
      // android:layout_width="wrap_content"
      // android:layout_height="wrap_content"
      // android:progress="25"/>

        // java Code 
        
         final Timer t=new Timer();
        TimerTask tt= new TimerTask() {
            @Override
            public void run() {
                count++;
                progressBar.setProgress(count);
                if (count == 100)
                {
                    t.cancel();
                }
            }
        };
        t.schedule(tt,0,100);
 

        progressDialog=new ProgressDialog(this);
        webView.loadUrl("https://strands.com/");
        WebSettings webSettings= webView.getSettings();

        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient()

                                 {
                                     @Override
                                     public void onPageStarted(WebView view, String url, Bitmap favicon) {
                                         super.onPageStarted(view, url, favicon);
                                         progressDialog.show();
                                     }

                                     @Override
                                     public void onPageFinished(WebView view, String url) {
                                         super.onPageFinished(view, url);
                                       progressDialog.dismiss();
                                     }
                                 }
        );

    }
}
