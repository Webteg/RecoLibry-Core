package es.ucm.fdi.gaia.recolibry.implementations.mahout.cfItem;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import org.apache.mahout.cf.taste.common.Refreshable;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.similarity.*;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;

import java.util.Collection;

public class MahoutItemSimilarity implements ItemSimilarity {

    private ItemSimilarity itemSimilarity;

    @Inject
    public MahoutItemSimilarity(@Named("TypeItemSimilarity") String type, DataModel dataModel) {

        try {

            switch (type) {
                case "CityBlock":
                    itemSimilarity = new CityBlockSimilarity(dataModel);
                    break;
                case "Euclidean":
                    itemSimilarity = new EuclideanDistanceSimilarity(dataModel);
                    break;
                case "LogLike":
                    itemSimilarity = new LogLikelihoodSimilarity(dataModel);
                    break;
                case "Pearson":
                    itemSimilarity = new PearsonCorrelationSimilarity(dataModel);
                    break;
                case "Tanimoto":
                    itemSimilarity = new TanimotoCoefficientSimilarity(dataModel);
                    break;
                case "UncenteredCosine":
                    itemSimilarity = new UncenteredCosineSimilarity(dataModel);
                    break;
                default:
                    break;
            }
        } catch (TasteException e) {
            e.printStackTrace();
        }

    }

    @Override
    public double itemSimilarity(long itemID1, long itemID2) throws TasteException {
        return itemSimilarity.itemSimilarity(itemID1, itemID2);
    }

    @Override
    public double[] itemSimilarities(long itemID1, long[] itemID2s) throws TasteException {
        return itemSimilarity.itemSimilarities(itemID1, itemID2s);
    }

    @Override
    public long[] allSimilarItemIDs(long itemID) throws TasteException {
        return itemSimilarity.allSimilarItemIDs(itemID);
    }

    @Override
    public void refresh(Collection<Refreshable> alreadyRefreshed) {
        itemSimilarity.refresh(alreadyRefreshed);
    }

}