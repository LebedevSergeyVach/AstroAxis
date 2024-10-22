package astro.axis.planet.libgdx.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import astro.axis.planet.libgdx.R

// Определение класса ButtonAdapter, который расширяет RecyclerView.Adapter
class ButtonAdapter // Конструктор класса ButtonAdapter
    (// Список строк для кнопок
    private val buttonList: ArrayList<String>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    // Интерфейс для обработки нажатия на кнопку
    interface OnButtonClickListener {
        fun onButtonClick(position: Int)
    }

    // Слушатель нажатия на кнопку
    private var onButtonClickListener: OnButtonClickListener? = null

    // Метод для установки слушателя нажатия на кнопку
    fun setOnButtonClickListener(listener: OnButtonClickListener?) {
        this.onButtonClickListener = listener
    }

    // Вложенный статический класс для представления элемента списка с кнопкой
    class ButtonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var button: Button = itemView.findViewById(R.id.button)
    }

    // Вложенный статический класс для представления элемента списка с текстом
    class LabelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var label: TextView = itemView.findViewById(R.id.label)
        var labels: TextView = itemView.findViewById(R.id.labels)
    }

    // Метод для определения типа элемента в списке
    override fun getItemViewType(position: Int): Int {
        return if (position == 0) {
            VIEW_TYPE_LABEL
        } else {
            VIEW_TYPE_BUTTON
        }
    }

    // Метод для создания нового ViewHolder'а
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == VIEW_TYPE_LABEL) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.label_item, parent, false)
            return LabelViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.button_item, parent, false)
            return ButtonViewHolder(view)
        }
    }

    // Метод для привязки данных к ViewHolder'у
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        if (holder is ButtonViewHolder) {
            val buttonText = buttonList[position - 1]
            holder.button.text = buttonText

            holder.button.setOnClickListener { v: View? ->
                if (onButtonClickListener != null) {
                    onButtonClickListener!!.onButtonClick(position - 1)
                }
            }
        } else if (holder is LabelViewHolder) {
            holder.label.text = "AstroAxis"
            holder.labels.text = "astronomical reference book"
        }
    }

    // Метод для получения количества элементов в списке
    override fun getItemCount(): Int {
        return buttonList.size + 1
    }

    companion object {
        // Константы для определения типа элемента в списке
        private const val VIEW_TYPE_LABEL = 0
        private const val VIEW_TYPE_BUTTON = 1
    }
}
