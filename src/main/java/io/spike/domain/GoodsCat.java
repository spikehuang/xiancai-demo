package io.spike.domain;

public class GoodsCat {

    private Integer catId;

    private String catName;

    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    @Override
    public String toString() {
        return "GoodsCat{" +
                "catId=" + catId +
                ", catName='" + catName + '\'' +
                '}';
    }
}
