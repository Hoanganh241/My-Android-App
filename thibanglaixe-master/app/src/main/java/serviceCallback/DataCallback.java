package serviceCallback;


import model.BaseModel;

/**
 * Created by PRINCE D. TOAD on 3/16/2017.
 */

public interface DataCallback<T extends BaseModel> {
    public void onSuccess(T data);

    public void onFail(String error);
}
