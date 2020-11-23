package com.xima.backpressure;

import com.xima.myEvent.MyEventListener;
import com.xima.myEvent.MyEventSource;
import com.xima.util.Utils;
import org.junit.Before;
import org.junit.Test;
import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.scheduler.Schedulers;

import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class BackPressureTest {
    // 生成的事件间隔时间，单位毫秒
    private final int EVENT_DURATION   = 10;
    // 生成的事件个数
    private final int EVENT_COUNT      = 20;
    // 订阅者处理每个元素的时间，单位毫秒
    private final int PROCESS_DURATION = 30;

    private SlowSubscriber slowSubscriber;
    private MyEventSource eventSource;
    private CountDownLatch countDownLatch;

    @Before
    public void setup() {
        countDownLatch = new CountDownLatch(1);
        slowSubscriber = new SlowSubscriber();
        eventSource = new MyEventSource();
    }

    /**
     * 测试create方法的不同OverflowStrategy的效果。
     */
    @Test
    public void testCreateBackPressureStrategy() throws InterruptedException {
        createFlux(FluxSink.OverflowStrategy.BUFFER)    // BUFFER/DROP/LATEST/ERROR/IGNORE
                        .publishOn(Schedulers.newSingle("newSingle"),1)
                        .subscribe(slowSubscriber);
        generateEvent(EVENT_COUNT, EVENT_DURATION);
        countDownLatch.await(1, TimeUnit.MINUTES);
    }

    private void generateEvent(int num, int millis) {
        for (int i = 0; i < num; i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(millis);
            } catch (InterruptedException e) {
            }
            eventSource.newEvent(new MyEventSource.MyEvent(new Date(), "Event-" + i));
        }
        eventSource.eventStopped();
    }

    /**
     * 快发布者
     */
    private Flux<MyEventSource.MyEvent> createFlux(FluxSink.OverflowStrategy strategy) {
        return Flux.create(sink -> eventSource.register(new MyEventListener() {
            @Override
            public void onNewEvent(MyEventSource.MyEvent event) {
                Utils.println("publish >>> " + event.getMessage());
                sink.next(event);
            }

            @Override
            public void onEventStopped() {
                sink.complete();
            }
        }), strategy);
    }

    /**
     * 慢订阅者
     */
    class SlowSubscriber extends BaseSubscriber<MyEventSource.MyEvent> {

        @Override
        protected void hookOnSubscribe(Subscription subscription) {
            request(1);
        }

        @Override
        protected void hookOnNext(MyEventSource.MyEvent event) {
            Utils.println("                      receive <<< " + event.getMessage());
            try {
                TimeUnit.MILLISECONDS.sleep(PROCESS_DURATION);
            } catch (InterruptedException e) {
            }
            request(1);
        }

        @Override
        protected void hookOnError(Throwable throwable) {
            Utils.println("                      receive <<< " + throwable);
        }

        @Override
        protected void hookOnComplete() {
            countDownLatch.countDown();
        }
    }



}