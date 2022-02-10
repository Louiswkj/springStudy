package com.imooc.spring.ioc.context;

import com.sun.deploy.panel.IProperty;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liuliang
 * 2022/1/25
 */
public class ClassPathXmlApplicationContext implements ApplicationContext {
    private Map iocContainer = new HashMap();

    public ClassPathXmlApplicationContext() {
        try {
            String filePath = this.getClass().getResource("/applicationContext.xml").getPath();
            filePath = URLDecoder.decode(filePath, "UTF8");
            SAXReader reader = new SAXReader();
            Document document = reader.read(new File(filePath));
            List<Node> beans = document.getRootElement().selectNodes("bean");
            for (Node node : beans) {
                Element ele = (Element) node;
                String id = ele.attributeValue("id");
                String className = ele.attributeValue("class");

                // 反射
                Class c = Class.forName(className);
                Object object = c.newInstance();
                iocContainer.put(id, object);

                List<Node> properties = ele.selectNodes("property");
                for (Node n : properties) {
                    Element property = (Element) n;
                    String propName = property.attributeValue("name");
                    String propValue = property.attributeValue("value");

                    String setMethodName = "set" + propName.substring(0, 1).toUpperCase() + propName.substring(1);
                    System.out.println("准备执行：" + setMethodName + "方法注入数据");
                    // 通过set注入数据
                    Method method = c.getMethod(setMethodName, String.class);
                    method.invoke(object, propValue);
                }
            }
            System.out.println("IoC容器初始化初始化完毕");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object getBean(String beanId) {
        return iocContainer.get(beanId);
    }
}
