package com.cashdemo.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.cashdemo.app.ui.theme.PrimaryLight
import com.cashdemo.app.ui.theme.SuccessGreen
import com.cashdemo.app.ui.theme.ErrorRed

data class TransactionItem(
    val id: Int,
    val name: String,
    val amount: Double,
    val type: String,
    val date: String
)

@Composable
fun HomeScreen(navController: NavController) {
    var balance by remember { mutableStateOf(1250.50) }
    var transactions by remember {
        mutableStateOf(
            listOf(
                TransactionItem(1, "John Doe", 50.0, "sent", "Today 2:30 PM"),
                TransactionItem(2, "Sarah Smith", 100.0, "received", "Yesterday 10:15 AM"),
                TransactionItem(3, "Mike Johnson", 25.50, "sent", "2 days ago"),
                TransactionItem(4, "Emma Wilson", 75.0, "received", "3 days ago"),
                TransactionItem(5, "David Brown", 150.0, "sent", "1 week ago")
            )
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        // Header
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(PrimaryLight)
                .padding(24.dp)
        ) {
            Column {
                Text(
                    text = "Your Balance",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.White,
                    fontSize = 14.sp
                )
                Text(
                    text = "$${"%.2f".format(balance)}",
                    style = MaterialTheme.typography.headlineLarge,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 36.sp,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }

        // Action Buttons
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            ActionButton(
                icon = Icons.Default.Send,
                label = "Send Money",
                onClick = { navController.navigate("send_money") }
            )
            ActionButton(
                icon = Icons.Default.ArrowDownward,
                label = "Request",
                onClick = { }
            )
            ActionButton(
                icon = Icons.Default.History,
                label = "History",
                onClick = { navController.navigate("transaction_history") }
            )
        }

        // Recent Transactions
        Text(
            text = "Recent Transactions",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(start = 16.dp, top = 24.dp, bottom = 12.dp)
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            items(transactions) { transaction ->
                TransactionCard(transaction)
            }
        }
    }
}

@Composable
fun ActionButton(
    icon: androidx.compose.material.icons.Icons,
    label: String,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable { onClick() }
    ) {
        Card(
            modifier = Modifier
                .size(60.dp),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant
            )
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = label,
                    tint = PrimaryLight,
                    modifier = Modifier.size(28.dp)
                )
            }
        }
        Text(
            text = label,
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.padding(top = 8.dp),
            fontSize = 12.sp
        )
    }
}

@Composable
fun TransactionCard(transaction: TransactionItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 12.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = transaction.name,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = transaction.date,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Text(
                text = if (transaction.type == "sent") "-${"%.2f".format(transaction.amount)}" else "+${"%.2f".format(transaction.amount)}",
                style = MaterialTheme.typography.bodyMedium,
                color = if (transaction.type == "sent") ErrorRed else SuccessGreen,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

