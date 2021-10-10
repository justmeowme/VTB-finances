package com.example.vtb_finances.ui.utils;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GridMarginItemDecoration extends RecyclerView.ItemDecoration {

    private int marginSize;
    private int spanCount;

    public GridMarginItemDecoration(int marginSize, int spanCount) {
        this.marginSize = marginSize;
        this.spanCount = spanCount;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        if (parent.getChildAdapterPosition(view) < spanCount) {
            outRect.top = marginSize;
        }
        if (parent.getChildAdapterPosition(view) % spanCount == 0) {
            outRect.left = marginSize;
        } else {
            outRect.left = marginSize / spanCount;
        }
        if (parent.getChildAdapterPosition(view) % spanCount == spanCount - 1) {
            outRect.right = marginSize;
        } else {
            outRect.right = marginSize / spanCount;
        }
        outRect.bottom = marginSize;
    }
}
