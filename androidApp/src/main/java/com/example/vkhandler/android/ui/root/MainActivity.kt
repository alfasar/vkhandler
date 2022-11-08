package com.example.vkhandler.android.ui.root

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.vkhandler.android.theme.AppTheme

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                AppScaffold()
            }
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    AppTheme {
        AppScaffold()
    }
}
