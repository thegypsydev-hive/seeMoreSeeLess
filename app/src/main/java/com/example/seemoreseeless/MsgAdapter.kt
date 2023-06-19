package com.example.seemoreseeless

import android.graphics.Color
import android.text.Spannable
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

        holder.smallText.maxLines =2
        holder.smallText.text = "${position+1} ${listdata[position]}"
        holder.longText.text = "${position+1} ${listdata[position]}"

        holder.longText.visibility = View.GONE
        holder.smallText.visibility = View.VISIBLE
        holder.smallText.post(Runnable {
            var lineCount = holder.smallText.lineCount
            Log.d("abcd", "lines $lineCount")

            if (lineCount > 2) {
                val layout = holder.smallText.layout
                val lineStart = layout.getLineStart(0);
                val lineEnd = layout.getLineEnd(1);

                val lineText = holder.smallText.text.substring(lineStart, lineEnd).toString();
//
                Log.d("abcd", "$lineText\n\n")


                val textSpan = lineText.substring(lineStart, lineEnd - 13)
                val finalString = "${textSpan}... See More"

                Log.d("abcd","$finalString")
                val sb: Spannable = SpannableString(finalString)

                val clickableSpan: ClickableSpan = object : ClickableSpan() {
                    override fun onClick(textView: View) {
                        holder.smallText.visibility = View.GONE
                        holder.longText.visibility = View.VISIBLE
                    }

                    override fun updateDrawState(ds: TextPaint) {
                        super.updateDrawState(ds)
                        ds.isUnderlineText = false
                    }
                }
                sb.setSpan(
                    clickableSpan,
                    finalString.length - 8,
                    finalString.length,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                )
                holder.smallText.text = sb
                holder.smallText.movementMethod = LinkMovementMethod.getInstance()
                holder.smallText.highlightColor = Color.GREEN

            } else {
                holder.longText.visibility = View.GONE
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

        init {
            smallText = itemView.findViewById<View>(R.id.small_text) as TextView
            longText = itemView.findViewById<View>(R.id.long_text) as TextView
        }
    }
}