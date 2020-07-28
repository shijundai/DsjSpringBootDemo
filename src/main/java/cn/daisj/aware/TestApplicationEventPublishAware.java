package cn.daisj.aware;/**
 * @author Administrator
 * @Title: Controller
 * @Description:
 * @date 2020/7/28
 */

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *@ClassName TestApplicationEventPublishAware
 *@Description TODO
 *@Author Administrator
 *@Date 2020/7/28 10:18
 *@Version 1.0
 **/
@Component
public class TestApplicationEventPublishAware implements ApplicationEventPublisherAware {

    ApplicationEventPublisher applicationEventPublisher;

    /**
     * 自定义事件
     */
    public static class MyEvent extends ApplicationEvent {
        public MyEvent(Object source) {
            super(source);
        }

        public void eventMethod() {
            System.out.println(" my event method");
        }
    }

    /**
     * 自定义事件监听
     */
    @Service
    public static class MyListenerService implements ApplicationListener<MyEvent> {
        @Override
        public void onApplicationEvent(MyEvent event) {
            System.out.println("进入自定义事件......");
            event.eventMethod();
        }
    }

    public void register(String name) {
        System.out.println("用户"+name+"注册.....");
        applicationEventPublisher.publishEvent(new MyEvent(name));
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        System.out.println("====== ApplicationEventPublisher Aware setApplicationEventPublisher method ======");
        this.applicationEventPublisher = applicationEventPublisher;
    }
}
