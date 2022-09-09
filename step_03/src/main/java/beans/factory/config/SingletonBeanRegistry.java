package beans.factory.config;

/**
 * 这个接口用来得到 单例类
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);

}
