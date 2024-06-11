package pe.edu.idat.ec1carrasco

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import java.util.Calendar

@Composable
fun Form03(navigateTo: (String) -> Unit){
    Box(
        Modifier
            .fillMaxSize()
            .padding(top = 30.dp)){

        var anioNac by rememberSaveable {
            mutableStateOf("")
        }
        var salida by rememberSaveable {
            mutableStateOf("")
        }

        Column {

            espacio(tamanio = 10)
            Text(text = "SALIDA DEL DNI", textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
            espacio(tamanio = 10)

            OutlinedTextField(value = anioNac, onValueChange = {anioNac = it}, modifier = Modifier.fillMaxWidth(), label = { Text(text = "Año de Nacimiento") },
                maxLines = 1, singleLine = true, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            espacio(tamanio = 10)

            Button(onClick = {salida = calcularEdad(anioNac.toIntOrNull())}, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Calcular")
            }
            espacio(tamanio = 10)

            Text(text = salida)
            espacio(tamanio = 16)

            Button(onClick = { navigateTo("main") }) {
                Text(text = "Regresar Menú")
            }

        }
    }
}

fun calcularEdad(anio: Int?): String {
    if (anio == null) {
        return "No es posible calcular"
    }
    val anioActual = Calendar.getInstance().get(Calendar.YEAR)
    if (anio > anioActual){
        return "El año ingresado es mayor al año actual"
    }else{
        val edadActual = anioActual - anio
        if(edadActual >= 18)
        {
            return "Ya puedes sacar tu DNI, tienes $edadActual años"
        }else{
            return "Aún no puedes sacar tu DNI, eres menor de 18 años"
        }
    }
}