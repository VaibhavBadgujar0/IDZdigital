package com.example.idzdigital;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adaptery extends RecyclerView.Adapter<Adaptery.MyViewHolder> {

    private final String mContext;
    private final List<EmployeeDetailsClass> mData;


    public Adaptery(String mContext, List<EmployeeDetailsClass> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        v = inflator.inflate(R.layout.Employee_items, parent, attachToRoot:false);


        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.name.setText(mData.get(position).getName());
        holder.age.setText(mData.get(position).getAge());
        holder.salary.setText(mData.get(position).getSalary());



    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        TextView age;
        TextView salary;




        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name_text);
            age = itemView.findViewById(R.id.age_text);
            salary = itemView.findViewById(R.id.salary_text);


        }
    }


}
