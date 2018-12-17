package org.java.zpoa.beans;

import java.util.List;

public class TaobaoConpon {
    private ResultsBean results;
    private int total_results;
    private String request_id;

    public ResultsBean getResults() {
        return results;
    }

    public void setResults(ResultsBean results) {
        this.results = results;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }

    public static class ResultsBean {
        private List<TbkCouponBean> tbk_coupon;

        public List<TbkCouponBean> getTbk_coupon() {
            return tbk_coupon;
        }

        public void setTbk_coupon(List<TbkCouponBean> tbk_coupon) {
            this.tbk_coupon = tbk_coupon;
        }

        public static class TbkCouponBean {
            /**
             * category : 16
             * commission_rate : 4.50
             * coupon_click_url : https://uland.taobao.com/coupon/edetail?e=w%2BvZKbkh7rsGQASttHIRqTSVN4gf6otthTzCLZMGOs7bLaGB9uZG%2Bm36n%2F7Mlv61QkbSmDuUTmi2JJCQEL47g5vUa0NW%2FgAcbd76m3V5xpYrzYxUZLrDweXY4%2B%2B8JTtckaLiYNocvZQw8eKZWLUod%2B1LRo38GBz3vWcDIMHLn%2F%2FYhpVVy38fp6zroKjs8vldxfFlZSCevACwmYQwT%2FYTeHui%2Fn%2FQ7Z5VvoDMYzjIDCaH6s3NfzeYtQ%3D%3D&traceId=0b084bc715448586081014970e
             * coupon_end_time : 2018-12-15
             * coupon_info : 满19元减3元
             * coupon_remain_count : 2000
             * coupon_start_time : 2018-12-15
             * coupon_total_count : 2000
             * item_description :
             * item_url : https://detail.tmall.com/item.htm?id=580220390214
             * nick : 商城魅引
             * num_iid : 580220390214
             * pict_url : http://img.alicdn.com/tfscom/i4/694475001/O1CN011moVC1pLOH2OvnX_!!694475001.jpg
             * seller_id : 694475001
             * shop_title : LLSTYLE
             * small_images : {"string":["http://img.alicdn.com/tfscom/i1/694475001/O1CN011moVBzoU2Hun15p_!!694475001.jpg","http://img.alicdn.com/tfscom/i2/694475001/O1CN011moVC0n1G83vOMG_!!694475001.jpg","http://img.alicdn.com/tfscom/i4/694475001/O1CN011moVC3XXxowF3zi_!!694475001.jpg","http://img.alicdn.com/tfscom/i1/694475001/O1CN011moVC1HYejI65g5_!!694475001.jpg"]}
             * title : 港味chic 新款气质套头上衣V领显瘦宽松慵懒风麻花毛衣女装针织衫
             * user_type : 0
             * volume : 1
             * zk_final_price : 49.00
             */

            private int category;
            private String commission_rate;
            private String coupon_click_url;
            private String coupon_end_time;
            private String coupon_info;
            private int coupon_remain_count;
            private String coupon_start_time;
            private int coupon_total_count;
            private String item_description;
            private String item_url;
            private String nick;
            private long num_iid;
            private String pict_url;
            private int seller_id;
            private String shop_title;
            private SmallImagesBean small_images;
            private String title;
            private int user_type;
            private int volume;
            private String zk_final_price;

            public int getCategory() {
                return category;
            }

            public void setCategory(int category) {
                this.category = category;
            }

            public String getCommission_rate() {
                return commission_rate;
            }

            public void setCommission_rate(String commission_rate) {
                this.commission_rate = commission_rate;
            }

            public String getCoupon_click_url() {
                return coupon_click_url;
            }

            public void setCoupon_click_url(String coupon_click_url) {
                this.coupon_click_url = coupon_click_url;
            }

            public String getCoupon_end_time() {
                return coupon_end_time;
            }

            public void setCoupon_end_time(String coupon_end_time) {
                this.coupon_end_time = coupon_end_time;
            }

            public String getCoupon_info() {
                return coupon_info;
            }

            public void setCoupon_info(String coupon_info) {
                this.coupon_info = coupon_info;
            }

            public int getCoupon_remain_count() {
                return coupon_remain_count;
            }

            public void setCoupon_remain_count(int coupon_remain_count) {
                this.coupon_remain_count = coupon_remain_count;
            }

            public String getCoupon_start_time() {
                return coupon_start_time;
            }

            public void setCoupon_start_time(String coupon_start_time) {
                this.coupon_start_time = coupon_start_time;
            }

            public int getCoupon_total_count() {
                return coupon_total_count;
            }

            public void setCoupon_total_count(int coupon_total_count) {
                this.coupon_total_count = coupon_total_count;
            }

            public String getItem_description() {
                return item_description;
            }

            public void setItem_description(String item_description) {
                this.item_description = item_description;
            }

            public String getItem_url() {
                return item_url;
            }

            public void setItem_url(String item_url) {
                this.item_url = item_url;
            }

            public String getNick() {
                return nick;
            }

            public void setNick(String nick) {
                this.nick = nick;
            }

            public long getNum_iid() {
                return num_iid;
            }

            public void setNum_iid(long num_iid) {
                this.num_iid = num_iid;
            }

            public String getPict_url() {
                return pict_url;
            }

            public void setPict_url(String pict_url) {
                this.pict_url = pict_url;
            }

            public int getSeller_id() {
                return seller_id;
            }

            public void setSeller_id(int seller_id) {
                this.seller_id = seller_id;
            }

            public String getShop_title() {
                return shop_title;
            }

            public void setShop_title(String shop_title) {
                this.shop_title = shop_title;
            }

            public SmallImagesBean getSmall_images() {
                return small_images;
            }

            public void setSmall_images(SmallImagesBean small_images) {
                this.small_images = small_images;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getUser_type() {
                return user_type;
            }

            public void setUser_type(int user_type) {
                this.user_type = user_type;
            }

            public int getVolume() {
                return volume;
            }

            public void setVolume(int volume) {
                this.volume = volume;
            }

            public String getZk_final_price() {
                return zk_final_price;
            }

            public void setZk_final_price(String zk_final_price) {
                this.zk_final_price = zk_final_price;
            }

            public static class SmallImagesBean {
                private List<String> string;

                public List<String> getString() {
                    return string;
                }

                public void setString(List<String> string) {
                    this.string = string;
                }
            }
        }
    }
}
