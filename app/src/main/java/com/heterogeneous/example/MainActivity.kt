package com.heterogeneous.example

import MultiViewRecyclerAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.heterogeneous.multipleviewtypeexample.R

/**
 * @author Ravi
 */
class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val listViewType = mutableListOf(
                MultiViewRecyclerAdapter.ITEM_HEADER_VIEW,
                MultiViewRecyclerAdapter.ITEM_OFFER_VIEW,
                MultiViewRecyclerAdapter.ITEM_RESTAURANT_VIEW,
                MultiViewRecyclerAdapter.ITEM_OFFER_VIEW,
                MultiViewRecyclerAdapter.ITEM_RESTAURANT_VIEW,
                MultiViewRecyclerAdapter.ITEM_OFFER_VIEW
        )
        val adapterRecyclerView = MultiViewRecyclerAdapter(this, listViewType = listViewType)
        recyclerView.adapter = adapterRecyclerView
    }
}