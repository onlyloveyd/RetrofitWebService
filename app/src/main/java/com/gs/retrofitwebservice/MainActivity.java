package com.gs.retrofitwebservice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.gs.retrofitwebservice.mobielcode.mobileCodeApi;
import com.gs.retrofitwebservice.mobielcode.request.MobileCodeRequestBody;
import com.gs.retrofitwebservice.mobielcode.request.MobileCodeRequestData;
import com.gs.retrofitwebservice.mobielcode.request.MobileCodeRequestEnvelope;
import com.gs.retrofitwebservice.mobielcode.response.MobileCodeResponseEnvelope;
import com.gs.retrofitwebservice.uszip.api;
import com.gs.retrofitwebservice.uszip.request.UsCityRequestBody;
import com.gs.retrofitwebservice.uszip.request.UsCityRequestData;
import com.gs.retrofitwebservice.uszip.request.UsCityRequestEnvelope;
import com.gs.retrofitwebservice.uszip.response.TableElement;
import com.gs.retrofitwebservice.uszip.response.UsCityResponseEnvelope;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bt_test)
    Button mBtTest;
    @BindView(R.id.tv_result)
    TextView mTvResult;
    @BindView(R.id.bt_mobileCode)
    Button mBtMobileCode;
    @BindView(R.id.tv_mobile_result)
    TextView mTvMobileResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.bt_test)
    protected void testSOAP(View view) {
        System.err.println("yidong -- testSoap");
        api apiService = Retrofitance.createService(api.class);
        UsCityRequestEnvelope requestEnvelope = new UsCityRequestEnvelope();    //soapenv:Envelope
        UsCityRequestBody requestBody = new UsCityRequestBody();    // body
        UsCityRequestData baseRequest = new UsCityRequestData();    // getroleinfo

        baseRequest.setCity("New York");
        requestBody.setUsStatesRequestData(baseRequest);
        requestEnvelope.setBody(requestBody);

        Call<UsCityResponseEnvelope> call = apiService.getInfoByCity(requestEnvelope);
        call.enqueue(new Callback<UsCityResponseEnvelope>() {
            @Override
            public void onResponse(Call<UsCityResponseEnvelope> call,
                    Response<UsCityResponseEnvelope> response) {
                UsCityResponseEnvelope usCityResponseEnvelope = response.body();
                if (usCityResponseEnvelope != null) {
                    Toast.makeText(MainActivity.this, "请求成功", Toast.LENGTH_SHORT).show();
                    StringBuilder result = new StringBuilder();
                    List<TableElement> message =
                            usCityResponseEnvelope.getBody().getData().getData().getElements();
                    for (TableElement element : message) {
                        result.append(element.getZip());
                    }
                    mTvResult.setText(result);
                    System.err.println("yidong -- result = " + result);
                }
            }

            @Override
            public void onFailure(Call<UsCityResponseEnvelope> call, Throwable t) {
                System.err.println("yidong -- onFailure");
                Toast.makeText(MainActivity.this, "请求失败", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @OnClick(R.id.bt_mobileCode)
    public void onViewClicked() {
        System.err.println("yidong -- testMobileCode");
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
                    String result = mobileCodeResponseEnvelope.getMobildCodeResponseBody().getMobileCodeResponseInfo().getMobileCodeResult();
                    mTvMobileResult.setText(result);
                    System.err.println("yidong -- result = " + result);
                }
            }

            @Override
            public void onFailure(Call<MobileCodeResponseEnvelope> call, Throwable t) {
                System.err.println("yidong -- onFailure");
                Toast.makeText(MainActivity.this, "请求失败", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
