package mx.loltilel.loltilel.ui.notifications

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mx.loltilel.loltilel.R
import mx.loltilel.loltilel.ui.notifications.model.SendEmailState

class NotificationsViewModel : ViewModel() {

    private val _sendMailForm = MutableLiveData<SendEmailState>()
    val sendFromState: LiveData<SendEmailState> = _sendMailForm

    private val _text = MutableLiveData<String>().apply {
        value = "This is notifications Fragment"
    }
    val text: LiveData<String> = _text

    fun sendDataChanged(name: String, correo: String, phone:String) {
        if (name.isEmpty()){
            _sendMailForm.value = SendEmailState(nombreError = R.string.invalid_name)
        } else if(!isMailValid(correo)){
            _sendMailForm.value = SendEmailState(correoError = R.string.invalid_correo)
        } else if(!isPhoneValid(phone)){
            _sendMailForm.value = SendEmailState(phoneError = R.string.invalid_phone)
        }
    }

    private fun isPhoneValid(phone: String): Boolean {
        return phone.length == 10
    }

    private fun isMailValid(correo: String): Boolean {
        return if (correo.contains('@')) {
            Patterns.EMAIL_ADDRESS.matcher(correo).matches()
        } else {
            correo.isNotBlank()
        }
    }
}