package ru.petrolplus.wsk_police.common.adapters

import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_sign_in.view.*
import kotlinx.android.synthetic.main.item_list.view.*
import ru.petrolplus.wsk_police.R
import ru.petrolplus.wsk_police.common.DataObject.ItemListObject

class RecyclerAdapterList(private val mContext: Context, private val mData: List<ItemListObject>) : RecyclerView.Adapter<RecyclerAdapterList.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_list, parent, false))
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.title.text = mData[position].title
        holder.imageId.setImageDrawable(ContextCompat.getDrawable(mContext,mData[position].imageId ))
    }


    class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        // Holds the TextView that will add each animal to
        val title: TextView = view.item_title
        val imageId: ImageView = view.image
    }
}