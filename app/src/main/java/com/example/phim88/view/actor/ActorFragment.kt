package com.example.phim88.view.actor

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.example.phim88.R
import com.example.phim88.base.ViewModelBaseFragment
import com.example.phim88.databinding.FragmentActorInfoBinding

/**
 * Created by Admin on 3/9/2023.
 * @author vup1912@gmail.com
 */
class ActorFragment : ViewModelBaseFragment<ActorViewModel, FragmentActorInfoBinding>() {
    override val viewModel: ActorViewModel by viewModels()
    private val actor by lazy {
        arguments?.let {

        }
    }
    override val getContentViewId: Int = R.layout.fragment_actor_info

    override fun initializeView(savedInstanceState: Bundle?) {
        TODO("Not yet implemented")
    }

    override fun initializeComponents() {
        TODO("Not yet implemented")
    }
}