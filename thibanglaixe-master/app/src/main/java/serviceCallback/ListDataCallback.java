package serviceCallback;

import java.util.List;

import model.BaseModel;

/**
 * Created by PRINCE D. TOAD on 3/16/2017.
 */

public interface ListDataCallback<T extends BaseModel> {
    public void onSuccess(List<T> data);

    public void onFail(String error);
}