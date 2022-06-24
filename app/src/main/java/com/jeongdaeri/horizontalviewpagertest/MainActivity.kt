package com.jeongdaeri.horizontalviewpagertest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Card
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.jeongdaeri.horizontalviewpagertest.ui.theme.HorizontalViewPagerTestTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    companion object {
        const val MAX_SIZE = 10
    }


    @OptIn(ExperimentalPagerApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HorizontalViewPagerTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(){
                        val state = rememberPagerState()
                        val scope = rememberCoroutineScope()


                        Button(onClick = {
                            scope.launch {
                                if (state.currentPage < MAX_SIZE - 1) {
                                    state.scrollToPage(state.currentPage + 1)
                                }
//                                // or
//                                state.scrollBy(100f)
                            }
                        }) {
                            Text(text = "페이지 넘기기 버튼")
                        }

                        HorizontalPager(
                            MAX_SIZE,
                            state = state
                        ) { page ->
                            Card() {
                                Text(text = "하하하 쩡대리 카드 $page")
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HorizontalViewPagerTestTheme {
        Greeting("Android")
    }
}
