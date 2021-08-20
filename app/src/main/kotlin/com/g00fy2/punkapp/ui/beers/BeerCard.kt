package com.g00fy2.punkapp.ui.beers

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.g00fy2.punkapp.model.entities.domain.Beer
import com.g00fy2.punkapp.ui.theme.PunkAppTheme
import com.g00fy2.punkapp.ui.theme.Purple200

@Composable
fun BeerCard(beer: Beer) {
  Row(modifier = Modifier.padding(all = 8.dp)) {
    Image(
      painter = rememberImagePainter(beer.imageUrl),
      contentDescription = null,
      modifier = Modifier
        .size(128.dp)
        .clip(CircleShape)
        .background(color = Purple200)
    )

    Spacer(modifier = Modifier.width(8.dp))

    Column {
      Text(text = beer.name)
      Spacer(modifier = Modifier.height(4.dp))
      Text(text = beer.description)
    }
  }
}

@Preview
@Composable
fun PreviewMessageCard() {
  PunkAppTheme {
    BeerCard(Beer(0, "Tasty Beer", "", "", "Description", ""))
  }
}