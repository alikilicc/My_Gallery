package com.ali.kilic.mygalery;

import java.util.ArrayList;

public class Galeri {

    private int ImageID;
    private String baslik,tanim;

    public int getImageID() {
        return ImageID;
    }

    public String getBaslik() {
        return baslik;
    }

    public String getTanim() {
        return tanim;
    }

    public void setImageID(int imageID) {
        ImageID = imageID;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public void setTanim(String tanim) {
        this.tanim = tanim;
    }

    public static ArrayList<Galeri> getData(){

        ArrayList<Galeri> dataList=new ArrayList<Galeri>();
        //resimlerin id lerini diziye atılır
        int[] resimler= {
                R.drawable.chick, R.drawable.cockpng, R.drawable.cow, R.drawable.horse,
                R.drawable.sheep, R.drawable.thumb_1_5, R.drawable.thumb_1_6, R.drawable.thumb_1_7,
                R.drawable.thumb_1_8, R.drawable.thumb_1_9,

                R.drawable.thumb_2_0, R.drawable.thumb_2_1, R.drawable.thumb_2_2, R.drawable.thumb_2_3,
                R.drawable.thumb_2_4, R.drawable.thumb_2_5, R.drawable.thumb_2_6, R.drawable.thumb_2_7,
                R.drawable.thumb_2_8, R.drawable.thumb_2_9,

                R.drawable.thumb_3_0, R.drawable.thumb_3_1, R.drawable.thumb_3_2, R.drawable.thumb_3_3,
                R.drawable.thumb_3_4, R.drawable.thumb_3_5, R.drawable.thumb_3_6, R.drawable.thumb_3_7,
                R.drawable.thumb_3_8, R.drawable.thumb_3_9,

                R.drawable.thumb_4_0, R.drawable.thumb_4_1, R.drawable.thumb_4_2, R.drawable.thumb_4_3,
                R.drawable.thumb_4_4, R.drawable.thumb_4_5, R.drawable.thumb_4_6, R.drawable.thumb_4_7,
                R.drawable.thumb_4_8, R.drawable.thumb_4_9,

                R.drawable.thumb_5_0, R.drawable.thumb_5_1, R.drawable.thumb_5_2, R.drawable.thumb_5_3,
                R.drawable.thumb_5_4, R.drawable.thumb_5_5, R.drawable.thumb_5_6, R.drawable.thumb_5_7,
                R.drawable.thumb_5_8, R.drawable.thumb_5_9,

                R.drawable.thumb_6_0, R.drawable.thumb_6_1, R.drawable.thumb_6_2, R.drawable.thumb_6_3,
                R.drawable.thumb_6_4, R.drawable.thumb_6_5, R.drawable.thumb_6_6, R.drawable.thumb_6_7,
                R.drawable.thumb_6_8, R.drawable.thumb_6_9,

                R.drawable.thumb_7_0, R.drawable.thumb_7_1, R.drawable.thumb_7_2, R.drawable.thumb_7_3,
                R.drawable.thumb_7_4
        };
        for (int i=0;i<resimler.length;i++){
            Galeri gecici=new Galeri();
            gecici.setImageID(resimler[i]);
            gecici.setBaslik("Resim "+i);
            gecici.setTanim("Tanım Bilgisi "+i);

            dataList.add(gecici);
        }

        return dataList;
    }
}
