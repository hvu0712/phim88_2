package com.example.phim88.view.actor

import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.motion.widget.MotionScene

/**
 * Created by Admin on 3/9/2023.
 * @author vup1912@gmail.com
 */
interface MotionLayoutListener : MotionLayout.TransitionListener {
    fun allowsTransition(p0: MotionScene.Transition?): Boolean = true
    override fun onTransitionStarted(motionLayout: MotionLayout?, startId: Int, endId: Int) {
    }

    override fun onTransitionChange(
        motionLayout: MotionLayout?,
        startId: Int,
        endId: Int,
        progress: Float
    ) {
    }

    override fun onTransitionCompleted(motionLayout: MotionLayout?, currentId: Int) {
    }

    override fun onTransitionTrigger(
        motionLayout: MotionLayout?,
        triggerId: Int,
        positive: Boolean,
        progress: Float
    ) {
    }
}