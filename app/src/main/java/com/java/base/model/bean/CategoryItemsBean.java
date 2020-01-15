package com.java.base.model.bean;

import android.os.Parcel;

import com.java.base.common.BaseModel;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>Create Date:</b> 2017/7/4<br>
 * <b>Author:</b> Zhanglei<br>
 * <b>Description:</b> <br>
 */

public class CategoryItemsBean extends BaseModel {
    /**
     * code : 30
     * ProductCategory : {"name":"牛奶饮品"}
     * name : 旺仔牛奶利乐礼盒长草君+钥匙圈
     * spec : 125ml*20
     * weight : 2533
     * minPrice : 64
     * maxPrice : 96
     * msrp : 64
     * bannerImages : 1
     * descriptionImages : 5
     * videos : 0
     * items : [{"sku":"10880","active":true,"flavour":"原味"}]
     * <p>
     * "shortName": "旺旺 煎饼",
     * "description": "15-test-商品简介",
     * "spec": "600g",
     * "weight": 600,
     * "originalPrice": 45.6,
     * "retailPrice": 38,
     * "storageMethod": "15-test-storageMethod",
     * "ingredients": "15-test-ingredients",
     * "shelfLife": "15-test-shelfLife",
     * "productStandards": "15-test-productStandards",
     * "factorySite": "15-test-factorySite",
     * "factoryName": "15-test-factoryName",
     * "productionLicense": "15-test-productionLicense",
     */

    public String code;
    public String imageNames;//4.0.3新增图片字段
//    public ProductItemCategory productCategory;
    public String name;
    public String spec;
    public int weight;
    public double minPrice;
    public double maxPrice;
    public double supplyPrice;
    public double msrp;
    public String shortName;
    public String description;
    public double originalPrice;
    public double retailPrice;
    public String storageMethod;
    public String ingredients;
    public String shelfLife;
    public String productStandards;
    public String factorySite;
    public String factoryName;
    public String productionLicense;
    public long preSaleStart;
    public long preSaleEnd;
    public int preSaleSold;//预定
//    public List<ItemsBean> items;
//    public List<Tags> tags;
    public String wbDiscount;
//    public List<Discount> discounts;
//    public List<ProductCommission> productCommission;
    public double commission;//单商品提成金额
    public int preSaleStock;//开抢数量
//    public int inventory;//库存
    public List<String> banner = new ArrayList<>();
    public List<String> detail = new ArrayList<>();
    public List<String> list = new ArrayList<>();
    public List<String> video = new ArrayList<>();
    public double commissionRate;//单商品提成
    public int signType;
    public int priceEditType;
    public String introductionMainTitle;
    public String introductionSubTitle;
    public int soldQuantity;
    public double discount;
    public double rushPrice;
    public double ceoRushPrice;
    public int status;

    @Override
    public String toString() {
        return "CategoryItemsBean{" +
                "code='" + code + '\'' +
                ", imageNames='" + imageNames + '\'' +
//                ", productCategory=" + productCategory +
                ", name='" + name + '\'' +
                ", spec='" + spec + '\'' +
                ", weight=" + weight +
                ", minPrice=" + minPrice +
                ", maxPrice=" + maxPrice +
                ", supplyPrice=" + supplyPrice +
                ", msrp=" + msrp +
                ", shortName='" + shortName + '\'' +
                ", description='" + description + '\'' +
                ", originalPrice=" + originalPrice +
                ", retailPrice=" + retailPrice +
                ", storageMethod='" + storageMethod + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", shelfLife='" + shelfLife + '\'' +
                ", productStandards='" + productStandards + '\'' +
                ", factorySite='" + factorySite + '\'' +
                ", factoryName='" + factoryName + '\'' +
                ", productionLicense='" + productionLicense + '\'' +
                ", preSaleStart=" + preSaleStart +
                ", preSaleEnd=" + preSaleEnd +
                ", preSaleSold=" + preSaleSold +
//                ", items=" + items +
//                ", tags=" + tags +
                ", wbDiscount='" + wbDiscount + '\'' +
//                ", discounts=" + discounts +
//                ", productCommission=" + productCommission +
                ", commission=" + commission +
                ", preSaleStock=" + preSaleStock +
                ", banner=" + banner +
                ", detail=" + detail +
                ", list=" + list +
                ", video=" + video +
                ", commissionRate=" + commissionRate +
                ", signType=" + signType +
                ", priceEditType=" + priceEditType +
                ", introductionMainTitle='" + introductionMainTitle + '\'' +
                ", introductionSubTitle='" + introductionSubTitle + '\'' +
                ", soldQuantity=" + soldQuantity +
                ", discount=" + discount +
                ", rushPrice=" + rushPrice +
                ", ceoRushPrice=" + ceoRushPrice +
                ", status=" + status +
                '}';
    }

