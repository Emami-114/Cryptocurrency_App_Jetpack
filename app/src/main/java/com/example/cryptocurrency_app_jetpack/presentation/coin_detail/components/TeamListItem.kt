package com.example.cryptocurrency_app_jetpack.presentation.coin_detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cryptocurrency_app_jetpack.data.remote.dto.TeamMember

@Composable
fun TimeListItem(teamMember: TeamMember, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = teamMember.name, fontSize = 22.sp)
        Spacer(modifier = Modifier.height(4.dp))

        Text(text = teamMember.position,
            style = MaterialTheme.typography.body2,
            fontStyle = FontStyle.Italic)

    }

}

@Preview
@Composable
fun TimeListItemPreview() {
    TimeListItem(teamMember = TeamMember("1", "team member", "1"))
}