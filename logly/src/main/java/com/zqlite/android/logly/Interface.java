package com.zqlite.android.logly;

/**
 * @author qinglian.zhang
 */
public interface Interface {
    public void v(String msg);

    public void v(Logly.Tag tag, String msg);

    public void d(String msg);

    public void d(Logly.Tag tag, String msg);

    public void i(String msg);

    public void i(Logly.Tag tag, String msg);

    public void w(String msg);

    public void w(Logly.Tag tag, String msg);

    public void e(String msg);

    public void e(Logly.Tag tag, String msg);
}
