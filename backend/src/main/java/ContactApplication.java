import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class ContactApplication extends Application<ContactConfiguration> {

    public static void main(String[] args) throws Exception {
        new ContactApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<ContactConfiguration> bootstrap) {

    }

    public void run(ContactConfiguration configuration, Environment environment) {
        final ContactResource resource = new ContactResource();
        final ContactHealthCheck healthCheck =
                new ContactHealthCheck();
        environment.healthChecks().register("contact", healthCheck);
        environment.jersey().register(resource);
    }
}
