package ca.bcit.assignment1;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import ca.bcit.assignment1.R;

public class ArticleAdapter extends ArrayAdapter<Article> {
    Context _context;
    public ArticleAdapter(Context context, ArrayList<Article> articles) {
        super(context, 0, articles);
        _context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Activity activity = (Activity) _context;
        // Get the data item for this position
        Article article = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view

        /*
        * ! Need to replace 'R.layout.list_row_layout' with the layout.xml file you use to
        *  Display an article
        *
        * */
        if (convertView == null) {
            // Goes here-> convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_row_layout, parent, false);
        }

    /* Lookup view for data population
    TextView tvFullName = convertView.findViewById(R.id.fullName);
    TextView tvOccupation = convertView.findViewById(R.id.occupation);
    TextView tvGender = convertView.findViewById(R.id.gender); */

    /* Populate the data into the template view using the data object
    tvFullName.setText(String.format("%s %s", article.getFirstName(), article.getLastName()));
    tvOccupation.setText(article.getOccupation());
    tvGender.setText(article.getGender()); */

    /* Populate the image view as well
    ImageView imgOnePhoto = convertView.findViewById(R.id.thumbImage);
    if (article.getPictureUrl() != null) {
        new ImageDownloaderTask(imgOnePhoto).execute(article.getPictureUrl());
    }*/

        // Return the completed view to render on screen
        return convertView;
    }
}
