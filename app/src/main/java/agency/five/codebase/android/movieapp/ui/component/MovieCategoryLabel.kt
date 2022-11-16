package agency.five.codebase.android.movieapp.ui.component

import agency.five.codebase.android.movieapp.R
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class MovieCategoryLabelViewState(
    val itemId: Int,
    val isSelected: Boolean,
    val category: MovieCategoryLabelTextViewState
)

sealed class MovieCategoryLabelTextViewState {
    class InputText(val text: String) : MovieCategoryLabelTextViewState()
    class ResourceText(@StringRes val textResource: Int) : MovieCategoryLabelTextViewState()
}

@Composable
fun MovieCategoryLabel(movieCategory: MovieCategoryLabelViewState) {
    if (movieCategory.isSelected) {
        Selected(movieCategory,   modifier = Modifier
            .width(intrinsicSize = IntrinsicSize.Max))
    } else {
        Unselected(movieCategory,
        modifier= Modifier)
    }
}

@Composable
fun Selected(movieCategory: MovieCategoryLabelViewState, modifier: Modifier) {
    Column(modifier = modifier.width(intrinsicSize = IntrinsicSize.Max))
    {
        Text(
            modifier = modifier.fillMaxWidth(),
            text = SelectTextSource(movieCategory = movieCategory),
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp

        )
        Spacer(modifier = modifier.size(3.dp))
        Divider(color = Color.Black, thickness = 4.dp, modifier = modifier.fillMaxWidth())
    }
}

@Composable
fun Unselected(movieCategoryLabelViewState: MovieCategoryLabelViewState,modifier: Modifier) {
    Text(modifier=Modifier.fillMaxWidth(),
        text = SelectTextSource(movieCategory = movieCategoryLabelViewState),
        color = Color.Gray,
        fontSize = 20.sp
    )
}

@Composable
fun SelectTextSource(movieCategory: MovieCategoryLabelViewState): String {
    return when (val categoryText = movieCategory.category) {
        is MovieCategoryLabelTextViewState.InputText -> categoryText.text
        is MovieCategoryLabelTextViewState.ResourceText -> stringResource(id = categoryText.textResource)
    }
}

@Preview(showBackground = true)
@Composable
fun MovieCategoryLabelPreview() {
    val inputText = MovieCategoryLabelTextViewState.InputText("Movies")
    val stringResource = MovieCategoryLabelTextViewState.ResourceText(R.string.app_name)
    val categoryViewState1 = MovieCategoryLabelViewState(2, false, inputText)
    val categoryViewState2 = MovieCategoryLabelViewState(1, true, stringResource)
    MovieCategoryLabel(movieCategory = categoryViewState2)
}
