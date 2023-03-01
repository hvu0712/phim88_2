package com.example.phim88.base

import android.accounts.NetworkErrorException
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.findNavController
import com.example.phim88.R
import com.example.phim88.exceptions.NetworkException
import com.example.phim88.exceptions.ServiceException

abstract class BaseActivity : AppCompatActivity(), IBaseViewMain {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getContentViewId)
        initializeView(savedInstanceState)
        initializeComponents()
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    private fun getCurrentFragment() : Fragment? {
        val currentNavHost = supportFragmentManager.findFragmentById(R.id.hostNavigation)
        val currentFragmentClassName =
            (currentNavHost!!.findNavController().currentDestination as FragmentNavigator.Destination).className
        return currentNavHost.childFragmentManager.fragments.filterNotNull().find {
            it.javaClass.name == currentFragmentClassName
        }
    }

    fun handleBusinessException(throwable: Throwable) {
        if (throwable is NetworkException) {
            return
        }
        if (throwable is ServiceException) {
            return
        }
    }
}