package com.totoro_fly.journey;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by totoro-fly on 2016/12/30.
 */

public class SceneryAdapter extends ArrayAdapter {

    public SceneryAdapter(Context context, ArrayList<Scenery> resource) {
        super(context, 0, resource);
    }

    private static class ViewHolder {
        ImageView imageView;
        TextView titel;
        TextView content;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        ViewHolder viewHolder;
        if (itemView == null) {
            itemView = LayoutInflater.from(getContext()).inflate(R.layout.scenery_list_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView) itemView.findViewById(R.id.item_image);
            viewHolder.titel = (TextView) itemView.findViewById(R.id.item_title);
            viewHolder.content = (TextView) itemView.findViewById(R.id.item_content);
            itemView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Scenery scenery = (Scenery) getItem(position);
        viewHolder.imageView.setImageResource(scenery.getmImage());
        viewHolder.titel.setText(scenery.getmTitel());
        viewHolder.content.setText(scenery.getmContent());
        return itemView;

    }
}
