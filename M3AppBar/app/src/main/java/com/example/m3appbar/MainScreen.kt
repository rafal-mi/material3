package com.example.m3appbar

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.ui.unit.dp
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
             TopAppBar(
                 scrollBehavior = scrollBehavior,
                 navigationIcon = {
                      IconButton(onClick = {}) {
                          Icon(
                              imageVector = Icons.Default.Menu,
                              contentDescription = "Menu Icon"
                          )
                      }
                 },
                 title = {
                     Text(text = "Home")
                 },
//                 colors = topAppBarColors(
//                     containerColor = MaterialTheme.colorScheme.surfaceColorAtElevation(3.dp)
//                 )
             )

        },
        content = {
            CustomList(paddingValues = it)
        }
    )
}

@Composable
fun CustomList(paddingValues: PaddingValues) {
    val numbers = remember { mutableStateListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16) }

    LazyColumn(
        modifier = Modifier
            .padding(top = paddingValues.calculateTopPadding())
    ) {
        items(
            count = numbers.size,
            key = { it.hashCode() },
            contentType = { null }
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 24.dp),
                text = "${numbers[it]}",
                style = TextStyle(
                    fontSize = MaterialTheme.typography.titleLarge.fontSize,
                    fontWeight = FontWeight.Medium
                )
            )
        }

    }
}