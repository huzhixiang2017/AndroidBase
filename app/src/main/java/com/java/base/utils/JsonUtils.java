package com.java.base.utils;

import android.content.Context;

import com.java.base.model.bean.ClassifyDetailsBean;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: AndroidBase
 * @Package: com.java.base.utils
 * @ClassName: JsonUtils
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2019/12/12 17:23
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019/12/12 17:23
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class JsonUtils {

    public JsonUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }


    /**
     * 解析Home页Item数据
     */
    public static List<ClassifyDetailsBean>  parseDataHomeItem (Context context, String fileName) {
        try {
            JSONArray jsonArray = getJsonFile(context,fileName);
            if (jsonArray != null) {
                int length = jsonArray.length();
                List<ClassifyDetailsBean> list = new ArrayList<>(length);
                for (int i = 0; i < length; i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String strObj = jsonObject.getString("object");
                    JSONArray resultArray =  new JSONArray(strObj);
                    if (resultArray != null) {
                        int resultLength = resultArray.length();
                        for (int j = 0; j < resultLength; j++) {
                            JSONObject resultObject = resultArray.getJSONObject(j);
                            String image = resultObject.getString("image");
                            JSONArray resultObj = resultObject.getJSONArray("result");
                            if (resultObj != null) {
                                for(int k = 0; k<resultObj.length(); k++){//解析第三层----对象
                                    JSONObject beanObj =resultObj.getJSONObject(k);
                                    ClassifyDetailsBean bean = new ClassifyDetailsBean();
                                    bean.setCode(beanObj.getString("code"));
                                    bean.setDescription(beanObj.getString("description"));
                                    bean.setFactoryName(beanObj.getString("factoryName"));
                                    bean.setFactorySite(beanObj.getString("factorySite"));
                                    bean.setImageNames(beanObj.getString("imageNames"));
                                    bean.setIngredients(beanObj.getString("ingredients"));
                                    //bean.setItems(beanObj.getJSONArray("items"));
                                    bean.setMaxPrice(beanObj.getString("maxPrice"));
                                    bean.setMinPrice(beanObj.getString("minPrice"));
                                    bean.setMsrp(beanObj.getString("msrp"));
                                    bean.setName(beanObj.getString("name"));
                                    bean.setOriginalPrice(beanObj.getString("originalPrice"));
                                    //bean.setProductCategory(beanObj.getString("productCategory"));
                                    bean.setProductionLicense(beanObj.getString("productionLicense"));
                                    bean.setProductStandards(beanObj.getString("productStandards"));
                                    bean.setRetailPrice(beanObj.getString("retailPrice"));
                                    bean.setShelfLife(beanObj.getString("shelfLife"));
                                    bean.setShortName(beanObj.getString("shortName"));
                                    bean.setSpec(beanObj.getString("spec"));
                                    bean.setStorageMethod(beanObj.getString("storageMethod"));
                                    bean.setWeight(beanObj.getString("weight"));
                                    bean.setIntroductionMainTitle(beanObj.getString("introductionMainTitle"));
                                    bean.setIntroductionSubTitle(beanObj.getString("introductionSubTitle"));
                                    bean.setSoldQuantity(beanObj.getString("soldQuantity"));
                                    bean.setSupplyPrice(beanObj.getString("supplyPrice"));
                                    bean.setImage(image);
                                    list.add(bean);
                                }
                            }
                        }
                    }
                }
                return list;
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 获取资产目录下面文件的字符串
     */
    private static JSONArray getJsonFile(Context context, String fileName) {
        try {
            InputStream inputStream = context.getAssets().open(fileName);
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[512];
            int length;
            while ((length = inputStream.read(buffer)) != -1) {
                outStream.write(buffer, 0, length);
            }
            outStream.close();
            inputStream.close();
            return new JSONArray(outStream.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
