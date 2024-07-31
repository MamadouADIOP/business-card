package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    BusinessCard("Jennifer Doe", phoneNumber = "jen.doe@android.com", feedbackPath = "@Android Dev", email = "jen.doe@android.com", position = "Android Developer Extraordinaire", modifier = Modifier)
                }
            }
        }
    }
}

@Composable
fun IdentitySection(name: String, position: String, modifier: Modifier = Modifier) {

        Column(modifier = Modifier, verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = R.drawable.android_logo),
                contentDescription = stringResource(R.string.logo_android_text),
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.Black)
            )
            Text(
                text = name,
                modifier = modifier,
                fontSize = 30.sp
            )
            Text(
                text = position,
                modifier = modifier,
                fontWeight =  FontWeight.Bold,
                color = Color(0xFF023020)
            )
        }
  }

@Composable
fun ContactSection(phoneNumber: String, feedbackPath: String, email: String, modifier: Modifier = Modifier) {
    Column(modifier = Modifier.padding(bottom = 60.dp, start = 6.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.Start) {
        Row {
            Icon(Icons.Rounded.Call, contentDescription = stringResource(R.string.phone_number_talkback), modifier= Modifier)
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = phoneNumber,
                modifier = modifier.padding(bottom = 15.dp)
            )
        }
        Row {
            Icon(Icons.Rounded.Share, contentDescription = stringResource(R.string.feedback_hash_tag_talkback), modifier= Modifier)
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = feedbackPath,
                modifier = modifier.padding(bottom = 15.dp)
            )
        }
        Row {
            Icon(Icons.Rounded.Email, contentDescription = stringResource(R.string.email_address_talkback), modifier= Modifier)
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = email,
                modifier = modifier
            )
        }
    }
}

@Composable
fun BusinessCard(name: String, phoneNumber: String, feedbackPath: String, email: String, position: String, modifier: Modifier = Modifier) {
    Column(modifier = Modifier.background(Color(0xFF3ddc84)))  {
        Row (
            Modifier
                .weight(1f)
                .fillMaxSize(), verticalAlignment = Alignment.Bottom, horizontalArrangement = Arrangement.Center) {
            IdentitySection(name = name, position = position, modifier = Modifier)
        }
        Row (
            Modifier
                .weight(1f)
                .fillMaxSize(), verticalAlignment = Alignment.Bottom, horizontalArrangement = Arrangement.Center) {
            ContactSection(phoneNumber, feedbackPath, email, Modifier)
            }
        }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCard("Jennifer Doe", phoneNumber = "jen.doe@android.com", feedbackPath = "@Android Dev", email = "jen.doe@android.com", position = "Android Developer Extraordinaire", modifier = Modifier)
    }
}