package sg.edu.rp.c346.pdapp4;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ShowAdapter extends ArrayAdapter<Show> {

    private ArrayList<Show> show;
    private Context context;
    private TextView tvShowTitle, tvShowLanguage, tvShowGenre;
    private ImageView ivSong, ivStar, ivStar2, ivStar3, ivStar4, ivStar5;

    public ShowAdapter(Context context, int resource, ArrayList<Show> objects){
        super(context, resource, objects);
        show = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.custom_layout, parent, false);

        tvShowTitle = rowView.findViewById(R.id.tvShowTitle);
        tvShowLanguage = rowView.findViewById(R.id.tvShowLanguage);
        tvShowGenre = rowView.findViewById(R.id.tvShowGenre);

        ivSong = rowView.findViewById(R.id.ivShow);

        ivStar = rowView.findViewById(R.id.ivStar);
        ivStar2 = rowView.findViewById(R.id.ivStar2);
        ivStar3 = rowView.findViewById(R.id.ivStar3);
        ivStar4 = rowView.findViewById(R.id.ivStar4);
        ivStar5 = rowView.findViewById(R.id.ivStar5);

        int count = position;
        Show currentShow = show.get(position);



        tvShowTitle.setText(currentShow.getShows());
        tvShowLanguage.setText(currentShow.getLanguage());

        tvShowGenre.setText(currentShow.getGenre());

        ivSong.setImageResource(R.drawable.show);



        if(currentShow.getStars() == 5) {
            ivStar.setImageResource(R.drawable.star);
            ivStar2.setImageResource(R.drawable.star);
            ivStar3.setImageResource(R.drawable.star);
            ivStar4.setImageResource(R.drawable.star);
            ivStar5.setImageResource(R.drawable.star);



        }
        else if(currentShow.getStars() == 4) {
            ivStar.setImageResource(R.drawable.star);
            ivStar2.setImageResource(R.drawable.star);
            ivStar3.setImageResource(R.drawable.star);
            ivStar4.setImageResource(R.drawable.star);
            ivStar5.setImageResource(R.drawable.nostar);
        }

        else if(currentShow.getStars() == 3) {
            ivStar.setImageResource(R.drawable.star);
            ivStar2.setImageResource(R.drawable.star);
            ivStar3.setImageResource(R.drawable.star);
            ivStar4.setImageResource(R.drawable.nostar);
            ivStar5.setImageResource(R.drawable.nostar);
        }

        else if(currentShow.getStars() == 2) {
            ivStar.setImageResource(R.drawable.star);
            ivStar2.setImageResource(R.drawable.star);
            ivStar3.setImageResource(R.drawable.nostar);
            ivStar4.setImageResource(R.drawable.nostar);
            ivStar5.setImageResource(R.drawable.nostar);
        }

        else if(currentShow.getStars() == 1) {
            ivStar.setImageResource(R.drawable.star);
            ivStar2.setImageResource(R.drawable.nostar);
            ivStar3.setImageResource(R.drawable.nostar);
            ivStar4.setImageResource(R.drawable.nostar);
            ivStar5.setImageResource(R.drawable.nostar);
        }

        else {
            ivStar.setImageResource(R.drawable.nostar);
            ivStar2.setImageResource(R.drawable.nostar);
            ivStar3.setImageResource(R.drawable.nostar);
            ivStar4.setImageResource(R.drawable.nostar);
            ivStar5.setImageResource(R.drawable.nostar);
        }


        return rowView;
    }

}
