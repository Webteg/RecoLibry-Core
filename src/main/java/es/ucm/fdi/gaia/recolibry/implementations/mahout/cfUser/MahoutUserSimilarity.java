package es.ucm.fdi.gaia.recolibry.implementations.mahout.cfUser;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import org.apache.mahout.cf.taste.common.Refreshable;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.similarity.*;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.similarity.PreferenceInferrer;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

import java.util.Collection;

/**
 *
 * @author Jose L. Jorro-Aragoneses
 * @version 1.0
 */
public class MahoutUserSimilarity implements UserSimilarity {

    private UserSimilarity userSimilarity;

    /**
     *
     * @param type
     * @param dataModel
     */
    @Inject
    public MahoutUserSimilarity(@Named("TypeUserSimilarity") String type, DataModel dataModel) {

        try {

            switch (type) {
                case "CityBlock":
                    userSimilarity = new CityBlockSimilarity(dataModel);
                    break;
                case "Euclidean":
                    userSimilarity = new EuclideanDistanceSimilarity(dataModel);
                    break;
                case "LogLike":
                    userSimilarity = new LogLikelihoodSimilarity(dataModel);
                    break;
                case "Pearson":
                    userSimilarity = new PearsonCorrelationSimilarity(dataModel);
                    break;
                case "Spearman":
                    userSimilarity = new SpearmanCorrelationSimilarity(dataModel);
                    break;
                case "Tanimoto":
                    userSimilarity = new TanimotoCoefficientSimilarity(dataModel);
                    break;
                case "UncenteredCosine":
                    userSimilarity = new UncenteredCosineSimilarity(dataModel);
                    break;
                default:
                    break;
            }
        } catch (TasteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public double userSimilarity(long l, long l1) throws TasteException {
        return userSimilarity.userSimilarity(l, l1);
    }

    @Override
    public void setPreferenceInferrer(PreferenceInferrer preferenceInferrer) {
        userSimilarity.setPreferenceInferrer(preferenceInferrer);
    }

    @Override
    public void refresh(Collection<Refreshable> collection) {
        userSimilarity.refresh(collection);
    }
}