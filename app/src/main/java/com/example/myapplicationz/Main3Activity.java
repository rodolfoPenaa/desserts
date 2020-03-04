package com.example.myapplicationz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.Toast;

import com.example.myapplicationz.R;
import com.example.myapplicationz.adapters.DessertsAdapter;
import com.example.myapplicationz.model.Desserts;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity implements DessertsAdapter.OnItemClickListener {
private RecyclerView mRecyclerView;
private DessertsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        mRecyclerView = findViewById(R.id.gridview);
        mAdapter = new DessertsAdapter(initializeDesserts(),this,this);
        mRecyclerView.setAdapter(mAdapter);
        //recyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));

    }
    private List<Desserts> initializeDesserts(){
       List<Desserts> desserts = new ArrayList<>();
       desserts.add(new Desserts(R.drawable.brownie_banana,"Banana Brownie"));
       desserts.add(new Desserts(R.drawable.galletas_rapidas_de_auyama_y_banano, "Quick Auyama and Banana Cookies"));
       desserts.add(new Desserts(R.drawable.mandocas_hormenadas, "Baked Mandocas"));
       desserts.add(new Desserts(R.drawable.muffins_de_pan_con_zanohoria, "Carrot Muffins"));
       desserts.add(new Desserts(R.drawable.muffins_integrales, "Integral Muffin"));
       desserts.add(new Desserts(R.drawable.palmeritas_de_banana,"Banana Palmeritas"));
       desserts.add(new Desserts(R.drawable.pan_de_calabacin_750x300, "Zucchini Bread"));
       desserts.add(new Desserts(R.drawable.panquecas_de_cacao_con_topping_de_banana, "Cacao Pankakes with Banana Topping"));
    return desserts;
    }

        private void instanceDetailFragment(String dessertName, int url){
        DetailFragment detailFragment = DetailFragment.newInstance(dessertName,url);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.layoutforFragment, detailFragment, "DetailFragment")
                .addToBackStack(String.valueOf(url))
                .commit();
    }

    @Override
    public void onClick(DessertsAdapter.ViewHolder viewHolder, String imageView, int id) {
        Toast.makeText(this, imageView, Toast.LENGTH_SHORT).show();
        instanceDetailFragment(imageView, id);
    }
}
