package com.pm.latihan

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
            ContactAdapter(testData, { phoneItem: PhoneData -> phoneItemClicked(phoneItem) })
    }
    private fun phoneItemClicked(phoneItem: PhoneData) {
        val showDetailActivityIntent = Intent(this, PhoneDetailActivity::class.java)
        showDetailActivityIntent.putExtra(Intent.EXTRA_TEXT, phoneItem.phone.toString())
        showDetailActivityIntent.putExtra("NM",  phoneItem.contactName)
        showDetailActivityIntent.putExtra("AL",  phoneItem.alamat)
        startActivity(showDetailActivityIntent)
    }
    private fun createPhoneData(): List<PhoneData> {
        val partList = ArrayList<PhoneData>()
        partList.add(PhoneData(9864932, "Alpha", "Jl. Padat Karya Gg. pelangi NO. 08 Sempaja"))
        partList.add(PhoneData(1341933, "Bravo", "Jl. Bung Tomo Gg. Indah NO. 22 Samarinda Sebrang"))
        partList.add(PhoneData(1401624, "Charlie", "Jl. Pahlawan Gang 8 NO. 2 Samarinda Kota"))
        return partList
    }

}