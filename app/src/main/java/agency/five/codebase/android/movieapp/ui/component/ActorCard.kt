package agency.five.codebase.android.movieapp.ui.component

import agency.five.codebase.android.movieapp.mock.MoviesMock
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage


data class ActorCardViewState(
    val imageUrl: String?,
    val name: String,
    val character: String
)
@Composable
fun ActorCard( actorCardViewState: ActorCardViewState,modifier: Modifier = Modifier)
    {
        Card(
            modifier = modifier.padding(10.dp).width(130.dp).height(250.dp),
            shape = RoundedCornerShape(20.dp),
            elevation = 100.dp
            ) {
                Column {
                        AsyncImage(
                            model = actorCardViewState.imageUrl,
                            contentDescription = actorCardViewState.name,
                            modifier = modifier.height(170.dp),
                            contentScale = ContentScale.Crop
                        )
                        Text(
                            modifier = modifier.padding(top=8.dp).padding(horizontal = 15.dp).width(100.dp),
                            text = actorCardViewState.name,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp
                        )
                        Text(
                            modifier = modifier.padding(start = 15.dp).width(100.dp),
                            text = actorCardViewState.character,
                            color = Color.LightGray,
                            fontSize = 10.sp
                        )
                        }
                }
    }

@Preview(showBackground = true)
@Composable
private fun ActorCardPreview() {
        val actor = MoviesMock.getActor()
        val actorCard = ActorCardViewState(imageUrl = actor.imageUrl, name = actor.name, character = actor.character)
        ActorCard(actorCardViewState = actorCard)
}