import org.eclipse.jetty.annotations.AnnotationConfiguration;
import org.eclipse.jetty.plus.webapp.EnvConfiguration;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.Configuration;
import org.eclipse.jetty.webapp.FragmentConfiguration;
import org.eclipse.jetty.webapp.JettyWebXmlConfiguration;
import org.eclipse.jetty.webapp.WebAppContext;
import servlets.FormServlet;

public class JettyServer {
    public static void main(String[] args) throws Exception {

        String webappDir = "C:\\Users\\computer\\TPJAD Projects\\ServletJettyEmbedded\\src\\main\\webapp";

        Server server = new Server(8080);
        WebAppContext context = new WebAppContext();
        server.setHandler(context);

        context.setResourceBase(webappDir);
        context.setContextPath("/");

        context.addServlet(FormServlet.class, "/calculateServlet");

        context.setAttribute("org.eclipse.jetty.server.webapp.ContainerIncludeJarPattern", ".*/[^/]*jstl.*\\.jar$");
        Configuration.ClassList classList = Configuration.ClassList.setServerDefault(server);
        classList.addBefore(JettyWebXmlConfiguration.class.getCanonicalName(), AnnotationConfiguration.class.getCanonicalName());
        classList.addAfter(FragmentConfiguration.class.getCanonicalName(), EnvConfiguration.class.getCanonicalName());

        server.start();
        server.join();
    }
}
