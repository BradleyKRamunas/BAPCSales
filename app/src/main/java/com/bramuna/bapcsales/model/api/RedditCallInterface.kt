package com.bramuna.bapcsales.model.api

import io.reactivex.Single
import retrofit2.http.GET

interface RedditCallInterface {
    @GET("/r/buildapcsales/new/.json") fun getNewest(): Single<SubredditPosts>
    @GET("/r/buildapcsales/hot/.json") fun getHotest(): Single<SubredditPosts>
}