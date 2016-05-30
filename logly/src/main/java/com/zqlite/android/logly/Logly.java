package com.zqlite.android.logly;

import android.util.Log;

/**
 * @author qinglian.zhang
 */
public class Logly implements Interface {

    public static final int FLAG_NONE = 0x000;

    public static final int FLAG_THREAD_NAME = 0x001;

    public static final int VERBOSE = Log.VERBOSE;

    public static final int DEBUG = Log.DEBUG;

    public static final int INFO = Log.INFO;

    public static final int WARN = Log.WARN;

    public static final int ERROR = Log.ERROR;

    private Tag tag = new Tag(FLAG_NONE,Logly.class.getSimpleName(),VERBOSE);

    private static Logly sInstance;

    private Logly(){}

    public synchronized static final Logly own(){
        if(sInstance == null){
            sInstance = new Logly();
        }
        return sInstance;
    }

    public void setGlobalTag(Tag tag){
        this.tag = tag;
    }

    public void v(String msg){
        if(tag.level <= VERBOSE){
            Log.v(tag.tag,getExtraInfoWithTag(tag,msg));
        }
    }

    @Override
    public void v(Tag tag, String msg) {
        if(tag.level <= VERBOSE){
            Log.v(tag.tag,getExtraInfoWithTag(tag,msg));
        }
    }

    public void d(String msg){
        if(tag.level <= DEBUG){
            Log.d(tag.tag, getExtraInfoWithTag(tag,msg));
        }
    }

    @Override
    public void d(Tag tag, String msg) {
        if(tag.level <= DEBUG){
            Log.d(tag.tag, getExtraInfoWithTag(tag,msg));
        }
    }

    public void i(String msg){
        if(tag.level <= INFO){
            Log.i(tag.tag, getExtraInfoWithTag(tag,msg));
        }
    }

    @Override
    public void i(Tag tag, String msg) {
        if(tag.level <= INFO){
            Log.i(tag.tag, getExtraInfoWithTag(tag,msg));
        }
    }

    public void w(String msg){
        if(tag.level <= WARN){
            Log.w(tag.tag, getExtraInfoWithTag(tag,msg));
        }
    }

    @Override
    public void w(Tag tag, String msg) {
        if(tag.level <= WARN){
            Log.w(tag.tag, getExtraInfoWithTag(tag,msg));
        }
    }

    public void e(String msg){
        if(tag.level <= ERROR){
            Log.e(tag.tag, getExtraInfoWithTag(tag,msg));
        }
    }

    @Override
    public void e(Tag tag, String msg) {
        if(tag.level <= ERROR){
            Log.e(tag.tag, getExtraInfoWithTag(tag,msg));
        }
    }

    private String getExtraInfoWithTag(Tag tag,String msg){
        if(tag.flag == FLAG_NONE){
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
