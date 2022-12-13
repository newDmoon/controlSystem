package com.dnoviy.controlSystem.pojo;

public class GoodForCountAnalyse {
    private String goodName;
    private Integer countOfGoods;
    private Float percentFromAll;

    public GoodForCountAnalyse(String goodName, Integer countOfGoods) {
        this.goodName = goodName;
        this.countOfGoods = countOfGoods;
    }

    public GoodForCountAnalyse() {
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public Integer getCountOfGoods() {
        return countOfGoods;
    }

    public void setCountOfGoods(Integer countOfGoods) {
        this.countOfGoods = countOfGoods;
    }

    public Float getPercentFromAll() {
        return percentFromAll;
    }

    public void setPercentFromAll(Float percentFromAll) {
        this.percentFromAll = percentFromAll;
    }
}
