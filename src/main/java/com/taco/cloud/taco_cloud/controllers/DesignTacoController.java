package com.taco.cloud.taco_cloud.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.taco.cloud.taco_cloud.entities.IngredientEntity;
import com.taco.cloud.taco_cloud.entities.TacoEntity;
import com.taco.cloud.taco_cloud.entities.IngredientEntity.Type;

@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController {

    @ModelAttribute // ejecuta esto antes de cualquier peticion a esta clase
    public void addIngredientsToModel(Model model) {
        List<IngredientEntity> ingredients = Arrays.asList(
                new IngredientEntity("FLTO", "Flour Tortilla", Type.WRAP),
                new IngredientEntity("COTO", "Corn Tortilla", Type.WRAP),
                new IngredientEntity("GRBF", "Ground Beef", Type.PROTEIN),
                new IngredientEntity("CARN", "Carnitas", Type.PROTEIN),
                new IngredientEntity("TMTO", "Diced Tomatoes", Type.VEGGIES),
                new IngredientEntity("LETC", "Lettuce", Type.VEGGIES),
                new IngredientEntity("CHED", "Cheddar", Type.CHEESE),
                new IngredientEntity("JACK", "Monterrey Jack", Type.CHEESE),
                new IngredientEntity("SLSA", "Salsa", Type.SAUCE),
                new IngredientEntity("SRCR", "Sour Cream", Type.SAUCE));

        Type[] types = Type.values();

        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }
    }

    @GetMapping
    public String showDesignForm(Model model) {
        model.addAttribute("taco", new TacoEntity());
        return "design";
    }

    @PostMapping
    public String processTaco(TacoEntity taco) {
        System.out.println("Prcessing taco " + taco);
        return "redirect:/orders/current";
    }

    private Iterable<IngredientEntity> filterByType(List<IngredientEntity> ingredients, Type type) {
        return ingredients.stream().filter(x -> x.getType() == type).collect(Collectors.toList());
    }

}
