import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

public class DutyPlannerService extends Service<DutyPlannerConfiguration> {
    public static void main(String[] args) throws Exception {
        new DutyPlannerService().run(args);
    }

    @Override
    public void initialize(Bootstrap<DutyPlannerConfiguration> bootstrap) {
        bootstrap.setName("hello-world");
    }

    @Override
    public void run(DutyPlannerConfiguration configuration,
                    Environment environment) {
        final String template = configuration.getTemplate();
        final String defaultName = configuration.getDefaultName();
        environment.addResource(new DutyPlannerResource(template, defaultName));
        environment.addHealthCheck(new DutyPlannerHealthCheck(template));
    }

}