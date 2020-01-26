package com.aniketkadam.heritageplaces

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import com.aniketkadam.heritageplaces.di.MAINACTIVITY_VM
import com.aniketkadam.heritageplaces.heritageplacelist.HeritageListDirections
import com.aniketkadam.heritageplaces.loadingscreen.LoadingFragmentDirections
import dagger.android.support.DaggerAppCompatActivity
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Named

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    @field:Named(MAINACTIVITY_VM)
    lateinit var mainVm: MainVm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainVm.viewState.observe(this, Observer { setActiveFragment(it) })
    }

    private fun setActiveFragment(viewState: ScreenLce?) = with(findNavController(R.id.nav_host)) {
        when (viewState) {
            ScreenLce.Loading -> {
                Timber.d("Is loading")
            } // Loading is the home fragment and currently we never return to it so nothing happens.

            ScreenLce.Error -> safeNavigate(LoadingFragmentDirections.actionLoadingFragmentToErrorFragment())

            is ScreenLce.Content -> safeNavigate(LoadingFragmentDirections.actionLoadingFragmentToHeritageList())

            is ScreenLce.MapsMarker -> safeNavigate(
                HeritageListDirections.actionHeritageListToMapsFragment(
                    viewState.heritagePlace
                )
            )
        }
    }

}

private fun NavController.safeNavigate(d: NavDirections) =
    currentDestination?.getAction(d.actionId)?.let { navigate(d) }
        ?: Timber.e("Invalid route for direction ${d} with id ${d.actionId}")