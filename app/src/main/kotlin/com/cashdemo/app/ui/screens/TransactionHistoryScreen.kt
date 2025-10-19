package com.cashdemo.app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.cashdemo.app.ui.theme.PrimaryLight
import com.cashdemo.app.ui.theme.SuccessGreen
import com.cashdemo.app.ui.theme.ErrorRed

@Composable
fun TransactionHistoryScreen(navController: NavController) {
    val transactions = remember {
        listOf(
            TransactionItem(1, "John Doe", 50.0, "sent", "Today 2:30 PM"),
            TransactionItem(2, "Sarah Smith", 100.0, "received", "Yesterday 10:15 AM"),
            TransactionItem(3, "Mike Johnson", 25.50, "sent", "2 days ago"),
            TransactionItem(4, "Emma Wilson", 75.0, "received", "3 days ago"),
            TransactionItem(5, "David Brown", 150.0, "sent", "1 week ago"),
            TransactionItem(6, "Lisa Anderson", 200.0, "received", "2 weeks ago"),
            TransactionItem(7, "Tom Harris", 45.0, "sent", "3 weeks ago"),
            TransactionItem(8, "Jessica Lee", 120.0, "received", "1 month ago"),
            TransactionItem(9, "Robert Taylor", 80.0, "sent", "1 month ago"),
            TransactionItem(10, "Amanda White", 95.0, "received", "1 month ago")
        )
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // Header with Back Button
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = PrimaryLight
                )
            }
            Text(
                text = "Transaction History",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(start = 8.dp)
            )
        }

        // Summary Stats
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            StatCard(
                label = "Total Sent",
                amount = 350.50,
                color = ErrorRed
            )
            StatCard(
                label = "Total Received",
                amount = 595.0,
                color = SuccessGreen
            )
        }

        // Transactions List
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 16.dp)
        ) {
            items(transactions) { transaction ->
                TransactionHistoryCard(transaction)
            }
        }
    }
}

@Composable
fun StatCard(
    label: String,
    amount: Double,
    color: androidx.compose.ui.graphics.Color
) {
    Card(
        modifier = Modifier
            .weight(1f)
            .padding(end = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = label,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Text(
                text = "$${"%.2f".format(amount)}",
                style = MaterialTheme.typography.bodyLarge,
                color = color,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
}

@Composable
fun TransactionHistoryCard(transaction: TransactionItem) {
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
            Column(
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = if (transaction.type == "sent") "-${"%.2f".format(transaction.amount)}" else "+${"%.2f".format(transaction.amount)}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = if (transaction.type == "sent") ErrorRed else SuccessGreen,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = if (transaction.type == "sent") "Sent" else "Received",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

