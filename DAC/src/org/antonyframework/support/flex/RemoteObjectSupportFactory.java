package org.antonyframework.support.flex;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import flex.messaging.FactoryInstance;
import flex.messaging.FlexFactory;
import flex.messaging.config.ConfigMap;
import flex.messaging.services.ServiceException;
//辅助flex 与spring 结合的工厂方法
public class RemoteObjectSupportFactory implements FlexFactory {
	private static final String SOURCE = "source";

	// 该方法用于初始化该工厂，会在配置文件中自动调用。
	@Override
	public void initialize(String id, ConfigMap configMap) {

	}

	// 该方法在一个destination被实例化时调用。
	@Override
	public FactoryInstance createFactoryInstance(String id, ConfigMap properties) {
		SpringFactoryInstance instance = new SpringFactoryInstance(this, id,
				properties);
		instance.setSource(properties.getPropertyAsString(SOURCE, "source"));
		return instance;
	}

	// 返回一个指定source和property的工厂实例，该方法会在每次服务请求时自动调用。
	@Override
	public Object lookup(FactoryInstance inst) {
		SpringFactoryInstance factoryInstance = (SpringFactoryInstance) inst;
		return factoryInstance.lookup();
	}

	class SpringFactoryInstance extends FactoryInstance {
		// 构造函数。
		SpringFactoryInstance(RemoteObjectSupportFactory factory, String id,
				ConfigMap properties) {
			super(factory, id, properties);
		}

		// 由Servlet容器中获取上下文内容(context)，然后根据配置源获取Spring中创建的Bean。
		@Override
		public Object lookup() {
			ApplicationContext appContext = WebApplicationContextUtils
					.getWebApplicationContext(flex.messaging.FlexContext
							.getServletConfig().getServletContext());
			String beanName = getSource(); // 配置文件中声明的源(也即一个bean的名字)。

			try {
				return appContext.getBean(beanName); // 返回Spring中创建的bean。
			} catch (NoSuchBeanDefinitionException nexc) // 没有找到指定的bean。
			{
				ServiceException e = new ServiceException();
				String msg = "Spring service named '" + beanName
						+ "' does not exist.";
				e.setMessage(msg);
				e.setRootCause(nexc);
				e.setDetails(msg);
				e.setCode("Spring.Processing");
				throw e;
			} catch (BeansException bexc) // 创建bean出错。
			{
				ServiceException e = new ServiceException();
				String msg = "Unable to create Spring service named '"
						+ beanName + "'.";
				e.setMessage(msg);
				e.setRootCause(bexc);
				e.setDetails(msg);
				e.setCode("Spring.Processing");
				throw e;
			}
		}

		@Override
		public String toString() {
			return "SpringFactory instance for id=" + getId() + " source="
					+ getSource() + " scope=" + getScope() + ".";
		}
	}
}