package com.example.phim88.view.detail

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.phim88.R
import com.example.phim88.base.ViewModelBaseFragment
import com.example.phim88.data.dto.CastDTO
import com.example.phim88.databinding.FragmentDetailBinding
import com.example.phim88.databinding.FragmentProductBinding
import com.example.phim88.view.adapter.CastAdapter
import com.example.phim88.widget.SpaceItemDecoration
import kotlinx.android.synthetic.main.fragment_actor.*
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
        val castAdapter = CastAdapter{
            if (::onCasterClick.isInitialized) onCasterClick.invoke(it)
        }
        recyclerCast.apply {
            layoutManager = GridLayoutManager(context, 3)
            addItemDecoration(SpaceItemDecoration(resources.getDimensionPixelSize(R.dimen.dp_4)))
            this.adapter = castAdapter
        }
        viewModel.detailMovie.observe(this, Observer {
            it?.credits?.let {
                castAdapter.submitList(it.cast)
            }
        })
    }

    override fun initializeComponents() {

    }

    companion object {
        @JvmStatic
        fun newInstance() = CastFragment()
    }

}