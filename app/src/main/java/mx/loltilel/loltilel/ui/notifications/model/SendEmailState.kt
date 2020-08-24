package mx.loltilel.loltilel.ui.notifications.model

data class SendEmailState (
    val nombreError: Int?= null,
    val correoError: Int?= null,
    val phoneError: Int?= null,
    val isValidData: Boolean = false
)