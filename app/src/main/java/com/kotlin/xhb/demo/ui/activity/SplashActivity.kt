package com.kotlin.xhb.demo.ui.activity

import android.content.Intent
import com.kotlin.xhb.R
import com.kotlin.xhb.demo.base.BaseActivity

/**
 * 通过添加 apply plugin: 'kotlin-android-extensions'
 * 可以直接使用layout id 名称获取当前view对象
 * 需要注意的是kotlin-android-extensions插件给我们自动寻址的id都是基于我们当前apk资源下的，即是:Resource指向的包
 */
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : BaseActivity() {

    override fun layoutId(): Int = R.layout.activity_splash
    override fun initData() {
        startActivity(Intent(this@SplashActivity, MainActivity::class.java))
    }
}