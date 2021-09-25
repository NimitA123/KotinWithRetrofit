package com.example.kotlin1_we

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_layout.view.*// do not need find view by id

class PostViewHolder(private  val view: View): RecyclerView.ViewHolder(view) {
    fun setData(responseDTO: ResponseDTO){
        view.tvName.text = responseDTO.name //.text means setText
        view.tvEmail.text = responseDTO.email //.text means setText
        view.tvBody.text = responseDTO.body //.text means setText
    }

}