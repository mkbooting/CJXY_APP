package cjxy.com.zs.xy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import cjxy.com.zs.MainActivity;
import cjxy.com.zs.R;

public class Four1 extends Activity {
    private WebView webview;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.four1);
        webview = (WebView) findViewById(R.id.webView3);
        //设置WebView属性，能够执行Javascript脚本
        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setLoadWithOverviewMode(true);

        webview.getSettings().setBuiltInZoomControls(true);

        webview.getSettings().setSupportZoom(true);
        //加载需要显示的网页
        webview.loadUrl("file:///android_asset/xy/zs.html");
        //设置Web视图
        webview.setWebViewClient(new HelloWebViewClient ());
    }

    @Override
    //设置回退
    //覆盖Activity类的onKeyDown(int keyCoder,KeyEvent event)方法
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webview.canGoBack()) {
            webview.goBack();
            //goBack()表示返回WebView的上一页面
            return true;
        }
        else
        {
            Intent myIntent = new Intent();
            myIntent = new Intent(Four1.this, MainActivity.class);
            myIntent.putExtra("name",50);
            startActivity(myIntent);
            this.finish();
        }
        return super.onKeyDown(keyCode, event);
    }

    //Web视图
    private class HelloWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}