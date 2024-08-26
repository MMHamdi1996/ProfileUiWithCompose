package com.example.profileui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.profileui.ui.theme.ProfileUiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            profile()
        }
    }

    @Preview
    @Composable
    private fun profile() {
        Column(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(color = Color(android.graphics.Color.parseColor("#f2f1f6"))),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ConstraintLayout(
                Modifier
                    .height(250.dp)
                    .background(color = Color(android.graphics.Color.parseColor("#32357a")))
            ) {
                val (topImg, profile, title, back, pen) = createRefs()
                Image(painterResource(id = R.drawable.arc_3), null, Modifier
                    .fillMaxWidth()
                    .constrainAs(topImg) {
                        bottom.linkTo(parent.bottom)
                    })
                Image(painterResource(id = R.drawable.user_2), null, Modifier
                    .fillMaxWidth()
                    .constrainAs(profile) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(topImg.bottom)
                    })
                Text(text = "profile",
                    style = TextStyle(
                        color = Color.White, fontSize = 30.sp
                    ),
                    modifier = Modifier
                        .constrainAs(title) {
                            top.linkTo(parent.top, margin = 32.dp)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                )

            }

        }
    }
}


