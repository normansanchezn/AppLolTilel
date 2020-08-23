package mx.loltilel.loltilel.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mx.loltilel.loltilel.R
import mx.loltilel.loltilel.ui.dashboard.adapter.ColaboradoresAdapter
import mx.loltilel.loltilel.ui.dashboard.model.ColaboradorModel

class DashboardFragment : Fragment() {

  // Nosotros

  private lateinit var dashboardViewModel: DashboardViewModel
  private var colaboradorData = MutableLiveData<List<ColaboradorModel>>()
  private lateinit var listDataColaboradores: List<ColaboradorModel>

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    dashboardViewModel = ViewModelProviders.of(this).get(DashboardViewModel::class.java)

    val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
    val tvWeUs: TextView = root.findViewById(R.id.tvBodyWeus)
    dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
        tvWeUs.text = resources.getString(R.string.txt_body_weus)
    })

    val rvColaboradores: RecyclerView = root.findViewById(R.id.rvColaboradores)
    rvColaboradores.layoutManager = LinearLayoutManager(context)
    dashboardViewModel.getColaboradores().observe(viewLifecycleOwner, Observer<List<ColaboradorModel>>{
        colaboradorData.value = it
        listDataColaboradores = it
        rvColaboradores.adapter = ColaboradoresAdapter(activity?.applicationContext!!, colaboradorData)
    })
    return root
  }
}