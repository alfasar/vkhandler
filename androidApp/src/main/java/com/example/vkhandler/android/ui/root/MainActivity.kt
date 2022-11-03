package com.example.vkhandler.android.ui.root

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewModelScope
import com.example.vkhandler.android.R
import com.example.vkhandler.android.ui.theme.AppTheme
import com.example.vkhandler.android.ui.vk.PhotoView
import com.example.vkhandler.presentation.PhotoViewModel
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val photoViewModel: PhotoViewModel by viewModel()
    val scope = MainScope()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContent {
//            AppTheme {
//                AppScaffold()
//            }
//        }
        setContentView(R.layout.activity_main)

        val text: TextView = findViewById(R.id.text_view)


    }
}

@Preview
@Composable
fun DefaultPreview() {
    AppTheme {
        AppScaffold()
    }
}
