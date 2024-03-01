package com.example.astroaxis;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class ButtonAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public interface OnButtonClickListener {
        void onButtonClick(int position);
    }

    private static final int VIEW_TYPE_LABEL = 0;
    private static final int VIEW_TYPE_BUTTON = 1;

    private ArrayList<String> buttonList;

    private OnButtonClickListener onButtonClickListener;

    public void setOnButtonClickListener(OnButtonClickListener listener) {
        this.onButtonClickListener = listener;
    }

    public static class ButtonViewHolder extends RecyclerView.ViewHolder {
        public Button button;

        public ButtonViewHolder(View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.button);
        }
    }

    public static class LabelViewHolder extends RecyclerView.ViewHolder {
        public TextView label;

        public LabelViewHolder(View itemView) {
            super(itemView);
            label = itemView.findViewById(R.id.label);
        }
    }

    public ButtonAdapter(ArrayList<String> buttonList) {
        this.buttonList = buttonList;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return VIEW_TYPE_LABEL;
        } else {
            return VIEW_TYPE_BUTTON;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_LABEL) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.label_item, parent, false);
            return new LabelViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.button_item, parent, false);
            return new ButtonViewHolder(view);
        }
    }

//    @Override
//    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//        if (holder instanceof ButtonViewHolder) {
//            String buttonText = buttonList.get(position - 1);
//            ((ButtonViewHolder) holder).button.setText(buttonText);
//        } else if (holder instanceof LabelViewHolder) {
//            ((LabelViewHolder) holder).label.setText("AstroAxis");
//        }
//    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ButtonViewHolder) {
            String buttonText = buttonList.get(position - 1);
            ((ButtonViewHolder) holder).button.setText(buttonText);

            ((ButtonViewHolder) holder).button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onButtonClickListener != null) {
                        onButtonClickListener.onButtonClick(position - 1);
                    }
                }
            });
        } else if (holder instanceof LabelViewHolder) {
            ((LabelViewHolder) holder).label.setText("AstroAxis");
        }
    }

    @Override
    public int getItemCount() {
        return buttonList.size() + 1;
    }
}
