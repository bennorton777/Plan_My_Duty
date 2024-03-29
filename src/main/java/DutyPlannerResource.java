import com.google.common.base.Optional;
import com.yammer.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class DutyPlannerResource {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public DutyPlannerResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public DataPojo sayHello(@QueryParam("name") Optional<String> name) {
        return new DataPojo(counter.incrementAndGet(),
                String.format(template, name.or(defaultName)));
    }
}