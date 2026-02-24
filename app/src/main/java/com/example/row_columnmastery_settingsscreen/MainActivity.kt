package com.example.row_columnmastery_settingsscreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.row_columnmastery_settingsscreen.ui.theme.RowColumnMasterySettingsScreenTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RowColumnMasterySettingsScreenTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ){ innerPadding ->
                    SettingsScreen(
                        modifier = Modifier.padding(innerPadding)
                    )

                }
            }
        }
    }
}

@Composable
fun SettingsScreen(modifier: Modifier = Modifier) {

    var notifications by rememberSaveable { mutableStateOf(true) }
    var darkMode by rememberSaveable { mutableStateOf(false) }
    var bluetoothEnabled by rememberSaveable { mutableStateOf(false) }
    var airplaneMode by rememberSaveable { mutableStateOf(false) }
    var brightness by rememberSaveable { mutableFloatStateOf(0.6f) }
    var textSize by rememberSaveable { mutableFloatStateOf(16f) }
    var highContrast by rememberSaveable { mutableStateOf(false) }
    var soundsEnabled by rememberSaveable { mutableStateOf(true) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {

        Text(
            text = "Settings",
            modifier = Modifier.align(Alignment.Start),
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.heightIn(min = 24.dp))

        /* Start of the account section*/
        SectionTitle("Account")

        SectionCard {
            SettingSwitchRow(
                "Notifications",
                "Receive push alerts",
                notifications
            ) { notifications = it }

            HorizontalDivider()

            SettingSwitchRow(
                "Dark Mode",
                "Use darker theme colors",
                darkMode
            ) { darkMode = it }
        }

        Spacer(modifier = Modifier.height(24.dp))

        /* Start of the connections section*/
        SectionTitle("Connections")

        SectionCard {
            SettingSwitchRow(
                "Bluetooth",
                "Connect to nearby devices",
                bluetoothEnabled
            ) { bluetoothEnabled = it }

            HorizontalDivider()

            SettingSwitchRow(
                "Airplane Mode",
                "Disable wireless connections",
                airplaneMode
            ) { airplaneMode = it }
        }

        Spacer(modifier = Modifier.height(24.dp))

        /* Start of the display section*/
        SectionTitle("Display")

        SectionCard {
            SettingSliderRow(
                "Brightness",
                "Adjust screen brightness",
                brightness
            ) { brightness = it }

            HorizontalDivider()

            SettingSliderRow(
                "Text Size",
                "Adjust reading size",
                textSize
            ) { textSize = it }
        }

        Spacer(modifier = Modifier.height(24.dp))

        /* Start of the accessibility section*/
        SectionTitle("Accessibility")

        SectionCard {
            SettingSwitchRow(
                "High Contrast",
                "Increase visual clarity",
                highContrast
            ) { highContrast = it }

            HorizontalDivider()

            SettingCheckboxRow(
                "Enable Sounds",
                "Play interaction sounds",
                soundsEnabled
            ) { soundsEnabled = it }
        }

        Spacer(modifier = Modifier.height(32.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun SettingsScreenPreview() {
    SettingsScreen()
}

@Composable
fun SectionTitle(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleMedium,
        modifier = Modifier.padding(bottom = 8.dp)
    )
}
@Composable
fun SectionCard(content: @Composable () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .border(1.dp, MaterialTheme.colorScheme.outline)
            .padding(12.dp)
    ) {
        content()
    }
}

@Preview(showBackground = true)
@Composable
fun SectionCardPreview() {
    SectionCard {
        Text("Example Setting")
    }
}

@Composable
fun SettingSwitchRow(
    title: String,
    description: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(end = 8.dp)
        ) {
            Text(title, style = MaterialTheme.typography.bodyLarge)

            Text(
                description,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        Switch(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SwitchRowPreview() {
    SettingSwitchRow(
        "Bluetooth",
        "Connect to nearby devices",
        true,
        {}
    )
}
@Composable
fun SettingCheckboxRow(
    title: String,
    description: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onCheckedChange(!checked) }
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(end = 8.dp)
        ) {
            Text(title)

            Text(
                description,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CheckboxRowPreview() {
    SettingCheckboxRow(
        "Enable Sounds",
        "Play interaction sounds",
        false,
        {}
    )
}
@Composable
fun SettingSliderRow(
    title: String,
    description: String,
    value: Float,
    onValueChange: (Float) -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp)
    ) {

        Text(title)

        Text(
            description,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.height(8.dp))

        Slider(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SliderRowPreview() {
    SettingSliderRow(
        "Brightness",
        "Adjust screen brightness",
        0.5f,
        {}
    )
}
