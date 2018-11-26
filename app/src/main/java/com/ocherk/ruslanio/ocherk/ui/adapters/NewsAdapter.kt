package com.ocherk.ruslanio.ocherk.ui.adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ocherk.ruslanio.ocherk.R
import com.ocherk.ruslanio.ocherk.data.local.model.Article
import com.ocherk.ruslanio.ocherk.databinding.ActivityMainBinding
import com.ocherk.ruslanio.ocherk.databinding.ItemArticleBinding
import java.util.*

class NewsAdapter() : RecyclerView.Adapter<NewsAdapter.ArticleHolder>() {

    var articles: List<Article> = Collections.emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var onItemClickListener : View.OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemArticleBinding>(inflater, R.layout.item_article, parent, false)
        return ArticleHolder(binding)
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    override fun onBindViewHolder(holder: ArticleHolder, position: Int) {
        holder.bind(articles[position])
    }

    inner class ArticleHolder(val binding: ItemArticleBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(article: Article) {
            binding.article = article
            binding.executePendingBindings()
            binding.listener = onItemClickListener
        }
    }
}