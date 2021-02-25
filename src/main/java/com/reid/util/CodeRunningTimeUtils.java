package com.reid.util;

/**
 * <p>
 * 类描述
 * </p>
 *
 * @Author REID
 * @Blog https://blog.csdn.net/qq_39035773
 * @GitHub https://github.com/BeginnerA
 * @Data 2021/2/25
 * @Version V1.0
 **/
public class CodeRunningTimeUtils {
    private static Long startTimes;
    private Long startTime;
    private Long tempTimes;

    /**
     * 获取初始时间戳，静态方法
     */
    public static void initRunTimes(){
        startTimes = System.currentTimeMillis();
    }

    /**
     * 获取结束时间戳并打印代码执行时间，静态方法，无参
     */
    public static void printRunTimes(){
        printRunTimes(null);
    }

    /**
     * 获取结束时间戳并打印代码执行时间，静态方法，有参
     * @param str 字符串会在打印前输出
     */
    public static void printRunTimes(String str){
        if(str != null)
            str += " => ";
        else
            str = "";
        Long endTimes = System.currentTimeMillis();
        //获取调用者的类名
        String classname = new Exception().getStackTrace()[1].getClassName();
        //获取调用者的方法名
        String method_name = new Exception().getStackTrace()[1].getMethodName();
        if(startTimes != null) {
            Long tempTime = (endTimes - startTimes);
            System.out.println(str + classname + " > " + method_name + ":花费时间"+
                    (((tempTime/86400000)>0)?((tempTime/86400000)+"d"):"")+
                    ((((tempTime/86400000)>0)||((tempTime%86400000/3600000)>0))?((tempTime%86400000/3600000)+"h"):(""))+
                    ((((tempTime/3600000)>0)||((tempTime%3600000/60000)>0))?((tempTime%3600000/60000)+"m"):(""))+
                    ((((tempTime/60000)>0)||((tempTime%60000/1000)>0))?((tempTime%60000/1000)+"s"):(""))+
                    ((tempTime%1000)+"ms"));
        }else{
            System.out.println("你忘记了放置静态初始方法了");
        }
    }

    /**
     * 获取初始时间戳
     */
    public void initRunTime(){
        startTime = System.currentTimeMillis();
    }

    /**
     * 获取结束时间戳并打印代码执行时间，无参
     */
    public void printRunTime(){
        printRunTime(null);
    }

    /**
     * 获取结束时间戳并打印代码执行时间，有参
     * 同时打印上次输出与本次输出之间的间隔时间
     */
    public void printRunTime(String str){
        if(str != null) {
            str += " => ";
        }else {
            str = "";
        }

        Long endTime = System.currentTimeMillis();
        //获取调用者的类名
        String classname = new Exception().getStackTrace()[1].getClassName();
        //获取调用者的方法名
        String method_name = new Exception().getStackTrace()[1].getMethodName();
        if(startTime != null) {
            Long tempTime = (endTime - startTime);
            System.out.print(str + classname + " > " + method_name + ":花费时间" +
                    (((tempTime / 86400000) > 0) ? ((tempTime / 86400000) + "d") : "") +
                    ((((tempTime / 86400000) > 0) || ((tempTime % 86400000 / 3600000) > 0)) ? ((tempTime % 86400000 / 3600000) + "h") : ("")) +
                    ((((tempTime / 3600000) > 0) || ((tempTime % 3600000 / 60000) > 0)) ? ((tempTime % 3600000 / 60000) + "m") : ("")) +
                    ((((tempTime / 60000) > 0) || ((tempTime % 60000 / 1000) > 0)) ? ((tempTime % 60000 / 1000) + "s") : ("")) +
                    ((tempTime % 1000) + "ms"));
            if(tempTimes != null){
                tempTime = (endTime - tempTimes);
                System.out.print(" \t间隔时间" +
                        (((tempTime / 86400000) > 0) ? ((tempTime / 86400000) + "d") : "") +
                        ((((tempTime / 86400000) > 0) || ((tempTime % 86400000 / 3600000) > 0)) ? ((tempTime % 86400000 / 3600000) + "h") : ("")) +
                        ((((tempTime / 3600000) > 0) || ((tempTime % 3600000 / 60000) > 0)) ? ((tempTime % 3600000 / 60000) + "m") : ("")) +
                        ((((tempTime / 60000) > 0) || ((tempTime % 60000 / 1000) > 0)) ? ((tempTime % 60000 / 1000) + "s") : ("")) +
                        ((tempTime % 1000) + "ms"));
            }
            System.out.println();
            tempTimes = System.currentTimeMillis();
        }else{
            System.out.println("你忘记了放置初始方法了");
        }
    }
}
