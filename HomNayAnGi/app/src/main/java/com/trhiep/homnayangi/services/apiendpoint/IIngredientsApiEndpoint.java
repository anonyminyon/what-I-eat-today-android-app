package com.trhiep.homnayangi.services.apiendpoint;

import com.trhiep.homnayangi.models.Ingredient;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface IIngredientsApiEndpoint {

    @GET("Ingredients")
    Call<List<Ingredient>> getAllIngredients();

    @GET("Ingredients/{id}")
    Call<Ingredient> getIngredientById(@Path("id") int id);

    @POST("Ingredients")
    Call<Ingredient> createIngredient(@Body Ingredient ingredient);

    @PUT("Ingredients/{id}")
    Call<Ingredient> updateIngredient(@Path("id") int id, @Body Ingredient ingredient);

    @DELETE("Ingredients/{id}")
    Call<Void> deleteIngredient(@Path("id") int id);
}
