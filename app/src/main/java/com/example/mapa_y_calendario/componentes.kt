package com.example.mapa_y_calendario

import android.view.LayoutInflater
import android.widget.CalendarView
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun PantallaCalendario(modifier: Modifier = Modifier) {

    var fechaSeleccionada by remember {
        mutableStateOf("No se ha seleccionado una fecha")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Seleccione una fecha",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(16.dp))

        AndroidView(
            factory = { context ->

                val view = LayoutInflater.from(context)
                    .inflate(R.layout.calendario_layout, null)

                val calendar = view.findViewById<CalendarView>(R.id.calendarView)

                calendar.setOnDateChangeListener { _, year, month, day ->

                    fechaSeleccionada =
                        "$day/${month + 1}/$year"
                }

                view
            }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Fecha seleccionada: $fechaSeleccionada",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}