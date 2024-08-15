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

public class Asrama_L_Fragment extends Fragment {

    private WebView webView360;
    private ProgressBar progressBar;
    private MaterialButton directionOneBtn;

    private String latitude = "-7.758190994595536";
    private String longitude = "112.72901878518336";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_asrama_l, container, false);

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
        webView360.loadUrl("https://www.google.co.id/maps/place/Asrama+L+Ponpes+Ngalah/@-7.7582478,112.7290206,3a,75y,240h,90t/data=!3m8!1e1!3m6!1sAF1QipOdFbqKMKFq1I6uh2hITy98jIKvAVlwYvBVC_U7!2e10!3e11!6shttps:%2F%2Flh5.googleusercontent.com%2Fp%2FAF1QipOdFbqKMKFq1I6uh2hITy98jIKvAVlwYvBVC_U7%3Dw900-h600-k-no-pi0-ya105-ro0-fo90!7i8704!8i4352!4m13!1m2!2m1!1sAsrama+L+ponpes+Ngalah!3m9!1s0x2dd7d3c31003053b:0x9e771b55c9f11363!8m2!3d-7.7582189!4d112.729014!10e5!14m1!1BCgIgAQ!15sChZBc3JhbWEgSSBwb25wZXMgTmdhbGFokgEQZWR1Y2F0aW9uX2NlbnRlcuABAA!16s%2Fg%2F11l2zdcyd0?coh=205410&entry=ttu");
    }

    private void directionFromCurrentMap(String destinationLatitude, String destinationLongitude) {
        Uri mapUri = Uri.parse("https://maps.google.com/maps?daddr=" + destinationLatitude + "," + destinationLongitude);
        Intent intent = new Intent(Intent.ACTION_VIEW, mapUri);
        startActivity(intent);
    }
}
