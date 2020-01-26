package com.aniketkadam.heritageplaces

import androidx.paging.PositionalDataSource
import com.aniketkadam.heritageplaces.data.HeritagePlace
import com.google.gson.Gson
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
    var jsonPagedDataSourceSize: Int = 0

    @Before
    fun setUp() {
        val loader = HeritageListLoader(
            ClassLoader.getSystemResourceAsStream("real.planet.world-heritage.json"),
            Gson()
        )
        jsonPagedDataSourceSize = loader.data.size
        jsonPagedDataSource = JsonPagedDataSource(loader)
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

    @Test
    fun `load range works as expected`() {
        // 3,2,1,29,26,4,27,24,18 are the ids in the list, from the start

        val params = PositionalDataSource.LoadRangeParams(5, 4)
        var result: MutableList<HeritagePlace>? = null
        jsonPagedDataSource.loadRange(
            params,
            object : PositionalDataSource.LoadRangeCallback<HeritagePlace>() {
                /**
                 * Called to pass loaded data from [.loadRange].
                 *
                 * @param data List of items loaded from the DataSource. Must be same size as requested,
                 * unless at end of list.
                 */
                override fun onResult(data: MutableList<HeritagePlace>) {
                    result = data
                }
            })

        assertThat(result?.map { it.id }, equalTo(listOf(4, 27, 24, 18)))
    }

    @Test
    fun `load range works when more items are requested than exist`() {
        val params = PositionalDataSource.LoadRangeParams(jsonPagedDataSourceSize - 1, 20)
        var result: MutableList<HeritagePlace>? = null
        jsonPagedDataSource.loadRange(
            params,
            object : PositionalDataSource.LoadRangeCallback<HeritagePlace>() {
                /**
                 * Called to pass loaded data from [.loadRange].
                 *
                 * @param data List of items loaded from the DataSource. Must be same size as requested,
                 * unless at end of list.
                 */
                override fun onResult(data: MutableList<HeritagePlace>) {
                    result = data
                }
            })

        assertThat(result?.map { it.id }, equalTo(listOf(1474)))
    }
}