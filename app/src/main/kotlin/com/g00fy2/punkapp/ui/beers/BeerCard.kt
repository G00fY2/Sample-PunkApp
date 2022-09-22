package com.g00fy2.punkapp.ui.beers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.g00fy2.punkapp.model.entities.domain.Beer
import com.g00fy2.punkapp.ui.theme.PunkAppTheme
import com.g00fy2.punkapp.ui.theme.Purple200

@Composable
fun BeerCard(beer: Beer, modifier: Modifier = Modifier) {
  Row(modifier = modifier) {
    AsyncImage(
      model = beer.imageUrl,
      contentDescription = null,
      modifier = Modifier
        .weight(1f)
        .aspectRatio(1f)
        .clip(CircleShape)
        .background(color = Purple200)
        .padding(8.dp)
    )

    Spacer(modifier = Modifier.width(8.dp))

    Column(modifier = Modifier.weight(1.5f)) {
      Text(
        text = beer.name,
        style = MaterialTheme.typography.h6,
      )
      Spacer(modifier = Modifier.height(4.dp))
      Text(
        text = beer.description,
        style = MaterialTheme.typography.body2
      )
    }
  }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun PreviewMessageCard() {
  PunkAppTheme {
    BeerCard(
      Beer(
        id = 0,
        name = "Tasty Beer",
        tagline = "",
        firstBrewed = "",
        description = "Description",
        imageUrl = ""
      )
    )
  }
}