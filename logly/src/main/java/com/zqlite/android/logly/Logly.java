package com.zqlite.android.logly;

import android.util.Log;

/**
 * @author qinglian.zhang
 */
public class Logly {

    public static final int FLAG_NONE = 0x000;

    public static final int FLAG_THREAD_NAME = 0x001;

    public static final int FLAG_INVISIBLE = 0x002;

    public static final int VERBOSE = Log.VERBOSE;

    public static final int DEBUG = Log.DEBUG;

    public static final int INFO = Log.INFO;

    public static final int WARN = Log.WARN;

    public static final int ERROR = Log.ERROR;

    private static Tag sTag = new Tag(FLAG_NONE,Logly.class.getSimpleName(),VERBOSE);

    private static Logly sInstance;

    private Logly(){}

    public static void setGlobalTag(Tag tag){
        sTag = tag;
    }

    public static void v(String msg){
        if(sTag.level <= VERBOSE && ((sTag.flag & FLAG_INVISIBLE) == 0)){
            Log.v(sTag.tag,getExtraInfoWithTag(sTag,msg));
        }
    }

    public static void v(Tag tag, String msg) {
        if(tag.level <= VERBOSE && ((tag.flag & FLAG_INVISIBLE) == 0)){
            Log.v(tag.tag,getExtraInfoWithTag(tag,msg));
        }
    }

    public static void d(String msg){
        if(sTag.level <= DEBUG && ((sTag.flag & FLAG_INVISIBLE) == 0)){
            Log.d(sTag.tag, getExtraInfoWithTag(sTag,msg));
        }
    }

    public static void d(Tag tag, String msg) {
        if(tag.level <= DEBUG && ((tag.flag & FLAG_INVISIBLE) == 0)){
            Log.d(tag.tag, getExtraInfoWithTag(tag,msg));
        }
    }

    public static void i(String msg){
        if(sTag.level <= INFO && ((sTag.flag & FLAG_INVISIBLE) == 0)){
            Log.i(sTag.tag, getExtraInfoWithTag(sTag,msg));
        }
    }

    public static void i(Tag tag, String msg) {
        if(tag.level <= INFO && ((tag.flag & FLAG_INVISIBLE) == 0)){
            Log.i(tag.tag, getExtraInfoWithTag(tag,msg));
        }
    }

    public static void w(String msg){
        if(sTag.level <= WARN && ((sTag.flag & FLAG_INVISIBLE) == 0)){
            Log.w(sTag.tag, getExtraInfoWithTag(sTag,msg));
        }
    }

    public static void w(Tag tag, String msg) {
        if(tag.level <= WARN && ((tag.flag & FLAG_INVISIBLE) == 0)){
            Log.w(tag.tag, getExtraInfoWithTag(tag,msg));
        }
    }

    public static void e(String msg){
        if(sTag.level <= ERROR && ((sTag.flag & FLAG_INVISIBLE) == 0)){
            Log.e(sTag.tag, getExtraInfoWithTag(sTag,msg));
        }
    }

    public static void e(Tag tag, String msg) {
        if(tag.level <= ERROR && ((tag.flag & FLAG_INVISIBLE) == 0)){
            Log.e(tag.tag, getExtraInfoWithTag(tag,msg));
        }
    }

    private static String getExtraInfoWithTag(Tag tag,String msg){
        if(tag.flag == FLAG_NONE ){
            return msg;
        }
        StringBuilder sb = new StringBuilder("[");

        if((tag.flag & FLAG_THREAD_NAME) == FLAG_THREAD_NAME){
            sb.append("T:").append(Thread.currentThread().getName());
        }
        sb.append("] ");
        sb.append(msg);
        return sb.toString();
    }

    public static class Tag{

        public int flag;

        public String tag;

        public int level;

        public Tag(int flag,String tag,int level){
            //TODO  flag,tag和level的错误处理
            this.flag |= flag;
            this.tag = tag;
            this.level = level;
        };
    }

}
