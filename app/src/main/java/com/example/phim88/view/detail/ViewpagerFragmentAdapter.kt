package com.example.phim88.view.detail

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.phim88.R
import com.example.phim88.utils.CurrentPosistion

/**
 * Created by Admin on 3/13/2023.
 * @author vup1912@gmail.com
 */
class ViewpagerFragmentAdapter(val context: Context, fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {
    private var fragments = ArrayList<Fragment>()

    fun submitData(fragments:ArrayList<Fragment>) {
        this.fragments = fragments
        notifyDataSetChanged()
    }

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }

    override fun getPageTitle(position: Int): CharSequence?= when(position){
        CurrentPosistion.TRAILER->context.getString(R.string.title_trailer)
        CurrentPosistion.CASTING->context.getString(R.string.title_casting)
        CurrentPosistion.PRODUCER->context.getString(R.string.title_producer)
        else->super.getPageTitle(position)
    }
}