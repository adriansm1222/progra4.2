package docs.resources;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import org.glassfish.jersey.media.multipart.MultiPartFeature;

@ApplicationPath("api")
public class RestConfiguration extends Application{
    @Override
    public Set<Class<?>> getClasses() {
        HashSet<Class<?>> classes = new HashSet<>();
        classes.add(MultiPartFeature.class);
        classes.add(docsBackEnd.class);      
        return classes;
    }       
}
