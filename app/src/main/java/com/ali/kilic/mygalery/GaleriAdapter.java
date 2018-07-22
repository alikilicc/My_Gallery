package com.ali.kilic.mygalery;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class GaleriAdapter extends RecyclerView.Adapter<GaleriAdapter.MyViewHolder> {

    ArrayList<Galeri> mDataList;
    LayoutInflater inflater;
    public GaleriAdapter(Context context,ArrayList<Galeri> data){
        //inflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        inflater=LayoutInflater.from(context);
        this.mDataList=data;
    }

    @NonNull
    @Override
    //ekranda görülen nesneler için inflation(xml den javaya dönüşüm) işlemi yapıyor
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //list_item layout unu xml den javaya çevir ve v nin içine at
        View v=inflater.inflate(R.layout.list_item,parent,false);
        MyViewHolder holder=new MyViewHolder(v);
        return holder;
    }

    @Override
    //position tıklanılan öğenin kaçıncı öğe olduğunu belirtir ve ilgili yere ilgili layoıut u atar.
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
       //tıklanılan öğe bilgilerini tiklanilan nın içine atar
        Galeri tiklanilan=mDataList.get(position);
        holder.setData(tiklanilan,position);

    }

    public void deleteItem(int position){
        mDataList.remove(position);
        notifyItemRemoved(position);//update sonrası listeyi güncelleri,silme efekti
        notifyItemRangeChanged(position,mDataList.size());//silme işleminden sonra pozisyonları düzenler
    }
    public void copyAddItem(int position,Galeri kopyResim){
        mDataList.add(position,kopyResim);
        notifyItemRemoved(position);//update sonrası listeyi güncelleri,ekleme efekti
        notifyItemRangeChanged(position,mDataList.size());//kopyalama işleminden sonra pozisyonları düzenler
        //notifyDataSetChanged();  //yukurıdaki iki kod parçasının işini yapar ama performansı düşürür.
    }
    @Override
    //veri ekleme işlmemri yapılır
    public int getItemCount() {
        return mDataList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView mGaleriBaslik,mGaleriTanim;
        ImageView mGaleriResim,mGaleriSil,mGaleriKopyala;
        int secilenOgePosition=0;
        Galeri kopyalananResim;

        public MyViewHolder(View itemView) {
            super(itemView);
            mGaleriBaslik=(TextView) itemView.findViewById(R.id.BaslikID);
            mGaleriTanim=(TextView) itemView.findViewById(R.id.TanimID);
            mGaleriResim=(ImageView) itemView.findViewById(R.id.ResimID);
            mGaleriSil=(ImageView) itemView.findViewById(R.id.DeleteID);
            mGaleriKopyala=(ImageView) itemView.findViewById(R.id.CopyID);

            mGaleriSil.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    deleteItem(secilenOgePosition);
                }
            });
            mGaleriKopyala.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    copyAddItem(secilenOgePosition,kopyalananResim);
                }
            });

        }
//tıklanılan öğe bilgilerini ilgili nesnelere atar
        public void setData(Galeri tiklanilan, int position) {
            this.mGaleriBaslik.setText(tiklanilan.getBaslik());
            this.mGaleriTanim.setText(tiklanilan.getTanim());
            this.mGaleriResim.setImageResource(tiklanilan.getImageID());
            this.secilenOgePosition=position;
            this.kopyalananResim=tiklanilan;

        }
    }
}
