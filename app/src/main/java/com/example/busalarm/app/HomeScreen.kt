package com.example.busalarm.app

import android.widget.Toast
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.busalarm.alarm.presentation.SharedViewModel
import com.example.busalarm.alarm.presentation.add.AddAlarmScreenRoot
import com.example.busalarm.alarm.presentation.add.AddAlarmViewModel
import com.example.busalarm.alarm.presentation.AlarmListScreenRoot
import com.example.busalarm.alarm.presentation.add.AddAction
import com.example.busalarm.alarm.presentation.bus_list.BusListScreenRoot
import com.example.busalarm.alarm.presentation.bus_list.BusListViewModel
import com.example.busalarm.core.presentation.DarkBlue
import com.example.busalarm.core.presentation.DesertWhite
import org.koin.androidx.compose.koinViewModel

data class NavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val badgeCount: Int? = null
)

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
    val sharedViewModel = koinViewModel<SharedViewModel>()
    val ctx = LocalContext.current
    SharedTransitionLayout {
        NavHost(
            navController = navController,
            startDestination = Route.Home
        ) {
            composable<Route.Home> {
                Scaffold(
                    modifier = modifier,
                    floatingActionButton = {
                        FloatingActionButton(
                            containerColor = DarkBlue.copy(0.8f),
                            contentColor = DesertWhite,
                            onClick = {
                                navController.navigate(Route.Add())
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = "Add Alarm",
                            )
                        }
                    }
                ) { innerPadding ->
                    Box(
                        modifier = Modifier.padding(innerPadding),
                        contentAlignment = Alignment.Center
                    ) {
                        AlarmListScreenRoot(
                            viewModel = sharedViewModel,
                            onAlarmClick = {
                                navController.navigate(Route.Alarm(it.name))
                            }
                        )
                    }
                }
            }

            composable<Route.Add> {
                val args = it.toRoute<Route.Add>()
                val viewModel = koinViewModel<AddAlarmViewModel>()
                if (args.alarmId != null) {
                    viewModel.initState(args.alarmId, sharedViewModel)
                }
                AddAlarmScreenRoot(
                    viewModel = viewModel,
                    modifier = Modifier.fillMaxSize(),
                    onDeleteClick = { name ->
                        if(!sharedViewModel.onDelete(name)) {
                            Toast.makeText(ctx, "Alarm not found", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(ctx, "Alarm deleted", Toast.LENGTH_SHORT).show()
                            navController.navigateUp()
                        }
                    },
                    onDoneClick = { alarm ->
                        sharedViewModel.onSave(alarm, viewModel.state.value.isNew)
                        Toast.makeText(ctx, "Alarm saved", Toast.LENGTH_SHORT).show()
                        navController.navigateUp()
                    }
                )
            }

            composable<Route.Alarm> { entry ->
                val args = entry.toRoute<Route.Alarm>()
                val alarm = sharedViewModel.getAlarm(args.alarmId)
                if (alarm == null) {
                    Toast.makeText(ctx, "Alarm not found", Toast.LENGTH_SHORT).show()
                    navController.navigateUp()
                } else {
                    val viewModel = koinViewModel<BusListViewModel>()
                    BusListScreenRoot(
                        viewModel = viewModel,
                        alarm = alarm,
                        onEditClick = {
                            navController.navigate(Route.Add(alarm.name))
                        },
                        onBackClick = {
                            navController.navigate(Route.Home)
                        }
                    )
                }
            }
        }
    }
}