package com.guoxiaomi.taco.web;


import com.guoxiaomi.taco.Taco;
import com.guoxiaomi.taco.TacoOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.guoxiaomi.taco.Ingredient.Type;
import com.guoxiaomi.taco.Ingredient;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController {

    @ModelAttribute
    public void addIngredientsToModel(Model model){
        List<Ingredient> ingredients = Arrays.asList(
            new Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
                new Ingredient("FLTO2", "Flour Tortilla 2", Type.WRAP),
                new Ingredient("GRBF", "Beef asdas", Type.PROTEIN),
                new Ingredient("GRBF2", "Beef asdas 2", Type.PROTEIN),
                new Ingredient("TMTO", "Tomato aesdsa", Type.VEGGIES),
                new Ingredient("TMTO2", "Tomato aesdsa 2", Type.VEGGIES),
                new Ingredient("JCAK", "Jack Cheese", Type.CHEESE),
                new Ingredient("SLSA", "Salad asdasd", Type.SAUCE),
                new Ingredient("SPCR", "Salad spiced", Type.SAUCE)
        );
        
        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
    }

    @ModelAttribute(name="tacoOrder")
    public TacoOrder order() {
        return new TacoOrder();
    }

    @ModelAttribute(name="taco")
    public Taco taco(){
        return new Taco();
    }

    @GetMapping
    public String showDesignForm(){
        return "design";
    }

    @PostMapping
    public String processTaco(Taco taco, @ModelAttribute TacoOrder tacoOrder) {
        tacoOrder.addTaco(taco);
        log.info("Processing taco: {}", taco);
        return "redirect:/orders/current";
    }

    private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, Type type){
        return ingredients
                .stream()
                .filter(x->x.getType().equals(type))
                .collect(Collectors.toList());
    }



}
