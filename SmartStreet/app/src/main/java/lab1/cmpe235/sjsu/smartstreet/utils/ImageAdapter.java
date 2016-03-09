package lab1.cmpe235.sjsu.smartstreet.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import lab1.cmpe235.sjsu.smartstreet.R;

/**
 * Created by sonthai on 2/27/16.
 */
public class ImageAdapter extends BaseAdapter {
    private Context context;
    private final String[] iconList;

    public ImageAdapter(Context context, String[] iconList) {
        this.context = context;
        this.iconList = iconList;
    }

    @Override
    public int getCount() {
        return iconList.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        if (convertView == null) {
            gridView = new View(context);

            // get layout from icon.xml
            gridView = inflater.inflate(R.layout.icon, null);

            // set value into textview
            if (!iconList[position].equals("Barcode")) {
                TextView textView = (TextView) gridView.findViewById(R.id.grid_item_label);
                textView.setText(iconList[position]);
            }
            // set image based on selected text
            ImageView imageView = (ImageView) gridView.findViewById(R.id.grid_item_image);

            String icon = iconList[position];
            //imageView.setImageResource(android.R.drawable.test);

            switch (icon) {
                case "About":
                    imageView.setImageResource(R.drawable.about);
                    break;
                case "Interact":
                    imageView.setImageResource(R.drawable.control);
                    break;
                case "Photo/Video":
                    imageView.setImageResource(R.drawable.video);
                    break;
                case "Share":
                    imageView.setImageResource(R.drawable.social_media);
                    break;
                case "Nearby":
                    imageView.setImageResource(R.drawable.map);
                    break;
                case "Comments":
                    imageView.setImageResource(R.drawable.feedback);
                    break;
                default:
                    imageView.setImageResource(R.drawable.smarttree);
                    break;


            }
        } else {
            gridView = (View) convertView;
        }

        return gridView;
    }
}
