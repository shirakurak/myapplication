package com.example.myapplication

import android.os.Bundle
import android.widget.ListView
import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.adapter.CustomAdapter
import com.example.myapplication.model.Data
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContent {
//            MyApplicationTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
//                    Greeting("Android")
//                }
//            }
//        }
        setContentView(R.layout.activity_main) // デザイン確認のため追加（同時に、上記はコメントアウト）

        var dataList = arrayListOf<Data>()
        for (i in 0..5) {
            dataList.add(Data().apply {
                title = "${i}番目のタイトル"
                text = "${i}番目のテキスト"
                buttonText = "ボタン${i}"
                buttonClickAction = {
                    // ボタンがクリックされた時の処理
                }
            })
        }

        val adapter = CustomAdapter(this, dataList)
        val customListView = findViewById<ListView>(R.id.custom_list_view)
        customListView.adapter = adapter
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
            text = "Hello $name!",
            modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}