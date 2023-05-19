@file:OptIn(ExperimentalMaterial3Api::class)

package com.baderlouay.monmedecin

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color.parseColor
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.baderlouay.monmedecin.ui.theme.MonMedecinTheme



class MainActivity : ComponentActivity() {

    lateinit var recyclerbtn: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(Home())
    }

    private fun replaceFragment(fragment: Fragment) {


        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()

    }
}



/*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MonMedecinTheme {
                RecyclerView()
            }
        }
    }
}

@Composable
fun ListItem(name : String){

    val expanded = remember { mutableStateOf(false)}
    val extraPadding by animateDpAsState(
        if (expanded.value) 24.dp else 0.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )

    Surface(color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp) .background(color = "#2596be".color)){

        Column(modifier = Modifier
            .padding(24.dp)
            .fillMaxWidth()) {

            Row{

                Column(
                    modifier = Modifier
                        .weight(1f)

                ) {
                    Text(text = "Doctor")
                    Text(text = "louay")
                }

                OutlinedButton(onClick = { expanded.value = !expanded.value }, colors = ButtonDefaults.buttonColors(Color.White)) {
                    Text(if (expanded.value) "Show less" else "Show more" , color = "#000000".color)
                }
            }

            if (expanded.value){

                Column(modifier = Modifier.padding(
                    bottom = extraPadding.coerceAtLeast(0.dp)
                )) {
                    Text(text = "Name/Profession/Spec")}

            }
        }

    }

}
val String.color
    get() = Color(parseColor(this))



@Composable
fun RecyclerView(names : List<String> = List(100){"$it"}){

    LazyColumn(modifier = Modifier.padding(vertical = 4.dp)){

        items(items = names){ name ->

            ListItem(name = name)

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
    MonMedecinTheme {
        RecyclerView()
    }
}


*/










/*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MonMedecinTheme {
                var name by remember {
                    mutableStateOf("")
                }
                var names by remember {
                    mutableStateOf(listOf<String>())
                }
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        OutlinedTextField(
                            value = name, 
                            onValueChange = {text ->
                                name = text
                            },
                            modifier = Modifier.weight(1f)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Button(onClick = {
                            if(name.isNotBlank()) {
                                names = names + name
                                name = ""
                            }
                        }) {
                            Text(text = "Add")
                        }
                    }
                    /*
                    LazyColumn(modifier) {
                        items(names) { currentName ->
                            Text(
                                text = currentName,
                                modifier = Modifier
                                 .fillMaxWidth()
                                 .padding(16.dp)
                            )
                            Divider()
                        }
                    }
                    */
                    NameList(names = names)
                }
            }
        }
    }
}


@Composable
fun NameList(
    names: List<String>,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier) {
        items(names) { currentName ->
            Text(
                text = currentName,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
            Divider()
        }
    }

}

/*
@Preview(showBackground = true)
@Composable
fun NameListPreview() {
        NameList(names = names)

}
*/


*/