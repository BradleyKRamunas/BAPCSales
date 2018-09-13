package com.bramuna.bapcsales.model

import com.bramuna.bapcsales.model.api.BaseRedditRepository
import com.bramuna.bapcsales.model.api.PostData
import io.reactivex.Single

interface BaseDataRepository {
    fun init(baseRedditRepository: BaseRedditRepository)
    fun getHotestSales(): Single<List<PostData>>
    fun getNewestSales(): Single<List<PostData>>
}