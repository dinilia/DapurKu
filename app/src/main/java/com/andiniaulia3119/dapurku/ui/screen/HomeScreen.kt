package com.andiniaulia3119.dapurku.ui.screen

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.andiniaulia3119.dapurku.R
import com.andiniaulia3119.dapurku.data.repository.RecipeRepository
import com.andiniaulia3119.dapurku.navigation.Screen
import com.andiniaulia3119.dapurku.ui.theme.DapurKuTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    val recipes by remember { mutableStateOf(RecipeRepository.getRecipes()) }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("DapurKu!") })
        }
    ) { padding ->
        Column(Modifier.padding(padding).padding(16.dp)) {
            // Menambahkan gambar logo
            Image(
                painter = painterResource(id = R.drawable.logo), // Ganti 'logo' dengan nama file gambar Anda
                contentDescription = "Logo DapurKu",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp) // Atur tinggi sesuai kebutuhan
                    .padding(bottom = 16.dp) // Jarak bawah
            )

            Text(
                text = "Selamat Datang di DapurKu!\nSilahkan melihat-lihat resep yang ada!!\nKamu punya resep baru? Jangan lupa tambahin yahh!!",
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { navController.navigate(Screen.AddRecipe.route) }) {
                Text("Tambah Resep")
            }
            Spacer(modifier = Modifier.height(24.dp))
            Text("Menu", style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(8.dp))
            LazyColumn {
                items(recipes) { recipe ->
                    Column(
                        Modifier
                            .fillMaxWidth()
                            .clickable { navController.navigate(Screen.Detail.createRoute(recipe.id)) }
                            .padding(8.dp)
                    ) {
                        Text(text = recipe.name, style = MaterialTheme.typography.titleMedium)
                        Text(text = recipe.type, style = MaterialTheme.typography.bodySmall)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun MainScreenPreview() {
    DapurKuTheme {
        HomeScreen(navController = NavController(LocalContext.current))
    }
}