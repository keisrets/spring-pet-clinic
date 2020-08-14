package xyz.petclinic.springpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import xyz.petclinic.springpetclinic.model.Owner;
import xyz.petclinic.springpetclinic.model.Pet;
import xyz.petclinic.springpetclinic.model.PetType;
import xyz.petclinic.springpetclinic.services.OwnerService;
import xyz.petclinic.springpetclinic.services.PetService;
import xyz.petclinic.springpetclinic.services.PetTypeService;

import javax.validation.Valid;
import java.util.Collection;

@Controller
@RequestMapping("/owners/{ownerId}")
public class PetController {

    private final PetService pets;
    private final OwnerService owners;
    private final PetTypeService petType;

    public PetController(PetService pets, OwnerService owners, PetTypeService petType) {
        this.pets = pets;
        this.owners = owners;
        this.petType = petType;
    }

    @ModelAttribute("types")
    public Collection<PetType> populatePetTypes() {
        return petType.findAll();
    }

    @ModelAttribute("owner")
    public Owner findOwner(@PathVariable("ownerId") Long ownerId) {
        return owners.findById(ownerId);
    }

    @InitBinder("owner")
    public void initOwnerBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @GetMapping("/pets/new")
    public String initCreationForm(Owner owner, Model model) {
        Pet pet = new Pet();
        owner.getPets().add(pet);
        pet.setOwner(owner);
        model.addAttribute("pet", pet);
        return "pet/createOrUpdatePetForm";
    }

    @PostMapping("/pets/new")
    public String processCreationForm(Owner owner, @Valid Pet pet, BindingResult bindingResult, Model model) {
//        if(StringUtils.hasLength(pet.getName()) && pet.isNew()) {
//            bindingResult.rejectValue("name", "duplicate", "already exists");
//        }
        owner.getPets().add(pet);
        pet.setOwner(owner);
        if(bindingResult.hasErrors()) {
            model.addAttribute("pet", pet);
            return "pet/createOrUpdatePetForm";
        } else {
            pets.save(pet);

            return "redirect:/owners/" + owner.getId();
        }
    }

}
