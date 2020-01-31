package com.example.millet.gestionbiblix.outil;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.millet.gestionbiblix.R;
import com.example.millet.gestionbiblix.view.MainActivity;



public class GridViewAdapter extends BaseAdapter {


    String[] result;
    Context context;
    int[] image;
    private static LayoutInflater inflater = null;

    public GridViewAdapter(MainActivity mainActivity, String[] ListeLivre, int[] osImages) {
        // TODO Auto-generated constructor stub
        result = ListeLivre;
        context = mainActivity;
        image = osImages;
        inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);


    }

    @Override
    public int getCount() {
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class Holder {
        TextView os_text;
        ImageView os_img;
    }

    @Override
    public View getView(final int position, View convertview, ViewGroup parent) {
        Holder holder = new Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.single_item, null);
        holder.os_text = (TextView) rowView.findViewById(R.id.textview);
        holder.os_img = (ImageView) rowView.findViewById(R.id.imageview);

        holder.os_text.setText(result[position]);
        holder.os_img.setImageResource(image[position]);

        /*rowView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(context,result[position], Toast.LENGTH_SHORT).show();
            }
        });
*/
        return rowView;
    }
}
