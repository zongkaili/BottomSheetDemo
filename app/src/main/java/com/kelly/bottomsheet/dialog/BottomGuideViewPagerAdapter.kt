package com.kelly.bottomsheet.dialog

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.util.SparseArray
import com.kelly.bottomsheet.R
import kotlinx.android.synthetic.main.viewpager_bottom_guide_style_1.view.*


/**
 * @author zongkaili
 * @date 2018/9/7
 * @desc
 */
class BottomGuideViewPagerAdapter(context: Context) : PagerAdapter() {
    private val mCount = 8
    private var mInflater: LayoutInflater = LayoutInflater.from(context)
    private val mPageCache = SparseArray<View>()

    override fun isViewFromObject(view: View, `object`: Any): Boolean = view == `object`

    override fun getCount(): Int = mCount

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        var page = mPageCache.get(position)
        if (page == null) {
            when (position) {
                0 -> {
                    page = mInflater.inflate(R.layout.viewpager_bottom_guide_style_1, container, false)
//                    TextTool.getBuilder(container.context, "")
//                            .append("测试")
//                            .append("图片\n")
//                            .setResourceId(R.drawable.logo)
//                            .into(page.viewpagerTitle)
                    page.viewpagerTitle.text = container.resources.getString(R.string.guide_step_1)
                    page.viewpagerContent.setImageResource(R.drawable.licard_quick_pay_guide_pic_1)
                }
                1 -> {
                    page = mInflater.inflate(R.layout.viewpager_bottom_guide_style_1, container, false)
                    page.viewpagerTitle.text = container.resources.getString(R.string.guide_step_2)
                    page.viewpagerContent.setImageResource(R.drawable.licard_quick_pay_guide_pic_2)
                }
                2 -> {
                    page = mInflater.inflate(R.layout.viewpager_bottom_guide_style_1, container, false)
                    page.viewpagerTitle.text = container.resources.getString(R.string.guide_step_3)
                    page.viewpagerContent.setImageResource(R.drawable.licard_quick_pay_guide_pic_3)
                }
                3 -> {
                    page = mInflater.inflate(R.layout.viewpager_bottom_guide_style_1, container, false)
                    page.viewpagerTitle.text = container.resources.getString(R.string.guide_step_4)
                    page.viewpagerContent.setImageResource(R.drawable.licard_quick_pay_guide_pic_4)
                }
                4 -> {
                    page = mInflater.inflate(R.layout.viewpager_bottom_guide_style_1, container, false)
                    page.viewpagerTitle.text = container.resources.getString(R.string.guide_step_5)
                    page.viewpagerContent.setImageResource(R.drawable.licard_quick_pay_guide_pic_5)
                }
                5 -> {
                    page = mInflater.inflate(R.layout.viewpager_bottom_guide_style_1, container, false)
                    page.viewpagerTitle.text = container.resources.getString(R.string.guide_step_6)
                    page.viewpagerContent.setImageResource(R.drawable.licard_quick_pay_guide_pic_6)
                }
                6 -> {
                    page = mInflater.inflate(R.layout.viewpager_bottom_guide_style_2, container, false)
                }
                7 -> {
                    page = mInflater.inflate(R.layout.viewpager_bottom_guide_style_3, container, false)
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