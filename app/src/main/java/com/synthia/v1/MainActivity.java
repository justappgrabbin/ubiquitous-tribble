package com.synthia.v1;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.webkit.WebViewAssetLoader;
public class MainActivity extends Activity {
 private WebView view;
 @Override public void onCreate(Bundle state) {
  super.onCreate(state);
  WebViewAssetLoader loader = new WebViewAssetLoader.Builder().addPathHandler("/assets/",new WebViewAssetLoader.AssetsPathHandler(this)).build();
  view = new WebView(this);
  view.getSettings().setJavaScriptEnabled(true);
  view.getSettings().setDomStorageEnabled(true);
  view.setWebViewClient(new WebViewClient(){
   @Override public android.webkit.WebResourceResponse shouldInterceptRequest(WebView v,android.webkit.WebResourceRequest request){
    return loader.shouldInterceptRequest(request.getUrl());
   }
  });
  setContentView(view);
  view.loadUrl("https://appassets.androidplatform.net/assets/synthia/phone-shell.html");
 }
 @Override public void onBackPressed(){if(view.canGoBack())view.goBack();else super.onBackPressed();}
}