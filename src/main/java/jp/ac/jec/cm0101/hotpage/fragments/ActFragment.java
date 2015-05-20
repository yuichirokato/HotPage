package jp.ac.jec.cm0101.hotpage.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import jp.ac.jec.cm0101.hotpage.DetailActivity;
import jp.ac.jec.cm0101.hotpage.R;
import jp.ac.jec.cm0101.hotpage.adapter.ArticleAdapter;
import jp.ac.jec.cm0101.hotpage.asyncrequest.AsyncRequest;
import jp.ac.jec.cm0101.hotpage.models.ArticleModel;

public class ActFragment extends HPBaseFragment {

    private static ActFragment actFragment;
    private ListView mListView;

    public static ActFragment getInstance() {
        if (actFragment == null) {
            actFragment = new ActFragment();
        }
        return actFragment;
    }

    public ActFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AsyncRequest request = new AsyncRequest(this);
        request.execute(request.getUrlByPagePosition(POSITION_ACT));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_act, container, false);

        mListView = (ListView) view.findViewById(R.id.act_list);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                ArticleModel article = (ArticleModel) adapterView.getItemAtPosition(position);

                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra("url", article.getPageUrl());
                startActivity(intent);
            }
        });

        return view;
    }

    @Override
    public void onPostExecute(String result) {
        try {
            JSONObject object = new JSONObject(result);
            JSONArray array = object.getJSONArray(ENTRIES_KEY);
            List<ArticleModel> articles = createArticleList(array);
            ArticleAdapter adapter = new ArticleAdapter(getActivity(), 0, articles);
            adapter.notifyDataSetChanged();
            mListView.setAdapter(adapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
