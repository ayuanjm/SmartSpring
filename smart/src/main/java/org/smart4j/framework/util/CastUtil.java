package org.smart4j.framework.util;

import org.apache.commons.lang3.StringUtils;

public class CastUtil {
    /**
     * 转化为String
     * @param obj
     * @return
     */
    public static String castString(Object obj){
        return castString(obj,"");
    }

    /**
     * 转为String型（提供默认值）
     * @param obj
     * @param defaultValue
     * @return
     */
    public static String castString(Object obj,String defaultValue){
        return obj == null ? defaultValue : obj.toString();
    }

    /**
     * 转为double
     * @param object
     * @return
     */
    public static double castDouble(Object object) {
        return CastUtil.castDouble(object,0);
    }

    /**
     * 转为double（提供默认值）
     * @param object
     * @param defaultValue
     * @return
     */
    public static double castDouble(Object object,double defaultValue) {
        double doubleValue = defaultValue;
        if (object!=null){
            String strValue = castString(object);
            if (StringUtils.isNotEmpty(strValue)){
                try {
                    doubleValue = Double.parseDouble(strValue);
                } catch (NumberFormatException e){
                    doubleValue = defaultValue;
                }
            }

        }
            return doubleValue;
    }

    /**
     * 转为long型
     * @param object
     * @return
     */
    public static long castLong(Object object) {
        return CastUtil.castLong(object,0);
    }

    /**
     * 转为long型（提供默认值）
     * @param object
     * @param defaultValue
     * @return
     */
    public static long castLong(Object object,long defaultValue) {
        long doubleValue = defaultValue;
        if (object!=null){
            String strValue = castString(object);
            if (StringUtils.isNotEmpty(strValue)){
                try {
                    doubleValue = Long.parseLong(strValue);
                } catch (NumberFormatException e){
                    doubleValue = defaultValue;
                }
            }

        }
        return doubleValue;
    }
    /**
     * 转为int
     * @param obj
     * @return
     */
    public static int castInt(Object obj){
        return  castInt(obj,0);
    }

    /**
     * 转为int（提供默认值）
     * @param obj
     * @param defaultValue
     * @return
     */
    public static int castInt(Object obj,int defaultValue){
        int intValue = defaultValue;
        if (obj instanceof Integer){
            return obj == null ? defaultValue : (Integer) obj;
        }else {
            if (obj!=null){
                String value = obj.toString();
                if (StringUtils.isNotEmpty(value)){
                    try {
                        intValue = Integer.parseInt(value);
                    } catch (NumberFormatException e) {
                        intValue = defaultValue;
                    }
                }
            }
            return intValue;
        }
    }

    /**
     * 转为boolean型
     * @param object
     * @return
     */
    public static boolean castBoolean(Object object){
        return CastUtil.castBoolean(object,false);
    }

    /**
     * 转为boolean型（提供默认值）
     * @param object
     * @param defaultValue
     * @return
     */
    public static boolean castBoolean(Object object,boolean defaultValue){
        boolean booleanValue = defaultValue;
        if (object!=null){
            booleanValue = Boolean.parseBoolean(castString(object));
        }
        return booleanValue;
    }
}
