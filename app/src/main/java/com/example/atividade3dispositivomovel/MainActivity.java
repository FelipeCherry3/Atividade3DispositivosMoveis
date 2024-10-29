package com.example.atividade3dispositivomovel;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.atividade3dispositivomovel.adpters.FilmeAdapter;
import com.example.atividade3dispositivomovel.model.Filme;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private FilmeAdapter adapter;
    private List<Filme> filmes = new ArrayList<>();
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        db = FirebaseFirestore.getInstance();
        carregarFilmesDoFirestore();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void carregarFilmesDoFirestore() {
        db.collection("filmes").get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                for (QueryDocumentSnapshot document : task.getResult()) {
                    String titulo = document.getString("titulo");
                    String ano = document.getString("ano");
                    String sinopse = document.getString("descricao");
                    String diretor = document.getString("diretor");
                    String imagem = document.getString("imagem");

                    Filme filme = new Filme(titulo, ano, sinopse, diretor, imagem);
                    filmes.add(filme);
                }
                adapter = new FilmeAdapter(filmes, this);
                recyclerView.setAdapter(adapter);
            } else {
                Log.w("MainActivity", "Erro ao carregar filmes.", task.getException());
            }
        });
    }
}