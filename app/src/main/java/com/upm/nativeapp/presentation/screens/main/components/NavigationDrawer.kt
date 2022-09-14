package com.upm.nativeapp.presentation.screens.main.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Check
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.upm.nativeapp.presentation.screens.main.NavigationItem
import com.upm.nativeapp.presentation.ui.theme.UpmTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun NavigationDrawer(
    scope: CoroutineScope,
    scaffoldState: ScaffoldState,
    navController: NavHostController,
    items: List<NavigationItem>,
) {
    Column(

    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            DrawerItem(
                item = item,
                selected = currentRoute == item.route,
                onItemClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                    scope.launch { scaffoldState.drawerState.close() }
                },
            )
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DrawerItem(
    item: NavigationItem,
    selected: Boolean,
    onItemClick: (NavigationItem) -> Unit
) {
    ListItem(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = { onItemClick(item) })
            .height(45.dp)
            .padding(start = 10.dp)
            .border(width = 0.dp, color = Color.Transparent, shape = RoundedCornerShape(5.dp)),
        icon = {
            Icon(
                imageVector = item.icon,
                contentDescription = stringResource(id = item.title),
                modifier = Modifier
                    .height(35.dp)
                    .width(35.dp)
            )
        },
        text = { Text(stringResource(id = item.title)) },
    )
//    Row(
//        verticalAlignment = Alignment.CenterVertically,
//        modifier = Modifier
//            .fillMaxWidth()
//            .clickable(onClick = { onItemClick(item) })
//            .height(45.dp)
//            .padding(start = 10.dp)
//            .border(width = 0.dp, color = Color.Transparent, shape = RoundedCornerShape(5.dp))
//    ) {
//        Icon(
//            imageVector = item.icon,
//            contentDescription = stringResource(id = item.title),
//            modifier = Modifier
//                .height(35.dp)
//                .width(35.dp)
//        )
//        Spacer(modifier = Modifier.width(7.dp))
//        Text(
//            text = stringResource(id = item.title),
//            fontSize = 18.sp,
//        )
//    }
}

@Preview(showBackground = true)
@Composable
private fun OnDrawerPreview() {
    UpmTheme {
//        NavigationDrawer()
    }
}