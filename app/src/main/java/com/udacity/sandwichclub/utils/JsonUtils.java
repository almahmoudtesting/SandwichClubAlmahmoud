package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    private static final String SNAME ="name";
    private static final String SMAIN_NAME ="mainName";
    private static final String SALSO_KNOWN_AS = "alsoKnownAs";
    private static final String SPLACE_OF_ORIGIN ="placeOfOrigin";
    private static final String SDESCRIPTION ="description";
    private static final String SIMAGE ="image";
    private static final String SINGREDIENTS = "ingredients";


    public static Sandwich parseSandwichJson(String json) {

        Sandwich sandwich = new Sandwich();
        try {
            JSONObject jsonObject = new JSONObject(json);

            JSONObject name = jsonObject.getJSONObject(SNAME);

            sandwich.setMainName(name.getString(SMAIN_NAME));
            JSONArray alsoKnownAsJson = name.getJSONArray(SALSO_KNOWN_AS);
            List<String> alsoKnownAs = new ArrayList<>();
            for(int i=0 ; i< alsoKnownAsJson.length() ; i++){
                alsoKnownAs.add(alsoKnownAsJson.getString(i));
            }
            sandwich.setAlsoKnownAs(alsoKnownAs);
            sandwich.setPlaceOfOrigin(jsonObject.getString(SPLACE_OF_ORIGIN));
            sandwich.setDescription(jsonObject.getString(SDESCRIPTION));
            sandwich.setImage(jsonObject.getString(SIMAGE));
            JSONArray ingredientsJsonArray = jsonObject.getJSONArray(SINGREDIENTS);
            List<String> ingredients = new ArrayList<>();
            for(int i=0 ;i< ingredientsJsonArray.length(); i++){
                ingredients.add(ingredientsJsonArray.getString(i));
            }
            sandwich.setIngredients(ingredients);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sandwich;
    }
}
