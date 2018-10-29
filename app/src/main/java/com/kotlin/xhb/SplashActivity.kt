package com.kotlin.xhb

import android.content.Intent
import com.kotlin.xhb.databinding.ActivitySplashBinding

class SplashActivity : BaseActivity<ActivitySplashBinding>(){

    override fun initContentView(): Int = R.layout.activity_splash

    override fun initData() {
        viewDataBinding.tvAcSplashContent.setText("欢迎进入Kotlin_Demo项目")
        viewDataBinding.tvAcSplashContent.setOnClickListener(
                {startActivity(Intent(this@SplashActivity, MainActivity::class.java))}
        )
    }
}