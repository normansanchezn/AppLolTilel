package mx.loltilel.loltilel.ui.notifications

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_notifications.*
import mx.loltilel.loltilel.R
import mx.loltilel.loltilel.ui.extensions.afterTextChanged

class NotificationsFragment : Fragment() {

  // Contacto
  private lateinit var notificationsViewModel: NotificationsViewModel

  private val nombre: String = ""
  private val correo: String = ""
  private val numero: String = ""

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
      notificationsViewModel = ViewModelProviders.of(this).get(NotificationsViewModel::class.java)
      val root = inflater.inflate(R.layout.fragment_notifications, container, false)

      val tvContact:TextView = root.findViewById(R.id.tvBodyContact)
      val etNombre: EditText = root.findViewById(R.id.et_nombre_completo)
      val etCorreo: EditText = root.findViewById(R.id.et_correo_electronico)
      val etNumero: EditText = root.findViewById(R.id.et_numero_telefono)
      val btnEnviar: ImageView = root.findViewById(R.id.btnEnviar)

      notificationsViewModel.sendFromState.observe(viewLifecycleOwner, Observer {
          val dataState = it?: return@Observer

          if (dataState.nombreError != null){
              etNombre.error = getString(dataState.nombreError)
          }
          if (dataState.correoError != null){
              etCorreo.error = getString(dataState.correoError)
          }

          if (dataState.phoneError != null) {
              etNumero.error = getString(dataState.phoneError)
          }
      })

      etNombre.afterTextChanged {
          notificationsViewModel.sendDataChanged(
            etNombre.text.toString(),
            etCorreo.text.toString(),
            etNumero.text.toString()
          )
      }

      etCorreo.afterTextChanged {
          notificationsViewModel.sendDataChanged(
            etNombre.text.toString(),
            etCorreo.text.toString(),
            etNumero.text.toString()
          )
      }

      etNumero.afterTextChanged {
          notificationsViewModel.sendDataChanged(
            etNombre.text.toString(),
            etCorreo.text.toString(),
            etNumero.text.toString()
          )
      }

      btnEnviar.setOnClickListener {
          val email = Intent(Intent.ACTION_SEND)
          email.putExtra(Intent.EXTRA_EMAIL, etCorreo.text.toString())
          email.putExtra(Intent.EXTRA_SUBJECT, "${etNumero.text.toString()}: Requerimos más información.")
          email.putExtra(Intent.EXTRA_TEXT, "")
          email.type = "message/rfc822"

          startActivity(Intent.createChooser(email, "Elige un cliente de correo electrónico:"))
      }

        notificationsViewModel.text.observe(viewLifecycleOwner, Observer {
            tvContact.text = resources.getString(R.string.txt_body_contact)
        })

        return root
  }
}