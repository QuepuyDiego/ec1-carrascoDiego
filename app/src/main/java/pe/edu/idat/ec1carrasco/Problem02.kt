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

@Composable
fun Form02(navigateTo: (String) -> Unit){
    Box(
        Modifier
            .fillMaxSize()
            .padding(top = 30.dp)){

        var nota1 by rememberSaveable {
            mutableStateOf("")
        }
        var nota2 by rememberSaveable {
            mutableStateOf("")
        }
        var nota3 by rememberSaveable {
            mutableStateOf("")
        }
        var promedio by rememberSaveable {
            mutableStateOf("")
        }


        Column {

            espacio(tamanio = 10)
            Text(text = "Promedio del Alumno", textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
            espacio(tamanio = 10)

            OutlinedTextField(value = nota1, onValueChange = {nota1 = it}, modifier = Modifier.fillMaxWidth(), label = { Text(text = "Ingrese la Nota 1") },
                maxLines = 1, singleLine = true, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            espacio(tamanio = 10)

            OutlinedTextField(value = nota2, onValueChange = {nota2 = it}, modifier = Modifier.fillMaxWidth(), label = { Text(text = "Ingrese la Nota 2") },
                maxLines = 1, singleLine = true, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            espacio(tamanio = 10)

            OutlinedTextField(value = nota3, onValueChange = {nota3 = it}, modifier = Modifier.fillMaxWidth(), label = { Text(text = "Ingrese la Nota 3") },
                maxLines = 1, singleLine = true, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            espacio(tamanio = 10)

            Button(onClick = {promedio = calcularPro(nota1.toDoubleOrNull(), nota2.toDoubleOrNull(), nota3.toDoubleOrNull())}, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Calcular Promedio")
            }
            espacio(tamanio = 10)

            Text(text = promedio)
            espacio(tamanio = 16)

            Button(onClick = { navigateTo("main") }) {
                Text(text = "Regresar Menú")
            }

        }
    }
}

fun calcularPro(nota1: Double?, nota2: Double?, nota3:Double?): String {
    if (nota1 == null || nota2 == null || nota3 == null) {
        return "0.0"
    }

    if (nota1 < 0 || nota1 > 20 || nota2 < 0 || nota2 > 20 || nota3 < 0 || nota3 > 20) {
        return "Error: Nota inválida"
    }

    val resultado = (nota1 * 0.2) + (nota2 * 0.3) + (nota3 * 0.5)
    return "El promedio del alumno es : $resultado"
}
