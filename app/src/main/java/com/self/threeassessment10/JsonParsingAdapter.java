package com.self.threeassessment10;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.net.URL;
import java.util.List;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.net.URL;
import java.util.List;

//public class JsonParsingAdapter extends ArrayAdapter<FoodItems>
public class JsonParsingAdapter extends RecyclerView.Adapter<JsonParsingAdapter.ViewHolder>
{

    TextView name,price ;
    ImageView imgV;
    List<FoodItems> foodlist;
    private Context context;

    public JsonParsingAdapter(@NonNull Context context, @NonNull List<FoodItems> foodlist)
    {
        //super(context, R.layout.jsoncustomview, foodlist);
        this.context = context;
        this.foodlist = foodlist;

    }

//
//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
//    {
//        LayoutInflater inflater = (LayoutInflater)
//                getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
//
//        if(convertView == null){
//            convertView = inflater.inflate(R.layout.jsoncustomview,null);
//        }
//
//
//        name = (TextView) convertView.findViewById(R.id.tvProductionName);
//        price =(TextView) convertView.findViewById(R.id.tvProductionPrice);
//        imgV =(ImageView) convertView.findViewById(R.id.imageView);
//
//        // for fill into grid view
//        FoodItems foodItems = foodlist.get(position);
//        name.setText(foodItems.getName());
//        price.setText(foodItems.getPrice());
//
//        //Glide library  loading image view
//        // fill image into grid view by using glide library
//        try
//        {
//            URL glideimageurl = new URL(foodItems.getImageurl());
//
//            Glide.with(context).load(glideimageurl).into(imgV);
//
//            //
//
//            convertView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view)
//                {
//
//                }
//            });
//
//
//        }catch (Exception e){e.printStackTrace();}
//
//
//        return convertView;
//    }


    //--------------------------------------------------- recycler View -------------------------------




//    @NonNull
//    @Override
//    public class JsonParsingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        return null;
//    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView name,price ;
        ImageView imgV;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            name = (TextView) itemView.findViewById(R.id.cardview_food_name);
            price = (TextView) itemView.findViewById(R.id.cardview_food_price);
            imgV = (ImageView) itemView.findViewById(R.id.cardview_food_Image);


        }


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View convertView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_json_custom,parent,false);
        return new ViewHolder(convertView);

    }

    @Override
    public void onBindViewHolder(@NonNull JsonParsingAdapter.ViewHolder holder, int position)
    {
        FoodItems foodItems = foodlist.get(position);
        holder.name.setText(foodItems.getName());
        holder.price.setText(foodItems.getPrice());

        try {
            URL glideimageurl = new URL(foodItems.getImageurl());

            Glide.with(context).load(glideimageurl).into(holder.imgV);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return foodlist.size();
    }




    // ----------------------- end ---------------------------------------------

}
