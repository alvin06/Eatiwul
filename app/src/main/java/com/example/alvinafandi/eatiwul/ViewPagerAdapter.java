package com.example.alvinafandi.eatiwul;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewPagerAdapter extends PagerAdapter{

    private Context context;
    private LayoutInflater layoutInflater;
    private Integer [] images = {R.drawable.cute_deer,R.drawable.little_kitty,R.drawable.uniwhale};
    private String [] name = {"Cute Deer","Little Kitty","Uniwhale"};
    public ViewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }



    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.custom_layout,null);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView3);
        TextView textView = (TextView) view.findViewById(R.id.textView2);
        imageView.setImageResource(images[position]);
        textView.setText(name[position]);
        ViewPager vp = (ViewPager) container;
        vp.addView(view,0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);
    }
}
