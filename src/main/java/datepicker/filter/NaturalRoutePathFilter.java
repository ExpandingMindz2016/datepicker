package datepicker.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NaturalRoutePathFilter {

    protected final transient Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/public/**")
    public String redirect_public() {
        logger.debug("In NaturalRoutePathFilter (PUBLIC clause)");
        return "forward:/";
    }

    @RequestMapping(value = "/auth/**")
    public String redirect_auth() {
        logger.debug("In NaturalRoutePathFilter (AUTH clause)");
        return "forward:/";
    }

    @RequestMapping(value = "/secure/**")
    public String redirect_secure() {
        logger.debug("In NaturalRoutePathFilter (SECURE clause)");
        return "forward:/";
    }

    @RequestMapping(value = "/forgot/**")
    public String redirect_forgot() {
        logger.debug("In NaturalRoutePathFilter (FORGOT clause)");
        return "forward:/";
    }

    @RequestMapping(value = "/{[path:[^\\.]*}")
    public String redirect_generic() {
        logger.debug("In NaturalRoutePathFilter (GENERIC clause)");
        return "forward:/";
    }
}
