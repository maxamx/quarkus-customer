package maxamx.producer;

import io.smallrye.mutiny.Multi;
import maxamx.model.Customer;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.UUID;

@Path("/customers")
public class CustomerResource {
    @Channel("2mgt1okd-customers-requests")
    Emitter<String> customerRequestEmiter;

    @POST
    @Path("/request")
    @Produces(MediaType.TEXT_PLAIN)
    public String createRequest(){
        UUID uuid = UUID.randomUUID();
        customerRequestEmiter.send(uuid.toString());
        return uuid.toString();
    }

    @Channel("2mgt1okd-customers")
    Multi<Customer> customers;

    @GET
    @Produces(MediaType.SERVER_SENT_EVENTS)
    public Multi<Customer> stream(){
        return customers;
    }

}
