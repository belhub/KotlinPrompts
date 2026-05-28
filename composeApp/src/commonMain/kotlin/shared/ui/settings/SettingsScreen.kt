package shared.ui.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ErrorOutline
import androidx.compose.material.icons.filled.Save
import androidx.compose.material.icons.filled.WarningAmber
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

private val SettingsAccent = Color(0xFFFF9800)

@Composable
fun SettingsScreen() {
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()
    var fullName by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    val isEmailInvalid = email.isNotBlank() && !email.isValidEmail()
    val isSaveDisabled = fullName.isBlank() || isEmailInvalid
    var bugDescription by rememberSaveable { mutableStateOf("") }
    var bugDescriptionError by rememberSaveable { mutableStateOf(false) }

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Card(
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                modifier = Modifier.fillMaxWidth(),
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                    Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                        Column(
                            modifier = Modifier
                                .background(SettingsAccent.copy(alpha = 0.15f), CircleShape)
                                .padding(14.dp),
                        ) {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = "Profil użytkownika",
                                tint = SettingsAccent,
                            )
                        }

                        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                            Text(
                                text = "Profil użytkownika",
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Bold,
                            )
                            Text(
                                text = "Zapisz dane kontaktowe lokalnie na urządzeniu.",
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                            )
                        }
                    }

                    OutlinedTextField(
                        value = fullName,
                        onValueChange = { fullName = it },
                        label = { Text(text = "Imię i nazwisko") },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true,
                    )

                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text(text = "Email") },
                        isError = isEmailInvalid,
                        supportingText = if (isEmailInvalid) {
                            { Text(text = "Email jest niepoprawny") }
                        } else {
                            null
                        },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true,
                    )

                    Button(
                        onClick = {
                            if (!isSaveDisabled) {
                                coroutineScope.launch {
                                    snackbarHostState.showSnackbar(
                                        message = "Zapisano zmiany profilu",
                                        duration = SnackbarDuration.Short,
                                    )
                                }
                                fullName = ""
                                email = ""
                            }
                        },
                        enabled = !isSaveDisabled,
                        colors = ButtonDefaults.buttonColors(containerColor = SettingsAccent),
                        shape = RoundedCornerShape(14.dp),
                        modifier = Modifier.fillMaxWidth(),
                    ) {
                        Icon(
                            imageVector = Icons.Default.Save,
                            contentDescription = null,
                        )
                        Text(
                            text = "Zapisz zmiany",
                            modifier = Modifier.padding(start = 8.dp),
                        )
                    }
                }
            }

            Card(
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                modifier = Modifier.fillMaxWidth(),
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                    Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                        Column(
                            modifier = Modifier
                                .background(SettingsAccent.copy(alpha = 0.15f), CircleShape)
                                .padding(14.dp),
                        ) {
                            Icon(
                                imageVector = Icons.Default.WarningAmber,
                                contentDescription = "Zgłoś błąd",
                                tint = SettingsAccent,
                            )
                        }

                        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                            Text(
                                text = "Zgłoś błąd",
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Bold,
                            )
                            Text(
                                text = "Opisz problem, a przekażemy go dalej.",
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                            )
                        }
                    }

                    OutlinedTextField(
                        value = bugDescription,
                        onValueChange = {
                            bugDescription = it
                            bugDescriptionError = false
                        },
                        label = { Text(text = "Opis problemu") },
                        placeholder = { Text(text = "Opisz napotkany błąd…") },
                        isError = bugDescriptionError,
                        supportingText = if (bugDescriptionError) {
                            { Text(text = "Pole opisu nie może być puste") }
                        } else {
                            null
                        },
                        modifier = Modifier.fillMaxWidth(),
                        minLines = 4,
                    )

                    Button(
                        onClick = {
                            val description = bugDescription.trim()
                            if (description.isEmpty()) {
                                bugDescriptionError = true
                                coroutineScope.launch {
                                    snackbarHostState.showSnackbar(
                                        message = "Opisz napotkany błąd",
                                        duration = SnackbarDuration.Short,
                                    )
                                }
                            } else {
                                sendBugReport(description)
                                bugDescription = ""
                                bugDescriptionError = false
                                coroutineScope.launch {
                                    snackbarHostState.showSnackbar(
                                        message = "Zgłoszenie zostało wysłane",
                                        duration = SnackbarDuration.Short,
                                    )
                                }
                            }
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE0E0E0), contentColor = Color.Black),
                        shape = RoundedCornerShape(14.dp),
                        modifier = Modifier.fillMaxWidth(),
                    ) {
                        Icon(
                            imageVector = Icons.Default.ErrorOutline,
                            contentDescription = null,
                        )
                        Text(
                            text = "Wyślij zgłoszenie",
                            modifier = Modifier.padding(start = 8.dp),
                        )
                    }
                }
            }
        }
    }
}

private fun sendBugReport(description: String) {
    // TODO: podłącz prawdziwe wysyłanie zgłoszenia, np. do backendu lub analityki.
    description.length
}

private fun String.isValidEmail(): Boolean {
    return Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$").matches(trim())
}