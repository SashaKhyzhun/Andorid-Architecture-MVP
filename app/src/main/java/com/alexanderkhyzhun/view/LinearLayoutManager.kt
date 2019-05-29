package com.alexanderkhyzhun.view

import android.content.Context

import androidx.recyclerview.widget.LinearLayoutManager

/**
 * @author SashaKhyzhun
 * Created on 3/1/19.
 */
class LinearLayoutManager(
    context: Context
) : LinearLayoutManager(context) {

    private var isScrollEnabled = true

    fun setScrollEnabled(flag: Boolean) {
        this.isScrollEnabled = flag
    }

    override fun canScrollVertically(): Boolean = isScrollEnabled && super.canScrollVertically()

}
