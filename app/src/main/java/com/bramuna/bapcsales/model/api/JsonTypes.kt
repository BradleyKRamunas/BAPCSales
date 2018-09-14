package com.bramuna.bapcsales.model.api

import com.squareup.moshi.Json

data class SubredditPosts(
        @field:Json(name = "kind") val kind: String,
        @field:Json(name = "data") val data: InnerSubredditData)

data class InnerSubredditData(
        @field:Json(name = "children") val children: List<SalePost>)

data class SalePost(
        @field:Json(name = "kind") val kind: String,
        @field:Json(name = "data") val data: PostData)

data class PostData(
        @field:Json(name = "title") val title: String? = "No Title", // post title
        @field:Json(name = "hide_score") val hide_score: Boolean = false, // whether the post's score is hidden
        @field:Json(name = "domain") val domain: String? = "No Domain", // domain of the link (i.e. amazon.com)
        @field:Json(name = "link_flair_text") val link_flair_text: String? = "No Flair", // text of the flair, determines sale type
        @field:Json(name = "score") val score: Int = 0, // current score of the post
        @field:Json(name = "over_18") val over_18: Boolean = false, // indicates whether sale has expired (not enforced)
        @field:Json(name = "author") val author: String? = "No Author", // who created the post
        @field:Json(name = "num_comments") val num_comments: Int = 0, // number of comments in the post
        @field:Json(name = "url") val url: String? = "No URL", // post url
        @field:Json(name = "created_utc") val created_utc: Double = 0.0) // number of |seconds|!! since epoch (NOT milliseconds!)
