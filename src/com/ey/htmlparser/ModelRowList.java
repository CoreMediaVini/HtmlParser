package com.ey.htmlparser;

import javax.jws.WebParam;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vvasund on 13.09.2017.
 */
public class ModelRowList {
    public ModelRowList() {
    }
    List<ModelRow> modelRowList = new ArrayList<ModelRow>();

    public List<ModelRow> getModelRowList() {
        return modelRowList;
    }

    public void setModelRowList(List<ModelRow> modelRowList) {
        this.modelRowList = modelRowList;
    }
    public void addModelRowItem(ModelRow modelRow)
    {
        this.modelRowList.add(modelRow);
    }

    public List<ModelRow> getModelRows()
    {
        return new ArrayList<ModelRow>();
    }
}
