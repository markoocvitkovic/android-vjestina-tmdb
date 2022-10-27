package agency.five.codebase.android.movieapp.ui.component

import agency.five.codebase.android.movieapp.mock.MoviesMock
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

data class CrewItemViewState(
    val name: String,
    val job: String
)

@Composable
fun CrewItem( crewItemViewState: CrewItemViewState)
{
    Column {
            Text(
                text = crewItemViewState.name,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp
                )
            Text(
                text = crewItemViewState.job,
                color = Color.Black,
                fontSize = 10.sp
                )
            }
}

@Preview(showBackground = true)
@Composable
private fun CrewItemPreview() {
    val crewman = MoviesMock.getCrewman()
    val crewItem = CrewItemViewState(name = crewman.name, job = crewman.job)
    CrewItem(crewItemViewState = crewItem)
}