    public CategoryItemsBean() {


    }

    public void setRetailPrice(double retailPrice) {
        this.retailPrice = retailPrice;
    }

   /* public String getImage() {//列表图片
        if (!TextUtils.isEmpty(imageNames)) {
            String[] split = imageNames.split(",");
            list.clear();
            for (int i = 0; i < split.length; i++) {
                String s = split[i];
                if (s.contains("list")) {
                    list.add(s);
                }
            }
            if (list.size() != 0) {
                return Constant.getProductListPath(MyTextUtil.safeStr(code), list.get(0));
            } else {
                return "";
            }
        }
        return "";
    }

    public String getListImg(){
        if (!TextUtils.isEmpty(imageNames)) {
            String[] split = imageNames.split(",");
            if(split.length>1){
                return Constant.getProductListPath(MyTextUtil.safeStr(code), split[0]);
            }
            list.clear();
            for (int i = 0; i < split.length; i++) {
                String s = split[i];
                if (s.contains("list")) {
                    list.add(s);
                }
            }
            if (list.size() != 0) {
                return Constant.getProductListPath(MyTextUtil.safeStr(code), list.get(0));
            } else {
                return "";
            }
        }
        return "";
    }



    public String getPreImage() {//单图

        if (imageNames != null && !TextUtils.isEmpty(imageNames)) {
            String[] split = imageNames.split(",");
            banner.clear();
            for (int i = 0; i < split.length; i++) {
                String s = split[i];
                if (s.contains("banner")) {
                    banner.add(Constant.getProductBannerPath(MyTextUtil.safeStr(code), s));
                }
            }
            if (banner.size() > 0) return banner.get(0);
            else return "";
        }
        return "";
    }

    public String getBanner(String index) {//详情banner
        return Constant.getProductBannerPath(MyTextUtil.safeStr(code), index);
    }

    public List getBannerList() {//bannerList
        if (imageNames != null && !TextUtils.isEmpty(imageNames)) {
            String[] split = imageNames.split(",");
            banner.clear();
            for (int i = 0; i < split.length; i++) {
                String s = split[i];
                if (s.contains("banner")) {
                    banner.add(Constant.getProductBannerPath(MyTextUtil.safeStr(code), s));
                }
            }
            return banner;
        }
        return null;
    }

//    public String getDetail(String index) {//详情多图
//        return Constant.getProductDetailPath(MyTextUtil.safeStr(code), index);
//    }

    public List getDetailList() {//详情多图List
        if (!TextUtils.isEmpty(imageNames)) {
            String[] split = imageNames.split(",");
            detail.clear();
            for (int i = 0; i < split.length; i++) {
                String s = split[i];
                if (s.contains("detail")) {
                    detail.add(Constant.getProductDetailPath(MyTextUtil.safeStr(code), s));
                }
            }
            return detail;
        }
        return null;
    }


    public String getPreSail() {
        if (!TextUtils.isEmpty(imageNames)) {
            String[] split = imageNames.split(",");
            banner.clear();
            for (int i = 0; i < split.length; i++) {
                String s = split[i];
                if (s.contains("banner")) {
                    banner.add(Constant.getPreSailPath(MyTextUtil.safeStr(code), s));
                }
            }
            return banner.get(0);
        }
        return "";
    }

    public String getVideoPath() {
        if (!TextUtils.isEmpty(imageNames)) {
            String[] split = imageNames.split(",");
            video.clear();
            for (int i = 0; i < split.length; i++) {
                String s = split[i];
                if (s.contains(".mp4")) {
                    video.add(s);
                    break;
                }
            }
            if (null != video && video.size() != 0) {
                return Constant.getVideoPath(code, video.get(0));
            }

        }
        return "";
    }

    public String getSharelink(String dealerCode) {
        return Constant.getProductShareLink(dealerCode, code);
    }

    public String getCategoryNone() {//获取分类图片是根据商品类外的categoryCode,
        String category = productCategory.getProductCategory();
        if (category.equals("牛奶/饮料")) {
            return Constant.getProductCategoryNone(String.valueOf(1));
        } else if (category.equals("米果/烘焙")) {
            return Constant.getProductCategoryNone(String.valueOf(2));
        } else if (category.equals("坚果豆类")) {
            return Constant.getProductCategoryNone(String.valueOf(5));
        } else if (category.equals("糖果/果冻")) {
            return Constant.getProductCategoryNone(String.valueOf(4));
        } else if (category.equals("母婴")) {
            return Constant.getProductCategoryNone(String.valueOf(6));
        } else if (category.equals("CEO组合")) {
            return Constant.getProductCategoryNone(String.valueOf(7));
        } else if (category.equals("周边商品")) {
            return Constant.getProductCategoryNone(String.valueOf(8));
        } else if (category.equals("休闲/冰品")) {
            return Constant.getProductCategoryNone(String.valueOf(3));
        } else if (category.equals("热销")) {
            return Constant.getProductCategoryNone(String.valueOf(1));
        } else if (category.equals("新品")) {
            return Constant.getProductCategoryNone(String.valueOf(2));
        } else if (category.equals("促销")) {
            return Constant.getProductCategoryNone(String.valueOf(3));
        }
        return null;
    }

    public ProductItemCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductItemCategory productCategory) {
        this.productCategory = productCategory;
    }*/

