package com.pm.Tugas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Adapter.OnItemClickListener {

    val list = ArrayList<Users>()
    val listUser = arrayOf(
        "Xiomi Redmi Note 8",
        "Xiomi Redmi Note 8 Pro",
        "Xiomi Redmi Note 9",
        "Xiomi Redmi Note 9 Pro",
        "Xiomi Redmi Note 10",
        "Xiomi Redmi Note 10 Pro",
        "Xiomi Mi 10 T",
        "Xiomi Mi 10 ",
        "Xiomi Mi 11"
    )
    private val listUserdes = arrayOf(
        "RP. 2.100.000",
        "RP. 2.500.000",
        "RP. 2.700.000",
        "RP. 3.000.000",
        "RP. 2.900.000",
        "RP. 3.400.000",
        "RP. 6.500.000",
        "RP. 9.000.000",
        "RP. 11.000.000"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager = LinearLayoutManager (this)
        for (i in 0 until listUser.size){
            list.add(Users(listUser.get(i)))
            if (listUser.size - 1 == i){
                val adapter = Adapter (list,this)
                adapter.notifyDataSetChanged()
                mRecyclerView.adapter= adapter
            }
        }
    }

    override fun onItemClick(position: Int) {
        Toast.makeText(this, "Barang tersedia \nPembayaran Via Bank \nHarga: "+ listUserdes .get(position), Toast.LENGTH_LONG).show()

    }
}