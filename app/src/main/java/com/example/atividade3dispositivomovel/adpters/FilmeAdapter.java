package com.example.atividade3dispositivomovel.adpters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.atividade3dispositivomovel.R;
import com.example.atividade3dispositivomovel.model.Filme;

import java.util.List;

public class FilmeAdapter extends RecyclerView.Adapter<FilmeAdapter.FilmeViewHolder> {
    private List<Filme> filmes;
    private Context context;

    public FilmeAdapter(List<Filme> filmes, Context context) {
        this.filmes = filmes;
        this.context = context;
    }

    @NonNull
    @Override
    public FilmeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_filme, parent, false);
        return new FilmeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmeViewHolder holder, int position) {
        Filme filme = filmes.get(position);
        holder.tvTitulo.setText(filme.getTitulo());
        holder.tvAno.setText(String.valueOf(filme.getAno()));
        holder.tvDiretor.setText(filme.getDiretor());
        Glide.with(context)
                .load(filme.getUrlImage()) // Carrega a URL da imagem
                .into(holder.ivPoster);

        holder.btnSinopse.setOnClickListener(v ->
                Toast.makeText(context, filme.getDescricao(), Toast.LENGTH_SHORT).show()
        );
    }

    @Override
    public int getItemCount() {
        return filmes.size();
    }

    public static class FilmeViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitulo, tvAno, tvDiretor;
        ImageView ivPoster;
        Button btnSinopse;

        public FilmeViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitulo = itemView.findViewById(R.id.textTitulo);
            tvAno = itemView.findViewById(R.id.textAno);
            tvDiretor = itemView.findViewById(R.id.textAtor);
            ivPoster = itemView.findViewById(R.id.imageView);
            btnSinopse = itemView.findViewById(R.id.button);
        }
    }
}