    public void setPriceEditType(int priceEditType) {
        this.priceEditType = priceEditType;
    }

    public void setIntroductionMainTitle(String introductionMainTitle) {
        this.introductionMainTitle = introductionMainTitle;
    }

    public void setIntroductionSubTitle(String introductionSubTitle) {
        this.introductionSubTitle = introductionSubTitle;
    }

    /*public List<Tags> getTags() {
        return tags;
    }

    public boolean isHotVisible() {
        boolean flag = false;
        if (tags != null && tags.size() > 0)
            flag = "2".equals(tags.get(0).code);
        return flag;
    }

    public boolean isNewVisible() {
        boolean flag = false;
        if (tags != null && tags.size() > 0)
            flag = "1".equals(tags.get(0).code);
        return flag;
    }

    public boolean isPreVisible() {
        boolean flag = false;
        if (tags != null && tags.size() > 0)
            flag = "3".equals(tags.get(0).code);
        return flag;
    }


    public boolean isHolidayVisible() {
        boolean flag = false;
        if (tags != null && tags.size() > 0)
            flag = "4".equals(tags.get(0).code);
        return flag;
    }

    public boolean isSpecialVisible() {
        boolean flag = false;
        if (tags != null && tags.size() > 0)
            flag = "5".equals(tags.get(0).code);
        return flag;
    }



    public boolean isSoldOut() {
        return isPreVisible() && ((new Date().getTime() > preSaleStart && items.get(0).inventory == 0) || new Date().getTime() > preSaleEnd);
    } */

