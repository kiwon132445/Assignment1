package ca.bcit.assignment1;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import ca.bcit.assignment1.R;

public class TitleAdapter extends ArrayAdapter<Article>{
    private Context _context;
    TitleAdapter(Context context, ArrayList<Article> articles) {
        super(context, 0,articles);
        _context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Activity activity = (Activity) _context;
        Article article = getItem(position);
        // Get the data item for this position
        // Check if an existing view is being reused, otherwise inflate the view
        /*
        * ! Need to replace 'R.layout.list_row_layout' with the layout.xml file you use to
        *  Display an article
        *
        *
        * */
        if (convertView == null) {
           convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_list, parent, false);
        }


        TextView articleTitle = (TextView)convertView.findViewById(R.id.titleList);
        if(article != null) {
            articleTitle.setText(article.getTitle());
        }
        return convertView;
    }
}
