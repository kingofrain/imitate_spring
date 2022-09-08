package cn.bugstack.springframework.beans.factory.config;

/**
 * 这个接口用来得到单例类
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);

}