    public boolean editVisible(){
        return this.priceEditType == 1;
    }
    public boolean isPriceVisible() {
        return this.priceEditType == 1;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(this.code);
        dest.writeString(this.imageNames);
//        dest.writeParcelable(this.productCategory, flags);
        dest.writeString(this.name);
        dest.writeString(this.spec);
        dest.writeInt(this.weight);
        dest.writeDouble(this.minPrice);
        dest.writeDouble(this.maxPrice);
        dest.writeDouble(this.supplyPrice);
        dest.writeDouble(this.msrp);
        dest.writeString(this.shortName);
        dest.writeString(this.description);
        dest.writeDouble(this.originalPrice);
        dest.writeDouble(this.retailPrice);
        dest.writeString(this.storageMethod);
        dest.writeString(this.ingredients);
        dest.writeString(this.shelfLife);
        dest.writeString(this.productStandards);
        dest.writeString(this.factorySite);
        dest.writeString(this.factoryName);
        dest.writeString(this.productionLicense);
        dest.writeLong(this.preSaleStart);
        dest.writeLong(this.preSaleEnd);
        dest.writeInt(this.preSaleSold);
//        dest.writeTypedList(this.items);
//        dest.writeTypedList(this.tags);
        dest.writeString(this.wbDiscount);
//        dest.writeTypedList(this.discounts);
//        dest.writeTypedList(this.productCommission);
        dest.writeDouble(this.commission);
        dest.writeInt(this.preSaleStock);
        dest.writeStringList(this.banner);
        dest.writeStringList(this.detail);
        dest.writeStringList(this.list);
        dest.writeStringList(this.video);
        dest.writeDouble(this.commissionRate);
        dest.writeInt(this.signType);
        dest.writeInt(this.priceEditType);
        dest.writeString(this.introductionMainTitle);
        dest.writeString(this.introductionSubTitle);
        dest.writeInt(this.soldQuantity);
        dest.writeDouble(this.discount);
        dest.writeDouble(this.rushPrice);
        dest.writeDouble(this.ceoRushPrice);
        dest.writeInt(this.status);
    }

    protected CategoryItemsBean(Parcel in) {
        super(in);
        this.code = in.readString();
        this.imageNames = in.readString();
//        this.productCategory = in.readParcelable(ProductItemCategory.class.getClassLoader());
        this.name = in.readString();
        this.spec = in.readString();
        this.weight = in.readInt();
        this.minPrice = in.readDouble();
        this.maxPrice = in.readDouble();
        this.supplyPrice = in.readDouble();
        this.msrp = in.readDouble();
        this.shortName = in.readString();
        this.description = in.readString();
        this.originalPrice = in.readDouble();
        this.retailPrice = in.readDouble();
        this.storageMethod = in.readString();
        this.ingredients = in.readString();
        this.shelfLife = in.readString();
        this.productStandards = in.readString();
        this.factorySite = in.readString();
        this.factoryName = in.readString();
        this.productionLicense = in.readString();
        this.preSaleStart = in.readLong();
        this.preSaleEnd = in.readLong();
        this.preSaleSold = in.readInt();
//        this.items = in.createTypedArrayList(ItemsBean.CREATOR);
//        this.tags = in.createTypedArrayList(Tags.CREATOR);
        this.wbDiscount = in.readString();
//        this.discounts = in.createTypedArrayList(Discount.CREATOR);
//        this.productCommission = in.createTypedArrayList(ProductCommission.CREATOR);
        this.commission = in.readDouble();
        this.preSaleStock = in.readInt();
        this.banner = in.createStringArrayList();
        this.detail = in.createStringArrayList();
        this.list = in.createStringArrayList();
        this.video = in.createStringArrayList();
        this.commissionRate = in.readDouble();
        this.signType = in.readInt();
        this.priceEditType = in.readInt();
        this.introductionMainTitle = in.readString();
        this.introductionSubTitle = in.readString();
        this.soldQuantity = in.readInt();
        this.discount = in.readDouble();
        this.rushPrice = in.readDouble();
        this.ceoRushPrice = in.readDouble();
        this.status = in.readInt();
    }

    public static final Creator<CategoryItemsBean> CREATOR = new Creator<CategoryItemsBean>() {
        @Override
        public CategoryItemsBean createFromParcel(Parcel source) {
            return new CategoryItemsBean(source);
        }

        @Override
        public CategoryItemsBean[] newArray(int size) {
            return new CategoryItemsBean[size];
        }
    };
}
