import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

public class ContactConfiguration extends Configuration {
    private String template;

    @JsonProperty
    public String getTemplate() {
        return template;
    }

    @JsonProperty
    public void setTemplate(String template) {
        this.template = template;
    }
}
