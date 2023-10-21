package com.example.travelplannerapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledIconToggleButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchColors
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.travelplannerapp.R
import com.example.travelplannerapp.ui.theme.darkGray
import com.example.travelplannerapp.ui.theme.textGray
import com.example.travelplannerapp.ui.theme.textOrange

@Composable
fun SignUpScreen(navController: NavController) {

    Surface(
        modifier = Modifier
            .fillMaxSize()

    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxHeight()
                .background(Color.White),


            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var emailInput by remember { mutableStateOf("") }
            var firstNameInput by remember { mutableStateOf("") }
            var lastNameInput by remember { mutableStateOf("") }
            var passwordInput by remember { mutableStateOf("") }
            var confirmPasswordInput by remember { mutableStateOf("") }
            var ageSliderValue by remember { mutableStateOf(18f) }
            var selectedSwitchState by remember { mutableIntStateOf(1) }

            var isEmailValid by remember { mutableStateOf(false) }

            var isPasswordValid by remember { mutableStateOf(false) }

            Spacer(modifier = Modifier.height(120.dp))
            OutlinedTextField(
                value = emailInput, onValueChange = {
                    emailInput = it
                    isEmailValid = isValidEmail(it)
                },
                label = {
                    Text(
                        text = "Enter Email", fontFamily = FontFamily(
                            Font(R.font.plus_jakarta_sans_medium)
                        ), fontSize = 14.sp,
                        color = Color.Gray
                    )
                },
                textStyle = TextStyle(
                    color = Color.Black, fontFamily = FontFamily(
                        Font(R.font.plus_jakarta_sans_medium)
                    )
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = firstNameInput, onValueChange = {
                    firstNameInput = it
                },
                label = {
                    Text(
                        text = "First Name", fontFamily = FontFamily(
                            Font(R.font.plus_jakarta_sans_medium)
                        ), fontSize = 14.sp,
                        color = Color.Gray
                    )
                },
                textStyle = TextStyle(
                    color = Color.Black, fontFamily = FontFamily(
                        Font(R.font.plus_jakarta_sans_medium)
                    )
                )
            )

            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = lastNameInput, onValueChange = {
                    lastNameInput = it
                },
                label = {
                    Text(
                        text = "Last Name", fontFamily = FontFamily(
                            Font(R.font.plus_jakarta_sans_medium)
                        ), fontSize = 14.sp,
                        color = Color.Gray
                    )
                },
                textStyle = TextStyle(
                    color = Color.Black, fontFamily = FontFamily(
                        Font(R.font.plus_jakarta_sans_medium)
                    )
                )
            )
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = passwordInput, onValueChange = {
                    passwordInput = it
                    isPasswordValid = isValidPassword(it)
                },
                label = {
                    Text(
                        text = "Password", fontFamily = FontFamily(
                            Font(R.font.plus_jakarta_sans_medium)
                        ), fontSize = 14.sp,
                        color = Color.Gray
                    )
                },
                textStyle = TextStyle(
                    color = Color.Black, fontFamily = FontFamily(
                        Font(R.font.plus_jakarta_sans_medium)
                    )
                ),
                visualTransformation = PasswordVisualTransformation()
            )
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = passwordInput, onValueChange = {
                    passwordInput = it
                    isPasswordValid = isValidPassword(it)
                },
                label = {
                    Text(
                        text = "Confirm Password", fontFamily = FontFamily(
                            Font(R.font.plus_jakarta_sans_medium)
                        ), fontSize = 14.sp,
                        color = Color.Gray
                    )
                },
                textStyle = TextStyle(
                    color = Color.Black, fontFamily = FontFamily(
                        Font(R.font.plus_jakarta_sans_medium)
                    )
                ),
                visualTransformation = PasswordVisualTransformation()
            )
            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Your age",
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(start = 20.dp),
                fontFamily =FontFamily(
                    Font(R.font.plus_jakarta_sans_bold)
                ), fontSize = 14.sp,
                color = darkGray )

            Text(text = ageSliderValue.toInt().toString(),
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(start = 20.dp),
                fontFamily =FontFamily(
                    Font(R.font.plus_jakarta_sans_bold)
                ), fontSize = 14.sp,
                color = darkGray )
            Slider(
                value = ageSliderValue, onValueChange = {
                    ageSliderValue = it
                },
                modifier = Modifier.padding(start = 20.dp, end = 20.dp),
                valueRange = 18f..100f,
                colors = SliderDefaults.colors(
                    thumbColor = textOrange,
                    activeTrackColor = textOrange,
                    inactiveTrackColor = Color.LightGray
                )
            )

            Text(text = "Gender",
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(start = 20.dp),
                fontFamily =FontFamily(
                    Font(R.font.plus_jakarta_sans_bold)
                ), fontSize = 14.sp,
                color = darkGray )

            Row(
                modifier = Modifier
                    .align(Alignment.Start)
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Male",modifier = Modifier
                    .padding(start = 20.dp),
                    fontFamily =FontFamily(
                        Font(R.font.plus_jakarta_sans_light)
                    ), fontSize = 14.sp,
                    color = if(selectedSwitchState ==1) Color.Black else Color.Gray)

                Switch(checked = selectedSwitchState == 1, onCheckedChange ={
                    selectedSwitchState = if(selectedSwitchState == 1) 0
                    else 1
                },
                    modifier = Modifier.padding(end = 20.dp),
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = textOrange, // Change thumb color when switch is checked
                        checkedTrackColor = textOrange.copy(alpha = 0.5f), // Change track color when switch is checked
                        uncheckedThumbColor = Color.LightGray, // Change thumb color when switch is unchecked
                        uncheckedTrackColor = Color.LightGray.copy(alpha = 0.5f) // Change track color when switch is unchecked
                    )
                )

            }

            Row(
                modifier = Modifier
                    .align(Alignment.Start)
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Female",modifier = Modifier
                    .padding(start = 20.dp),
                    fontFamily =FontFamily(
                        Font(R.font.plus_jakarta_sans_light)
                    ), fontSize = 14.sp,
                    color =if(selectedSwitchState ==2) Color.Black else Color.Gray)

                Switch(checked = selectedSwitchState == 2, onCheckedChange ={
                    selectedSwitchState = if(selectedSwitchState == 2) 0
                    else 2
                },
                    modifier = Modifier.padding(end = 20.dp),
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = textOrange, // Change thumb color when switch is checked
                        checkedTrackColor = textOrange.copy(alpha = 0.5f), // Change track color when switch is checked
                        uncheckedThumbColor = Color.LightGray, // Change thumb color when switch is unchecked
                        uncheckedTrackColor = Color.LightGray.copy(alpha = 0.5f) // Change track color when switch is unchecked
                    )
                )

            }

            Row(
                modifier = Modifier
                    .align(Alignment.Start)
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Other",modifier = Modifier
                    .padding(start = 20.dp),
                    fontFamily =FontFamily(
                        Font(R.font.plus_jakarta_sans_light)
                    ), fontSize = 14.sp,
                    color = if(selectedSwitchState ==3) Color.Black else Color.Gray)

                Switch(checked = selectedSwitchState == 3, onCheckedChange ={
                    selectedSwitchState = if(selectedSwitchState == 3) 0
                    else 3
                },
                    modifier = Modifier.padding(end = 20.dp),
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = textOrange, // Change thumb color when switch is checked
                        checkedTrackColor = textOrange.copy(alpha = 0.5f), // Change track color when switch is checked
                        uncheckedThumbColor = Color.LightGray, // Change thumb color when switch is unchecked
                        uncheckedTrackColor = Color.LightGray.copy(alpha = 0.5f) // Change track color when switch is unchecked
                    )
                )

            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp)
                    .height(48.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    textOrange, disabledContainerColor =
                    Color.LightGray, disabledContentColor = Color.White
                ),
                shape = RoundedCornerShape(6.dp),
                onClick = {

                },
                enabled = isEmailValid && isPasswordValid
            ) {
                Text(
                    text = "Signup", fontFamily = FontFamily(
                        Font(R.font.plus_jakarta_sans_bold)
                    ), fontSize = 14.sp,
                    color = Color.White
                )
            }
            Spacer(modifier = Modifier.height(20.dp))

            Text(modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 20.dp),
                text = "Details complete", fontFamily = FontFamily(
                Font(R.font.plus_jakarta_sans_medium)
            ), fontSize = 14.sp,
                color = textGray)

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier
                    .align(Alignment.Start)
                    .fillMaxWidth()
                    .padding(top = 16.dp),

                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(modifier = Modifier
                    .padding(start = 20.dp),
                    text = "0%", fontFamily = FontFamily(
                        Font(R.font.plus_jakarta_sans_extra_bold)
                    ), fontSize = 20.sp,
                    color = textGray)

                Surface(
                    modifier = Modifier
                        .padding(start = 10.dp, end = 16.dp)
                        .height(8.dp),
                    shape = RoundedCornerShape(4.dp), // Apply rounded corners here
                    color = Color.Gray.copy(alpha = 0.3f) // Set the background color for the progress indicator
                ) {
                    LinearProgressIndicator(
                        modifier = Modifier.fillMaxSize(),
                        progress = 0.2f,
                        color = textOrange,
                        trackColor = Color.LightGray
                    )
                }


            }

            Spacer(modifier = Modifier.height(20.dp))

        }


    }
}