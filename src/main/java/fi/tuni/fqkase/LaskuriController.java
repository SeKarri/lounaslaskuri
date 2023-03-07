package fi.tuni.fqkase;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

@Controller

public class LaskuriController {

    @GetMapping("/lounaslaskuri")
    public String lounaskysy(Model model) {
        model.addAttribute("lounaslaskuri", new Laskuri());
        return "kysy";
    }

    @PostMapping("/lounaslaskuri")
    public String lounastulosta(@ModelAttribute Laskuri lounaslaskuri, Model model) {
        model.addAttribute("lounaslaskuri", lounaslaskuri);
        return "tulosta";
    }
}
