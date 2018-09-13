package com.bramuna.bapcsales.model

import android.util.Log
import com.bramuna.bapcsales.model.api.BaseRedditRepository
import com.bramuna.bapcsales.model.api.PostData
import io.reactivex.Single

object DataRepository: BaseDataRepository {

    private var baseRedditRepository: BaseRedditRepository? = null

    /**
     * init() MUST be called prior to using this object, otherwise a null-pointer exception will be raised when using any of its member functions
     * This function acts as a function injection for all the dependencies this object requires
     */
    override fun init(baseRedditRepository: BaseRedditRepository) {
        this.baseRedditRepository = baseRedditRepository
    }

    override fun getHotestSales(): Single<List<PostData>> {
        return baseRedditRepository!!.getHotestSales()
    }

    override fun getNewestSales(): Single<List<PostData>> {
        return baseRedditRepository!!.getNewestSales()
    }

}