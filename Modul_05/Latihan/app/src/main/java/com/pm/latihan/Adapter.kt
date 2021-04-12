package com.pm.latihan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list.view.*

class Adapter (private val list:ArrayList<Users>,private val listener: OnItemClickListener) : RecyclerView.Adapter<Adapter.Holder>(){

    override fun onCreateViewHolder (parent: ViewGroup, viewType: Int): Holder {
        return Holder (LayoutInflater.from(parent.context).inflate(R.layout.list,parent,false))
    }

    override fun getItemCount (): Int = list.size

    override fun onBindViewHolder (holder: Holder, position: Int) {
        holder.view.lbList. text = list.get(position).name }

    inner class Holder (val view: View) : RecyclerView.ViewHolder (view), View.OnClickListener {

        init {
            view.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position  != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }
    interface OnItemClickListener{

        fun onItemClick(position: Int)
    }
}
