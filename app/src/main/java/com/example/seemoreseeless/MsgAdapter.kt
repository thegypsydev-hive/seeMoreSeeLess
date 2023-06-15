package com.example.seemoreseeless

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MsgAdapter(listdata: ArrayList<String>) :
    RecyclerView.Adapter<MsgAdapter.ViewHolder>() {
    private val listdata: ArrayList<String>

    // RecyclerView recyclerView;
    init {
        this.listdata = listdata
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem: View =
            layoutInflater.inflate(R.layout.item_rv, parent, false)
        return ViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val myListData: String = listdata[position]

        holder.smallText.setText(listdata[position])
        holder.longText.setText(listdata[position])

        holder.longText.post(Runnable {
            var lineCount = holder.longText.lineCount
            Log.d("abcd", "lines $lineCount")
            if (lineCount > 2) {
                holder.smallText.maxLines = 2
                holder.readMoreText.visibility = View.VISIBLE
                holder.smallText.visibility = View.VISIBLE
                holder.longText.visibility = View.GONE
                holder.readMoreText.setOnClickListener {
                    holder.smallText.visibility = View.GONE
                    holder.longText.visibility = View.VISIBLE
                    holder.readMoreText.visibility = View.GONE
                }
            } else {
                holder.longText.visibility = View.GONE
                holder.readMoreText.visibility = View.GONE
                holder.smallText.visibility = View.VISIBLE

            }
        })


    }

    override fun getItemCount(): Int {
        return listdata.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var smallText: TextView
        var longText: TextView
        var readMoreText: TextView

        init {
            smallText = itemView.findViewById<View>(R.id.small_text) as TextView
            longText = itemView.findViewById<View>(R.id.long_text) as TextView
            readMoreText = itemView.findViewById<View>(R.id.see_more) as TextView
        }
    }
}