package com.aniketkadam.heritageplaces.heritageplacelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.aniketkadam.heritageplaces.MainVm
import com.aniketkadam.heritageplaces.PagedHeritagePlaceAdapter
import com.aniketkadam.heritageplaces.R
import com.aniketkadam.heritageplaces.ScreenLce
import com.aniketkadam.heritageplaces.data.HeritagePlace
import com.aniketkadam.heritageplaces.di.MAINACTIVITY_FRAGMENT_VM
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.layout_heritage_list.*
import javax.inject.Inject
import javax.inject.Named

class HeritageList : DaggerFragment() {

    @Inject
    @field:Named(MAINACTIVITY_FRAGMENT_VM)
    lateinit var mainVm: MainVm

    private val adapter = PagedHeritagePlaceAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.layout_heritage_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        heritageListRecyclerview.adapter = adapter
        mainVm.viewState.observe(viewLifecycleOwner, Observer { renderState(it) })
    }

    private fun renderState(viewState: ScreenLce?) {
        if (viewState is ScreenLce.Content) {
            viewState.heritagePagedList.observe(viewLifecycleOwner, Observer { renderList(it) })
        }
    }

    private fun renderList(pagedList: PagedList<HeritagePlace>?) {
        adapter.submitList(pagedList)
    }
}