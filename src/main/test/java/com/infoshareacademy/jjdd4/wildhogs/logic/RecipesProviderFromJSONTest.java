package com.infoshareacademy.jjdd4.wildhogs.logic;

import com.infoshareacademy.jjdd4.wildhogs.app.Configuration;
import com.infoshareacademy.jjdd4.wildhogs.data.Recipe;
import net.bytebuddy.dynamic.loading.ClassInjector;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.Properties;

import static java.util.Objects.isNull;
import static org.assertj.core.api.Assertions.assertThat;

class RecipesProviderFromJSONTest {

    //4 testy
    // - czy zwraca nulla jakjest zła kategoria -> Bad category in recipes file: " + jsonObject.get("name").toString(
    // - zła gramatura (300 amount) - > ad amount in recipes file in: " + recipe.getName
    // - zła jednostka (gram ) -> Bad unit in recipes file: " + recipe.getName(
    // - czy jak wszystko jest ok zwraca przepis  -> return recipe;
    
    @Test
    void readsRecipesProviderAsNull() {

       Properties properties = new Properties();
        JSONProvider json = new JSONProvider();
        Recipe recipe = new Recipe(readsRecipesProviderAsNull());
        JSONObject jsonObject = new JSONObject();
        assertThat( jsonObject.get( "Bad category in recipes file:" +  jsonObject.get("name").toString()).isNull.isInstanceOf( JSONArray.class );
    }
}

//    @Test
//    void ReturnEmptyObject() {
//        Properties properties = new Properties();
//        properties.setProperty( "jsonPath", "invalid_file" );
//
//        Configuration configuration = new Configuration( properties );
//        JSONProvider json = new JSONProvider();
//
//        JSONObject jsonObject = json.read( configuration );
//
//        assertThat( jsonObject ).isNotNull();
//        assertThat( jsonObject.isEmpty() ).isTrue();
//
//