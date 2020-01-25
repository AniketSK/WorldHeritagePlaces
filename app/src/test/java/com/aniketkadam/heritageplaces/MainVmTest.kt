package com.aniketkadam.heritageplaces

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
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
        mainVm = MainVm()
    }

    @Test
    fun `the vm begins in a loading state`() {
        mainVm.viewState.test().assertValue(ScreenLce.Loading)
    }
}