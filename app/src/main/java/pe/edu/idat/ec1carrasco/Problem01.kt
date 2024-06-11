package pe.edu.idat.ec1carrasco

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun Form01(navigateTo: (String) -> Unit){
    Box(
        Modifier
            .fillMaxSize()
            .padding(top = 30.dp)){

        var numHoras by rememberSaveable {
            mutableStateOf("")
        }
        var numMinutos by rememberSaveable {
            mutableStateOf("")
        }
        var estaciona by rememberSaveable {
            mutableStateOf("")
        }


        Column {

            espacio(tamanio = 10)
            Text(text = "CALCULAR ESTACIONAMIENTO", textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
            espacio(tamanio = 10)

            OutlinedTextField(value = numHoras, onValueChange = {numHoras = it}, modifier = Modifier.fillMaxWidth(), label = { Text(text = "Ingrese las Horas")},
            maxLines = 1, singleLine = true, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))
            espacio(tamanio = 10)

            OutlinedTextField(value = numMinutos, onValueChange = {numMinutos = it}, modifier = Modifier.fillMaxWidth(), label = { Text(text = "Ingrese los Minutos")},
                maxLines = 1, singleLine = true, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))
            espacio(tamanio = 10)

            Button(onClick = {estaciona = calcularEst(numHoras.toDoubleOrNull(), numMinutos.toDoubleOrNull())}, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Calcular Estacionamiento")
            }
            espacio(tamanio = 10)

            Text(text = estaciona)
            espacio(tamanio = 16)

            Button(onClick = { navigateTo("main") }) {
                Text(text = "Regresar Menú")
            }

        }
    }
}

fun calcularEst(numHoras: Double?, numMinutos: Double?): String {
    if (numHoras == null || numMinutos == null) {
        return "0.0"
    }
    val totalMinutos = numHoras * 60 + numMinutos
    val totalHoras = totalMinutos / 60
    val pago = totalHoras * 1500
    val resultado = String.format("%.2f", pago)
    return "Va a cancelar el total de S./$resultado por $numHoras horas y $numMinutos minutos"
}

@Composable
fun espacio(tamanio:Int){
    Spacer(modifier = Modifier.height(tamanio.dp))
}
