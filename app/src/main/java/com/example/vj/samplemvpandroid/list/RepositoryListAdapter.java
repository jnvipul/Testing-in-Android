package com.example.vj.samplemvpandroid.list;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.vj.samplemvpandroid.model.Repository;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by vJ on 1/20/17.
 */

public class RepositoryListAdapter extends BaseAdapter {

    private List<Repository> list;
    private Context context;

    public RepositoryListAdapter(List<Repository> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        ViewHolder viewHolder;
        Repository repository = list.get(i);
        if (view == null) {
            view = ((Activity) context).getLayoutInflater().inflate(android.R.layout.simple_list_item_1, parent, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.textView.setText(repository.getName());
        return view;
    }

    public static class ViewHolder {
        @BindView(android.R.id.text1)
        TextView textView;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
