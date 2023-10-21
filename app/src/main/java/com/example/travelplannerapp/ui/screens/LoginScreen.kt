package com.example.travelplannerapp.ui.screens
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
import com.example.travelplannerapp.ui.theme.textBlue
import com.example.travelplannerapp.ui.theme.textOrange

@Composable
fun LoginScreen(navController: NavController) {

    Surface {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Spacer(modifier = Modifier.height(60.dp))
            LoginSignupSegmentedSwitch(navController = navController)
            Spacer(modifier = Modifier.height(32.dp))
            LoginForm(navController = navController)
        }
    }
}

@Composable
fun LoginSignupSegmentedSwitch(navController: NavController) {
    Row(
        modifier = Modifier
            .border(0.1.dp, Color.Gray, RoundedCornerShape(8.dp))
            .padding(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            onClick = {},
            colors = ButtonDefaults.outlinedButtonColors(textOrange),
            shape = RoundedCornerShape(6.dp),
            modifier = Modifier
                .width(62.dp)
                .height(34.dp),
            contentPadding = PaddingValues(0.dp),
            elevation = ButtonDefaults.buttonElevation(4.dp)
        ) {
            Text(
                modifier = Modifier.padding(0.dp),
                text = "Login", fontFamily = FontFamily(
                    Font(R.font.plus_jakarta_sans_medium)
                ), fontSize = 14.sp,
                color = Color.White
            )
        }
        Spacer(modifier = Modifier.width(6.dp))
        TextButton(onClick = {

        },
            contentPadding = PaddingValues(0.dp),
            shape = RoundedCornerShape(6.dp),
            modifier = Modifier
                .width(62.dp)
                .height(34.dp),
            content = {
                Text(
                    text = "Signup",
                    fontFamily = FontFamily(
                        Font(R.font.plus_jakarta_sans_medium)
                    ), fontSize = 14.sp,
                    color = Color.Black
                )
            })

    }
}

@Composable
fun LoginForm(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var emailInput by remember { mutableStateOf("") }
        var passwordInput by remember { mutableStateOf("") }

        var isEmailValid by remember { mutableStateOf(false) }

        var isPasswordValid by remember { mutableStateOf(false) }
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
        Spacer(modifier = Modifier.height(20.dp))
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

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 24.dp),
            text = "Forgot Password?",
            fontFamily = FontFamily(
                Font(R.font.plus_jakarta_sans_medium)
            ), fontSize = 12.sp,
            color = textBlue
        )

        Spacer(modifier = Modifier.height(32.dp))

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
                text = "Login", fontFamily = FontFamily(
                    Font(R.font.plus_jakarta_sans_bold)
                ), fontSize = 14.sp,
                color = Color.White
            )
        }

    }
}

fun isValidEmail(email: String): Boolean {
    return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
}

fun isValidPassword(password: String): Boolean {
    return password.length >= 8
}
