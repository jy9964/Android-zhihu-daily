package com.kim.zhihudailynews.common.support.recyclerview;

import androidx.core.view.GestureDetectorCompat;
import androidx.recyclerview.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Support RecyclerView Item Click Event
 *
 * @author kim
 * @version 1.0.0
 */
public abstract class RecyclerItemClickListener implements RecyclerView.OnItemTouchListener {

    private GestureDetectorCompat mGestureDetector;
    protected RecyclerView mRecyclerView;

    public RecyclerItemClickListener(){}

    public RecyclerItemClickListener(RecyclerView recyclerView){
        this.mRecyclerView = recyclerView;
        this.mGestureDetector = new GestureDetectorCompat(mRecyclerView.getContext(), new GestureListener());
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        this.mGestureDetector.onTouchEvent(e);
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        this.mGestureDetector.onTouchEvent(e);
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        // do nothing....
    }

    /**
     * 待实现click事件
     * @param holder
     */
    public abstract void onItemClick(RecyclerView.ViewHolder holder);

    /**
     * 手势监听器,
     */
    private class GestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            View child = mRecyclerView.findChildViewUnder(e.getX(), e.getY());
            if (child != null) {
                RecyclerView.ViewHolder VH = mRecyclerView.getChildViewHolder(child);
                onItemClick(VH);
            }
            return true;
        }

        @Override
        public void onLongPress(MotionEvent e) {
            View child = mRecyclerView.findChildViewUnder(e.getX(), e.getY());
            if (child != null) {
                RecyclerView.ViewHolder VH = mRecyclerView.getChildViewHolder(child);
                onItemClick(VH);
            }
        }
    }
}
