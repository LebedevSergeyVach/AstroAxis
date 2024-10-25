package astro.axis.planet.libgdx.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import astro.axis.planet.libgdx.R;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;


// Определение класса ButtonAdapter, который расширяет RecyclerView.Adapter
public class ButtonAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    // Интерфейс для обработки нажатия на кнопку
    public interface OnButtonClickListener {
        void onButtonClick(int position);
    }

    // Константы для определения типа элемента в списке
    private static final int VIEW_TYPE_LABEL = 0;
    private static final int VIEW_TYPE_BUTTON = 1;

    // Список строк для кнопок
    private final ArrayList<String> buttonList;

    // Слушатель нажатия на кнопку
    private OnButtonClickListener onButtonClickListener;

    // Метод для установки слушателя нажатия на кнопку
    public void setOnButtonClickListener(OnButtonClickListener listener) {
        this.onButtonClickListener = listener;
    }

    // Вложенный статический класс для представления элемента списка с кнопкой
    public static class ButtonViewHolder extends RecyclerView.ViewHolder {
        public Button button;

        public ButtonViewHolder(View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.button);
        }
    }

    // Вложенный статический класс для представления элемента списка с текстом
    public static class LabelViewHolder extends RecyclerView.ViewHolder {
        public TextView label;
        public TextView labels;

        public LabelViewHolder(View itemView) {
            super(itemView);
            label = itemView.findViewById(R.id.label);
            labels = itemView.findViewById(R.id.labels);
        }
    }

    // Конструктор класса ButtonAdapter
    public ButtonAdapter(ArrayList<String> buttonList) {
        this.buttonList = buttonList;
    }

    // Метод для определения типа элемента в списке
    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return VIEW_TYPE_LABEL;
        } else {
            return VIEW_TYPE_BUTTON;
        }
    }

    // Метод для создания нового ViewHolder'а
    @NotNull
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

    // Метод для привязки данных к ViewHolder'у
    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        if (holder instanceof ButtonViewHolder) {
            String buttonText = buttonList.get(position - 1);
            ((ButtonViewHolder) holder).button.setText(buttonText);

            ((ButtonViewHolder) holder).button.setOnClickListener(v -> {
                if (onButtonClickListener != null) {
                    onButtonClickListener.onButtonClick(position - 1);
                }
            });
        } else if (holder instanceof LabelViewHolder) {
            ((LabelViewHolder) holder).label.setText("AstroAxis");
            ((LabelViewHolder) holder).labels.setText("astronomical reference book");
        }
    }

    // Метод для получения количества элементов в списке
    @Override
    public int getItemCount() {
        return buttonList.size() + 1;
    }
}
