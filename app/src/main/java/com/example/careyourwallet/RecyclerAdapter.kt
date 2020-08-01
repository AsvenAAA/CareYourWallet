package com.example.careyourwallet

import android.content.Context
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(context: Context) : RecyclerView.Adapter<RecyclerAdapter.MainHolder>(){

    abstract class MainHolder(private val viewGroup: ViewGroup) : RecyclerView.ViewHolder(viewGroup)

    class DayHolder(private val viewGroup: LinearLayout) : MainHolder(viewGroup) {

    }

    class WeekHolder(private val viewGroup: LinearLayout) : MainHolder(viewGroup) {

    }

    class MonthHolder(private val viewGroup: LinearLayout) : MainHolder(viewGroup) {

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

}