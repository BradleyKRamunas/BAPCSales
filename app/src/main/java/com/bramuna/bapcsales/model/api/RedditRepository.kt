package com.bramuna.bapcsales.model.api

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

class RedditRepository: BaseRedditRepository {

    private val redditApi: RedditCallInterface by lazy {
        val logger = HttpLoggingInterceptor()
        logger.level = HttpLoggingInterceptor.Level.BODY
        val moshi = Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()
        val client: OkHttpClient = OkHttpClient.Builder()
                .addInterceptor { chain ->
                    val originalRequest: Request = chain.request()
                    val newRequest = originalRequest.newBuilder()
                            .header("User-Agent", "android:com.bramuna.bapcsales:v1.0.0 (by /r/justryintolearn)")
                            .build()
                    chain.proceed(newRequest)
                }
                .addInterceptor(logger)
                .build()
        val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl("https://www.reddit.com")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .client(client)
                .build()
        retrofit.create(RedditCallInterface::class.java)
    }

    override fun getNewestSales(): Single<List<PostData>> {
        val allPosts: List<SalePost> = redditApi.getNewest().subscribeOn(Schedulers.io()).blockingGet().data.children
        return Single.just(allPosts.map { it.data })
    }

    override fun getHotestSales(): Single<List<PostData>> {
        val parent = redditApi.getHotest().subscribeOn(Schedulers.io()).blockingGet()
        val allPosts: List<SalePost> = parent.data.children
        return Single.just(allPosts.map { it.data })
    }

}