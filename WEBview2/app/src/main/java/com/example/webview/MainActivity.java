package com.example.webview;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import java.lang.String;

public class MainActivity extends Activity implements View.OnClickListener{
    private WebView webView;
    private Button bt;

    private String url = "http://192.168.137.97";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        bt=(Button) findViewById(R.id.refresh);
        bt.setOnClickListener(this);

    }
    public void onClick(View v) {
        webView.loadUrl(url);
    }

    private void init(){
        webView = (WebView) findViewById(R.id.webview);
        //WebView加载web资源
        webView.loadUrl("http://192.168.137.97");
        //覆盖WebView默认使用第三方或系统默认浏览器打开网页的行为，使网页用WebView打开
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // TODO Auto-generated method stub
                //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                view.loadUrl(url);
                return true;
            }
        });
    }

}

