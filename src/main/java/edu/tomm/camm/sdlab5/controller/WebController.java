package edu.tomm.camm.sdlab5.controller;

import edu.tomm.camm.sdlab5.SdLab5Application;
import edu.tomm.camm.sdlab5.entities.Corso;
import edu.tomm.camm.sdlab5.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class WebController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/addEsame")
    public String addEsame() {
        return "addEsame";
    }

    @GetMapping("api/{IDCorsoDiLaurea}/{IDEsame}/editEsame")
    public String editEsame(@PathVariable String IDCorsoDiLaurea, @PathVariable String IDEsame) {
        Corso cs = SdLab5Application.corsi.stream()
                    .filter(c -> c.getCorsoDiLaurea().equals(IDCorsoDiLaurea))
                    .findFirst()
                    .orElseThrow(ResourceNotFoundException::new);

        cs.getEsami().stream()
                .filter(c -> c.getNome().equals(IDEsame))
                .findFirst()
                .orElseThrow(ResourceNotFoundException::new);

        return "editEsame";
    }
}
