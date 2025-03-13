package com.example.rental_car_ui_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import com.example.rental_car_ui_compose.ui.HomeScreen
import com.example.rental_car_ui_compose.ui.Pager
import com.example.rental_car_ui_compose.ui.TopBar
import com.example.rental_car_ui_compose.ui.theme.Rental_Car_Ui_ComposeTheme
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.haze
import dev.chrisbanes.haze.hazeChild

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Rental_Car_Ui_ComposeTheme {
                val hasState = remember { HazeState() }
                val scrollBehaviour = TopAppBarDefaults.enterAlwaysScrollBehavior(
                    state = rememberTopAppBarState()
                )
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .nestedScroll(scrollBehaviour.nestedScrollConnection)
                        .background(MaterialTheme.colorScheme.background),
                    containerColor = Color.Transparent,
                    topBar = {
                        Column {
                            TopBar(
                                modifier = Modifier.hazeChild(state = hasState),
                                scrollBehavior = scrollBehaviour
                            )
                            Pager(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .hazeChild(state = hasState)
                            )
                        }

                    }) { innerPadding ->

                    HomeScreen(modifier = Modifier.fillMaxSize(),
                        hazeState = hasState,
                        paddingValues = innerPadding)
                }
            }
        }
    }
}

