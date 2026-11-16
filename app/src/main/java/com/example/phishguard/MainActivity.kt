package com.example.phishguard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Background = Color(0xFFF5F7FC)
private val CardColor = Color.White
private val Green = Color(0xFF16A36A)
private val Blue = Color(0xFF2563EB)
private val LightText = Color(0xFF17243A)
private val MutedText = Color(0xFF7B8799)
private val Red = Color(0xFFE5484D)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PhishGuardApp()
        }
    }
}

@Composable
fun PhishGuardApp() {

    var url by remember { mutableStateOf("") }
    var scanned by remember { mutableStateOf(false) }
    var suspicious by remember { mutableStateOf(false) }
    var selectedTab by remember { mutableIntStateOf(0) }

    MaterialTheme(
        colorScheme = lightColorScheme(
            primary = Blue,
            secondary = Green,
            background = Background,
            surface = CardColor,
            onBackground = LightText,
            onSurface = LightText
        )
    ) {

        Scaffold(
            containerColor = Background,

            bottomBar = {
                NavigationBar(
                    containerColor = Color.White,
                    contentColor = Blue
                ) {

                    val items = listOf(
                        Triple("⌂", "Home", 0),
                        Triple("◎", "Scanner", 1),
                        Triple("◷", "History", 2),
                        Triple("⚙", "Settings", 3)
                    )

                    items.forEach { item ->

                        NavigationBarItem(
                            selected = selectedTab == item.third,
                            onClick = {
                                selectedTab = item.third
                            },
                            icon = {
                                Text(
                                    item.first,
                                    fontSize = 22.sp
                                )
                            },
                            label = {
                                Text(
                                    item.second,
                                    fontSize = 10.sp
                                )
                            },
                            colors = NavigationBarItemDefaults.colors(
                                selectedIconColor = Blue,
                                selectedTextColor = Blue,
                                indicatorColor = Color(0xFFE8F0FF),
                                unselectedIconColor = MutedText,
                                unselectedTextColor = MutedText
                            )
                        )
                    }
                }
            }

        ) { padding ->

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 20.dp)
            ) {

                Spacer(modifier = Modifier.height(22.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Box(
                        modifier = Modifier
                            .size(48.dp)
                            .background(
                                Color(0xFFE8F0FF),
                                RoundedCornerShape(15.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("🛡️", fontSize = 27.sp)
                    }

                    Spacer(modifier = Modifier.width(12.dp))

                    Column(
                        modifier = Modifier.weight(1f)
                    ) {

                        Text(
                            "PhishGuard",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = LightText
                        )

                        Text(
                            "YOUR DIGITAL SECURITY PARTNER",
                            fontSize = 9.sp,
                            color = MutedText,
                            letterSpacing = 1.sp
                        )
                    }

                    Box(
                        modifier = Modifier
                            .background(
                                Color(0xFFE4F7EC),
                                CircleShape
                            )
                            .padding(
                                horizontal = 10.dp,
                                vertical = 8.dp
                            )
                    ) {
                        Text(
                            "● PROTECTED",
                            color = Green,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                Spacer(modifier = Modifier.height(30.dp))

                Text(
                    "Stay Safe Online 👋",
                    color = LightText,
                    fontSize = 27.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(7.dp))

                Text(
                    "Check suspicious links before you click.",
                    color = MutedText,
                    fontSize = 14.sp
                )

                Spacer(modifier = Modifier.height(25.dp))

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFFE7F8F0)
                    )
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Box(
                            modifier = Modifier
                                .size(55.dp)
                                .background(
                                    Color(0xFFD0F2E1),
                                    CircleShape
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("🛡️", fontSize = 29.sp)
                        }

                        Spacer(modifier = Modifier.width(15.dp))

                        Column {

                            Text(
                                "Your Protection",
                                color = MutedText,
                                fontSize = 12.sp
                            )

                            Spacer(modifier = Modifier.height(4.dp))

                            Text(
                                "Security Dashboard",
                                color = Green,
                                fontSize = 17.sp,
                                fontWeight = FontWeight.Bold
                            )

                            Text(
                                "Ready to check your links",
                                color = LightText,
                                fontSize = 11.sp
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(27.dp))


                Text(
                    "URL SECURITY SCANNER",
                    color = Blue,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.5.sp
                )

                Spacer(modifier = Modifier.height(12.dp))

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = CardColor
                    ),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 3.dp
                    )
                ) {

                    Column(
                        modifier = Modifier.padding(18.dp)
                    ) {

                        Text(
                            "Scan a Website",
                            fontSize = 19.sp,
                            fontWeight = FontWeight.Bold,
                            color = LightText
                        )

                        Spacer(modifier = Modifier.height(6.dp))

                        Text(
                            "Paste a URL below to check for suspicious patterns.",
                            fontSize = 12.sp,
                            color = MutedText
                        )

                        Spacer(modifier = Modifier.height(18.dp))

                        OutlinedTextField(
                            value = url,
                            onValueChange = {
                                url = it
                                scanned = false
                            },
                            modifier = Modifier.fillMaxWidth(),

                            placeholder = {
                                Text(
                                    "https://example.com",
                                    color = MutedText
                                )
                            },

                            leadingIcon = {
                                Text("🔗", fontSize = 19.sp)
                            },

                            singleLine = true,

                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Uri
                            ),

                            shape = RoundedCornerShape(13.dp),

                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = Blue,
                                unfocusedBorderColor = Color(0xFFDCE3EE),
                                focusedTextColor = LightText,
                                unfocusedTextColor = LightText,
                                cursorColor = Blue,
                                focusedContainerColor = Color.White,
                                unfocusedContainerColor = Color.White
                            )
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Button(
                            onClick = {

                                if (url.isNotBlank()) {

                                    val cleanUrl = url.lowercase()

                                    suspicious =
                                        cleanUrl.contains("verify-account") ||
                                                cleanUrl.contains("free-gift") ||
                                                cleanUrl.contains("login-secure") ||
                                                cleanUrl.contains("@") ||
                                                Regex(
                                                    """https?://\d{1,3}(\.\d{1,3}){3}"""
                                                ).containsMatchIn(cleanUrl)

                                    scanned = true
                                }
                            },

                            modifier = Modifier
                                .fillMaxWidth()
                                .height(52.dp),

                            shape = RoundedCornerShape(13.dp),

                            colors = ButtonDefaults.buttonColors(
                                containerColor = Blue,
                                contentColor = Color.White
                            ),

                            enabled = url.isNotBlank()

                        ) {

                            Text(
                                "⌕   SCAN URL NOW",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        if (scanned) {

                            Spacer(modifier = Modifier.height(18.dp))

                            HorizontalDivider(
                                color = Color(0xFFE0E6EF)
                            )

                            Spacer(modifier = Modifier.height(15.dp))

                            Text(
                                if (suspicious)
                                    "⚠ Suspicious URL Pattern"
                                else
                                    "✓ No Obvious Warning Patterns",

                                color = if (suspicious) Red else Green,

                                fontSize = 16.sp,

                                fontWeight = FontWeight.Bold
                            )

                            Spacer(modifier = Modifier.height(7.dp))

                            Text(
                                if (suspicious)
                                    "This URL contains patterns that deserve further investigation. Avoid entering personal information."
                                else
                                    "Our basic demo checks did not identify the configured warning patterns. This does not prove the website is safe.",

                                color = MutedText,
                                fontSize = 12.sp
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(25.dp))

                Text(
                    "SECURITY FEATURES",
                    color = Blue,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.5.sp
                )

                Spacer(modifier = Modifier.height(14.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {

                    FeatureCard(
                        modifier = Modifier.weight(1f),
                        icon = "🔍",
                        title = "URL Scanner",
                        description = "Check suspicious links"
                    )

                    FeatureCard(
                        modifier = Modifier.weight(1f),
                        icon = "🎣",
                        title = "Phishing Alert",
                        description = "Spot suspicious patterns"
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {

                    FeatureCard(
                        modifier = Modifier.weight(1f),
                        icon = "🔐",
                        title = "Privacy",
                        description = "Stay digitally protected"
                    )

                    FeatureCard(
                        modifier = Modifier.weight(1f),
                        icon = "📊",
                        title = "Reports",
                        description = "View scan results"
                    )
                }

                Spacer(modifier = Modifier.height(25.dp))

                Text(
                    "RECENT ACTIVITY",
                    color = Blue,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.5.sp
                )

                Spacer(modifier = Modifier.height(13.dp))

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(17.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = CardColor
                    ),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 2.dp
                    )
                ) {

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {

                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Text("🌐", fontSize = 23.sp)

                            Spacer(modifier = Modifier.width(12.dp))

                            Column(
                                modifier = Modifier.weight(1f)
                            ) {

                                Text(
                                    "Website scan history",
                                    color = LightText,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.SemiBold
                                )

                                Text(
                                    "Your latest scan will appear here",
                                    color = MutedText,
                                    fontSize = 11.sp
                                )
                            }

                            Text(
                                "›",
                                color = Blue,
                                fontSize = 25.sp
                            )
                        }

                        if (scanned) {

                            Spacer(modifier = Modifier.height(15.dp))

                            HorizontalDivider(
                                color = Color(0xFFE0E6EF)
                            )

                            Spacer(modifier = Modifier.height(12.dp))

                            Text(
                                url,
                                color = MutedText,
                                fontSize = 12.sp
                            )

                            Spacer(modifier = Modifier.height(7.dp))

                            Text(
                                if (suspicious)
                                    "⚠ Needs review"
                                else
                                    "✓ No obvious warning patterns",

                                color = if (suspicious) Red else Green,

                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    "PhishGuard • Stay Alert. Stay Protected.",
                    color = MutedText,
                    fontSize = 11.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 20.dp),
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun FeatureCard(
    modifier: Modifier = Modifier,
    icon: String,
    title: String,
    description: String
) {

    Card(
        modifier = modifier,
        shape = RoundedCornerShape(17.dp),
        colors = CardDefaults.cardColors(
            containerColor = CardColor
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 3.dp
        )
    ) {

        Column(
            modifier = Modifier.padding(15.dp)
        ) {

            Text(
                icon,
                fontSize = 25.sp
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                title,
                color = LightText,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                description,
                color = MutedText,
                fontSize = 10.sp
            )
        }
    }
}
