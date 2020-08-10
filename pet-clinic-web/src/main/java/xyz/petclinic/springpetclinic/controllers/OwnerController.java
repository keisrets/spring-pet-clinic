package xyz.petclinic.springpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import xyz.petclinic.springpetclinic.model.Owner;
import xyz.petclinic.springpetclinic.services.OwnerService;

import java.util.List;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @InitBinder
    public void setAllowedField(WebDataBinder webDataBinder) {
        webDataBinder.setDisallowedFields("id");
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String listOwners(Model model) {
        model.addAttribute("owners", ownerService.findAll());
        return "owner/index";
    }

    @RequestMapping({"/find", "/oups"})
    public String findOwners(Model model) {
        model.addAttribute("owner", Owner.builder().build());
        return "owner/findOwners";
    }

    @GetMapping
    public String processFindForm(Owner owner, BindingResult bindingResult, Model model) {
        if(owner.getLastName() == null) {
            owner.setLastName("");
        }

        List<Owner> results = ownerService.findAllByLastNameLike("%" + owner.getLastName() + "%");

        if(results.isEmpty()) {
            bindingResult.rejectValue("lastName", "notFound");
            return "owner/findOwners";
        } else if(results.size() == 1) {
            owner = results.get(0);
            return "redirect:/owners/" + owner.getId();
        } else {
            model.addAttribute("selections", results);
            return "owner/ownersList";
        }
    }

    @GetMapping("/{ownerId}")
    public ModelAndView showOwner(@PathVariable("ownerId") Long id) {
        ModelAndView mav = new ModelAndView("owner/ownerDetails");
        mav.addObject(this.ownerService.findById(id));
        return mav;
    }
}