package com.kim.zhihudailynews.news.contract;

import com.kim.zhihudailynews.common.support.mvp.BasePresenter;
import com.kim.zhihudailynews.common.support.mvp.BaseView;
import com.kim.zhihudailynews.news.entity.News4List;

import java.util.Date;

/**
 * 新闻列表契约类
 *
 * @author kim
 * @version 1.0.0
 */
public interface NewsContract {

    interface Presenter extends BasePresenter{
        /**
         * 拉取最新新闻
         */
        void fetchLatest();

        /**
         * 拉取历史消息
         * @param date 指定日期
         */
        void fetchHistory(Date date);
    }

    interface View extends BaseView<Presenter>{

        void setRefreshing(boolean refreshing);

        void onDataChanged(News4List news4List);

        void onFetchFail();
    }
}
