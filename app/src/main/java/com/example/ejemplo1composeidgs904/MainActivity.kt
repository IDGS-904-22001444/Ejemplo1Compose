package com.example.ejemplo1composeidgs904

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.defaultDecayAnimationSpec
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class PersonajeTarjeta(val title: String, val body: String)

private val personajes:List<PersonajeTarjeta> = listOf(
    PersonajeTarjeta("Goku", "El protagonista de la serie, conocido por su gran poder y personalidad amigable. Originalmente enviado a la Tierra como un infante volador con la misión de conquistarla"),
    PersonajeTarjeta("Vegeta", "Príncipe de los Saiyans, inicialmente un villano, pero luego se une a los Z Fighters. A pesar de que a inicios de Dragon Ball Z, Vegeta cumple un papel antagónico, poco después decide rebelarse ante el Imperio de Freeza, volviéndose un aliado clave para los Guerreros Z"),
    PersonajeTarjeta("Freezer", "Freezer es el tirano espacial y el principal antagonista de la saga de Freezer"),
    PersonajeTarjeta("Gohan", "Son Gohanda en su tiempo en España, o simplemente Gohan en Hispanoamérica, es uno de los personajes principales de los arcos argumentales de Dragon Ball Z, Dragon Ball Super y Dragon Ball GT"),
    PersonajeTarjeta("Android17", "Antes de ser secuestrado, es el hermano mellizo de la Androide Número 18, quien al igual que ella antes de ser Androide era un humano normal hasta que fueron secuestrados por el Dr. Gero, y es por eso que lo odian"),
    PersonajeTarjeta("Bills", "Dios de la Destrucción Beerus, conocido también como Beers, o Bills en Hispanoamérica e inicialmente en España[1], es un personaje que fue introducido en la película Dragon Ball Z: La batalla de los dioses, donde es el antagonista principal de la película"),
    PersonajeTarjeta("Jiren", "Jiren es un poderoso luchador del Universo 11 y uno de los oponentes más formidables en el torneo"),
    PersonajeTarjeta("Vegetto", "Vegetto es el personaje más fuerte dentro del manga original y uno de los personajes más poderosos de toda la serie en general. Su poder es el resultado del máximo poder combinado de Goku y Vegeta"),
    PersonajeTarjeta("Broly", "Broly es un Saiyajin que posee un poder gigantesco e incontrolable, el cual se manifiesta en toda su magnitud cuando se convierte en el Super Saiyajin Legendario")
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ejemplo1ComposeIDGS904Theme {
            Tarjeta(personajes)

            }
        }
    }
}


@Composable
fun Tarjeta(personajes: List<PersonajeTarjeta>) {
    LazyColumn(
        modifier = Modifier
            .padding(24.dp)
            .background(MaterialTheme.colorScheme.background)
    ) {
        items(personajes) { personaje ->
            MyPersonajes(personaje = personaje)
        }

    }
}

@Composable
fun MyPersonajes(personaje: PersonajeTarjeta) {

    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .background(MaterialTheme.colorScheme.background),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        shape = RoundedCornerShape(16.dp)
    ){


    Row(modifier = Modifier
        .background(MaterialTheme.colorScheme.background)
        .padding(8.dp)
    ){


        ImagenPersonaje(personaje.title)
        Personajes(personaje)
    }
    }


}

@Composable
fun Personajes(personaje: PersonajeTarjeta){
    Column {
        Text(personaje.title)
        Text(personaje.body)
    }
}

//Composable que muestra una imagen circular con un fondo de color y padding
@Composable
fun ImagenPersonaje(imageName: String) {
    val context= LocalContext.current;
    val ImageResid = remember (imageName){
        context.resources.getIdentifier(
            imageName.lowercase(),
            "drawable",
            context.packageName
        )
    }


    Image( // Composable que se usa para mostrar una imagen en pantalla
        painter = painterResource(id=ImageResid),
        // painter: Especifica el recurso de imagen que se va a cargar (en este caso una imagen de "vegeta_normal")
        // painterResource carga imágenes que están en la carpeta res/drawable

        contentDescription = imageName,
        // contentDescription: Descripción accesible para usuarios con lectores de pantalla.
        // Es importante para accesibilidad, aunque no se muestra en la UI.

        modifier = Modifier // Aquí empieza la configuración visual de la imagen usando Modifiers
            .padding(8.dp)
            // padding: Agrega un espacio de 8dp alrededor de la imagen

            .clip(CircleShape)
            // clip: Recorta la imagen con la forma especificada (en este caso, un círculo)
            // Esto hace que la imagen tenga bordes redondos en forma de círculo

            .size(100.dp)
            // size: Define el tamaño de la imagen en 100dp de ancho y alto

            .background(MaterialTheme.colorScheme.primary)
        // background: Asigna un color de fondo a la imagen recortada (usando el color primario del tema)
    )
}
    @Composable
fun Personaje(Nombre: String){
   Text(text = Nombre)
}


@Preview (showBackground = true)
@Composable
fun PreviewMessageCard() {
    Tarjeta(personajes)
}