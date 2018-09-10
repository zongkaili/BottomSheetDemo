package com.kelly.bottomsheet

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.kelly.bottomsheet.databinding.ActivityMainBinding
import com.kelly.bottomsheet.dialog.BottomAddCardDialogFragment
import com.kelly.bottomsheet.dialog.BottomGuideDialogFragment

class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        mBinding.show.setOnClickListener {
            val bottomAddCardFragment = BottomAddCardDialogFragment()
            bottomAddCardFragment.show(supportFragmentManager, BottomAddCardDialogFragment::class.java.simpleName)
            bottomAddCardFragment.setAddCardListener(object: BottomAddCardDialogFragment.AddCardListener {
                override fun onLookAddCardProcess() {
                    val bottomGuideDialogFragment = BottomGuideDialogFragment()
                    bottomGuideDialogFragment.show(supportFragmentManager, BottomGuideDialogFragment::class.java.simpleName)
                }
            })
        }
    }
}
