package com.kim.zhihudailynews.news.api;

import com.kim.zhihudailynews.news.entity.News;
import com.kim.zhihudailynews.news.entity.News4List;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * 新闻类API
 *
 * @author kim
 * @version 1.0.0
 */
public interface NewsService {

    @GET("news/latest")
    Observable<News4List> fetchLatestNews();

    @GET("news/before/{date}")
    Observable<News4List> fetchHistoryNews(@Path("date") String date);

    @GET("news/{id}")
    Observable<News> loadNews(@Path("id") int id);

    @GET("start-image/1080*1776")
    Observable<ResponseBody> loadStartImage();
}
