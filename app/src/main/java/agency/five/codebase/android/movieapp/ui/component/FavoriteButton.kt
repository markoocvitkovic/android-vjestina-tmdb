package agency.five.codebase.android.movieapp.ui.component

import agency.five.codebase.android.movieapp.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FavoriteButton(modifier: Modifier = Modifier,contentDescription: String = "Favorite button")
{
    val favorite = remember { mutableStateOf(false) }
    Image(
        painter = painterResource(id = if(favorite.value) R.drawable.group_8 else R.drawable.group_10),
        contentDescription = contentDescription,
        modifier = modifier.clickable { favorite.value = favorite.value.not() }
    )
}

@Preview(showBackground = true)
@Composable
private fun FavoriteButtonPreview() {
    FavoriteButton()
}