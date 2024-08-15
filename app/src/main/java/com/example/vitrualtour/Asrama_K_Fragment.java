package com.example.vitrualtour;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;

public class Asrama_K_Fragment extends Fragment {

    private WebView webView360;
    private ProgressBar progressBar;
    private MaterialButton directionOneBtn;

    private String latitude = "-7.758255588367384";
    private String longitude = "112.73121198761736";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_asrama_k, container, false);

        webView360 = view.findViewById(R.id.webview_360);
        progressBar = view.findViewById(R.id.progressBar);
        directionOneBtn = view.findViewById(R.id.directionOneBtn);

        initView();

        webView360.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                progressBar.setVisibility(View.GONE);
            }
        });

        directionOneBtn.setOnClickListener(v -> {
            directionFromCurrentMap(latitude, longitude);
        });

        return view;
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void initView() {
        WebSettings webSettings = webView360.getSettings();
        webSettings.setJavaScriptEnabled(true);
        // Ubah URL di sini dengan URL yang ingin Anda tampilkan di WebView
        webView360.loadUrl("https://www.google.co.id/maps/place/Asrama+K+ponpes+Ngalah/@-7.7583229,112.7311958,3a,75y,340h,90t/data=!3m8!1e1!3m6!1sAF1QipN-WxOyvKOc2AaMMvjBBe4EC9uwl7A0E4z-N_-g!2e10!3e11!6shttps:%2F%2Flh5.googleusercontent.com%2Fp%2FAF1QipN-WxOyvKOc2AaMMvjBBe4EC9uwl7A0E4z-N_-g%3Dw900-h600-k-no-pi0-ya309-ro0-fo90!7i8704!8i4352!4m17!1m7!3m6!1s0x2dd7d3000816e317:0xfdecbb20f5b84e73!2sAsrama+K+ponpes+Ngalah!8m2!3d-7.7583229!4d112.7311958!16s%2Fg%2F11vz7qwx2h!3m8!1s0x2dd7d3000816e317:0xfdecbb20f5b84e73!8m2!3d-7.7583229!4d112.7311958!10e5!14m1!1BCgIgAQ!16s%2Fg%2F11vz7qwx2h?coh=205410&entry=ttu");
    }

    private void directionFromCurrentMap(String destinationLatitude, String destinationLongitude) {
        Uri mapUri = Uri.parse("https://maps.google.com/maps?daddr=" + destinationLatitude + "," + destinationLongitude);
        Intent intent = new Intent(Intent.ACTION_VIEW, mapUri);
        startActivity(intent);
    }
}
