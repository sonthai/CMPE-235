package lab1.cmpe235.sjsu.smartstreet.activity;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import lab1.cmpe235.sjsu.smartstreet.utils.ImageAdapter;
import lab1.cmpe235.sjsu.smartstreet.R;

public class HomeActivity extends Activity {
    GridView gridView;

    static final String[] icon_list = new String[] {
            "About", "Interact", "Photo/Video", "Share", "Comments", "Nearby", "Barcode"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        final Activity activity = this;
        activity.setTitle("About");

        gridView = (GridView) findViewById(R.id.gridView);

        gridView.setAdapter(new ImageAdapter(this, icon_list));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedView =  ((TextView) view.findViewById(R.id.grid_item_label)).getText().toString();
                Intent intent;
                if (selectedView.equals("About")) {
                    intent = new Intent(HomeActivity.this, AboutActivity.class);
                    startActivity(intent);
                } else if (selectedView.equals("Interact")) {

                } else if (selectedView.equals("Share")) {

                } else if (selectedView.equals("Nearby")) {
                    intent = new Intent(HomeActivity.this, NearbyActivity.class);
                    startActivity(intent);
                } else if (selectedView.equals("Photo/Video")) {

                } else if (selectedView.equals("Comments")){

                }

            }

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }
}
