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
import android.widget.TextView


/**
 * @author zongkaili
 * @date 2018/9/7
 * @desc: 用于显示在底部的引导DialogFragment
 */
class BottomAddCardDialogFragment : BottomSheetDialogFragment() {
    private lateinit var bottomSheetDialog: Dialog
    private var mAddCardListener: AddCardListener? = null
    public interface AddCardListener {
        fun onLookAddCardProcess()
    }
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        bottomSheetDialog = super.onCreateDialog(savedInstanceState)
        bottomSheetDialog.setContentView(R.layout.dialog_fragment_bottom_add_card)

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
        val ivClose= bottomSheetDialog.findViewById<AppCompatImageView>(R.id.ivClose)
        Log.d("dialogfragment", " ivClose = $ivClose")
        ivClose.setOnClickListener {
            Log.d("dialogfragment", " 点击关闭 isShowing: ${bottomSheetDialog.isShowing}")
            if (bottomSheetDialog.isShowing) {
                bottomSheetDialog.dismiss()
            }
        }

        val tvLookAddCardProcess = bottomSheetDialog.findViewById<TextView>(R.id.tvLookAddCardProcess)
        tvLookAddCardProcess.setOnClickListener {
            mAddCardListener?.onLookAddCardProcess()
        }
    }

    override fun onStart() {
        super.onStart()
    }

    public fun setAddCardListener(listener: AddCardListener) {
        mAddCardListener = listener
    }

}