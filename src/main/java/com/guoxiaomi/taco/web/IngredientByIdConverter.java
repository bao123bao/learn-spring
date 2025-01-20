package com.guoxiaomi.taco.web;

import com.guoxiaomi.taco.Ingredient;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {
    private Map<String, Ingredient> ingredientMap = new HashMap<>();

    public IngredientByIdConverter() {
        ingredientMap.put("FLTO", new Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP));
        ingredientMap.put("FLTO2", new Ingredient("FLTO2", "Flour Tortilla 2", Ingredient.Type.WRAP));
        ingredientMap.put("GRBF", new Ingredient("GRBF", "Beef asdas", Ingredient.Type.PROTEIN));
        ingredientMap.put("GRBF2", new Ingredient("GRBF2", "Beef asdas 2", Ingredient.Type.PROTEIN));
        ingredientMap.put("TMTO", new Ingredient("TMTO", "Tomato aesdsa", Ingredient.Type.VEGGIES));
        ingredientMap.put("TMTO2", new Ingredient("TMTO2", "Tomato aesdsa 2", Ingredient.Type.VEGGIES));
        ingredientMap.put("JCAK", new Ingredient("JCAK", "Jack Cheese", Ingredient.Type.CHEESE));
        ingredientMap.put("SLSA", new Ingredient("SLSA", "Salad asdasd", Ingredient.Type.SAUCE));
        ingredientMap.put("SPCR", new Ingredient("SPCR", "Salad spiced", Ingredient.Type.SAUCE));
    }

    @Override
    public Ingredient convert(String id){
        return ingredientMap.get(id);
    }
}
