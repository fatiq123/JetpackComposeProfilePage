package com.example.simpleprofilepage

import android.view.textclassifier.TextClassifierEvent.LanguageDetectionEvent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension

@Composable
fun ProfilePage() {

    // using the constraint layout
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 100.dp, bottom = 100.dp, start = 16.dp, end = 16.dp)
            .border(width = 2.dp, color = Color.White, shape = RoundedCornerShape(15.dp))
    ) {
        BoxWithConstraints {

            val constraints = if (minWidth < 600.dp) {
                portraitConstraints(margin = 16.dp) // Portrait constraints
            } else {
                landscapeConstraints(margin = 32.dp) // Landscape constraints
            }

            ConstraintLayout(constraintSet = constraints) {

                Image(
                    painter = painterResource(id = R.drawable.mypic),
                    contentDescription = "My Picture",
                    modifier = Modifier
                        .size(200.dp)
                        .clip(shape = CircleShape)
                        .border(width = 2.dp, color = Color.Red, shape = CircleShape)
                        .layoutId("image"),
                    contentScale = ContentScale.Crop
                )

                Text(
                    text = "Fatiq Hussnain", modifier = Modifier.layoutId("nameText"),
                    fontWeight = FontWeight.Bold
                )
                Text(text = "ISSB", modifier = Modifier.layoutId("placeText"))

                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .layoutId("rowStats")
                ) {
                    ProfileStats(count = "150", title = "Followers")
                    ProfileStats(count = "100", title = "Following")
                    ProfileStats(count = "10", title = "Posts")
                }

                Button(onClick = { }, modifier = Modifier.layoutId("followButton")) {
                    Text(text = "Follow")
                }
                Button(onClick = { }, modifier = Modifier.layoutId("unfollowButton")) {
                    Text(text = "UnFollow")
                }

            }
        }
    }


    /*{
    ConstraintLayout {

        val image = createRef()
        val nameText = createRef()
        val placeText = createRef()
        val rowStat = createRef()
        val followButton = createRef()
        val unfollowButton = createRef()

        val guideLine = createGuidelineFromTop(0.1f)

        Image(
            painter = painterResource(id = R.drawable.mypic),
            contentDescription = "My Picture",
            modifier = Modifier
                .size(200.dp)
                .clip(shape = CircleShape)
                .border(width = 2.dp, color = Color.Red, shape = CircleShape)
                .constrainAs(image) {
                    top.linkTo(guideLine)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Fatiq Hussnain",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.constrainAs(nameText) {
                top.linkTo(image.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            })
        Text(text = "ISSB", modifier = Modifier.constrainAs(placeText) {
            top.linkTo(nameText.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .constrainAs(rowStat) {
                    top.linkTo(placeText.bottom)
                }
        ) {
            ProfileStats(count = "150", title = "Followers")
            ProfileStats(count = "100", title = "Following")
            ProfileStats(count = "10", title = "Posts")
        }

        Button(onClick = { }, modifier = Modifier.constrainAs(followButton) {
            top.linkTo(rowStat.bottom, margin = 16.dp)
            start.linkTo(parent.start)
            end.linkTo(unfollowButton.start)
            width = Dimension.wrapContent
        }) {
            Text(text = "Follow")
        }
        Button(onClick = { }, modifier = Modifier.constrainAs(unfollowButton) {
            top.linkTo(rowStat.bottom, margin = 16.dp)
            start.linkTo(followButton.end)
            end.linkTo(parent.end)
            width = Dimension.wrapContent
        }) {
            Text(text = "UnFollow")
        }

    }
}*/


    /*Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 100.dp, bottom = 100.dp, start = 16.dp, end = 16.dp)
            .border(width = 2.dp, color = Color.White, shape = RoundedCornerShape(15.dp))
    ) {
        Column(
            Modifier.verticalScroll(rememberScrollState()).padding(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.mypic),
                contentDescription = "My Picture",
                modifier = Modifier
                    .size(200.dp)
                    .clip(shape = CircleShape)
                    .border(width = 2.dp, color = Color.Red, shape = CircleShape),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(text = "Fatiq Hussnain", fontWeight = FontWeight.Bold)
            Text(text = "ISSB")

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                ProfileStats(count = "150", title = "Followers")
                ProfileStats(count = "100", title = "Following")
                ProfileStats(count = "10", title = "Posts")
            }

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Button(onClick = { }) {
                    Text(text = "Follow")
                }
                Button(onClick = { }) {
                    Text(text = "UnFollow")
                }
            }
        }
    }*/

}


private fun portraitConstraints(margin: Dp): ConstraintSet {
    return ConstraintSet {

        val image = createRefFor("image")
        val nameText = createRefFor("nameText")
        val placeText = createRefFor("placeText")
        val rowStat = createRefFor("rowStat")
        val followButton = createRefFor("followButton")
        val unfollowButton = createRefFor("unfollowButton")
        val guideLine = createGuidelineFromTop(0.1f)

        constrain(image) {
            top.linkTo(guideLine)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(nameText) {
            top.linkTo(image.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(placeText) {
            top.linkTo(nameText.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(rowStat) {
            top.linkTo(placeText.bottom)
        }
        constrain(followButton) {
            top.linkTo(rowStat.bottom, margin = margin)
            start.linkTo(parent.start)
            end.linkTo(unfollowButton.start)
            width = Dimension.wrapContent
        }
        constrain(unfollowButton) {
            top.linkTo(rowStat.bottom, margin = margin)
            start.linkTo(followButton.end)
            end.linkTo(parent.end)
            width = Dimension.wrapContent
        }
    }
}

fun landscapeConstraints(margin: Dp): ConstraintSet {
    return ConstraintSet {

        val image = createRefFor("image")
        val nameText = createRefFor("nameText")
        val placeText = createRefFor("placeText")
        val rowStat = createRefFor("rowStat")
        val followButton = createRefFor("followButton")
        val unfollowButton = createRefFor("unfollowButton")
        val guideLine = createGuidelineFromTop(0.1f)

        constrain(image) {
            top.linkTo(parent.top, margin = margin)
            start.linkTo(parent.start, margin = margin)
        }
        constrain(nameText) {
            top.linkTo(image.bottom)
            start.linkTo(image.start)
        }
        constrain(placeText) {
            top.linkTo(nameText.bottom)
            start.linkTo(nameText.start)
            end.linkTo(nameText.end)
        }
        constrain(rowStat) {
            top.linkTo(image.top)
            start.linkTo(image.end, margin = margin)
            end.linkTo(parent.end)
        }
        constrain(followButton) {
            top.linkTo(rowStat.bottom, margin = 16.dp)
            start.linkTo(rowStat.start)
            end.linkTo(unfollowButton.start)
            bottom.linkTo(placeText.bottom)
            width = Dimension.wrapContent
        }
        constrain(unfollowButton) {
            top.linkTo(rowStat.bottom, margin = 16.dp)
            start.linkTo(followButton.end)
            end.linkTo(parent.end)
            bottom.linkTo(placeText.bottom)
            width = Dimension.wrapContent
        }
    }
}


@Composable
fun ProfileStats(count: String, title: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = count, fontWeight = FontWeight.Bold)
        Text(text = title)
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePagePreview() {
    ProfilePage()
}