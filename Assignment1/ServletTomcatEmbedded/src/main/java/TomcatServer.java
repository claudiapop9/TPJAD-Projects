import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.StandardRoot;
import servlets.FormServlet;

public class TomcatServer {
    public static void main(String[] args) throws Exception {

        String webappDir = "C:\\Users\\computer\\TPJAD Projects\\ServletTomcatEmbedded\\src\\main\\webapp";
        Tomcat server = new Tomcat();
        server.setPort(8080);

        StandardContext rootCtx = (StandardContext) server.addWebapp("/", webappDir);
        WebResourceRoot resources = new StandardRoot(rootCtx);
        rootCtx.setResources(resources);

        Tomcat.addServlet(rootCtx, "form", new FormServlet());
        rootCtx.addServletMapping("/calculateServlet", "form");

        server.start();
        server.getServer().await();

    }
}
