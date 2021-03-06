package es.ucm.fdi.gaia.recolibry.implementations.mahout.cfItem;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import es.ucm.fdi.gaia.recolibry.implementations.mahout.models.DataModelFactory;
import org.apache.mahout.cf.taste.common.Refreshable;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.similarity.*;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;

import java.util.Collection;

/**
 * Class to select the similarity function to apply in the {@link RecommenderMahoutCFItem}. There
 * are 6 functions to select: CityBlock, Euclidean, LogLike, Pearson, Tanimoto nad
 * UncenteredCosine.
 *
 * @author Jose L. Jorro-Aragoneses
 * @version 1.0
 */
public class MahoutItemSimilarity implements ItemSimilarity {

    private ItemSimilarity itemSimilarity;

    /**
     * Method to build the similarity function.
     * @param type type of similarity function selected.
     * @param dataModel data model where is applied this similarity function.
     */
    @Inject
    public MahoutItemSimilarity(@Named("TypeItemSimilarity") String type, DataModelFactory dataModel) {

        try {

            switch (type) {
                case "CityBlock":
                    itemSimilarity = new CityBlockSimilarity(dataModel.getModel());
                    break;
                case "Euclidean":
                    itemSimilarity = new EuclideanDistanceSimilarity(dataModel.getModel());
                    break;
                case "LogLike":
                    itemSimilarity = new LogLikelihoodSimilarity(dataModel.getModel());
                    break;
                case "Pearson":
                    itemSimilarity = new PearsonCorrelationSimilarity(dataModel.getModel());
                    break;
                case "Tanimoto":
                    itemSimilarity = new TanimotoCoefficientSimilarity(dataModel.getModel());
                    break;
                case "UncenteredCosine":
                    itemSimilarity = new UncenteredCosineSimilarity(dataModel.getModel());
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
