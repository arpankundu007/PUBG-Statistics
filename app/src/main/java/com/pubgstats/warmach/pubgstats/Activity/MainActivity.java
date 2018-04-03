package com.pubgstats.warmach.pubgstats.Activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.pubgstats.warmach.pubgstats.BuildConfig;
import com.pubgstats.warmach.pubgstats.Interface.PUBGApi;
import com.pubgstats.warmach.pubgstats.Models.ServerStatus;
import com.pubgstats.warmach.pubgstats.R;
import com.pubgstats.warmach.pubgstats.Utils.PUBGRetrofit;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.api_version)
    TextView apiVersion;

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        checkServerStatus();
    }

    private void checkServerStatus() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Getting status...");
        progressDialog.show();
        PUBGApi pubgApi = PUBGRetrofit.createService(PUBGApi.class, BuildConfig.PUBG_API_KEY);
        Call<ServerStatus> call = pubgApi.checkServerStatus();
        call.enqueue(new Callback<ServerStatus>() {
            @Override
            public void onResponse(Call<ServerStatus> call, Response<ServerStatus> response) {
                if (response.isSuccessful()) {
                    Log.v("Response: ", response.body().getData().getType());
                    apiVersion.setText(response.body().getData().getAttributes().getVersion());
                    progressDialog.dismiss();
                } else {
                }
            }

            @Override
            public void onFailure(Call<ServerStatus> call, Throwable t) {
            }
        });
    }


}
