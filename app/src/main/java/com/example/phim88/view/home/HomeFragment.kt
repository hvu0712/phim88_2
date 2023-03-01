package com.example.phim88.view.home

import android.content.res.Configuration
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.TooltipCompat
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.phim88.MainActivity
import com.example.phim88.R
import com.example.phim88.base.BaseResponse
import com.example.phim88.base.ViewModelBaseFragment
import com.example.phim88.constants.Constants
import com.example.phim88.data.dto.CategoryDTO
import com.example.phim88.data.entity.Movie
import com.example.phim88.databinding.FragmentHomeBinding
import com.example.phim88.utils.CategoryQuery
import com.example.phim88.widget.BackDropView
import com.example.phim88.widget.SpaceItemDecoration
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by Admin on 2/28/2023.
 * @author vup1912@gmail.com
 */
class HomeFragment : ViewModelBaseFragment<HomeViewModel, FragmentHomeBinding>(),
    View.OnClickListener {

    override val viewModel: HomeViewModel by viewModel()

    override val getContentViewId = R.layout.fragment_home

    override fun initializeView(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        setUpToolBar()
    }

    override fun initializeComponents() {
        initGenres()
        initCategory()
    }

    private fun initGenres() {
//        val adapterGenres = GenresAdapter {
//            drawer.closeDrawer(GravityCompat.END)
//            val directions = HomeFragmentDirections.actHomeToMovieByGenres(it)
//            findNavController().navigate(directions)
//        }
        recyclerGenres.apply {
//            this.adapter = adapterGenres
        }
        viewModel.genres.observe(this, Observer {
            handleError(it)
            it.result?.let { genres ->
//                adapterGenres.submitList(genres)
            }
        })
    }

    override fun registerListeners() {
//        buttonFavorite.setOnClickListener(this)
//        buttonAbout.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when (v) {
//            buttonFavorite -> {
//                findNavController().navigate(R.id.actHomeToFavorite)
//            }
//            buttonAbout->{
//                AlertDialogUtil.showAppInfoMessageDialog(context!!,true)
//            }
        }
    }

    override fun onBackPressed(): Boolean {
        if (drawer.isDrawerOpen(GravityCompat.END)) {
            drawer.closeDrawer(GravityCompat.END)
            return true
        }
        return false
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_main, menu)
        val toggleTheme = menu.findItem(R.id.menu_theme)
        val actionView = toggleTheme.actionView
        (actionView as CheckBox?)?.apply {
            setButtonDrawable(R.drawable.ic_dark_theme)
            isChecked = isDarkTheme()
            jumpDrawablesToCurrentState()
            setOnCheckedChangeListener { _, isChecked ->
                postDelayed({
                    AppCompatDelegate.setDefaultNightMode(
                        if (isChecked) AppCompatDelegate.MODE_NIGHT_YES
                        else AppCompatDelegate.MODE_NIGHT_NO
                    )
                    (activity as MainActivity).delegate.applyDayNight()
                }, Constants.TIME_DELAY_CHANGE_MODE)
            }
            TooltipCompat.setTooltipText(this, getString(R.string.title_dark_theme))
        }
        super.onCreateOptionsMenu(menu, inflater)
    }

    private fun isDarkTheme(): Boolean {
        return requireContext()!!.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.menu_search -> {
//            findNavController().navigate(R.id.actHomeToSearch)
            true
        }
        R.id.menu_filter -> {
            drawer.openDrawer(GravityCompat.END)
            true
        }
        else -> super.onOptionsItemSelected(item)

    }

    private fun setUpToolBar() {
        (activity as MainActivity).setSupportActionBar(toolBar)
        toolBar.setNavigationOnClickListener(
            BackDropView(
                requireContext()!!, home, AccelerateDecelerateInterpolator(),
                ContextCompat.getDrawable(requireContext()!!, R.drawable.ic_menu),
                ContextCompat.getDrawable(requireContext()!!, R.drawable.ic_close_menu)
            )
        )
    }

    private fun initCategory() {
        val categories = viewModel.getCategories()
//        val adapter = HomeAdapter({
//            val directions = HomeFragmentDirections.actHomeToMovieByCategory(it.queryType)
//            findNavController().navigate(directions)
//        }, {
//            val directions = HomeFragmentDirections.actHomeToDetail(it)
//            findNavController().navigate(directions)
//
//
//        })
        recyclerView.apply {
            setHasFixedSize(true)
            addItemDecoration(SpaceItemDecoration(resources.getDimensionPixelSize(R.dimen.dp_8)))
            this.adapter = adapter
        }
//        adapter.submitList(categories)
//        categories.forEach { category ->
//            when (category.queryType) {
//                CategoryQuery.POPULAR -> {
//                    observeMovieByCategory(category, adapter, viewModel.moviesPopular)
//                }
//                CategoryQuery.UP_COMING -> {
//                    observeMovieByCategory(category, adapter, viewModel.moviesUpComing)
//                }
//            }
//        }
    }

    private fun observeMovieByCategory(
        category: CategoryDTO,
//        adapter: HomeAdapter,
        data: LiveData<BaseResponse<List<Movie>>>
    ) {
        data.observe(this, Observer {
            handleError(it)
            it.result?.let { movies ->
                category.movies = movies
//                adapter.notifyDataSetChanged()
            }
        })
    }
}
