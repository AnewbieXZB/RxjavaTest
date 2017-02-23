package com.retrofit2test.rxjavates.Fragments.Rxbus;

import android.annotation.TargetApi;
import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Administrator on 2017/2/21.
 */
public class Events<T> {
    //所有事件的CODE
    public static final int TAP = 1 ;
    public static final int OTHER = 21;
    //枚举
    @IntDef({TAP,OTHER})
    @Retention(RetentionPolicy.SOURCE)
    public @interface EventCode{}

    public @Events.EventCode int code;
    public T content;
    public static <O> Events<O> setContent(O t){
        Events<O> events = new Events<>();
        events.content = t;
        return events;
    }
    public <T> T getContent(){
        return (T) content;
    }
}

