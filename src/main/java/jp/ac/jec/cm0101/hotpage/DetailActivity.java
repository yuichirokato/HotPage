package jp.ac.jec.cm0101.hotpage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;


public class DetailActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        String url = "http://www.jec.ac.jp/design-w/";

        if (intent != null) {
            url = intent.getStringExtra("url");
            Toast.makeText(this, url, Toast.LENGTH_LONG).show();
        }


        WebView webView = (WebView) findViewById(R.id.webView);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
//        webView.getSettings().setBuiltInZoomControls(true);

        webView.getSettings().setCacheMode(webSettings.LOAD_DEFAULT);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setLoadWithOverviewMode(true);

        webView.loadUrl(url);

        webView.setWebViewClient(new WebViewClient());
        webView.restoreState(savedInstanceState);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        WebView webView1 = new WebView(this);
        webView1.saveState(outState);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
