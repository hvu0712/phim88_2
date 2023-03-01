package com.example.phim88.view

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.os.Handler
import android.provider.SyncStateContract
import androidx.navigation.fragment.findNavController
import androidx.vectordrawable.graphics.drawable.Animatable2Compat
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
import com.example.phim88.R
import com.example.phim88.base.BaseFragment
import com.example.phim88.constants.Constants
import com.example.phim88.databinding.FragmentSplashScreenBinding
import kotlinx.android.synthetic.main.fragment_splash_screen.*

class SplashScreenFragment : BaseFragment<FragmentSplashScreenBinding>() {

    override val getContentViewId: Int = R.layout.fragment_splash_screen

    override fun initializeView(savedInstanceState: Bundle?) {
        motion_layout.transitionToEnd()
        val topLeftAnimationForward =
            AnimatedVectorDrawableCompat.create(requireContext()!!, R.drawable.top_left_liquid_forward)
        val topLeftAnimationReverse =
            AnimatedVectorDrawableCompat.create(requireContext()!!, R.drawable.top_left_liquid_reverse)
        val bottomRightAnimationForward =
            AnimatedVectorDrawableCompat.create(requireContext()!!, R.drawable.bottom_right_liquid_forward)
        val bottomRightAnimationReverse =
            AnimatedVectorDrawableCompat.create(requireContext()!!, R.drawable.bottom_right_liquid_reverse)
        val topLeftImageView = imageTopLeft.apply {
            setImageDrawable(topLeftAnimationForward)
        }
        val bottomRightImageView = imageBottomRight.apply {
            setImageDrawable(bottomRightAnimationForward)
        }

        topLeftAnimationForward?.registerAnimationCallback(object : Animatable2Compat.AnimationCallback() {
            override fun onAnimationEnd(drawable: Drawable?) {
                topLeftImageView.setImageDrawable(topLeftAnimationReverse)
                topLeftAnimationReverse?.start()

            }
        })
        topLeftAnimationReverse?.registerAnimationCallback(object : Animatable2Compat.AnimationCallback() {
            override fun onAnimationEnd(drawable: Drawable?) {
                topLeftImageView.setImageDrawable(topLeftAnimationForward)
                topLeftAnimationForward?.start()
            }
        })

        bottomRightAnimationForward?.registerAnimationCallback(object : Animatable2Compat.AnimationCallback() {
            override fun onAnimationEnd(drawable: Drawable?) {
                bottomRightImageView.setImageDrawable(bottomRightAnimationReverse)
                bottomRightAnimationReverse?.start()
            }
        })
        bottomRightAnimationReverse?.registerAnimationCallback(object : Animatable2Compat.AnimationCallback() {
            override fun onAnimationEnd(drawable: Drawable?) {
                bottomRightImageView.setImageDrawable(bottomRightAnimationForward)
                bottomRightAnimationForward?.start()
            }
        })
        topLeftAnimationForward?.start()
        bottomRightAnimationForward?.start()
    }

    override fun initializeComponents() {
        TODO("Not yet implemented")
    }

    override fun onResume() {
        super.onResume()
        Handler().postDelayed({
            view?.let {
                findNavController().navigate(R.id.actionSplashToHome)
            }
        }, Constants.TIME_DELAY)
    }

    override fun onBackPressed(): Boolean = true
}