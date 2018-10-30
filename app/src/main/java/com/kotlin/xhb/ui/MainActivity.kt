package com.kotlin.xhb.ui

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import com.kotlin.xhb.bean.Person
import com.kotlin.xhb.adapter.PersonRvAdapter
import com.kotlin.xhb.R
import com.kotlin.xhb.base.BaseActivity
import com.kotlin.xhb.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun initContentView(): Int = R.layout.activity_main

    override fun initData() {
        viewDataBinding.person = Person("tom", 12)

        //列表
        viewDataBinding.recyclerView.layoutManager = LinearLayoutManager(this)
        viewDataBinding.recyclerView.adapter = PersonRvAdapter(LayoutInflater.from(this),
                Array(10, init = { it -> Person("Tom--" + "${it}", it) })
        )
    }

}
