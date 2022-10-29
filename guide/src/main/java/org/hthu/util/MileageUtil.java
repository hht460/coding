package org.hthu.util;

import com.alibaba.fastjson.JSON;

import static java.lang.Math.toRadians;

/**
 * @author haitao.hu2
 * @version 0.0.1
 * @date 2022/10/26
 */
public class MileageUtil {


    /**
     * 赤道半径，也通常作为地球半径使用
     */
    private static final double EQUATORIAL_RADIUS = 6378137;

    /**
     * 计算两经纬度点之间的平面直线距离(单位米)--美团算法
     *
     * @param lng1 起点经度
     * @param lat1 起点纬度
     * @param lng2 重点经度
     * @param lat2 终点纬度
     * @return 平面距离
     */
    public static double planeDistance(double lng1, double lat1, double lng2, double lat2) {
        // 经度差值
        double lngDiff = lng1 - lng2;
        // 纬度差值
        double latDiff = lat1 - lat2;
        // 平均纬度
        double averageLat = (lat1 + lat2) / 2.0;
        // 东西距离
        double eastWestDistance = toRadians(lngDiff) * EQUATORIAL_RADIUS * Math.cos(toRadians(averageLat));
        // 南北距离
        double northSouthDistance = EQUATORIAL_RADIUS * toRadians(latDiff);
        // 用平面的矩形对角距离公式计算总距离
        return Math.sqrt(Math.pow(eastWestDistance, 2) + Math.pow(northSouthDistance, 2));
    }

    /**
     * 根据经纬度计算曲面直线距离(单位米)--Haversine公式
     *
     * @param lng1 起点经度
     * @param lat1 起点纬度
     * @param lng2 重点经度
     * @param lat2 终点纬度
     * @return 曲面距离
     */
    public static double curveDistance(double lng1, double lat1, double lng2, double lat2) {
        // 角度转弧度
        double radLng1 = toRadians(lng1);
        double radLat1 = toRadians(lat1);
        double radLng2 = toRadians(lng2);
        double radLat2 = toRadians(lat2);

        // 经度差值
        double lngDiff = radLng1 - radLng2;
        // 纬度差值
        double latDiff = radLat1 - radLat2;
        return 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(latDiff / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(lngDiff / 2), 2))) * EQUATORIAL_RADIUS;
    }

    public static void main(String[] args) {
        // 南京工业大学江浦校区
//        double lng1 = 118.796624;
//        double lat1 = 32.059344;
//        // 雨花台区祝冉中央厨房
//        double lng2 = 116.405285;
//        double lat2 = 39.904989;

        // 南京工业大学江浦校区
        double lng1 = 118.796624;
        double lat1 = 32.059344;
        // 雨花台区祝冉中央厨房
        double lng2 = 117.115349;
        double lat2 = 30.531828;

        // 南京-北京    993.26(地图)    899.4403917246745(本地计算)
        // 南京-安庆    278.07(地图)    233.42514909713977(马鞍山)
        // 南京-马鞍山  57.79(地图)     51.390501185927584(本地计算)
        System.out.println(curveDistance(lng1, lat1, lng2, lat2));
    }
}
