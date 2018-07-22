package com.ali.kilic.mygalery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ekranda nesneleri göterme
        recyclerView =(RecyclerView) findViewById(R.id.recyclerView);
        GaleriAdapter galeriAdapter=new GaleriAdapter(this,Galeri.getData());
        recyclerView.setAdapter(galeriAdapter);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,4);
        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.layout_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case R.id.linerViewHorizontal:
                LinearLayoutManager linearLayoutManagerH=new LinearLayoutManager(this);
                linearLayoutManagerH.setOrientation(LinearLayoutManager.HORIZONTAL);
                recyclerView.setLayoutManager(linearLayoutManagerH);
            break;
            case R.id.linerViewVertical:
                LinearLayoutManager linearLayoutManagerV=new LinearLayoutManager(this);
                linearLayoutManagerV.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(linearLayoutManagerV);
                break;
            case  R.id.GridView:
                GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
                gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(gridLayoutManager);
                break;
            case  R.id.staggeredViewHorizontal:
                StaggeredGridLayoutManager gridLayoutManagerH=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.HORIZONTAL);
                recyclerView.setLayoutManager(gridLayoutManagerH);
                break;
            case  R.id.staggeredViewVertical:
                StaggeredGridLayoutManager gridLayoutManagerV=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(gridLayoutManagerV);
                break;


        }
        return super.onOptionsItemSelected(item);
    }
}