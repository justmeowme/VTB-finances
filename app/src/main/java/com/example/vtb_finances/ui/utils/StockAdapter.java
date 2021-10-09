package com.example.vtb_finances.ui.utils;

import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.vtb_finances.R;
import com.example.vtb_finances.model.Stock;
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou;

import java.util.ArrayList;
import java.util.List;

class StockViewHolder extends RecyclerView.ViewHolder {

    private RequestManager requestManager;
    private ImageView imageView;
    private TextView nameTV;
    private TextView purchaseCostTV;
    private TextView sellingPrice;

    public StockViewHolder(@NonNull View itemView, RequestManager requestManager) {
        super(itemView);
        this.imageView = itemView.findViewById(R.id.item_stock_image);
        nameTV = itemView.findViewById(R.id.item_stock_name);
        purchaseCostTV = itemView.findViewById(R.id.purchase_cost);
        sellingPrice = itemView.findViewById(R.id.selling_price);
    }

    public void bind(Stock stock) {
        Log.d("StockVH", "imageView " + (imageView == null));

        Glide.with(itemView.getContext())
                .load(stock.getImage())
                .into(imageView);
        nameTV.setText(stock.getName());
        purchaseCostTV.setText(String.valueOf(stock.getPurchaseCost()));
        sellingPrice.setText(String.valueOf(stock.getSellingPrice()));
    }
}

public class StockAdapter extends RecyclerView.Adapter<StockViewHolder> {

    private List<Stock> stocks = new ArrayList<>();
    private final RequestManager requestManager;

    public StockAdapter(List<Stock> stocks, RequestManager requestManager) {
        super();
        this.stocks = stocks;
        this.requestManager = requestManager;
    }

    public List<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }

    @NonNull
    @Override
    public StockViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_stock, parent, false);
        return new StockViewHolder(view, requestManager);
    }

    @Override
    public void onBindViewHolder(@NonNull StockViewHolder holder, int position) {
        holder.bind(stocks.get(position));
    }

    @Override
    public int getItemCount() {
        return stocks.size();
    }
}
