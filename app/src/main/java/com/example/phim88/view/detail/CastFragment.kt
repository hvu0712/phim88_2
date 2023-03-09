package com.example.phim88.view.detail

import android.os.Bundle
import com.example.phim88.R
import com.example.phim88.base.ViewModelBaseFragment
import com.example.phim88.data.dto.CastDTO
import com.example.phim88.databinding.FragmentDetailBinding
import com.example.phim88.databinding.FragmentProductBinding
import org.koin.android.viewmodel.ext.android.sharedViewModel

/**
 * Created by Admin on 3/9/2023.
 * @author vup1912@gmail.com
 */
class CastFragment : ViewModelBaseFragment<DetailMovieViewModel, FragmentProductBinding>() {
    private lateinit var onCasterClick: (caster: CastDTO) -> Unit

    fun setOnCasterClickListener(casterClick: (caster: CastDTO) -> Unit) {
        this.onCasterClick = casterClick
    }

    override val viewModel: DetailMovieViewModel by sharedViewModel(from ={ requireParentFragment() })

    override val getContentViewId: Int = R.layout.fragment_actor

    override fun initializeView(savedInstanceState: Bundle?) {

    }

    override fun initializeComponents() {

    }

    companion object {
        @JvmStatic
        fun newInstance() = CastFragment()
    }

}