package com.example.app_actividadsemanaaa;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.libroViewHolder> {

    ArrayList<Lista.libro> listaLibros;

    public Adapter(ArrayList<Lista.libro> listaLibros) {
        this.listaLibros = listaLibros;
    }

    @NonNull
    @Override
    public libroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item,null,false);
        return new libroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull libroViewHolder holder, int position) {
        holder.titulo.setText(listaLibros.get(position).titulo);
        holder.descripcion.setText(listaLibros.get(position).descripcion);
        holder.fecha.setText(listaLibros.get(position).fecha);
        holder.copias.setText(listaLibros.get(position).copias);
        holder.paginas.setText(listaLibros.get(position).paginas);
        holder.autor.setText(listaLibros.get(position).autor);
        holder.editorial.setText(listaLibros.get(position).editorial);
        holder.estante.setText(listaLibros.get(position).estante);

    }

    @Override
    public int getItemCount() {
        return this.listaLibros.size();
    }

    public class libroViewHolder extends RecyclerView.ViewHolder {
        TextView titulo,descripcion,fecha,copias,paginas,autor,editorial,estante;

        public libroViewHolder(@NonNull View itemView) {
            super(itemView);
            titulo= itemView.findViewById(R.id.itemTitulo);
            descripcion= itemView.findViewById(R.id.itemDescripcion);
            fecha= itemView.findViewById(R.id.itemFecha);
            copias= itemView.findViewById(R.id.itemCopias);
            paginas= itemView.findViewById(R.id.itemPaginas);
            autor= itemView.findViewById(R.id.itemAutor);
            editorial= itemView.findViewById(R.id.itemEditorial);
            estante= itemView.findViewById(R.id.itemEstante);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, Libro.class);
                    intent.putExtra("titulo", listaLibros.get(getAdapterPosition()).titulo);
                    intent.putExtra("descripcion", listaLibros.get(getAdapterPosition()).descripcion);
                    intent.putExtra("fecha", listaLibros.get(getAdapterPosition()).fecha);
                    intent.putExtra("copias", listaLibros.get(getAdapterPosition()).copias);
                    intent.putExtra("paginas", listaLibros.get(getAdapterPosition()).paginas);
                    intent.putExtra("autor", listaLibros.get(getAdapterPosition()).autor);
                    intent.putExtra("editorial", listaLibros.get(getAdapterPosition()).editorial);
                    intent.putExtra("estante", listaLibros.get(getAdapterPosition()).estante);

                    context.startActivity(intent);
                }
            });
        }
    }
}
