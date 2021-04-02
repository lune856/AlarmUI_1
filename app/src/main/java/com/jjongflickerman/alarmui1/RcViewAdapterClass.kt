package com.jjongflickerman.alarmui1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyViewHolder(xmlConvertedToViewObj: View) : RecyclerView.ViewHolder(xmlConvertedToViewObj){
    val tv1: TextView = xmlConvertedToViewObj.findViewById(R.id.id_tv1_InsideCardView)
    val tv2: TextView = xmlConvertedToViewObj.findViewById(R.id.id_tv2_InsideCardView)
    val imageView: ImageView = xmlConvertedToViewObj.findViewById(R.id.id_imageView)
}

class RcViewAdapterClass(val receivedList: List<MyDataClassItem>) : RecyclerView.Adapter<MyViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val myXmlToViewObject = LayoutInflater.from(parent.context).inflate(R.layout.cardviewlayout, parent, false)
        return MyViewHolder(myXmlToViewObject)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = receivedList[position]
        holder.apply{
            imageView.setImageResource(currentItem.imgResource)
            tv1.text = currentItem.text1
            tv2.text = currentItem.text2
        }


    }

    override fun getItemCount(): Int = receivedList.size

}