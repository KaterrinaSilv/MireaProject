package ru.mirea.serebriakovaea.mireaproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class ViewPageAdapter extends PagerAdapter {

    Context context;

    int image[] = {
            R.drawable.ruk,
            R.drawable.ruk,
            R.drawable.ruk
    };
    int titles[] = {
            R.string.title1,
            R.string.title2,
            R.string.title3
    };
    int texts[] = {
            R.string.text1,
            R.string.text2,
            R.string.text3
    };

    public ViewPageAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (LinearLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slider_layout, container, false);

        ImageView slideTitleImage = (ImageView) view.findViewById(R.id.titleImage);
        TextView slideTitleText = (TextView) view.findViewById(R.id.textTitle);
        TextView slideTextContent = (TextView) view.findViewById(R.id.textContent);

        slideTitleImage.setImageResource(image[position]);
        slideTitleText.setText(titles[position]);
        slideTextContent.setText(texts[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout) object);
    }
}
