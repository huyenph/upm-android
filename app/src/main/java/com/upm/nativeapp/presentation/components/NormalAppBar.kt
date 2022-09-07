package com.upm.nativeapp.presentation.components

import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.upm.nativeapp.R
import com.upm.nativeapp.presentation.ui.theme.UpmTheme

@Composable
fun NormalAppBar(
    navIcon: ImageVector = Icons.Filled.ArrowBackIos,
    @StringRes title: Int,
    actions: @Composable RowScope.() -> Unit = {},
    onNavIconClicked: () -> Unit = {},
) {
    TopAppBar(
        backgroundColor = MaterialTheme.colors.background,
        navigationIcon = {
            Icon(
                modifier = Modifier
                    .padding(16.dp)
                    .clickable(onClick = onNavIconClicked),
                imageVector = navIcon,
                contentDescription = stringResource(id = R.string.app_navigation_description),
            )
        },
        title = { Text(text = stringResource(id = title)) },
        actions = actions,
    )
}

@Preview(showBackground = true)
@Composable
private fun OnNormalAppBarPreview() {
    UpmTheme {
        NormalAppBar(title = R.string.language)
    }
}