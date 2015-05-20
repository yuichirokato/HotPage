package jp.ac.jec.cm0101.hotpage.fragments;

import android.support.v4.app.Fragment;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import jp.ac.jec.cm0101.hotpage.asyncrequest.AsyncRequestCallback;
import jp.ac.jec.cm0101.hotpage.models.ArticleModel;

public class HPBaseFragment extends Fragment implements AsyncRequestCallback {

    public final int POSITION_CURRICULUM = 0;
    public final int POSITION_ACT = 1;
    public final int POSITION_EVENT = 2;
    public final int POSITION_PEOPLE = 3;
    public final int POSITION_JOB_HUNTING = 4;
    public final String ENTRIES_KEY = "entries";

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onPreExecute() {

    }

    @Override
    public void onPostExecute(String result) {
        Log.d("onPostExecute!", result);
    }

    protected List<ArticleModel> createArticleList(JSONArray articles) {
        List<ArticleModel> list = new ArrayList<ArticleModel>();

        for (int i = 0; i < articles.length(); i++) {
            try {
                JSONObject object = articles.getJSONObject(i);
                Log.v("createArticleList", "url = " + object.getString("image_url"));
                ArticleModel model = new ArticleModel(
                        object.getString("title"),
                        object.getString("lead"),
                        object.getString("image_url"),
                        object.getString("url")
                );
                list.add(model);
            } catch (JSONException exception) {
                exception.printStackTrace();
            }
        }
        return list;
    }
}
