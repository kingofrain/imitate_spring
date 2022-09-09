package beans.factory.support;

import beans.BeansException;
import beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 这个类实现了 对有参和无参构造2中情况的处理
 * 首先通过 beanDefinition 获取 Class 信息，这个 Class 信息是在 Bean 定义的时
 * 候传递进去的。
 *  接下来判断 ctor 是否为空，如果为空则是无构造函数实例化，否则就是需要有构
 * 造函数的实例化。
 *  这里我们重点关注有构造函数的实例化，实例化方式为
 * clazz.getDeclaredConstructor(ctor.getParameterTypes()).ne
 * wInstance(args);，把入参信息传递给 newInstance 进行实例化。
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy{
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {
        Class clazz = beanDefinition.getBeanClass();
        try {
            if (null!=ctor){
                return clazz.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
            }else {
                return clazz.getDeclaredConstructor().newInstance();
            }
        } catch (InvocationTargetException | IllegalAccessException | NoSuchMethodException | InstantiationException e) {
            throw new BeansException("Failed to instantiate ["+clazz.getName()+"]",e);
        }
    }
}
