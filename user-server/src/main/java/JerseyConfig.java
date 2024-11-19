import org.glassfish.jersey.server.ResourceConfig;
import jakarta.ws.rs.ApplicationPath;

@ApplicationPath("/user-server") // Chemin de base pour tous les endpoints
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        packages("."); // Scanne tout le package courant pour trouver les classes JAX-RS
    }
}
