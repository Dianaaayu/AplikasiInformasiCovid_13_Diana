package com.example.aplikasiinformasicovid13_diana.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.aplikasiinformasicovid13_diana.api.RetrofitClient
import com.example.aplikasiinformasicovid13_diana.infocovid_19.infocovid_19.ProvinceActivity
import com.example.aplikasiinformasicovid13_diana.model.indonesiaResponse
import com.example.retrofitaplikasiinformasicovid13_diana.R
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showIndonesia()

        btnProvince.setOnClickListener{
            Intent(this@MainActivity, ProvinceActivity::class.java).also {
                startActivity(it)
            }
        }
    }

    private fun showIndonesia(){
        RetrofitClient.instance.getIndonesia().enqueue(object :
            Callback<ArrayList<indonesiaResponse>> {
            override fun onFailure(call: Call<ArrayList<indonesiaResponse>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<ArrayList<indonesiaResponse>>,
                response: Response<ArrayList<indonesiaResponse>>
            ) {
                val indonesia = response.body()?.get(0)
                val positive = indonesia?.positif
                val hospitilized = indonesia?.dirawat
                val recover = indonesia?.sembuh
                val death = indonesia?.meninggal

                tvPositive.text = positive
                tvHospitalized.text = hospitilized
                tvRecover.text = recover
                tvDeath.text = death
            }
        })
    }
}