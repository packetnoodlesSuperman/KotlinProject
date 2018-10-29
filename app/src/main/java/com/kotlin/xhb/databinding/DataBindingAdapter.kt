package com.kotlin.xhb.databinding

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide

object DataBindingAdapter {

    /**
     * @desc 它在Java中运行良好 。但不是在kotlin 工作。 据我所知，kotlin中的对象是Java的静态方法。但它不适用于数据绑定。
     * @desc JvmStatic 指定如果它是一个函数，则需要从该元素生成另一个静态方法。如果此元素是属性，则应生成其他静态getter / setter方法。
     *          https://stackoverflow.com/questions/51875634/can-not-use-bindingadapter
     */
    @BindingAdapter("app:imageUrl")
    @JvmStatic
    fun glideLoadUrlToImagView(imageView: ImageView, url: String){
        Glide.with(imageView.context)
                .load(url)
                .into(imageView)
    }

}