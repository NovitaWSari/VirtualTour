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

public class Asrama_I_Fragment extends Fragment {

    private WebView webView360;
    private ProgressBar progressBar;
    private MaterialButton directionOneBtn;

    private String latitude = "-7.758252110530023";
    private String longitude = "112.72971508674722";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_asrama_i, container, false);

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
        webView360.loadUrl("https://www.google.co.id/maps/place/Asrama+I+Ponpes+Ngalah/@-7.7582717,112.7297118,3a,75y,340h,100t/data=!3m8!1e1!3m6!1sAF1QipPisY3Fbu4ja9dpfYsP2m08QrHaeoD_DfdKBPT6!2e10!3e11!6shttps:%2F%2Flh5.googleusercontent.com%2Fp%2FAF1QipPisY3Fbu4ja9dpfYsP2m08QrHaeoD_DfdKBPT6%3Dw900-h600-k-no-pi-10-ya1-ro0-fo90!7i8704!8i4352!4m11!1m2!2m1!1sAsrama+i+ponpes+Ngalah!3m7!1s0x2dd7d38634bbf737:0x9e31f323b7c458f6!8m2!3d-7.7582717!4d112.7297118!10e5!15sChZBc3JhbWEgaSBwb25wZXMgTmdhbGFokgETcmVzaWRlbnRpYWxfY29sbGVnZeABAA!16s%2Fg%2F11ks2nhz29?coh=205410&entry=ttu#");
    }

    private void directionFromCurrentMap(String destinationLatitude, String destinationLongitude) {
        Uri mapUri = Uri.parse("https://maps.google.com/maps?daddr=" + destinationLatitude + "," + destinationLongitude);
        Intent intent = new Intent(Intent.ACTION_VIEW, mapUri);
        startActivity(intent);
    }
}
