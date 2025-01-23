package com.projects.customerservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RefreshScope
/* hadi il va indiquer a spring que ce controller il va etre instancier (càd ytcréa mn jdid) a chaque fois on a
refresher la config ay f kol mra changina f la config-repo */
public class ConfigTestRestController {

    @Value("${global.params.p1}")
    private String p1;

    @Value("${global.params.p2}")
    private String p2;

    @Autowired
    private CustomerConfigParams customerConfigParams;

    @GetMapping("/testConfig1")
    public Map<String,String> configTest1() {
        return Map.of("p1", p1, "p2", p2);
    }

    @GetMapping("/testConfig2")
    public CustomerConfigParams configTest2() {
        return customerConfigParams;
    }

    /* hna aprés ma derna hadchi ghadi nchangiw f config repo ghadi nchangiw p1 et p2 aprés khass dir commit
    aprés ma drna commit db ghanchofo wach tchanjaw les params donc ila dekhalna l config server ay
    f http://localhost:9999/customer-service/default ghadi nl9aw les params tchanjaw mais ila dekhalna b
    http://localhost:8081/testConfig1 ghanl9aw ga3 matchanjaw => alors hna khassna ndiro un refresh
    l customer service w bach ndiroha b actuator ay ghadi nsefto request POST l
    http://localhost:8081/actuator/refresh mais wakha hakak ila refrechiti page ghadi tal9a matbadloch ay khassk
    tatredemaré server donc hna khassk darori tzid wahd annotation @RefreshScope f had lcontroller bach yb9a
    ytrefresha une fois l9a chi changement db ila changiti w commitit w sefteti req POST une fois dir refresh
    l page ghadi tal9a bila tchanjaw
    */
}
