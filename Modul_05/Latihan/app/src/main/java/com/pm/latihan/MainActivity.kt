package com.pm.latihan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Adapter.OnItemClickListener {

    val list = ArrayList<Users>()
    val listUser = arrayOf(
        "Alpha",
        "Bravo",
        "Delta",
        "Echo",
        "Foxtrot",
        "Golf",
        "Hotel",
        "India",
        "Juliet"
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
        Toast.makeText(this, "Anda Mengklik Item "+ listUser.get(position), Toast.LENGTH_SHORT).show()

    }
}