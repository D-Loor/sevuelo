package ec.sevolutivo.sevuelos.sevuelos.config;

import ec.sevolutivo.sevuelos.sevuelos.SevuelosApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SevuelosApplication.class);
    }

}
