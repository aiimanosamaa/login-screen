package com.example.login_register.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.login_register.R
import androidx.navigation.NavController

@Composable

fun Register(navController: NavController) {
    val context = LocalContext.current
    val nameVal = remember { mutableStateOf("") }
    val emailVal = remember { mutableStateOf("") }
    val phoneVal = remember { mutableStateOf("") }
    val passwordVal = remember { mutableStateOf("") }
    val confirmPasswordVal = remember { mutableStateOf("") }

    val passwordVisibility = remember { mutableStateOf(false) }
    val confirmPasswordVisibility = remember { mutableStateOf(false) }

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
                Image(
                    painter = painterResource(id = R.drawable.reg),
                    contentDescription = "login image", modifier = Modifier
                        .width(400.dp)
                        .height(350.dp),
                    contentScale = ContentScale.Fit
                )

                Spacer(modifier = Modifier.height(10.dp))

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // name
                    OutlinedTextField(
                        value = nameVal.value,
                        onValueChange = { nameVal.value = it },
                        label = { Text("Name") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(0.85f)
                    )
                    Spacer(modifier = Modifier.height(12.dp))

                    // email
                    OutlinedTextField(
                        value = emailVal.value,
                        onValueChange = { emailVal.value = it },
                        label = { Text("Email Address") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(0.85f)
                    )
                    Spacer(modifier = Modifier.height(12.dp))


                    // phone
                    OutlinedTextField(
                        value = phoneVal.value,
                        onValueChange = { phoneVal.value = it },
                        label = { Text("Phone number") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(0.85f)
                    )
                    Spacer(modifier = Modifier.height(12.dp))

                    // password
                    val visualTransformation = null
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
                        }

                    )
                    Spacer(modifier = Modifier.height(12.dp))

                    // Confirm password
                    OutlinedTextField(
                        value = confirmPasswordVal.value,
                        onValueChange = { confirmPasswordVal.value = it },
                        label = { Text("Confirm Password") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(0.85f),

                        visualTransformation = if (confirmPasswordVisibility.value) VisualTransformation.None
                        else PasswordVisualTransformation(),
                        trailingIcon = {
                            IconButton(onClick = {
                                confirmPasswordVisibility.value =
                                    !confirmPasswordVisibility.value

                            }) {
                                Icon(
                                    painter = painterResource(
                                        if (confirmPasswordVisibility.value) R.drawable.outline_disabled_visible_24
                                        else R.drawable.outline_disabled_visible_24

                                    ),
                                    contentDescription = "Password visibility",
                                    tint = if (confirmPasswordVisibility.value) Color.Black else Color.Gray
                                )
                            }
                        }

                    )
                    Spacer(modifier = Modifier.height(12.dp))

                    Button(onClick = {}, colors = ButtonDefaults.buttonColors(Color(0xFF407BFF))) {
                        Text(
                            "Sign Up",
                            modifier = Modifier.padding(8.dp),
                            color = Color.White,
                            fontSize = 20.sp
                        )
                    }


                }


            }

        }

    }
}