package com.example.careyourwallet

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.careyourwallet.databinding.ActivityMainBinding.inflate
import com.example.careyourwallet.databinding.DayRecyclerBinding
import com.example.careyourwallet.repository.local.EntityOfDayActions
import kotlinx.android.synthetic.main.day_recycler.view.*
import java.lang.NullPointerException
import java.util.zip.Inflater

class RecyclerAdapter(context: Context) : RecyclerView.Adapter<RecyclerAdapter.MainHolder>(){

    private val inflater = LayoutInflater.from(context)
    private val entityOfDayActions = emptyList<EntityOfDayActions>()

    abstract class MainHolder(private val viewGroup: ViewGroup) : RecyclerView.ViewHolder(viewGroup)

    class DayHolder(private val viewGroup: LinearLayout) : MainHolder(viewGroup) {
/*        private val bind = DataBindingUtil.getBinding<DayRecyclerBinding>(viewGroup)
        val action = bind?.item
        val moneyCount = bind?.money*/
        val itemTextView = viewGroup.findViewById<TextView>(R.id.item)
        val moneyTextView = viewGroup.findViewById<TextView>(R.id.money)

    }

    class WeekHolder(private val viewGroup: LinearLayout) : MainHolder(viewGroup) {
        val dayNameTextView = viewGroup.findViewById<TextView>(R.id.day_name)
        val dayOfWeekIncomeTextView = viewGroup.findViewById<TextView>(R.id.day_of_week_income)
        val dayOfWeekExpensesTextView = viewGroup.findViewById<TextView>(R.id.day_of_week_expenses)
        val dayOfWeekTotalTextView = viewGroup.findViewById<TextView>(R.id.day_of_week_total)
    }

    class MonthHolder(private val viewGroup: LinearLayout) : MainHolder(viewGroup) {
        val monthNameTextView = viewGroup.findViewById<TextView>(R.id.month_name)
        val monthIncomeTextView = viewGroup.findViewById<TextView>(R.id.month_income)
        val monthExpensesTextView = viewGroup.findViewById<TextView>(R.id.month_expenses)
        val monthTotalTextView = viewGroup.findViewById<TextView>(R.id.month_total)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        return when(viewType) {
            dayHolderId -> DayHolder(inflater.inflate(R.layout.day_recycler, parent, false) as LinearLayout)
            weekHolderId -> WeekHolder(inflater.inflate(R.layout.week_recycler_view, parent, false) as LinearLayout)
            monthHolderId -> MonthHolder(inflater.inflate(R.layout.month_recycler_view, parent, false) as LinearLayout)
            else -> DayHolder(inflater.inflate(R.layout.day_recycler, parent, false) as LinearLayout)
        }
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        when(getItemViewType(position)) {
            dayHolderId -> let {
                holder as DayHolder
                holder.itemTextView.text = entityOfDayActions[position].moneyAction
                holder.moneyTextView.text = entityOfDayActions[position].amountOfMoney.toString()

            }
        }
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    companion object {
        const val dayHolderId = 1
        const val weekHolderId = 2
        const val monthHolderId = 3
    }

}