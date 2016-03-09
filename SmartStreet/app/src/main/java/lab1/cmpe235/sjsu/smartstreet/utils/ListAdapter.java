package lab1.cmpe235.sjsu.smartstreet.utils;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import lab1.cmpe235.sjsu.smartstreet.R;
import lab1.cmpe235.sjsu.smartstreet.model.Direction;

/**
 * Created by sonthai on 3/3/16.
 */
public class ListAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Direction> directionArrayList;
    public ListAdapter(Context context, ArrayList<Direction> directionArrayList) {
        this.context = context;
        this.directionArrayList = directionArrayList;
    }
    @Override
    public int getCount() {
        return directionArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);;
        View listView;

        if (convertView == null) {
            listView = inflater.inflate(R.layout.list_row, null);
            Direction direction = directionArrayList.get(position);
            TextView instruction = (TextView) listView.findViewById(R.id.instruction);
            String ins = Html.fromHtml(direction.getInstruction()).toString();
            ins = ins.replaceAll("[\n\r]+", "\n");
            ins = ins.replaceAll("\n[ \t]*\n", "\n");
            instruction.setLines(ins.split("\n").length);
            instruction.setText(ins);
            TextView distance = (TextView) listView.findViewById(R.id.distance);
            distance.setText(direction.getDistance());
            TextView duration = (TextView) listView.findViewById(R.id.duration);
            duration.setText(direction.getDuration());
        } else {
            listView = (View) convertView;
        }

        return listView;
    }
}
