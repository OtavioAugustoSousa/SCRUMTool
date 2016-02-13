package br.ufc.quixada.es.ScrumTool.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import br.ufc.quixada.es.ScrumTool.Application;

@Configuration
public class RestExporterWebInitializer implements WebApplicationInitializer {
 
    @Override
    public void onStartup(ServletContext servletContext)
            throws ServletException {
        AnnotationConfigWebApplicationContext rootCtx = new AnnotationConfigWebApplicationContext();
        rootCtx.register(Application.class);
 
        servletContext.addListener(new ContextLoaderListener(rootCtx));
 
        AnnotationConfigWebApplicationContext webCtx = new AnnotationConfigWebApplicationContext();
 
        DispatcherServlet dispatcherServlet = new DispatcherServlet(webCtx);
        ServletRegistration.Dynamic reg = servletContext.addServlet(
                "rest-exporter", dispatcherServlet);
        reg.setLoadOnStartup(1);
        reg.addMapping("/*");
 
    }
 
}
