package com.example.phim88.view.detail

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.os.Bundle
import android.util.SparseArray
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import at.huber.youtubeExtractor.VideoMeta
import at.huber.youtubeExtractor.YouTubeExtractor
import at.huber.youtubeExtractor.YtFile
import com.example.phim88.R
import com.example.phim88.base.ViewModelBaseFragment
import com.example.phim88.utils.StringUtils
import com.example.phim88.databinding.FragmentDetailBinding
import com.example.phim88.utils.PlayManager
import kotlinx.android.synthetic.main.fragment_detail.*
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by Admin on 3/9/2023.
 * @author vup1912@gmail.com
 */
open class DetailMovieFragment : ViewModelBaseFragment<DetailMovieViewModel, FragmentDetailBinding>() {
    private val movie by lazy {
        arguments?.let {
            DetailMovieFragmentArgs.fromBundle(it).movie
        }
    }
    private lateinit var playManager: PlayManager
    override val viewModel: DetailMovieViewModel by viewModel()

    override val getContentViewId: Int = R.layout.fragment_detail

    override fun initializeView(savedInstanceState: Bundle?) {
        movie?.let {
            viewDataBinding.item = movie
        }
        viewDataBinding.lifecycleOwner = this
        viewDataBinding.viewModel = viewModel
    }

    private fun extractYoutubeUrl(url: String) {
        @SuppressLint("StaticFieldLeak")
        val mExtractor = object : YouTubeExtractor(requireContext()!!) {
            override fun onExtractionComplete(
                ytFiles: SparseArray<YtFile>?,
                videoMeta: VideoMeta?
            ) {
                ytFiles?.let {
                    if (::playManager.isInitialized) {
                        playManager.release()
                        playManager.init(requireContext()!!, details_backdrop_scrim, ytFiles.get(22).url)
                    }
                }
            }
        }
        mExtractor.extract(url, true, true)
    }

    override fun initializeComponents() {
        playManager = PlayManager()
        val adapter = ViewpagerFragmentAdapter(requireContext()!!, childFragmentManager)
        viewDataBinding.viewPager?.adapter = adapter
        viewDataBinding.viewPager?.offscreenPageLimit = 2
        viewDataBinding.tabLayout?.setupWithViewPager(viewDataBinding.viewPager)
        initAdapter(adapter)
    }

    private fun initAdapter(adapter: ViewpagerFragmentAdapter) {
        val fragmens = ArrayList<Fragment>()
        val fragmentTrailer = TrailerFragment.newInstance()
        fragmentTrailer.setOnTrailerClickListener {
            extractYoutubeUrl(StringUtils.getUrlYoutube(it.key))
        }
        fragmentTrailer.setOnFirstTrailerListener {
            extractYoutubeUrl(StringUtils.getUrlYoutube(it))
        }
        val fragmentCast=CastFragment.newInstance()
        fragmentCast.setOnCasterClickListener {
            val directions=DetailMovieFragmentDirections.actDetailToActorInfo(it)
            findNavController().navigate(directions)

        }
        fragmens.add(fragmentTrailer)
        fragmens.add(fragmentCast)
        fragmens.add(ProductFragment.newInstance())
        adapter.submitData(fragmens)
    }

    override fun onPause() {
        super.onPause()
        if (::playManager.isInitialized) playManager.reset()
    }

    override fun onDestroy() {
        if (::playManager.isInitialized) playManager.release()
        super.onDestroy()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        val currentPosistion = resources.configuration.orientation
        if (currentPosistion == Configuration.ORIENTATION_LANDSCAPE) {
            hideSystemUiFullScreen()
        } else {
            hideSystemUi()
        }
    }

    private fun hideSystemUiFullScreen() {
        details_backdrop_scrim?.let {
            it.systemUiVisibility = (View.SYSTEM_UI_FLAG_LOW_PROFILE
                    or View.SYSTEM_UI_FLAG_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)
        }
    }

    private fun hideSystemUi() {
        details_backdrop_scrim?.let {
            it.systemUiVisibility = (View.SYSTEM_UI_FLAG_LOW_PROFILE
                    or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)
        }
    }
}