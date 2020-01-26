package com.aniketkadam.heritageplaces

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.aniketkadam.heritageplaces.data.HeritagePlace
import com.jraska.livedata.test
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainVmTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    lateinit var mainVm: MainVm

    @Before
    fun setup() {
        mainVm = MainVm(HeritagePlaceRepository(object : IHeritageListLoader {
            override val data: List<HeritagePlace> = emptyList()
        }))
    }

    @Test
    fun `the vm executes a load and returns content`() {
        mainVm.viewState.test().assertValue { it is ScreenLce.HeritageListScreen }
    }
}