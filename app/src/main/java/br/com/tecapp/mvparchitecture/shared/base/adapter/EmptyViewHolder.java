package br.com.tecapp.mvparchitecture.shared.base.adapter;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import br.com.tecapp.mvparchitecture.R;
import br.com.tecapp.mvparchitecture.shared.model.EmptyObject;
import butterknife.BindView;
import butterknife.ButterKnife;

import static br.com.tecapp.mvparchitecture.shared.model.EmptyObject.ICON_RESOURCE_ZERO;

/**
 * @author Vitor Otero on 12/06/18.
 */
public class EmptyViewHolder extends BaseViewHolder {

    @BindView(R.id.cpt_empty_list_text) TextView tvMessage;
    @BindView(R.id.cpt_empty_list_iv) ImageView ivIcon;
    @BindView(R.id.cpt_empty_list_button) Button btnTryAgain;
    @BindView(R.id.ll_empty_list) LinearLayout llEmptyList;

    public EmptyViewHolder(View itemView, EmptyObject emptyObject) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        bind(emptyObject);
    }

    @Override
    public <T> void bind(T object) {
        if (!(object instanceof EmptyObject) && object == null) {
            return;
        }

        btnTryAgain.setVisibility(View.GONE);

        @SuppressWarnings("ConstantConditions")
        EmptyObject emptyObject = (EmptyObject) object;
        if (emptyObject.getIcon() != ICON_RESOURCE_ZERO) {
            ivIcon.setImageResource(emptyObject.getIcon());
        }

        if (emptyObject.getMessage() != null && !emptyObject.getMessage().isEmpty()) {
            tvMessage.setText(emptyObject.getMessage());
        }

        if (emptyObject.getButtonText() != null) {
            btnTryAgain.setText(emptyObject.getButtonText());
        }

        if (emptyObject.getListener() != null) {
            btnTryAgain.setOnClickListener(emptyObject.getListener());
            btnTryAgain.setVisibility(View.VISIBLE);
        }

        if (emptyObject.getLayoutListener() != null) {
            llEmptyList.setOnClickListener(emptyObject.getLayoutListener());
        }

    }
}