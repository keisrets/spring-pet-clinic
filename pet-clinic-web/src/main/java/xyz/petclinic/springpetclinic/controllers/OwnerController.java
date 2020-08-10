package xyz.petclinic.springpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import xyz.petclinic.springpetclinic.model.Owner;
import xyz.petclinic.springpetclinic.services.OwnerService;

import javax.validation.Valid;
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

    @GetMapping("/new")
    public String newOwnerForm(Model model) {
        model.addAttribute("owner", Owner.builder().build());
        return "owner/createOrUpdateOwnerForm";
    }

    @PostMapping("/new")
    public String newOwner(@Valid Owner owner, BindingResult result) {
        if(result.hasErrors()) {
            return "owner/createOrUpdateOwnerForm";
        } else {
            Owner saved = ownerService.save(owner);
            return "redirect:/owners/" + saved.getId();
        }
    }

    @GetMapping("/{ownerId}/edit")
    public String editOwnerForm(@PathVariable("ownerId") Long ownerId, Model model) {
        model.addAttribute("owner", ownerService.findById(ownerId));
        return "owner/createOrUpdateOwnerForm";
    }

    @PostMapping("/{ownerId}/edit")
    public String editOwner(@Valid Owner owner, BindingResult result, @PathVariable("ownerId") Long ownerId) {
        if(result.hasErrors()) {
            return "owner/createOrUpdateOwnerForm";
        } else {
            owner.setId(ownerId);
            Owner saved = ownerService.save(owner);
            return "redirect:/owners/" + saved.getId();
        }
    }
}