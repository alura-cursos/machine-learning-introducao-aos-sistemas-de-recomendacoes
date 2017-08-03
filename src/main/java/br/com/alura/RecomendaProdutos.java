package br.com.alura;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class RecomendaProdutos {

	public static void main(String[] args) throws TasteException, IOException {
		File file = new File("dados.csv");
		FileDataModel model = new FileDataModel(file);


		UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
		UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.1, similarity, model);
		UserBasedRecommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);

        System.out.println("usuário 1");
        List<RecommendedItem> recommendations = recommender.recommend(1, 4);
        for (RecommendedItem recommendation : recommendations) {
            System.out.println(recommendation);
        }
        System.out.println("usuário 3");
        recommendations = recommender.recommend(3, 4);
        for (RecommendedItem recommendation : recommendations) {
            System.out.println(recommendation);
        }
        System.out.println("usuário 4");
        recommendations = recommender.recommend(4, 4);
        for (RecommendedItem recommendation : recommendations) {
            System.out.println(recommendation);
        }
	}

}
