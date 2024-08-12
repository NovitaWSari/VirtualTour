package com.example.vitrualtour;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;

public class Asrama_A_Fragment extends Fragment {

    private WebView webView360;
    private ProgressBar progressBar;
    private MaterialButton directionOneBtn;

    private String latitude = "-7.757743809763594";
    private String longitude = "112.72881502883523";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_asrama_a, container, false);

        webView360 = view.findViewById(R.id.webview_360);
        progressBar = view.findViewById(R.id.progressBar);

        initView();

        webView360.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                progressBar.setVisibility(View.GONE);
            }
        });

        directionOneBtn = view.findViewById(R.id.directionOneBtn);


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
        webView360.loadUrl("https://www.google.co.id/maps/place/Pondok+Pesantren+Ngalah/@-7.7579139,112.7288043,3a,75y,340h,90t/data=!3m8!1e1!3m6!1sAF1QipNXarrZ93oq1Ke5Fa5a5gA24T1r-B4QQQHDGdJ8!2e10!3e11!6s%2F%2Flh5.ggpht.com%2Fp%2FAF1QipNXarrZ93oq1Ke5Fa5a5gA24T1r-B4QQQHDGdJ8%3Dw900-h600-k-no-pi0-ya353-ro0-fo100!7i8704!8i4352!4m9!3m8!1s0x2dd7d3e4a0151741:0xaa4ec707ee970700!8m2!3d-7.7579058!4d112.7288027!10e5!14m1!1BCgIgARICEAM!16s%2Fg%2F11c5sy3c3w?coh=205410&entry=ttu");
    }

    private void directionFromCurrentMap(String destinationLatitude, String destinationLongitude) {
        Uri mapUri = Uri.parse("https://maps.google.com/maps?daddr=" + destinationLatitude + "," + destinationLongitude);
        Intent intent = new Intent(Intent.ACTION_VIEW, mapUri);
        startActivity(intent);
    }
}
