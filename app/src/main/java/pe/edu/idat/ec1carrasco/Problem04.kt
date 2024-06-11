package pe.edu.idat.ec1carrasco

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun Form04(navigateTo: (String) -> Unit){
    Box(
        Modifier
            .fillMaxSize()
            .padding(top = 30.dp)){

        var salida by rememberSaveable {
            mutableStateOf("")
        }

        Column {

            espacio(tamanio = 10)
            Text(text = "NÚMEROS PARES ORDENADOS DEL 10 AL 20", textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
            espacio(tamanio = 10)


            Button(onClick = {salida = resultado()}, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Mostrar Pares")
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

fun resultado(): String {
    val numeros = mutableListOf<Int>()
    for (i in 10..20) {
        if (i % 2 == 0) {
            numeros.add(i)
        }
    }

    var resultado = "Lista de números pares: "
    for (numero in numeros) {
        resultado += "$numero "
    }

    return resultado
}