package com.example.travelplannerapp.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.travelplannerapp.R
import com.example.travelplannerapp.ui.theme.offWhite
import com.example.travelplannerapp.ui.theme.textOrange
import java.util.Calendar

@Composable
fun HomeScreen(navController: NavController) {
    Surface(
        modifier = Modifier
            .background(offWhite)
            .fillMaxSize()
            .padding(top = 40.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(offWhite)
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, top = 20.dp, end = 20.dp),
                verticalAlignment = Alignment.CenterVertically,

                ) {

                Column {
                    Text(
                        text = "CurrentLocation", fontFamily = FontFamily(
                            Font(R.font.plus_jakarta_sans_medium)
                        ), fontSize = 12.sp,
                        color = Color.Black
                    )
                    Row(
                        modifier = Modifier.padding(top = 8.dp, start = 1.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.iv_location_indicator),
                            modifier = Modifier.padding(top = 4.dp), contentDescription = ""
                        )
                        Text(
                            modifier = Modifier.padding(start = 6.dp),
                            text = "Delhi", fontFamily = FontFamily(
                                Font(R.font.plus_jakarta_sans_bold)
                            ), fontSize = 16.sp,
                            color = Color.Black
                        )
                    }


                }
                Spacer(modifier = Modifier.width(180.dp))
                Image(
                    painter = painterResource(id = R.drawable.iv_notification_icon),
                    contentDescription = ""
                )


            }
            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Button(
                    modifier = Modifier
                        .height(32.dp)
                        .width(80.dp)
                        .border(
                            width = 0.1.dp, color = Color.LightGray,
                            RoundedCornerShape(6.dp)
                        )
                        .padding(0.dp)
                    ,

                    colors = ButtonDefaults.outlinedButtonColors(
                        textOrange.copy(0.05f), disabledContainerColor =
                        Color.LightGray, disabledContentColor = Color.White
                    ),
                    shape = RoundedCornerShape(6.dp),
                    onClick = {

                    },
                    contentPadding = PaddingValues(0.dp),
                ){
                    Text(
                            text = getCurrentMonth(), fontFamily = FontFamily(
                                Font(R.font.plus_jakarta_sans_light)
                            ), fontSize = 14.sp,
                            color = textOrange
                        )
                    Spacer(modifier = Modifier.width(4.dp))
                        Image(
                            painter = painterResource(id = R.drawable.iv_calendar),
                            contentDescription = ""
                        )
                }

                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 16.dp),
                    state = rememberLazyListState(),
                ) {
                    for (i in 1..4) {
                        item { WeekGridItem(weekCount = i) }
                    }
                }
            }

            Spacer(modifier = Modifier.height(140.dp))

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.iv_empty_box_placeholder),
                    contentDescription = "",
                    modifier = Modifier
                        .height(100.dp)
                        .width(100.dp),
                    contentScale = ContentScale.Inside
                )

                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Looks like you don’t have any upcoming plans. You can start from here..",
                    fontFamily = FontFamily(
                        Font(R.font.plus_jakarta_sans_extra_light)
                    ), fontSize = 14.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(start = 12.dp, end = 12.dp),
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    modifier = Modifier
                        .height(40.dp)
                        .width(96.dp),

                    colors = ButtonDefaults.outlinedButtonColors(
                        textOrange, disabledContainerColor =
                        Color.LightGray, disabledContentColor = Color.White
                    ),
                    shape = RoundedCornerShape(6.dp),
                    onClick = {

                    },
                    contentPadding = PaddingValues(0.dp),
                ) {
                    Text(
                        text = "Create plan", fontFamily = FontFamily(
                            Font(R.font.plus_jakarta_sans_medium)
                        ), fontSize = 14.sp,
                        color = Color.White
                    )

                }

            }
        }


    }

}


@Composable
fun WeekGridItem(weekCount: Int) {
    Surface(
        modifier = Modifier
            .padding(start = 16.dp)
            .background(Color.White),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(0.5.dp, Color.LightGray)
    ) {
        Row(
            modifier = Modifier
                .background(Color.White)
                .padding(10.dp)
        ) {
            Text(
                text = "Week$weekCount", fontFamily = FontFamily(
                    Font(R.font.plus_jakarta_sans_light)
                ), fontSize = 14.sp,
                color = Color.Black
            )
        }

    }


}

fun getCurrentMonth(): String {
    val cal: Calendar = Calendar.getInstance()
    return when (cal.get(Calendar.MONTH)) {
        0 -> "Jan"
        1 -> "Feb"
        2 -> "Mar"
        3 -> "Apr"
        4 -> "May"
        5 -> "Jun"
        6 -> "Jul"
        7 -> "Aug"
        8 -> "Sept"
        9 -> "Oct"
        10 -> "Nov"
        11 -> "Dec"
        else -> ""
    }

}

@Composable
fun BottomSheet() {

}