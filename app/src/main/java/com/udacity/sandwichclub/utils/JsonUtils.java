package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        try {
            JSONObject sandwichJson = new JSONObject(json);
            JSONObject name = sandwichJson.getJSONObject("name");
            String mainName = name.optString("mainName");
            String placeOfOrigin = sandwichJson.optString("placeOfOrigin");
            String description = sandwichJson.optString("description");
            String image = sandwichJson.optString("image");
            JSONArray namearray = name.optJSONArray("alsoKnownAs");
            List<String> alsoKnownAs = new ArrayList<>();
            for (int i = 0; i < namearray.length(); i++) {
                alsoKnownAs.add(namearray.optString(i));
            }
            JSONArray ingredientarray = sandwichJson.optJSONArray("ingredients");
            List<String> ingredients = new ArrayList<>();
            for (int i = 0; i < ingredientarray.length(); i++) {
                ingredients.add(ingredientarray.optString(i));
            }
            return new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);
        }  catch (JSONException e) {
            throw new RuntimeException(e);
        }


    }
}
