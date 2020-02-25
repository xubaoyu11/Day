package com.example.day5.entity;

import java.util.List;

public class ShopEntity {

    /**
     * result : [{"commodityId":184,"commodityName":"瑞士军刀双肩包男士背包新款大容量休闲商务旅行电脑包学生书包 USb充电包","masterPic":"http://mobile.bwstudent.com/images/small/commodity/xbsd/sjb/1/1.jpg","price":99,"saleNum":0},{"commodityId":171,"commodityName":"HOTBOOM2018男士双肩包休闲背包潮流学生书包多功能笔记本商务14英寸电脑包5606 时尚灰","masterPic":"http://mobile.bwstudent.com/images/small/commodity/xbsd/dnb/2/1.jpg","price":109,"saleNum":0},{"commodityId":189,"commodityName":"高尔夫GOLF锦纶双肩包男士个性旅行背包大容量电脑背包D8BV33913J","masterPic":"http://mobile.bwstudent.com/images/small/commodity/xbsd/sjb/6/1.jpg","price":179,"saleNum":10},{"commodityId":186,"commodityName":"SWISSGEAR双肩包 防水多功能笔记本电脑包14.6英寸/15.6英寸商务背包男学生书包休闲 SA-9393III","masterPic":"http://mobile.bwstudent.com/images/small/commodity/xbsd/sjb/3/1.jpg","price":99,"saleNum":0},{"commodityId":176,"commodityName":"瑞士军刀大容量背包多功能户外出差旅行包双肩包男15.6英寸笔记本电脑包手提斜挎行李包旅游登山包防泼水 黑色【多功能手提斜跨双肩单肩】","masterPic":"http://mobile.bwstudent.com/images/small/commodity/xbsd/dnb/7/1.jpg","price":119,"saleNum":0}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * commodityId : 184
         * commodityName : 瑞士军刀双肩包男士背包新款大容量休闲商务旅行电脑包学生书包 USb充电包
         * masterPic : http://mobile.bwstudent.com/images/small/commodity/xbsd/sjb/1/1.jpg
         * price : 99
         * saleNum : 0
         */

        private int commodityId;
        private String commodityName;
        private String masterPic;
        private String price;
        private int saleNum;

        public ResultBean(int commodityId, String commodityName, String masterPic, String price, int saleNum) {
            this.commodityId = commodityId;
            this.commodityName = commodityName;
            this.masterPic = masterPic;
            this.price = price;
            this.saleNum = saleNum;
        }

        public int getCommodityId() {
            return commodityId;
        }

        public void setCommodityId(int commodityId) {
            this.commodityId = commodityId;
        }

        public String getCommodityName() {
            return commodityName;
        }

        public void setCommodityName(String commodityName) {
            this.commodityName = commodityName;
        }

        public String getMasterPic() {
            return masterPic;
        }

        public void setMasterPic(String masterPic) {
            this.masterPic = masterPic;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public int getSaleNum() {
            return saleNum;
        }

        public void setSaleNum(int saleNum) {
            this.saleNum = saleNum;
        }
    }
}
