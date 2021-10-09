package com.example.vtb_finances.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.vtb_finances.R;
import com.example.vtb_finances.databinding.ItemNewsBinding;
import com.example.vtb_finances.model.News;

import java.util.List;

class NewsViewHolder extends RecyclerView.ViewHolder {

    private final ItemNewsBinding binding;

    public NewsViewHolder(ItemNewsBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(News news) {
        binding.itemNewsContent.setText(news.getContent());
        Glide.with(itemView)
                .load(news.getImage())
                .into(binding.itemNewsStockImage);
        binding.itemNewsStockName.setText(news.getTitle());
    }
}

class HeaderVH extends RecyclerView.ViewHolder {
    public HeaderVH(@NonNull View itemView) {
        super(itemView);
    }
}

public class NewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<News> news;

    public NewsAdapter(List<News> news) {
        this.news = news;
    }

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0)
            return 0;
        else
            return 1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        if (viewType == 1) {
            ItemNewsBinding binding = ItemNewsBinding.inflate(layoutInflater, parent, false);
            return new NewsViewHolder(binding);
        } else {
            return new HeaderVH(layoutInflater.inflate(R.layout.item_news_header, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof NewsViewHolder) {
            NewsViewHolder newsViewHolder = (NewsViewHolder) holder;
            newsViewHolder.bind(news.get(position - 1));
        }
    }

    @Override
    public int getItemCount() {
        return news.size() == 0 ? 0 : news.size() + 1;
    }
}
