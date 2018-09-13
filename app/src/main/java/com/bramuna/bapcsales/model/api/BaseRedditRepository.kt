package com.bramuna.bapcsales.model.api

import io.reactivex.Single

interface BaseRedditRepository {
    fun getNewestSales(): Single<List<PostData>>
    fun getHotestSales(): Single<List<PostData>>
}