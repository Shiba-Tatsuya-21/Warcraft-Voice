package fr.pisano.warcraftvoice.ui.internet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import fr.pisano.warcraftvoice.R;

public class InternetFragment extends Fragment {

    private InternetViewModel internetViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        internetViewModel =
                ViewModelProviders.of(this).get(InternetViewModel.class);
        View root = inflater.inflate(R.layout.fragment_internet, container, false);

        WebView mWebView = root.findViewById(R.id.wikipedia);
        mWebView.getSettings().setLoadWithOverviewMode(true);
        mWebView.getSettings().setUseWideViewPort(true);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mWebView.loadUrl("https://mangakakalot.com/");//de base https://fr.wikipedia.org/wiki/Warcraft
        mWebView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        return root;
    }
}