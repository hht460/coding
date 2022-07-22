package org.hthu.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author haitao.hu2
 * @version 0.0.1
 * @date 2022/7/21
 */
public class TimeUtil {

    /**
     * 获取今天零点的时间戳
     *
     * @return
     */
    public static long getTodayZeroTime() {
        LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        return localDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }

    /**
     * 有问题的方式：获取当天零点时间戳
     * @return
     */
    public static long getTodayZeroTimeOld() {
        return System.currentTimeMillis() / (1000 * 3600 * 24) * (1000 * 3600 * 24) - TimeZone.getDefault().getRawOffset();
    }

    public static long getCurrTime(){
        return System.currentTimeMillis() / (1000 * 3600 * 24);
    }

    public static boolean isFistHalfOfToday(long time, int timeDivision) {
        long todayZeroTime = getTodayZeroTime();
        long visionTime = timeDivision * 3600 * 1000;
        return time >= todayZeroTime && time < todayZeroTime + visionTime;
    }

    public static void main(String[] args) {
        System.out.println(isFistHalfOfToday(System.currentTimeMillis(), 12));
    }
}
