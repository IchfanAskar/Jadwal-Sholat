package com.example.hijiriakalender;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.util.Log;

import com.example.hijiriakalender.model.HijriResponse;
import com.example.hijiriakalender.model.HijriResponse.DataBean;
import com.example.hijiriakalender.remote.HijriService;

import java.util.List;

import static com.example.hijiriakalender.model.HijriResponse.DataBean.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HijriService.getAPI()
                .getPrayerDateHijri("Makassar", "ID")
                .enqueue(new Callback<HijriResponse>() {
                    @Override
                    public void onResponse(Call<HijriResponse> call, Response<HijriResponse> response) {
                        if (response.isSuccessful()){
                            List<DataBean> dataBeans = response.body().getData();

                            for (DataBean dataBean: dataBeans){
                                TimingsBean timingsBean = dataBean.getTimings();
                                DateBean dateBean = dataBean.getDate();
                                MetaBean metaBean = dataBean.getMeta();

                                Log.d("jadwal subuh" , timingsBean.getFajr());

                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<HijriResponse> call, Throwable t) {
                        Log.e("pesan gagal", t.getMessage());
                    }
                });
    }
}
