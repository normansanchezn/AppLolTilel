package mx.loltilel.loltilel.ui.dashboard.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_colaborador.view.*
import mx.loltilel.loltilel.ui.dashboard.model.ColaboradorModel

class ColaboradoresViewHolder(var ctx: Context, var item: View): RecyclerView.ViewHolder(item) {
    fun bindItems(model: ColaboradorModel) {

        val imagenColaborador = item.ivColaborador
        Picasso.with(ctx).load(model.imagenColaborador).into(imagenColaborador)

        item.tvName.text = model.nombreColaborador
        item.tvSeniority.text = model.puestoColaborador

        item.ivLinkedln.setOnClickListener {
            val goLinkedln = Intent(Intent.ACTION_VIEW, Uri.parse(model.linkdlColaborador))
            goLinkedln.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            ctx.startActivity(goLinkedln)
        }
    }
}