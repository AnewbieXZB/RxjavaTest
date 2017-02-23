package com.retrofit2test.rxjavates.Fragments.Rxbus;

import android.app.Fragment;
import android.app.Notification;
import android.provider.CalendarContract;
import android.provider.ContactsContract;


import com.trello.rxlifecycle.ActivityEvent;
import com.trello.rxlifecycle.ActivityLifecycleProvider;
import com.trello.rxlifecycle.FragmentEvent;
import com.trello.rxlifecycle.FragmentLifecycleProvider;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;
/**
 * Created by Administrator on 2017/2/20.
 */
public class Rxbus {
    private static Rxbus rxbus;
   private final Subject<Events<?>,Events<?>> _bus = new SerializedSubject<Events<?>, Events<?>>(PublishSubject.<Events<?>>create());
    private Rxbus(){

    }
    public static Rxbus getInstance(){
        if(rxbus == null){
            synchronized (Rxbus.class){
                if(rxbus == null){
                    rxbus = new Rxbus();
                }
            }
        }
        return rxbus;
    }
    public void send(Events<?> o){
            _bus.onNext(o);
    }
    public void send(@Events.EventCode int code,Object content){
        Events<Object> events = new Events<>();
        events.code = code;
        events.content = content;
        send(events);
    }
    public Observable<Events<?>> toObeservable(){
        return _bus;
    }
    public static SubscriberBuilder with(FragmentLifecycleProvider provider){
            return new SubscriberBuilder(provider);
    }
    public static SubscriberBuilder with(ActivityLifecycleProvider provider){
        return new SubscriberBuilder(provider);
    }
    public static class SubscriberBuilder{
        private FragmentLifecycleProvider mFragLifecycleProvider;
        private ActivityLifecycleProvider mActLifecycleProvider;
        private FragmentEvent mFragmentEndEvent;
        private ActivityEvent mActivityEndEvent;
        private int event;
        private Action1<? super Events<?>> onNext;
        private Action1<Throwable> onError;
        public SubscriberBuilder(FragmentLifecycleProvider provider){
            this.mFragLifecycleProvider = provider;
        }
        public SubscriberBuilder(ActivityLifecycleProvider provider){
            this.mActLifecycleProvider = provider;
        }
        public SubscriberBuilder setEvent(@Events.EventCode int event){
                this.event = event;
            return this;
        }
        public SubscriberBuilder setEndEvent(FragmentEvent event){
            this.mFragmentEndEvent = event;
            return this;
        }
        public SubscriberBuilder onNext(Action1<? super Events<?>> action){
            this.onNext = action;
            return this;
        }
        public SubscriberBuilder onError(Action1<Throwable> action){
            this.onError = action;
            return this;
        }
        public void create(){
            _create();
        }
        public Subscription _create(){
            if(mFragLifecycleProvider!=null){
                return Rxbus.getInstance().toObeservable()
                        .compose(mFragmentEndEvent == null ? mFragLifecycleProvider.<Events<?>>bindToLifecycle() :mFragLifecycleProvider.<Events<?>>bindUntilEvent(mFragmentEndEvent))
                        .filter(new Func1<Events<?>,Boolean>() {
                            @Override
                            public Boolean call(Events<?> events) {
                                return events.code == event;
                            }
                        })
                        .subscribe(onNext,onError==null ?new Action1<Throwable>(){

                            @Override
                            public void call(Throwable throwable) {
                                throwable.printStackTrace();
                            }
                        }:onError);
            }
            if(mActLifecycleProvider!=null){
                return Rxbus.getInstance().toObeservable()
                        .compose(mActivityEndEvent == null ? mActLifecycleProvider.<Events<?>>bindToLifecycle() : mActLifecycleProvider.<Events<?>>bindUntilEvent(mActivityEndEvent))
                        .filter(new Func1<Events<?>, Boolean>() {
                            @Override
                            public Boolean call(Events<?> events) {
                                return events.code == event;
                            }
                        })
                        .subscribe(onNext,onError==null ? new Action1<Throwable>() {
                            @Override
                            public void call(Throwable throwable) {
                                throwable.printStackTrace();
                            }
                        }:onError);
            }
            return null;
        }
    }
}
