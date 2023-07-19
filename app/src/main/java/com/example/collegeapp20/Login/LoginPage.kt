package com.dbtechprojects.photonotes.ui.Login

import android.content.Context
import android.graphics.Paint.Align
import android.icu.text.CaseMap.Title
import android.text.InputType
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.collegeapp20.Navdrawer.NavigationItem


@Composable
fun LoginPage(
    navController: NavController,
    context: Context

) {


    var email by remember {
        mutableStateOf(" ")
    }

    var password by remember {
        mutableStateOf(" ")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(50.dp)

            ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "SARJ-NOTIFY",

            )

        OutlinedTextField(value = " ",
            onValueChange = { email = it },

            modifier = Modifier.padding()
            ,
            label = { Text("enter your email") },
            leadingIcon = {
                Icon(Icons.Default.Call, contentDescription = "call")
            }

        )


        OutlinedTextField(value = " ",
            onValueChange = { password = it },
            modifier = Modifier.padding(10.dp),
            label = { Text("enter your password") },
            leadingIcon = {
                Icon(Icons.Default.Info, contentDescription = "Info")
            },

            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password))


        OutlinedButton(
            onClick =  {
                navController.navigate(route =NavigationItem.MainPage.route)


            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp, top = 10.dp)
        ) {
            Text(
                text = "Login",
                textAlign = TextAlign.Center
            )




        }


    }
}

fun logged(email: String, password: String, context: Context) {

}

@Composable
    fun HyperlinkText(
        modifier: Modifier,
        fullText: String,
        linkText: List<String>,
        linkTextColor: Color = Color.Black,
        linkTextFontWeight: FontWeight = FontWeight.Bold,
        linkTextDecoration: TextDecoration = TextDecoration.Underline,
        hyperlinks: List<String>,
        fontSize: TextUnit = TextUnit.Unspecified
    ) {

        val annotatedString = buildAnnotatedString {
            append(fullText)
            linkText.forEachIndexed { index, link ->
                val startIndex = fullText.indexOf(link)
                val endIndex = startIndex + link.length
                addStyle(
                    style = SpanStyle(
                        color = linkTextColor,
                        fontWeight = linkTextFontWeight,
                        textDecoration = linkTextDecoration
                    ),
                    start = startIndex,
                    end = endIndex
                )

                addStringAnnotation(
                    tag = "URL",
                    annotation = hyperlinks[index],
                    start = startIndex,
                    end = endIndex
                )
            }
            addStyle(
                SpanStyle(
                ),
                start = 0,
                end = fullText.length
            )
        }


        val uriHandler = LocalUriHandler.current

        ClickableText(

            modifier = Modifier,

            text = annotatedString,


            onClick =
            {
                annotatedString
                    .getStringAnnotations("URL", it, it)
                    .firstOrNull()?.let { stringAnnotation ->
                        uriHandler.openUri(stringAnnotation.item)
                    }
            })

    }








