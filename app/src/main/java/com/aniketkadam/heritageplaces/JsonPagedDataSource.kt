package com.aniketkadam.heritageplaces

import androidx.paging.PositionalDataSource
import com.aniketkadam.heritageplaces.data.HeritagePlace
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class JsonPagedDataSource(private val heritageListLoader: IHeritageListLoader) :
    PositionalDataSource<HeritagePlace>() {

    private val disposable = CompositeDisposable()

    /**
     * Called to load a range of data from the DataSource.
     *
     *
     * This method is called to load additional pages from the DataSource after the
     * LoadInitialCallback passed to dispatchLoadInitial has initialized a PagedList.
     *
     *
     * Unlike [.loadInitial], this method must return
     * the number of items requested, at the position requested.
     *
     * @param params Parameters for load, including start position and load size.
     * @param callback Callback that receives loaded data.
     */
    override fun loadRange(
        params: LoadRangeParams,
        callback: LoadRangeCallback<HeritagePlace>
    ) {

        if (!isStartPositionValid(params)) {
            callback.onResult(emptyList())
        } else {
            disposable.add(
                Observable.just(params)
                    .map(::returnParamsWithinRange)
                    .map { heritageListLoader.data.subList(it.first, it.second) }
                    .subscribeOn(Schedulers.computation())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeBy {
                        callback.onResult(it)
                    }
            )
        }
    }

    private fun isStartPositionValid(params: LoadRangeParams): Boolean =
        params.startPosition < heritageListLoader.data.size

    private fun returnParamsWithinRange(params: LoadRangeParams): Pair<Int, Int> {
        val maxSize = heritageListLoader.data.size

        var endPosition: Int = params.startPosition + params.loadSize

        if (endPosition > maxSize) {
            endPosition = maxSize
        }

        return Pair(params.startPosition, endPosition)
    }

    /**
     * Load initial list data.
     *
     *
     * This method is called to load the initial page(s) from the DataSource.
     *
     *
     * Result list must be a multiple of pageSize to enable efficient tiling.
     *
     * @param params Parameters for initial load, including requested start position, load size, and
     * page size.
     * @param callback Callback that receives initial load data, including
     * position and total data set size.
     */
    override fun loadInitial(
        params: LoadInitialParams,
        callback: LoadInitialCallback<HeritagePlace>
    ) {
        assert(!params.placeholdersEnabled) { "This class has not implemented placeholder support yet" }

        Timber.w("Note params.requestedStartPosition is not handled, always beginning from index 0")
        disposable.add(
            Observable.just(params).map {
                heritageListLoader.data.subList(
                    0,
                    params.requestedLoadSize
                )
            }
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy {
                    callback.onResult(it, 0)
                }
        )

    }

}