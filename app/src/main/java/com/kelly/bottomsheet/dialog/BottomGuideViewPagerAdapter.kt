package com.kelly.bottomsheet.dialog

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.util.SparseArray
import com.kelly.bottomsheet.R
import com.kelly.bottomsheet.utils.TextTool
import kotlinx.android.synthetic.main.viewpager_bottom_guild.view.*


/**
 * @author zongkaili
 * @date 2018/9/7
 * @desc
 */
class BottomGuideViewPagerAdapter(context: Context) : PagerAdapter() {
    private val mCount = 3
    private var mInflater: LayoutInflater = LayoutInflater.from(context)
    private val mPageCache = SparseArray<View>()

    override fun isViewFromObject(view: View, `object`: Any): Boolean = view == `object`

    override fun getCount(): Int = mCount

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        var page = mPageCache.get(position)
        if (page == null) {
            page = mInflater.inflate(R.layout.viewpager_bottom_guild, container, false)
            when (position) {
                0 -> {
                    TextTool.getBuilder(container.context, "")
                            .append("测试")
                            .append("图片\n")
                            .setResourceId(R.drawable.logo)
                            .into(page.viewpagerTitle)
//                    page.viewpagerTitle.text = "测试$position"
                    page.viewpagerContent.setImageResource(R.drawable.ic_launcher_background)
                }
                1 -> {
                    page.viewpagerTitle.text = "测试$position"
                    page.viewpagerContent.setImageResource(R.drawable.ic_launcher_background)
                }
                2 -> {
                    page.viewpagerTitle.text = "测试$position"
                    page.viewpagerContent.setImageResource(R.drawable.ic_launcher_background)
                }
                else -> {

                }
            }
            mPageCache.append(position, page)
        }
        container.addView(page)
        return page
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View?)
    }

}