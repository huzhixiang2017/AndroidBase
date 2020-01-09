package com.java.base.model.bean;

import android.os.Parcel;

import com.java.base.common.BaseModel;

import java.util.List;

/**
 * Created by chemin on 2018/6/19 17:33.
 * description：
 */
public class ClassifyDetailsBean extends BaseModel {
//    public List<String> listImg = new ArrayList<>();
//    public List<String> listBanner = new ArrayList<>();

    /*{
    "object": [
         { "result": [{
                "code": "227",
                "description": "TEST 提交功能",
                "factoryName": "sd",
                "factorySite": "dsds",
                "imageNames": "banner_1525229860870.jpg,detail_1525229878388.jpg,list_1525229850562.png",
                "ingredients": "ds",
                "items": [
                    {
                        "sku": "2000",
                        "active": true,
                        "flavour": "甜"
                    }
                ],
                "maxPrice": 5,
                "minPrice": 0.8,
                "msrp": 0.9,
                "name": "促销牛奶",
                "originalPrice": 8,
                "productCategory": {
                    "code": "1",
                    "name": "牛奶/饮料",
                    "imageNames": "2_15305003247092.jpg"
                },
                 "retailPrice": 0.9,
                "productionLicense": "ds",
                "productStandards": "s",
                "shelfLife": "dd",
                "shortName": "促销牛奶",
                "spec": "20",
                "storageMethod": "dd",
                "weight": 2,
                "introductionMainTitle": "【牛奶我的最爱】—快来一起分享，为了测试字数，打多点字吧，好累好累好累好累好累好累！",
                "introductionSubTitle": "【只是测试副标题】—，为了测试字数，打多点字吧，好累好累好累好累好累好累！",
                "soldQuantity": 54,
                "supplyPrice": 0.6
            },
    ]
     "image": "7_1530255610855.jpg"
}

 */

    public String code;
    public String description;
    public String factoryName;
    public String factorySite;
    public String imageNames;
    public String ingredients;
//    public List<Items> items;
    public String maxPrice;
    public String minPrice;
    public String msrp;
    public String name;
    public String originalPrice;
//    public ProductCategory productCategory;
    public String productionLicense;
    public String productStandards;
    public String retailPrice;
    public String shelfLife;
    public String shortName;
    public String spec;
    public String storageMethod;
    public String weight;
    public String introductionMainTitle;
    public String introductionSubTitle;
    public String soldQuantity;
    public String supplyPrice;
    public String image;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    public String getFactorySite() {
        return factorySite;
    }

    public void setFactorySite(String factorySite) {
        this.factorySite = factorySite;
    }

    public String getImageNames() {
        return imageNames;
    }

