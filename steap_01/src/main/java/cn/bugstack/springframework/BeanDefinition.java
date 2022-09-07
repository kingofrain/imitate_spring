package cn.bugstack.springframework;

/**
 * 这个类用来存储对象，你可以防任何对象进来
 */
public class BeanDefinition {
    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }
}
