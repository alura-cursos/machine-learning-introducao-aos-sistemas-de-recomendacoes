package br.com.alura;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;

import java.io.IOException;
import java.util.List;

public class RecomendaCursos {
    public static void main(String[] args) throws IOException, TasteException {
        DataModel cursos = new Recomendador().getModeloDeCursos();
        Recommender recommender = new RecomendadorBuilder().buildRecommender(cursos);

        List<RecommendedItem> recommendations = recommender.recommend(15, 600);
        for (RecommendedItem recommendation : recommendations) {
            System.out.println(recommendation);
        }


    }
}
