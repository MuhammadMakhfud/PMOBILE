package com.pm.praktek

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val testData = createPhoneData()
        rv_part.layoutManager = LinearLayoutManager(this)
        rv_part.setHasFixedSize(true)
        rv_part.adapter =
            ContactAdapter(
                testData,
                { phoneItem: com.pm.praktek.PhoneData -> phoneItemClicked(phoneItem) })
    }
    private fun phoneItemClicked(phoneItem: com.pm.praktek.PhoneData) {
        val showDetailActivityIntent = Intent(this, com.pm.praktek.PhoneDetailActivity::class.java)
        showDetailActivityIntent.putExtra(Intent.EXTRA_TEXT, phoneItem.phone.toString())
        showDetailActivityIntent.putExtra("NM",  phoneItem.contactName)
        showDetailActivityIntent.putExtra("AL",  phoneItem.alamat)
        startActivity(showDetailActivityIntent)
    }
    private fun createPhoneData(): List<com.pm.praktek.PhoneData> {
        val partList = ArrayList<com.pm.praktek.PhoneData>()
        partList.add(
            com.pm.praktek.PhoneData(
                9864932,
                "Alpha",
                "Jl. Padat Karya Gg. pelangi NO. 08 Sempaja"
            )
        )
        partList.add(
            com.pm.praktek.PhoneData(
                1341933,
                "Bravo",
                "Jl. Bung Tomo Gg. Indah NO. 22 Samarinda Sebrang"
            )
        )
        partList.add(
            com.pm.praktek.PhoneData(
                1401624,
                "Charlie",
                "Jl. Pahlawan Gang 8 NO. 2 Samarinda Kota"
            )
        )
        return partList
    }

}