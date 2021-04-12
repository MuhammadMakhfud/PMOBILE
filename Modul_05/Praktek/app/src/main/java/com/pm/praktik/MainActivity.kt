package com.pm.praktik

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

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
            if (listUser.size -1 == i){
                val adapter = Adapter (list)
                adapter.notifyDataSetChanged()
                mRecyclerView.adapter= adapter
            }
        }
    }
}