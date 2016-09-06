package net.beifeng.mobile_scm.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class SysInit implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {

    }

    @Override
    public void contextInitialized(ServletContextEvent event) {
        ServletContext application = event.getServletContext();
        //系统名称
        String sysname = application.getInitParameter("sysname");
        application.setAttribute("sysname", sysname);
        //全局上下文路径
        application.setAttribute("ctx", application.getContextPath());        
    }

}
