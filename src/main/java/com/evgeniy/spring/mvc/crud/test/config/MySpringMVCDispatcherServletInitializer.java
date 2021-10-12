package com.evgeniy.spring.mvc.crud.test.config;

import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

// Этот класс заменяет web.xml
public class MySpringMVCDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() { // В этот метод подставляем наш класс SpringConfig
        // Теперь наш MySpringMVCDispatcherServletInitializer знает, где находится Spring конфигурация
        return new Class[] {SpringConfigForJSP.class};
    }

    @Override
    protected String[] getServletMappings() { // <!-- Любой url который вводит пользователь перенаправляется на наш DespatcherServlet -->
        return new String[] {"/"};
    }

    @Override
    public void onStartup(ServletContext aServletContext) throws ServletException {
        super.onStartup(aServletContext);
        registerHiddenFieldFilter(aServletContext);
    }

    private void registerHiddenFieldFilter(ServletContext aContext) {
        aContext.addFilter("hiddenHttpMethodFilter",
                new HiddenHttpMethodFilter()).addMappingForUrlPatterns(null ,true, "/*");
    }
}
