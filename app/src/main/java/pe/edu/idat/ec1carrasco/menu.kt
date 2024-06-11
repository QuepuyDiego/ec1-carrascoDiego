package pe.edu.idat.ec1carrasco

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun forMenu(){
    var actual by rememberSaveable {
        mutableStateOf("main")
    }

    when(actual){
        "main" -> MainMenu { actual = it }
        "estacionamiento" -> Form01 { actual = "main"}
        "promedio" -> Form02 {actual = "main"}
        "dni"  -> Form03 {actual = "main"}
        "lista"  -> Form04 {actual = "main"}
    }

}

@Composable
fun MainMenu(navigateTo: (String) -> Unit) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { navigateTo("estacionamiento") }) {
            Text("Calcular Salario")
        }
        espacio(tamanio = 16)

        Button(onClick = { navigateTo("promedio") }) {
            Text("Calcular Promedio")
        }
        espacio(tamanio = 16)
        Button(onClick = { navigateTo("dni") }) {
            Text("Ver DNI")
        }
        espacio(tamanio = 16)
        Button(onClick = { navigateTo("lista") }) {
            Text("Lista de números pares")

        }
    }
}