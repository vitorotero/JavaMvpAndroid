package br.com.tecapp.mvparchitecture.shared.base.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import br.com.tecapp.mvparchitecture.R;
import br.com.tecapp.mvparchitecture.shared.model.EmptyObject;

/**
 * @author Vitor Otero on 12/06/18.
 */
public abstract class BaseAdapter<V> extends RecyclerView.Adapter<BaseViewHolder> {

    private static final int VIEW_TYPE_EMPTY = 1000;
    private static final int MINIMUM_EMPTY_LIST = 1;
    protected IBaseAdapterListener<V> adapterListener;
    protected IBaseViewHolderClickListener<V> clickListener;
    protected IBaseViewHolderLongClickListener<V> longClickListener;
    private List<V> model = new ArrayList<>();
    private EmptyObject emptyObject;

    public BaseAdapter() {
        adapterListener = null;
        clickListener = null;
        longClickListener = null;
    }

    public BaseAdapter(IBaseAdapterListener<V> adapterListener) {
        this.adapterListener = adapterListener;
    }

    public BaseAdapter(IBaseViewHolderClickListener<V> clickListener) {
        this.clickListener = clickListener;
    }

    public BaseAdapter(IBaseViewHolderLongClickListener<V> longClickListener) {
        this.longClickListener = longClickListener;
    }

    public BaseAdapter(IBaseViewHolderClickListener<V> clickListener,
                       IBaseViewHolderLongClickListener<V> longClickListener) {
        this.clickListener = clickListener;
        this.longClickListener = longClickListener;
    }

    protected List<V> getModel() {
        return model;
    }

    protected void setModel(List<V> model) {
        this.model = model;
        notifyDataSetChanged();
    }

    public void setEmptyObject(@NonNull EmptyObject emptyObject) {
        this.emptyObject = emptyObject;
    }

    public abstract void setList(List<V> list);

    public abstract BaseViewHolder holder(View view);

    @LayoutRes
    public abstract int getLayoutItem();

    @Override
    public int getItemCount() {
        if (model.isEmpty()) {
            return MINIMUM_EMPTY_LIST;
        }
        return model.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (model.isEmpty()) {
            return VIEW_TYPE_EMPTY;
        }
        return super.getItemViewType(position);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(getLayoutItem(), parent, false);

        if (VIEW_TYPE_EMPTY == viewType) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.empty_list_component, parent, false);
            return new EmptyViewHolder(view, emptyObject);
        }

        return holder(view);
    }

    protected interface IBaseAdapterListener<V> {
        void notifyPositionItemChanged(V v, int position);
    }

    public interface IBaseViewHolderClickListener<V> {
        void onClickListener(V v, View view);
    }

    public interface IBaseViewHolderLongClickListener<V> {
        void onLongClickListener(V v, View view);
    }
}