package com.trhiep.homnayangi.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.trhiep.homnayangi.R;
import com.trhiep.homnayangi.models.Ingredient;
import com.trhiep.homnayangi.services.ApiServices;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    
    private TextView tvData;
    private Button btnLoad;
    
    private void bindingView() {
        tvData = findViewById(R.id.tvData);
        btnLoad = findViewById(R.id.btnLoad);
    }
    private void bindingAction() {
        btnLoad.setOnClickListener(this::onBtnLoadClick);
    }

    private void onBtnLoadClick(View view) {
        ApiServices.getIngredientsApiEndpoint().getAllIngredients()
                .enqueue(new Callback<List<Ingredient>>() {
                    @Override
                    public void onResponse(Call<List<Ingredient>> call, Response<List<Ingredient>> response) {
                        List<Ingredient> ingredients = response.body();
                        String data = "";
                        for (Ingredient ingredient : ingredients) {
                            data += ingredient.toString() + "\n\n";
                        }
                        tvData.setText(data);
                    }

                    @Override
                    public void onFailure(Call<List<Ingredient>> call, Throwable t) {
                        tvData.setText(t.getMessage());
                    }
                });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        bindingView();
        bindingAction();
    }
}