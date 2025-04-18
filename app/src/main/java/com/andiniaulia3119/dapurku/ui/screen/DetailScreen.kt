package com.andiniaulia3119.dapurku.ui.screen

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.andiniaulia3119.dapurku.R
import com.andiniaulia3119.dapurku.data.repository.RecipeRepository
import com.andiniaulia3119.dapurku.ui.theme.DapurKuTheme
import com.andiniaulia3119.dapurku.utils.ShareUtils

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(navController: NavController, recipeId: Long) {
    val recipe = RecipeRepository.getRecipeById(recipeId)
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Resep") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = stringResource(R.string.back))
                    }
                },
                actions = {
                    IconButton(onClick = {
                        recipe?.let {
                            ShareUtils.shareText(
                                context,
                                "Resep ${it.name}",
                                "${it.name} (${it.type})\n\n${it.description}"
                            )
                        }
                    }) {
                        Icon(Icons.Default.Share, contentDescription = "Share")
                    }
                }
            )
        }
    ) { padding ->
        if (recipe != null) {
            Column(Modifier.padding(padding).padding(16.dp)) {
                Text(recipe.name, style = MaterialTheme.typography.headlineSmall)
                Spacer(modifier = Modifier.height(8.dp))
                Text("${recipe.type}", style = MaterialTheme.typography.bodyLarge)
                Spacer(modifier = Modifier.height(16.dp))
                Text(recipe.description, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun DetailScreenPreview() {
    DapurKuTheme {
        DetailScreen(navController = rememberNavController(), recipeId = 1)
    }
}

