package com.kotlin.xhb.adapter

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.kotlin.xhb.BR
import com.kotlin.xhb.R
import com.kotlin.xhb.bean.Person

/**
 * Created by xhb on 2018/10/28.
 */
class PersonRvAdapter(var inflater: LayoutInflater, var personList: Array<Person>) : RecyclerView.Adapter<PersonRvAdapter.ViewHolder>() {

    override fun getItemCount() = personList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.viewDataBinding.setVariable(BR.adapter_person, personList[position])
        holder.viewDataBinding.executePendingBindings()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder = ViewHolder(
            DataBindingUtil.inflate(inflater, R.layout.item_main_adapter, parent, false)
    )


    class ViewHolder(var viewDataBinding: ViewDataBinding) : RecyclerView.ViewHolder(viewDataBinding.root)

}