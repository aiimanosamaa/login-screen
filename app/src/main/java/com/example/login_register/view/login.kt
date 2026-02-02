package com.example.login_register.view

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.login_register.R

@Composable
fun LoginPage(navController: NavController) {
    val context = LocalContext.current
    val emailVal = remember { mutableStateOf("") }
    val passwordVal = remember { mutableStateOf("") }
    val passwordVisibility = remember { mutableStateOf(false) }

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { paddingValues ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color.White)
        ) {

            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {

                // login photo
                Image(
                    painter = painterResource(id = R.drawable.loginbackground),
                    contentDescription = "login image",
                    modifier = Modifier
                        .width(400.dp)
                        .height(350.dp),
                    contentScale = ContentScale.Fit
                )

                Spacer(modifier = Modifier.height(20.dp))

                // form
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = "Sign In",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    // Email
                    OutlinedTextField(
                        value = emailVal.value,
                        onValueChange = { emailVal.value = it },
                        label = { Text("Email Address") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(0.85f)
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    // Password
                    OutlinedTextField(
                        value = passwordVal.value,
                        onValueChange = { passwordVal.value = it },
                        label = { Text("Password") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(0.85f),
                        visualTransformation = if (passwordVisibility.value) VisualTransformation.None
                        else PasswordVisualTransformation(),
                        trailingIcon = {
                            IconButton(onClick = {
                                passwordVisibility.value = !passwordVisibility.value
                            }) {
                                Icon(
                                    painter = painterResource(
                                        if (passwordVisibility.value) R.drawable.outline_disabled_visible_24
                                        else R.drawable.outline_disabled_visible_24
                                    ),
                                    contentDescription = "Password visibility",
                                    tint = if (passwordVisibility.value) Color.Black else Color.Gray
                                )
                            }
                        })

                    Spacer(modifier = Modifier.height(20.dp))

                    // Button
                    Button(
                        onClick = {
                            when {
                                emailVal.value.isEmpty() -> {
                                    Toast.makeText(
                                        context, "Please enter email", Toast.LENGTH_SHORT
                                    ).show()
                                }

                                passwordVal.value.isEmpty() -> {
                                    Toast.makeText(
                                        context, "Please enter password", Toast.LENGTH_SHORT
                                    ).show()

                                }

                                else -> {
                                    Toast.makeText(context, "Login Successful", Toast.LENGTH_SHORT)
                                        .show()
                                }

                            }
                        },
                        modifier = Modifier
                            .width(280.dp)
                            .height(50.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF407BFF)
                        )
                    ) {
                        Text(
                            text = "Sign In", fontSize = 20.sp, color = Color.White
                        )
                    }
                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        "Create an Account ?",
                        color = Color.Black,
                        modifier = Modifier.clickable {navController.navigate("register")},
                        fontSize = 15.sp
                    )


                }
            }
        }
    }
}
