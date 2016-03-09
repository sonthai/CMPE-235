package lab1.cmpe235.sjsu.smartstreet.utils;

import java.util.ArrayList;

import lab1.cmpe235.sjsu.smartstreet.model.Direction;
import lab1.cmpe235.sjsu.smartstreet.model.NearByPlace;

/**
 * Created by sonthai on 2/28/16.
 */
public interface AsyncResponse {
    void processFinish(ArrayList<NearByPlace> nearByList);
    void processDirectionResult(ArrayList<Direction> directions);
}
