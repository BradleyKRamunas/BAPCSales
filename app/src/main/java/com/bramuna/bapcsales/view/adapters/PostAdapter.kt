package com.bramuna.bapcsales.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bramuna.bapcsales.R
import com.bramuna.bapcsales.model.api.PostData
import kotlinx.android.synthetic.main.view_postcard.view.*

class PostAdapter(private val contents: MutableList<PostData>): RecyclerView.Adapter<PostAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_postcard, parent, false))

    override fun getItemCount() = contents.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.setContent(contents[position])

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val title: TextView? = itemView.viewholder_textview_title
        private val postDate: TextView? = itemView.viewholder_textview_posteddate
        private val domain: TextView? = itemView.viewholder_textview_domain
        private val votes: TextView? = itemView.viewholder_textview_votes
        private val comments: TextView? = itemView.viewholder_textview_comments

        fun setContent(content: PostData) {
            title?.text = content.title
            postDate?.text = content.postedOn
            domain?.text = content.domain
            votes?.text = content.score.toString()
            comments?.text = content.commentCount.toString()
        }
    }
}
