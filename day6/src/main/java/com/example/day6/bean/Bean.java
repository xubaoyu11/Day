package com.example.day6.bean;

import com.stx.xhb.xbanner.entity.SimpleBannerInfo;

import java.util.List;

/**
 * @ProjectName: My Application4
 * @Package: com.example.day6.bean
 * @ClassName: Bean
 * @Description: java类作用描述
 * @Author: deshuai
 * @CreateDate: 2020/2/26 21:04
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/2/26 21:04
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class Bean {

    private List<ResultsBean> results;

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        private List<BannerBean> banner;
        private List<NewsistBean> newsist;

        public List<BannerBean> getBanner() {
            return banner;
        }

        public void setBanner(List<BannerBean> banner) {
            this.banner = banner;
        }

        public List<NewsistBean> getNewsist() {
            return newsist;
        }

        public void setNewsist(List<NewsistBean> newsist) {
            this.newsist = newsist;
        }

        public static class BannerBean extends SimpleBannerInfo {

            private String imageurl;

            public String getImageurl() {
                return imageurl;
            }

            public void setImageurl(String imageurl) {
                this.imageurl = imageurl;
            }

            @Override
            public Object getXBannerUrl() {
                return null;
            }
        }

        public static class NewsistBean {


            private String title;
            private String content;
            private String author;
            private String time;
            private String image;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }
        }
    }
}


