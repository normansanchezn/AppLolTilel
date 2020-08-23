package mx.loltilel.loltilel.ui.dashboard.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import mx.loltilel.loltilel.R
import mx.loltilel.loltilel.ui.dashboard.model.ColaboradorModel

class ColaboradoresAdapter(private val ctx: Context, private val data: LiveData<List<ColaboradorModel>>):
    RecyclerView.Adapter<ColaboradoresViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColaboradoresViewHolder {
        return ColaboradoresViewHolder(
            ctx,
            LayoutInflater.from(ctx).inflate(R.layout.item_colaborador, parent, false))
    }

    override fun onBindViewHolder(holder: ColaboradoresViewHolder, position: Int) {
        holder.bindItems(data.value?.get(position)!!)
    }

    override fun getItemCount(): Int = data.value!!.size
}