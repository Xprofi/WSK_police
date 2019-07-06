package ru.petrolplus.wsk_police.common.adapters

import android.content.Context
import android.view.*
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_list.view.*
import ru.petrolplus.wsk_police.main.model.MenuInterface
import ru.petrolplus.wsk_police.R
import ru.petrolplus.wsk_police.common.DataObject.Department

class RecyclerAdapterDepartments(private val mContext: Context, private val mData: List<Department>) : RecyclerView.Adapter<RecyclerAdapterDepartments.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_list, parent, false))
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.title.text = mData[position].name
      holder.secondText.text = mData[position].address
        holder.itemView.setOnClickListener {
           if (mContext is MenuInterface){
               //mContext.onItemClickMenu(mData[position])
           }
        }
    }


    class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {

        // Holds the TextView that will add each animal to
        val title: TextView = view.item_title
        val secondText: TextView = view.second_text
    }
}