package mx.loltilel.loltilel.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mx.loltilel.loltilel.ui.dashboard.model.ColaboradorModel

class DashboardViewModel : ViewModel() {

    private var listaColaboradores: MutableLiveData<List<ColaboradorModel>>? = null

    internal fun getColaboradores(): MutableLiveData<List<ColaboradorModel>> {
        if (listaColaboradores == null){
            listaColaboradores = MutableLiveData()
            agregarColaboradores()
        }
        return listaColaboradores as MutableLiveData<List<ColaboradorModel>>
    }

    private fun agregarColaboradores() {
        val colaboradores: ArrayList<ColaboradorModel> = arrayListOf<ColaboradorModel>()
        // Aquí se agregan los colaboradores
        colaboradores.add(
            ColaboradorModel(
                "https://firebasestorage.googleapis.com/v0/b/lol-tilel.appspot.com/o/photo_norman.png?alt=media&token=28655982-69db-438b-9e4f-408737a457b9",
                "Norman Sánchez Nolasco",
                "Fundador - Director ejecutivo",
                "https://www.linkedin.com/in/norman-sanchez-nolasco"))

        colaboradores.add(
            ColaboradorModel(
                "https://firebasestorage.googleapis.com/v0/b/lol-tilel.appspot.com/o/armando_photo.png?alt=media&token=6afa743f-fd47-4f3f-99c5-ba5a6a58a7fe",
                "Armando Rafael Dávalos Herrera",
                "Fundador - Director de operaciones",
                "https://www.linkedin.com/"))

        colaboradores.add(
            ColaboradorModel(
                "https://firebasestorage.googleapis.com/v0/b/lol-tilel.appspot.com/o/photo_lesly.png?alt=media&token=5f269004-966b-464a-8517-d94053e863ac",
                "Lesly Herrera Martinez",
                "Desarrollador Jr. Frontend",
                "https://www.linkedin.com/in/lesly-herrera-martinez-9815691b5/"))

        listaColaboradores?.postValue(colaboradores)
    }

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text
}