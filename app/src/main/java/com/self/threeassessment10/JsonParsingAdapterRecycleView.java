package com.self.threeassessment10;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
//
//public class JsonParsingAdapterRecycleView extends RecyclerView.Adapter<JsonParsingAdapterRecycleView.ViewHolder>
//{

//
//    ArrayList<FoodItems> detailsfood;
//    private Context context;
//
//
//
//    public JsonParsingAdapterRecycleView(Context context, ArrayList<FoodItems> detailsfood) {
//        this.detailsfood = detailsfood;
//        this.context = context;
//    }
//    //
//    public JsonParsingAdapterRecycleView(Context context) {
//        this.foodItemsList = foodItemsList;
//        this.context = context;
//    }

//    public class ViewHolder extends RecyclerView.ViewHolder
//    {
//        TextView foodname, foodprice;
//        ImageView foodimage;
//        public ViewHolder(@NonNull View itemView)
//        {
//                super(itemView);
//                foodname = itemView.findViewById(R.id.cardview_food_name);
//                foodprice = itemView.findViewById(R.id.cardview_food_price);
//                foodimage = itemView.findViewById(R.id.cardview_food_Image);
//
//        }

//    }
//
//
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
//    {
//
//        View convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_json_custom,parent,false);
//        return new ViewHolder(convertView);
//
//        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
//        View view = layoutInflater.inflate( R.layout.cardview_json_custom,parent,false );
//        ViewHolder viewHolder = new ViewHolder(view);
//        return viewHolder;

//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull JsonParsingAdapterRecycleView.ViewHolder holder, int position)
  //  {
//        FoodItems foodItems = detailsfood.get(position);
//        holder.foodname.setText(foodItems.getName());
//        holder.foodprice.setText(foodItems.getPrice());
//
//        try {
//            URL glideimageurl = new URL(foodItems.getImageurl());
//
//            Glide.with(context).load(glideimageurl).into(holder.foodimage);
//
//
//        }catch (Exception e){e.printStackTrace();}
//    }
//
//    @Override
//    public int getItemCount() {
//        return detailsfood.size();
//   }
//}
//