    public void setImageNames(String imageNames) {
        this.imageNames = imageNames;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(String maxPrice) {
        this.maxPrice = maxPrice;
    }

    public String getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(String minPrice) {
        this.minPrice = minPrice;
    }

    public String getMsrp() {
        return msrp;
    }

    public void setMsrp(String msrp) {
        this.msrp = msrp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(String originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getProductionLicense() {
        return productionLicense;
    }

    public void setProductionLicense(String productionLicense) {
        this.productionLicense = productionLicense;
    }

    public String getProductStandards() {
        return productStandards;
    }

    public void setProductStandards(String productStandards) {
        this.productStandards = productStandards;
    }

    public String getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(String retailPrice) {
        this.retailPrice = retailPrice;
    }

    public String getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(String shelfLife) {
        this.shelfLife = shelfLife;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getStorageMethod() {
        return storageMethod;
    }

    public void setStorageMethod(String storageMethod) {
        this.storageMethod = storageMethod;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getIntroductionMainTitle() {
        return introductionMainTitle;
    }

    public void setIntroductionMainTitle(String introductionMainTitle) {
        this.introductionMainTitle = introductionMainTitle;
    }

    public String getIntroductionSubTitle() {
        return introductionSubTitle;
    }

    public void setIntroductionSubTitle(String introductionSubTitle) {
        this.introductionSubTitle = introductionSubTitle;
    }

    public String getSoldQuantity() {
        return soldQuantity;
    }

    public void setSoldQuantity(String soldQuantity) {
        this.soldQuantity = soldQuantity;
    }

    public String getSupplyPrice() {
        return supplyPrice;
    }

    public void setSupplyPrice(String supplyPrice) {
        this.supplyPrice = supplyPrice;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public static Creator<ClassifyDetailsBean> getCREATOR() {
        return CREATOR;
    }


    public ClassifyDetailsBean() {
    }

    protected ClassifyDetailsBean(Parcel in) {
        super(in);
        this.code = in.readString();
        this.description = in.readString();
        this.factoryName = in.readString();
        this.factorySite = in.readString();
        this.imageNames = in.readString();
        this.ingredients = in.readString();
//        this.items = in.createTypedArrayList(Items.CREATOR);
        this.maxPrice = in.readString();
        this.minPrice = in.readString();
        this.msrp = in.readString();
        this.name = in.readString();
        this.originalPrice = in.readString();
//        this.productCategory = in.readParcelable(ProductCategory.class.getClassLoader());
        this.productionLicense = in.readString();
        this.productStandards = in.readString();
        this.retailPrice = in.readString();
        this.shelfLife = in.readString();
        this.shortName = in.readString();
        this.spec = in.readString();
        this.storageMethod = in.readString();
        this.weight = in.readString();
        this.introductionMainTitle = in.readString();
        this.introductionSubTitle = in.readString();
        this.soldQuantity = in.readString();
        this.supplyPrice = in.readString();
        this.image = in.readString();

    }

    @Override
    public String toString() {
        return "ClassifyDetailsBean{" +
                "code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", factoryName='" + factoryName + '\'' +
                ", factorySite='" + factorySite + '\'' +
                ", imageNames='" + imageNames + '\'' +
                ", ingredients='" + ingredients + '\'' +
//                ", items=" + items +
                ", maxPrice='" + maxPrice + '\'' +
                ", minPrice='" + minPrice + '\'' +
                ", msrp='" + msrp + '\'' +
                ", name='" + name + '\'' +
                ", originalPrice='" + originalPrice + '\'' +
//                ", productCategory=" + productCategory +
                ", productionLicense='" + productionLicense + '\'' +
                ", productStandards='" + productStandards + '\'' +
                ", retailPrice='" + retailPrice + '\'' +
                ", shelfLife='" + shelfLife + '\'' +
                ", shortName='" + shortName + '\'' +
                ", spec='" + spec + '\'' +
                ", storageMethod='" + storageMethod + '\'' +
                ", weight='" + weight + '\'' +
                ", introductionMainTitle='" + introductionMainTitle + '\'' +
                ", introductionSubTitle='" + introductionSubTitle + '\'' +
                ", soldQuantity='" + soldQuantity + '\'' +
                ", supplyPrice='" + supplyPrice + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(this.code);
        dest.writeString(this.description);
        dest.writeString(this.factoryName);
        dest.writeString(this.factorySite);
        dest.writeString(this.imageNames);
        dest.writeString(this.ingredients);
//        dest.writeTypedList(this.items);
        dest.writeString(this.maxPrice);
        dest.writeString(this.minPrice);
        dest.writeString(this.msrp);
        dest.writeString(this.name);
        dest.writeString(this.originalPrice);
//        dest.writeParcelable(this.productCategory, flags);
        dest.writeString(this.productionLicense);
        dest.writeString(this.productStandards);
        dest.writeString(this.retailPrice);
        dest.writeString(this.shelfLife);
        dest.writeString(this.shortName);
        dest.writeString(this.spec);
        dest.writeString(this.storageMethod);
        dest.writeString(this.weight);
        dest.writeString(this.introductionMainTitle);
        dest.writeString(this.introductionSubTitle);
        dest.writeString(this.soldQuantity);
        dest.writeString(this.supplyPrice);
        dest.writeString(this.image);
    }



    public static final Creator<ClassifyDetailsBean> CREATOR = new Creator<ClassifyDetailsBean>() {
        @Override
        public ClassifyDetailsBean createFromParcel(Parcel source) {
            return new ClassifyDetailsBean(source);
        }

        @Override
        public ClassifyDetailsBean[] newArray(int size) {
            return new ClassifyDetailsBean[size];
        }
    };
}
