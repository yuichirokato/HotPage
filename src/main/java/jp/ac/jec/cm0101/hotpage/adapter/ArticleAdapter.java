package jp.ac.jec.cm0101.hotpage.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import jp.ac.jec.cm0101.hotpage.R;
import jp.ac.jec.cm0101.hotpage.models.ArticleModel;

public class ArticleAdapter extends ArrayAdapter<ArticleModel> {
    private LayoutInflater mLayoutInflater;

    public ArticleAdapter(Context context, int textViewResourceId, List<ArticleModel> objects) {
        super(context, textViewResourceId, objects);
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 特定の行(position)のデータを得る
        ArticleModel item = (ArticleModel) getItem(position);

        // convertViewは使い回しされている可能性があるのでnullの時だけ新しく作る
        if (null == convertView) {
            convertView = mLayoutInflater.inflate(R.layout.article, null);
        }

        // CustomDataのデータをViewの各Widgetにセットする
        // TODO: なぜかイメージが取得できない。webviewにURIを渡すと画像が表示された。わけわかめ。
//        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);
//        imageView.setImageURI(Uri.parse(item.getImageUrl()));

        TextView title = (TextView) convertView.findViewById(R.id.articleTitle);
        title.setText(item.getTitle());
        TextView body = (TextView) convertView.findViewById(R.id.articleBody);
        body.setText(item.getBody());

        return convertView;
    }

}