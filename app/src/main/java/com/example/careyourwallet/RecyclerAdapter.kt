package com.example.careyourwallet

import android.content.Context
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.careyourwallet.databinding.DayRecyclerBinding
import kotlinx.android.synthetic.main.day_recycler.view.*

class RecyclerAdapter(context: Context) : RecyclerView.Adapter<RecyclerAdapter.MainHolder>(){

    abstract class MainHolder(private val viewGroup: ViewGroup) : RecyclerView.ViewHolder(viewGroup)

    class DayHolder(private val viewGroup: LinearLayout) : MainHolder(viewGroup) {
        private val bind = DataBindingUtil.getBinding<DayRecyclerBinding>(viewGroup)
        val action = bind?.item
        val moneyCount = bind?.money

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