package com.kelly.bottomsheet.dialog

import android.app.Dialog
import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.support.design.widget.BottomSheetDialogFragment
import android.view.View
import com.kelly.bottomsheet.R
import android.support.v4.view.ViewPager
import android.support.v7.widget.AppCompatImageView
import android.util.Log


/**
 * @author zongkaili
 * @date 2018/9/7
 * @desc: 用于显示在底部的引导DialogFragment
 */
class BottomGuideDialogFragment : BottomSheetDialogFragment() {
    private lateinit var bottomSheetDialog: Dialog
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        bottomSheetDialog = super.onCreateDialog(savedInstanceState)
        bottomSheetDialog.setContentView(R.layout.dialog_fragment_bottom_guide)

        try {
            val mBehaviorField = bottomSheetDialog.javaClass.getDeclaredField("mBehavior")
            mBehaviorField.isAccessible = true
            val behavior = mBehaviorField.get(bottomSheetDialog) as BottomSheetBehavior<*>
            behavior.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
                override fun onStateChanged(bottomSheet: View, newState: Int) {
                    //在拖拽状态下设置为收缩模式，可去掉默认的拖拽样式
                    if (newState == BottomSheetBehavior.STATE_DRAGGING) {
                        behavior.state = BottomSheetBehavior.STATE_COLLAPSED
                    }
                }

                override fun onSlide(bottomSheet: View, slideOffset: Float) {
                }
            })
        } catch (e: NoSuchFieldException) {
            e.printStackTrace()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        }

        setupView()

        return bottomSheetDialog
    }

    private fun setupView() {
        val viewPager = bottomSheetDialog.findViewById<ViewPager>(R.id.viewPager)
        viewPager.adapter = BottomGuideViewPagerAdapter(this.context!!)
        viewPager.addOnPageChangeListener(OnViewPageChangeListener())

        val ivClose= bottomSheetDialog.findViewById<AppCompatImageView>(R.id.ivClose)
        Log.d("dialogfragment", " ivClose = $ivClose")
        ivClose.setOnClickListener {
            Log.d("dialogfragment", " 点击关闭 isShowing: ${bottomSheetDialog.isShowing}")
            if (bottomSheetDialog.isShowing) {
                bottomSheetDialog.dismiss()
            }
        }

        //可调整indicator选中和非选中时的大小，且选中的indicator始终在中间
//        val indicator = bottomSheetDialog.findViewById<ViewPagerIndicator>(R.id.vpIndicator)
//        indicator.attachToViewPager(viewPager)

        val indicator = bottomSheetDialog.findViewById<CirclePageIndicator>(R.id.vpIndicator)
        indicator.setViewPager(viewPager)
    }

    override fun onStart() {
        super.onStart()
    }

    inner class OnViewPageChangeListener: ViewPager.OnPageChangeListener {
        override fun onPageScrollStateChanged(state: Int) {
        }

        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        }

        override fun onPageSelected(position: Int) {
            when (position) {
                0->{

                }
                1->{

                }
                2->{

                }
                else->{

                }
            }
        }

    }


}