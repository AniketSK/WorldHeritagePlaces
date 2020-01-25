package com.aniketkadam.heritageplaces

import androidx.paging.PositionalDataSource
import com.aniketkadam.heritageplaces.data.HeritagePlace
import org.hamcrest.Matchers.equalTo
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

class JsonPagedDataSourceTest {

    @get:Rule
    val immediateScheduler = RxImmediateSchedulerRule()

    lateinit var jsonPagedDataSource: JsonPagedDataSource

    @Before
    fun setUp() {
        jsonPagedDataSource = JsonPagedDataSource(TestHeritageListLoader())
    }

    @Test
    fun `loadinitial returns the expected values for 4 values`() {

        val latch = CountDownLatch(1)
        var result: MutableList<HeritagePlace>? = null

        val params = PositionalDataSource.LoadInitialParams(0, 4, 4, false)
        jsonPagedDataSource.loadInitial(params,
            object : PositionalDataSource.LoadInitialCallback<HeritagePlace>() {
                override fun onResult(
                    data: MutableList<HeritagePlace>,
                    position: Int,
                    totalCount: Int
                ) {

                }

                override fun onResult(data: MutableList<HeritagePlace>, position: Int) {
                    result = data
                    latch.countDown()
                }

            }
        )

        latch.await(2, TimeUnit.SECONDS)

        assertThat(
            result?.map { it.id },
            equalTo(listOf(3, 2, 1, 29))
        ) // Checking only the ids instead of entire objects for brevity
    }
}