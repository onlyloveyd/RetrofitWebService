package com.gs.retrofitwebservice;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.gs.retrofitwebservice.databinding.ActivityMainBinding;
import com.gs.retrofitwebservice.mobilecode.mobileCodeApi;
import com.gs.retrofitwebservice.mobilecode.request.MobileCodeRequestBody;
import com.gs.retrofitwebservice.mobilecode.request.MobileCodeRequestData;
import com.gs.retrofitwebservice.mobilecode.request.MobileCodeRequestEnvelope;
import com.gs.retrofitwebservice.mobilecode.response.MobileCodeResponseEnvelope;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }

    public void sendRequest(View view) {
        mobileCodeApi apiService = Retrofitance.createMobileCodeService(mobileCodeApi.class);
        MobileCodeRequestEnvelope requestEnvelope = new MobileCodeRequestEnvelope();
        MobileCodeRequestBody requestBody = new MobileCodeRequestBody();
        MobileCodeRequestData requestData = new MobileCodeRequestData();

        requestData.setMobileCode("18507152743");
        requestBody.setMobileCodeRequestData(requestData);
        requestEnvelope.setBody(requestBody);

        Call<MobileCodeResponseEnvelope> call = apiService.getMobileCodeInfo(requestEnvelope);
        call.enqueue(new Callback<MobileCodeResponseEnvelope>() {
            @Override
            public void onResponse(Call<MobileCodeResponseEnvelope> call,
                                   Response<MobileCodeResponseEnvelope> response) {
                MobileCodeResponseEnvelope mobileCodeResponseEnvelope = response.body();
                if (mobileCodeResponseEnvelope != null) {
                    Toast.makeText(MainActivity.this, "请求成功", Toast.LENGTH_SHORT).show();
                    String result =
                            mobileCodeResponseEnvelope.getMobildCodeResponseBody()
                                    .getMobileCodeResponseInfo().getMobileCodeResult();
                    mBinding.tvMobileResult.setText(result);
                }
            }

            @Override
            public void onFailure(Call<MobileCodeResponseEnvelope> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(MainActivity.this, "请求失败", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
