package com.example.phim88.base

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.AndroidViewModel

/**
 * Created by Admin on 2/28/2023.
 * @author vup1912@gmail.com
 */
abstract class ViewModelBaseFragment <VM : AndroidViewModel, VB: ViewDataBinding> : BaseFragment<VB>(){
    protected abstract val viewModel: VM
}