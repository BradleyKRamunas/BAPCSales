package com.bramuna.bapcsales.model.api

import com.squareup.moshi.Json

data class SubredditPosts(
        @Json(name = "kind") val dataType: String,
        @Json(name = "data") val subredditData: InnerSubredditData)

data class InnerSubredditData(
        @Json(name = "children") val children: List<SalePost>)

data class SalePost(
        @Json(name = "kind") val kind: String,
        @Json(name = "data") val data: PostData)

data class PostData(
        @Json(name = "title") val title: String = "No Title", // post title
        @Json(name = "hide_score") val scoreHidden: Boolean = false, // whether the post's score is hidden
        @Json(name = "domain") val domain: String = "No Domain", // domain of the link (i.e. amazon.com)
        @Json(name = "link_flair_text") val flairText: String = "No Flair", // text of the flair, determines sale type
        @Json(name = "score") val score: Int = 0, // current score of the post
        @Json(name = "over_18") val expired: Boolean = false, // indicates whether sale has expired (not enforced)
        @Json(name = "author") val author: String = "No Author", // who created the post
        @Json(name = "num_comments") val commentCount: Int = 0, // number of comments in the post
        @Json(name = "url") val url: String = "No URL", // post url
        @Json(name = "created_utc") val postedOn: Double = 0.0) // number of |seconds|!! since epoch (NOT milliseconds!)
