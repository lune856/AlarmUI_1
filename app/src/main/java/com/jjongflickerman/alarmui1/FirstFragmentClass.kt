package com.jjongflickerman.alarmui1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FirstFragmentClass : Fragment() // for the constructor, we need to pass the id of corresponding layout xml file.
{
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //************ RcView and More*************
        val rcView = this.view?.findViewById<RecyclerView>(R.id.id_rcViewFrag1)

        rcView?.adapter = RcViewAdapterClass(generateDummyList(30))
        rcView?.layoutManager = LinearLayoutManager(activity)
        rcView?.setHasFixedSize(true)
    }

    private fun generateDummyList(mySize: Int): List<MyDataClassItem>
    {
        val listOfMyDataClassItem = ArrayList<MyDataClassItem>()

        for (i in 0 until mySize)
        {
            val imgResource = when(i%3)
            {
                0 -> R.drawable.thumbnail_bike
                1 -> R.drawable.thumbnail_bus
                else -> R.drawable.thumbnail_camera
            }
            val singleDataClassInstance = MyDataClassItem(imgResource, "Item $i","text 2 yo!" )
            listOfMyDataClassItem += singleDataClassInstance
        }
        return listOfMyDataClassItem
    }

}