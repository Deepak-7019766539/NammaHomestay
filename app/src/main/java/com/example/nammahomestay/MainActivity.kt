package com.example.namma_homestay

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                HomeScreen()
            }
        }
    }
}

data class HomeStay(
    val name: String,
    val location: String,
    val price: String,
    val description: String
)

@Composable
fun HomeScreen() {

    val homeStays = listOf(

        HomeStay(
            "River View Stay",
            "Chikmagalur",
            "₹1500/night",
            "Traditional food with mountain view"
        ),

        HomeStay(
            "Coffee Valley Homestay",
            "Coorg",
            "₹2200/night",
            "Coffee estate experience"
        ),

        HomeStay(
            "Nature Nest",
            "Sakleshpur",
            "₹1800/night",
            "Nature stay with campfire"
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color(0xFF2E7D32),
                        Color(0xFFA5D6A7)
                    )
                )
            )
            .padding(16.dp)
    ) {

        Text(
            text = "🏡 Namma HomeStay",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Discover Rural Tourism",
            color = Color.White,
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn {

            items(homeStays) { stay ->

                HomeStayCard(stay)
            }
        }
    }
}

@Composable
fun HomeStayCard(stay: HomeStay) {

    var expanded by remember {
        mutableStateOf(false)
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
            .clickable {
                expanded = !expanded
            },

        shape = RoundedCornerShape(20.dp),

        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {

        Column(
            modifier = Modifier.padding(18.dp)
        ) {

            Text(
                text = stay.name,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = null,
                    tint = Color.Red
                )

                Spacer(modifier = Modifier.width(6.dp))

                Text(
                    text = stay.location,
                    fontSize = 17.sp
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = stay.price,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2E7D32)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = stay.description,
                fontSize = 16.sp
            )

            if (expanded) {

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "🍛 Today's Menu",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text("• Ragi Mudde")
                Text("• Bamboo Curry")
                Text("• Akki Rotti")

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {},

                    modifier = Modifier.fillMaxWidth(),

                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF2E7D32)
                    ),

                    shape = RoundedCornerShape(12.dp)
                ) {

                    Text(
                        text = "Book Now",
                        fontSize = 18.sp
                    )
                }
            }
        }
    }
}