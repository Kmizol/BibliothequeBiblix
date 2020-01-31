package com.example.millet.gestionbiblix.outil;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.millet.gestionbiblix.R;
import com.example.millet.gestionbiblix.modele.Livre;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    Context c;
    ArrayList<Livre> livres;
    LayoutInflater inflater;

    public CustomAdapter(Context c, ArrayList<Livre> livres) {
        this.c = c;
        this.livres = livres;

        inflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return livres.size();
    }

    @Override
    public Object getItem(int position) {
        return livres.get(position);
    }

    @Override
    public long getItemId(int position) {
        return livres.get(position).getId();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if(convertView==null)
        {
            convertView=inflater.inflate(R.layout.model_liste_livre,parent,false);
        }

        TextView titreText =(TextView) convertView.findViewById(R.id.titreTxt);
        TextView auteurText =(TextView) convertView.findViewById(R.id.auteurTxt);
        TextView editeurText =(TextView) convertView.findViewById(R.id.editeurTxt);
        TextView genreText =(TextView) convertView.findViewById(R.id.genreTxt);
        TextView DescText =(TextView) convertView.findViewById(R.id.DescTxt);

        titreText.setText(livres.get(position).getTitre());
        auteurText.setText(livres.get(position).getAuteur());
        editeurText.setText(livres.get(position).getEditeur());
        genreText.setText(livres.get(position).getGenre());
        DescText.setText(livres.get(position).getDescription());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(c,livres.get(position).getTitre(),Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;


    }
}
