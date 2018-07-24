package br.com.tecapp.mvparchitecture.shared.base.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * @author Vitor Otero on 12/06/18.
 */
public abstract class BaseViewHolder extends RecyclerView.ViewHolder {

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public <T> void bind(T object) {
    }

    public <T> void bind(T object, int position) {
    }

}
